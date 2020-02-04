package com.example.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final RadioButton lbsToKilo = findViewById(R.id.radLbsToKilo);
        final RadioButton kiloToLbs = findViewById(R.id.radKilosToLbs);
        final EditText weight = findViewById(R.id.txtWeight);

        final Button convert = findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final double CONVERSION_RATE = 2.2;
                double convertedWeight;
                DecimalFormat tenth = new DecimalFormat("#.#");
                double weightEntered = Double.parseDouble(weight.getText().toString());
                TextView result = findViewById(R.id.txtResults);

                if(lbsToKilo.isChecked())
                {
                    if(weightEntered > 800)
                    {
                        Toast.makeText(MainActivity.this, "You entered too many lbs", Toast.LENGTH_LONG).show();
                    }

                    else
                    {
                        convertedWeight = weightEntered / CONVERSION_RATE;
                        result.setText(tenth.format(convertedWeight) + "kilos");
                    }
                }
            }
        });
    }
}
