package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText principal;
    private EditText rate;
    private EditText time;
    private EditText monthlyPayment;
    private Button calculate;

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        principal = findViewById(R.id.principalAmount);
        rate = findViewById(R.id.interestRate);
        time = findViewById(R.id.loanTerm);
        monthlyPayment = findViewById(R.id.monthlyPayment);
        calculate = findViewById(R.id.button);

        calculate.setOnClickListener(v -> {
            double amount = Double.parseDouble(principal.getText().toString());
            double percent = Double.parseDouble(rate.getText().toString());
            double period = Double.parseDouble(time.getText().toString());
            double result = amount * (percent / 1200) * Math.pow(1 + percent / 1200, period)
                    / (Math.pow(1 + percent / 1200, period) - 1);
            monthlyPayment.setText(String.format(" $ %.2f", result));

            Intent intent = new Intent(MainActivity.this, Display.class);
            intent.putExtra("monthlyPayment", result);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
