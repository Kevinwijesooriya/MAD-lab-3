package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_value;
    RadioButton radioButtonCel;
    RadioButton radioButtonFar;
    Button cal_button;
    TextView tv_displayAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_value = findViewById(R.id.et_value);
        radioButtonCel = findViewById(R.id.radioButtonCel);
        radioButtonFar = findViewById(R.id.radioButtonFar);
        cal_button = findViewById(R.id.cal_button);
        tv_displayAnswer = findViewById(R.id.tv_displayAnswer);

    }

    @Override
    protected void onResume() {
        super.onResume();
        cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer() {
        Calculate calculation = new Calculate();
        String temp_value = et_value.getText().toString();


        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please enter a tempherature value",Toast.LENGTH_LONG).show();
        }else{
            Float temp = Float.parseFloat(temp_value);
            if(radioButtonCel.isChecked()){
                temp = calculation.convertCelciusToFahrenheit(temp);
            }else if(radioButtonFar.isChecked()){
                temp = calculation.convertFahrenheitToCelcius(temp);
            }else{
                Toast.makeText( this, "Select Radio!",Toast.LENGTH_LONG).show();

                temp = 0.0f;
            }
            tv_displayAnswer.setText(new Float(temp).toString());
        }
    }
}