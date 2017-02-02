package com.example.saltin.webservisdeneme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saltin.webservisdeneme.TemperatureConvert.TempConvert;

public class MainActivity extends AppCompatActivity {

    public static Thread thread;
    public static TempConvert tempConvert;
    public static EditText fahrenheit;
    public static TextView result;
    public static String sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInvokeService = (Button) findViewById(R.id.btnInvoke);
        result = (TextView) findViewById(R.id.textView3);
        fahrenheit = (EditText) findViewById(R.id.editText1);

        btnInvokeService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tempConvert = new TempConvert();
                        sonuc = tempConvert.FahrenheitToCelsius(fahrenheit.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                result.setText(sonuc);
                            }
                        });
                    }
                });
                thread.start();
            }
        });
    }
}
