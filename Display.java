package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {
    private TextView monthlyPayment;
    private Button returnButton;

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        monthlyPayment = findViewById(R.id.monthlyPayment);
        returnButton = findViewById(R.id.returnButton);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("monthlyPayment", 0);
        monthlyPayment.setText(String.format("Your monthly payment is $ %.2f", result));

        returnButton.setOnClickListener(v -> finish());
    }
}
