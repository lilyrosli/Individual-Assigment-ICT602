package com.example.assignment1;




import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;




public class AboutActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);




       // Set the theme based on user preferences
       setTheme(ThemeUtil.getThemeId(this));




       // Set the layout for the activity
       setContentView(R.layout.activity_about);




       // Initialize UI elements
       TextView txtUrl = findViewById(R.id.txt_url);
       Button btnBack = findViewById(R.id.btn_back);




       // Enable clickable URL for the TextView
       txtUrl.setMovementMethod(LinkMovementMethod.getInstance());




       // Set action for the Back button
       btnBack.setOnClickListener(v -> finish());
   }
}
