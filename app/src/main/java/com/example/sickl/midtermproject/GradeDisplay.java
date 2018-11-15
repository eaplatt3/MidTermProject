package com.example.sickl.midtermproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GradeDisplay extends AppCompatActivity {

    public static final String PERCENT_A_S = "Percent A's";
    public static final String PERCENT_B_S = "Percent B's";
    public static final String PERCENT_C_S = "Percent C's";
    public static final String PERCENT_D_S = "Percent D's";
    public static final String PERCENT_F_S = "Percent F's";

    String per;
    String per1;
    String per2;
    String per3;
    String per4;

    @BindView(R.id.grade_display) TextView gradeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_display);
        ButterKnife.bind(this);

        //Method CAll to Receive data from previous activity
        extractDataFromIntent();

        //Displays Retrieved Data
        gradeDisplay.setText("Percent of A's: " + per + "%" + "\n" + "Percent of B's: " + per1 + "%" + "\n"
                                    + "Percent of C's: " + per2 + "%" + "\n" + "Percent of D's: " + per3 + "%" + "\n"
                                        + "Percent of F's: " + per4 + "%");

    }

    //Method to get Data from previous
    private void extractDataFromIntent() {

        Intent intent = getIntent();
         per = intent.getStringExtra(PERCENT_A_S);
         per1 = intent.getStringExtra(PERCENT_B_S);
         per2 = intent.getStringExtra(PERCENT_C_S);
         per3 = intent.getStringExtra(PERCENT_D_S);
         per4 = intent.getStringExtra(PERCENT_F_S);
    }

    public static Intent makeIntent(Context context, String per, String per1, String per2, String per3, String per4){
        Intent intent = new Intent(context, GradeDisplay.class);
        intent.putExtra(PERCENT_A_S, per);
        intent.putExtra(PERCENT_B_S, per1);
        intent.putExtra(PERCENT_C_S, per2);
        intent.putExtra(PERCENT_D_S, per3);
        intent.putExtra(PERCENT_F_S, per4);
        return intent;
    }

    //passing data to next activity
    public void toChart(View view) {

        Intent intent = BarChart.makeIntent(GradeDisplay.this, per, per1, per2, per3, per4);
        startActivity(intent);
    }
}
