package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply theme
        setTheme(ThemeUtil.getThemeId(this));
        setContentView(R.layout.activity_main);

        // Initialize buttons
        Button btnCalculator = findViewById(R.id.btn_calculator);
        Button btnAbout = findViewById(R.id.btn_about);
        Button btnShare = findViewById(R.id.btn_share);
        Button btnInstructions = findViewById(R.id.btn_instructions); // Fixed: Corrected ID reference

        // Set button click listeners
        btnCalculator.setOnClickListener(v -> {
            Intent calculatorIntent = new Intent(this, CalculatorActivity.class);
            startActivity(calculatorIntent);
        });

        btnAbout.setOnClickListener(v -> {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
        });

        btnInstructions.setOnClickListener(v -> {
            Intent instructionIntent = new Intent(this, InstructionActivity.class); // Assuming this activity exists
            startActivity(instructionIntent);
        });

        // Share app functionality
        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareMessage = "Check out this awesome app: https://play.google.com/store/apps/details?id=" + getPackageName();
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "Share App"));
        });
    }
}
