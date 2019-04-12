package com.example.numconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText textnum;
    private TextView textresult;
    private Button buttonconverter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setAction();
    }
    private void initiate(){
        textnum =findViewById(R.id.textInput);
        textresult =findViewById(R.id.textOutput);
        buttonconverter =findViewById(R.id.btnnConvert);
    }
    private void setAction(){
        buttonconverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(textnum.getText().toString());
                Model model = new Model();
                if (input < 20) {

                    textresult.setText(model.getOnes()[input]);
                } else if (input < 100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        textresult.setText(model.getTens()[tensIndex] + " " + model.getOnes()[onesIndex]);
                    } else {
                        textresult.setText(model.getTens()[tensIndex]);
                    }
                } else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0) {
                        textresult.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex] +
                                " " + model.getOnes()[onesIndex]);
                    } else {
                        textresult.setText(model.getOnes()[hundredsIndex] + " Hundred " + model.getTens()[tensIndex]);
                    }
                }
            }});
        }
    }
