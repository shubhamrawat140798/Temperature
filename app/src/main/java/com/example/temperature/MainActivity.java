package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText temp_value;
    TextView display;
    Spinner spinner;
    String temperature[]={"choice:","Celsius","Kelvin","Fahrenheit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp_value=  (EditText) findViewById(R.id.edtxt);
        display = findViewById(R.id.textView2);
        spinner = (Spinner)findViewById(R.id.Spinner);
        // Create an ArrayAdapter using string array and a default spinner
        ArrayAdapter<String> adapterOb= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temperature);
        adapterOb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterOb);
        spinner.setOnItemSelectedListener(MainActivity.this);


    }

   /* public  void CtoF(View v){

        float temp= Float.parseFloat(temp_value.getText().toString());
        float F;
        F=((9*temp)/5 )+32;
        //System.out.println(F);
        display.setText(F+"F");
    }
    public  void FtoC(View v){

        float temp= Float.parseFloat(temp_value.getText().toString());
        float C;
        C=5*(temp-32)/9;
        //System.out.println(C+"c");
        display.setText(C+"C");

    }*/

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Selected Temperature:"+temperature[position],Toast.LENGTH_SHORT).show();
        String s = parent.getSelectedItem().toString();

        String s1= temp_value.getText().toString().trim();
        float temp;
        if((s == "Celsius" && s1.length() != 0)){
            temp = Float.parseFloat(temp_value.getText().toString());
            float kelvin= (float) (temp + 273.15);
            float fahrenheit=(float) ((temp*9)/5)+32;
            display.setText("\nKelvin: "+kelvin+"K"+"\nFahrenheit:"+fahrenheit+"F");

        }
        else if((s == "Kelvin" && s1.length() != 0)){
            temp = Float.parseFloat(temp_value.getText().toString());
            float celsius = (float) (temp -273.15);
            float fahrenheit=(float) ((celsius*9)/5)+32;
            display.setText("\nCelsius: "+celsius+"C"+"\nFahrenheit:"+fahrenheit+"F");
        }
        else if((s == "Fahrenheit" && s1.length() != 0)){
            temp = Float.parseFloat(temp_value.getText().toString());
            float celsius = (float) 5*(temp-32)/9;
            float kelvin=(float) (temp + 273.15);
            display.setText("\nCelsius: "+celsius+"C"+"\nKelvin:"+kelvin+"K");
        }
        else{
            Toast.makeText(getApplicationContext(),"Entered Temperature",Toast.LENGTH_SHORT).show();
            display.setText("Enter Temperature");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
