package com.example.ejerciciotres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {
    private String username, usernameSet = "user";
    private int password, passwordSet = 1234;
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    public void login(View view) {
        String username = etUsername.getText().toString();
        int password = Integer.parseInt(etPassword.getText().toString());

        try {
            if (!isEmpty(username) || !isEmpty(String.valueOf(password))) {
                if (username.contains(usernameSet) && password == passwordSet) {
                    Intent paymentCalculator = new Intent(MainActivity.this, CalculoHoras.class);
                    startActivity(paymentCalculator);
                    //finish();
                } else {
                    etUsername.setText("Usuario o contraseña incorrecto");
                    etPassword.setText("");
                }
            } else {
                etUsername.setText("No puede estar nulo");
            }

        } catch (Exception e) {
            etUsername.setText("Ha ocurrido un error");
        }
    }
}
