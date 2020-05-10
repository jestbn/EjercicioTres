package com.example.ejerciciotres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MostrarResultados extends AppCompatActivity {
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultados);
        tvTotal = findViewById(R.id.tvTotal);
        tvTotal.setText(Double.toString(CalculoHoras.total));
    }
}
