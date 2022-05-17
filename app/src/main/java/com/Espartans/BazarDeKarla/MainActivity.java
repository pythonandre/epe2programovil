package com.Espartans.BazarDeKarla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.Espartans.BazarDeKarla.database.DatabaseHelper;
import com.Espartans.BazarDeKarla.database.DatabaseUsuario;

public class MainActivity extends AppCompatActivity implements Comunicacion {

    private ProgressBar pgbEjecutando;
    private Button btnIngresar;
    private TextView txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        setTitle("Iniciar sesión");
        pgbEjecutando = findViewById(R.id.pgbEjecutanto);
        btnIngresar = findViewById(R.id.btnIngresar);
        txtUser = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPassword);
        Button btnEjecutar = findViewById(R.id.btnIngresar);
        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        if (database != null) {
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al crear base de datos", Toast.LENGTH_LONG).show();
        }
        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseUsuario databaseUsuario = new DatabaseUsuario(MainActivity.this);

                new LoginActivity(MainActivity.this).execute(databaseUsuario.obtenerUsuario(txtUser.getText().toString(), txtPass.getText().toString()));
            }
        });


    }

    @Override
    public void activarProgressBar(boolean status) {
        if (status) {
            pgbEjecutando.setVisibility(View.VISIBLE);
        } else {
            pgbEjecutando.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void mostrarMensaje(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
