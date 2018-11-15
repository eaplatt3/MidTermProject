package com.example.sickl.midtermproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BarChart extends AppCompatActivity {

    //Dosent work With BarChart
    // @BindView(R.id.barChart) BarChart barChart;

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

    //Creates Bar Chart
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        // ButterKnife.bind(this);

        //Dosent Work either Have no idea Why
        barChart = findViewById(R.id.barChart);

        extractDataFromIntent();

        //Converting Data From Previous Activity
        float perNum = Float.parseFloat(per);
        float perNum1 = Float.parseFloat(per1);
        float perNum2 = Float.parseFloat(per2);
        float perNum3 = Float.parseFloat(per3);
        float perNum4 = Float.parseFloat(per4);

        //Populating the Bar Chart
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(perNum, 0));
        barEntries.add(new BarEntry(perNum1, 1));
        barEntries.add(new BarEntry(perNum2, 2));
        barEntries.add(new BarEntry(perNum3, 3));
        barEntries.add(new BarEntry(perNum4, 4));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Grades");

        ArrayList<String> theGrades = new ArrayList<>();
        theGrades.add("A's");
        theGrades.add("B's");
        theGrades.add("C's");
        theGrades.add("D's");
        theGrades.add("F's");

        //Setting Data
        BarData theData = new BarData(theGrades, barDataSet);
        barChart.setData(theData);
    }

    private void setData(BarData theData) {
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

    public static Intent makeIntent(Context context, String per, String per1, String per2, String per3, String per4) {
        Intent intent = new Intent(context, GradeDisplay.class);
        intent.putExtra(PERCENT_A_S, per);
        intent.putExtra(PERCENT_B_S, per1);
        intent.putExtra(PERCENT_C_S, per2);
        intent.putExtra(PERCENT_D_S, per3);
        intent.putExtra(PERCENT_F_S, per4);
        return intent;
    }

}
