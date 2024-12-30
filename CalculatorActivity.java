package com.example.assignment1;




import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;




public class CalculatorActivity extends AppCompatActivity {
   private EditText edtWeight, edtGoldValue;
   private RadioButton rbKeep, rbWear;
   private TextView txtResult;




   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setTheme(ThemeUtil.getThemeId(this));
       setContentView(R.layout.activity_calculator);




       edtWeight = findViewById(R.id.edt_weight);
       edtGoldValue = findViewById(R.id.edt_gold_value);
       rbKeep = findViewById(R.id.rb_keep);
       rbWear = findViewById(R.id.rb_wear);
       txtResult = findViewById(R.id.txt_result);
       Button btnCalculate = findViewById(R.id.btn_calculate);
       Button btnBack = findViewById(R.id.btn_back);




       btnCalculate.setOnClickListener(v -> calculateZakat());




       btnBack.setOnClickListener(v -> finish());
   }




   private void calculateZakat() {




       String weightStr = edtWeight.getText().toString();
       String goldValueStr = edtGoldValue.getText().toString();




       if (weightStr.isEmpty() || goldValueStr.isEmpty() || (!rbKeep.isChecked() && !rbWear.isChecked())) {
           Toast.makeText(this, "Please fill all fields and select a category.", Toast.LENGTH_SHORT).show();
           return;
       }




       double weight = Double.parseDouble(weightStr);
       double goldValue = Double.parseDouble(goldValueStr);
       double uruf = rbKeep.isChecked() ? 85 : 200;




       double zakatPayableWeight = Math.max(0, weight - uruf);
       double zakatPayableValue = zakatPayableWeight * goldValue;
       double totalZakat = zakatPayableValue * 0.025;




       txtResult.setText(String.format("Zakat Payable Value: RM %.2f\nTotal Zakat: RM %.2f", zakatPayableValue, totalZakat));
   }
}
