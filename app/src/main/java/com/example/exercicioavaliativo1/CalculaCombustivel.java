package com.example.exercicioavaliativo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculaCombustivel extends AppCompatActivity {
    EditText edtTxtGasolina, edtTxtEtanol;
    Button btnCalcular, btnHome;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcula_combustivel);
        LoadWidgets();
        Click();
    }

    private void LoadWidgets() {
        edtTxtGasolina=(EditText) findViewById(R.id.edtTxtGasolina);
        edtTxtEtanol=(EditText) findViewById(R.id.edtTxtEtanol);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnHome=(Button) findViewById(R.id.btnHome);
        txtResultado=(TextView) findViewById(R.id.txtResultado);
    }

    private void Click() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;

                text = "⛽️" + Calcular();

                txtResultado.setText(text);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CalculaCombustivel.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    private String Calcular() {
        double gasolina, etanol;

        gasolina = Double.parseDouble(edtTxtGasolina.getText().toString());
        etanol = Double.parseDouble(edtTxtEtanol.getText().toString());

        if(gasolina != etanol) {
            if(gasolina < etanol) {
                return "A Gasolina está compensando mais.";
            } else {
                return "O Etanol está compensando mais.";
            }
        } else {
            return "Os dois estão valendo a mesma coisa.";
        }

    }
}