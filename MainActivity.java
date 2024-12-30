package com.example.assignment1;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setTheme(ThemeUtil.getThemeId(this));
       setContentView(R.layout.activity_main);


       // Initialize buttons
       Button btnCalculator = findViewById(R.id.btn_calculator);
       Button btnAbout = findViewById(R.id.btn_about);
       Button btnShare = findViewById(R.id.btn_share);  // Add Share button


       // Set button click listeners
       btnCalculator.setOnClickListener(v -> startActivity(new Intent(this, CalculatorActivity.class)));
       btnAbout.setOnClickListener(v -> startActivity(new Intent(this, AboutActivity.class)));


       // Share app functionality
       btnShare.setOnClickListener(v -> {
           // Create the sharing intent
           Intent shareIntent = new Intent(Intent.ACTION_SEND);
           shareIntent.setType("text/plain");
           String shareMessage = "Check out this awesome app: https://play.google.com/store/apps/details?id=" + getPackageName();
           shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
           startActivity(Intent.createChooser(shareIntent, "Share App"));
       });
   }
}


