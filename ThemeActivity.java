package com.example.assignment1;




import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;




public class ThemeActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setTheme(ThemeUtil.getThemeId(this));
       setContentView(R.layout.activity_theme);




       RadioButton rbPink = findViewById(R.id.rb_pink);
       RadioButton rbSoft1 = findViewById(R.id.rb_soft1);
       RadioButton rbSoft2 = findViewById(R.id.rb_soft2);
       Button btnApply = findViewById(R.id.btn_apply);
       Button btnBack = findViewById(R.id.btn_back);




       btnApply.setOnClickListener(v -> {
           if (rbPink.isChecked()) {
               ThemeUtil.setTheme(this, R.style.Theme_Pink);
           } else if (rbSoft1.isChecked()) {
               ThemeUtil.setTheme(this, R.style.Theme_Soft1);
           } else if (rbSoft2.isChecked()) {
               ThemeUtil.setTheme(this, R.style.Theme_Soft2);
           }
           startActivity(new Intent(this, MainActivity.class));
           finish();
       });




       btnBack.setOnClickListener(v -> finish());
   }
}
