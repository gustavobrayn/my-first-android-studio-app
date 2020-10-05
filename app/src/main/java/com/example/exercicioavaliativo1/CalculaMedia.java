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

public class CalculaMedia extends AppCompatActivity {

    Button btnCalcular, btnHome;
    EditText edtP1, edtProjeto, edtLista;
    Double p1, projeto, lista, resultado;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcula_media);
        LoadWidgets();
        Click();
    }

    private void LoadWidgets() {
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        edtP1 = (EditText)findViewById(R.id.edtTxtP1);
        edtProjeto = (EditText)findViewById(R.id.edtTxtProjeto);
        edtLista = (EditText)findViewById(R.id.edtTxtLista);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
        btnHome = (Button)findViewById(R.id.btnHome);
    }

    private double CalcularMedia() {
        Double result;
        p1 = Double.parseDouble(edtP1.getText().toString());
        projeto = Double.parseDouble(edtProjeto.getText().toString());
        lista = Double.parseDouble(edtLista.getText().toString());

        result = (p1 * 0.30) + (projeto * 0.50) + lista;

        return result;
    }

    private String VerificaMedia(double media) {
        String text = "";

        if (media <= 4) {
            text = "Passou muitooooo longe \uD83D\uDE13 \nSua média foi " + media;
        } else if ((media > 4) && (media < 6)) {
            text = "Foi beeeeem perto \uD83D\uDE30 \nSua média foi " + media;
        } else if ((media >= 6) && (media <= 9)) {
            text = "Você passou, parabéns \uD83D\uDE00 \nSua média foi " + media;
        } else {
            text = "Você é um robo?  \uD83E\uDD16 \nPassou sossegado \uD83D\uDE02 \nSua média foi " + media;
        }

        return text;
    }

    private void Click() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                resultado = CalcularMedia();
                text = VerificaMedia(resultado);
                txtResultado.setText(text);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CalculaMedia.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

}