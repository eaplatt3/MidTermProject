package com.example.sickl.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;

//Earl A Platt III
//11/8/2018
//MidTerm Assignment

public class GradeEntry extends AppCompatActivity {

    //Binding TextView and EditText
    @BindView(R.id.tot_student) EditText totStudents;
    @BindView(R.id.tot_a) EditText totAs;
    @BindView(R.id.tot_b) EditText totBs;
    @BindView(R.id.tot_c) EditText totCs;
    @BindView(R.id.tot_d) EditText totDs;
    @BindView(R.id.tot_f) EditText totFs;

    //Creating Objects
    Compute comp = new Compute();
    Compute comp1 = new Compute();
    Compute comp2 = new Compute();
    Compute comp3 = new Compute();
    Compute comp4 = new Compute();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_entry);
        ButterKnife.bind(this);


    }

    public void readNum(View view) {
        //Grabs the Imputed Text
        String totStu = totStudents.getText().toString().trim();

        String totA = totAs.getText().toString().trim();

        String totB = totBs.getText().toString().trim();

        String totC = totCs.getText().toString().trim();

        String totD = totDs.getText().toString().trim();

        String totF = totFs.getText().toString().trim();

        //Coverts Imputed Text to Doubles
        double stu = Double.parseDouble(totStu);
        double a = Double.parseDouble(totA);
        double b = Double.parseDouble(totB);
        double c = Double.parseDouble(totC);
        double d = Double.parseDouble(totD);
        double f = Double.parseDouble(totF);


        //Passes the Converted Doubles to the Method
        comp.getPercent(stu, a);
        comp1.getPercent(stu, b);
        comp2.getPercent(stu, c);
        comp3.getPercent(stu, d);
        comp4.getPercent(stu, f);

        //Passes Data to next Activity
        Intent intent = GradeDisplay.makeIntent(GradeEntry.this, Double.toString(comp.percent), Double.toString(comp1.percent),
                Double.toString(comp2.percent), Double.toString(comp3.percent), Double.toString(comp4.percent));
        startActivity(intent);

    }

}
