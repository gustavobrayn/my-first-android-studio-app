package com.example.exercicioavaliativo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalcMedia, btnCalcCombustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadWidgets();
        evento();
    }

    private void LoadWidgets() {
        btnCalcMedia=(Button) findViewById(R.id.btnCalcMedia);
        btnCalcCombustivel=(Button) findViewById(R.id.btnCalcCombustivel);
    }

    private void evento() {
        btnCalcMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CalculaMedia.class);
                startActivity(it);
            }
        });
        btnCalcCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CalculaCombustivel.class);
                startActivity(it);
            }
        });
    }

}