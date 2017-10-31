package com.example.user.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity
{
    public TextView textViewMonthlyPayment, textViewStatusResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get extra value
        //getIntent() method = asking "who called me?"
        Intent intent = getIntent();
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        //For numerical data, a default value (0) must be provided
        double monthlyPayment = intent.getDoubleExtra(MainActivity.LOAN_REPAYMENT, 0);

        textViewMonthlyPayment = (TextView)findViewById(R.id.TextViewMonthlyPayment);
        textViewStatusResult = (TextView)findViewById(R.id.textViewStatusResult);

        textViewMonthlyPayment.setText("Monthly Repayment = " + monthlyPayment);
        textViewStatusResult.setText("Status : " + status);

    }

    public void closeActivity(View view)
    {
        finish();
    }
}
