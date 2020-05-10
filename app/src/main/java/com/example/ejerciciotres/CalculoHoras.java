package com.example.ejerciciotres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.text.TextUtils.isEmpty;

public class CalculoHoras extends AppCompatActivity {
    private double ValorHora, CantidadTrabajadas, HorasExtras;
    private EditText etHoraExtra, etValorHora, etCantidadHoras;
    public static double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_horas);
        etValorHora = findViewById(R.id.etValorHora);
        etCantidadHoras = findViewById(R.id.etNumHora);
        etHoraExtra = findViewById(R.id.etHoraExtra);
    }

    public void Calcular(View view) {
        String Text_ValorHora = etValorHora.getText().toString().trim();
        String Text_CantidadTrabajadas = etCantidadHoras.getText().toString().trim();
        String text_HoraExtra = etHoraExtra.getText().toString().trim();

        try {


            if (validar(Text_ValorHora, Text_CantidadTrabajadas)) {
                ValorHora = Double.parseDouble(Text_ValorHora);
                CantidadTrabajadas = Double.parseDouble(etCantidadHoras.getText().toString());
                if (isEmpty(text_HoraExtra)) {
                    total = CantidadTrabajadas * ValorHora;
                } else {
                    HorasExtras = Double.parseDouble(text_HoraExtra);
                    total = (CantidadTrabajadas * ValorHora) + (HorasExtras * (ValorHora * 2));
                }

                Intent MostrarResultados = new Intent(CalculoHoras.this, MostrarResultados.class);
                startActivity(MostrarResultados);
                //finish();
            } else {

            }

        } catch (Exception e) {
            etValorHora.setText("Se ha producdo un error " /*+ e.toString()*/);
        }

    }

    private boolean validar(String text_valorHora, String text_cantidadTrabajadas) {
        if ( isEmpty(text_valorHora) || isEmpty(text_cantidadTrabajadas) ){
            return false;
        }
        else{
            return true;
        }
    }
}
