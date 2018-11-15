package com.example.sickl.midtermproject;

public class Compute {

    //Declared Variable for the Method
    public double percent;

    //Constructor
    public Compute() {

    }

    //Method for Computing the Percent Based on Values Passed
    public double getPercent(double v, double w) {

        double totA = (w / v);

        percent = totA * 100;

        return percent;
    }
}