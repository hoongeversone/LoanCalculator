package com.example.user.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.Telephony.BaseMmsColumns.STATUS;

public class MainActivity extends AppCompatActivity
{
    public static final String LOAN_STATUS = "status";
    public static final String LOAN_REPAYMENT = "repayment";
    private EditText editTextPrice, editTextDownPayment, editTextInterestRate, editTextRepayment, editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
    }

    public void calculateLoan(View view)
    {
        double price, downPayment, interestRate, Repayment, Salary;
        double totalInterest, totalLoan, monthlyPayment;
        String status;

        price = Double.parseDouble(editTextPrice.getText().toString());
        downPayment = Double.parseDouble(editTextDownPayment.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        Repayment = Double.parseDouble(editTextRepayment.getText().toString());
        Salary = Double.parseDouble(editTextSalary.getText().toString());

        totalInterest = (price - downPayment) * interestRate * (Repayment / 12);
        totalLoan = (price - downPayment) + totalInterest;
        monthlyPayment = totalLoan / Repayment;

        if (monthlyPayment > (Salary * 30 / 100))
        {
            status = "Rejected";
        }
        else
        {
            status = "Accepted";
        }

        //This lines is to go from UI to another UI
        Intent intent = new Intent(this, ResultActivity.class);

        //putExtra has two parameters (Tag, Value)
        intent.putExtra(LOAN_STATUS, status);
        intent.putExtra(LOAN_REPAYMENT, monthlyPayment);
        startActivity(intent);

    }

}
