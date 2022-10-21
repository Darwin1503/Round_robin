package com.example.round_robin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contenedro_Activities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedro_activities);
    }

    public void Teoria (View view){
        Intent teoria = new Intent(this, Teoria_Activity.class);
        startActivity(teoria);
    }
    public void Funcionalidad(View view){
        Intent funcionalidad = new Intent(this, Funcionalidad.class);
        startActivity(funcionalidad);
    }
    public void Creditos(View view){
        Intent creditos = new Intent(this, Creditos.class);
        startActivity(creditos);
    }
}