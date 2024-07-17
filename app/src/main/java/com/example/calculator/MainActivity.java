package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity

{
    private TextView textViewResult;
    private String input = "";
    private double num1, num2;
    private String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
    }
    // Method to handle number button clicks
    public void onNumberClick(View view) {
        Button button = (Button) view;
        input += button.getText().toString();
        textViewResult.setText(input);
    }

    // Method to handle operator button clicks
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        num1 = Double.parseDouble(input);
        input = "";
    }

    // Method to handle decimal button click
    public void onDecimalClick(View view) {
        if (!input.contains(".")) {
            input += ".";
            textViewResult.setText(input);
        }
    }

    // Method to handle equals button click
    public void onEqualsClick(View view) {
        num2 = Double.parseDouble(input);
        double result = calculateResult(num1, num2, operator);
        textViewResult.setText(formatResult(result));
        input = String.valueOf(result);
    }

    // Method to perform calculations based on operator
    private double calculateResult(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "×":
                return (num1 * num2);
            case "÷":
                if (num2 == 0) return 0; // Handle division by zero
                return (num1 / num2);
            default:
                return 0;
        }
    }

    // Method to format the result to avoid trailing zeros
    private String formatResult(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
        return decimalFormat.format(result);
    }

    // Method to handle clear button click
    public void onClearButtonClick(View view) {
        input = "";
        textViewResult.setText("0");
    }

    // Method to handle backspace button click
    public void onBackspaceClick(View view) {
        if (input.length() > 0) {
            input = input.substring(0, input.length() - 1);
            textViewResult.setText(input);
        }
    }
}
