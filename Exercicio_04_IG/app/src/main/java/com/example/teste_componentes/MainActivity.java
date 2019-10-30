package com.example.teste_componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonAltoContraste;
    private TextView textView;
    private Switch switchAltoContraste;
    private Switch switchModoAmpliado;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchAltoContraste = findViewById(R.id.switchAltoContraste);
        switchModoAmpliado = findViewById(R.id.switchModoAmpliado);
        buttonAltoContraste = findViewById(R.id.btn_altoContraste);
        textView = findViewById(R.id.txt_conteudo);
        view = findViewById(R.id.view);

        buttonAltoContraste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean swichStateAltoContraste = switchAltoContraste.isChecked();
                boolean swichStateModoAmpliado = switchModoAmpliado.isChecked();


                // A e B ON
                if (swichStateAltoContraste == true && swichStateModoAmpliado == true){
                    textView.setTextColor(Color.WHITE);
                    view.setBackgroundColor(getResources().getColor(android.R.color.black));
                    textView.setTextSize(28f);
                }
                // A OFF e B OFF
                if(swichStateAltoContraste == false && swichStateModoAmpliado == false){
                    textView.setTextColor(Color.BLACK);
                    view.setBackgroundColor(getResources().getColor(android.R.color.white));
                    textView.setTextSize(14f);
                }
                //
                if(swichStateAltoContraste == true && swichStateModoAmpliado == false){
                    textView.setTextColor(Color.WHITE);
                    view.setBackgroundColor(getResources().getColor(android.R.color.black));
                    textView.setTextSize(14f);
                }
                if(swichStateAltoContraste == false && swichStateModoAmpliado == true){
                    textView.setTextColor(Color.BLACK);
                    view.setBackgroundColor(getResources().getColor(android.R.color.white));
                    textView.setTextSize(28f);
                }
            }
        });
    }
}
