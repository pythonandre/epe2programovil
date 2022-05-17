package com.Espartans.BazarDeKarla;

import android.os.AsyncTask;

import com.Espartans.BazarDeKarla.database.DatabaseHelper;
import com.Espartans.BazarDeKarla.database.DatabaseUsuario;

public class LoginActivity extends AsyncTask <Object, Void, Boolean>{

    String userActual;

    private Comunicacion comunicacion;
    public LoginActivity(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }

    @Override
    protected void onPreExecute() {
        comunicacion.activarProgressBar(true);
    }

    @Override
    protected Boolean doInBackground(Object... objects) {
        return (boolean) objects[0];
    }

    @Override
    protected void onPostExecute(Boolean bo) {
        if (bo){
            
            if (userActual == "admin"){
                this.comunicacion.lanzarActividad(MenuAdmin.class);
                this.comunicacion.mostrarMensaje("Datos Correctos");
                this.comunicacion.activarProgressBar(false);
            }else if (userActual == "editor"){
                this.comunicacion.lanzarActividad(MenuBodega.class);
                this.comunicacion.mostrarMensaje("Datos Correctos");
                this.comunicacion.activarProgressBar(false);
            }else if (userActual == "vendedor"){
                this.comunicacion.lanzarActividad(MenuVendedor.class);
                this.comunicacion.mostrarMensaje("Datos Correctos");
                this.comunicacion.activarProgressBar(false);
            }
        }else{
            this.comunicacion.mostrarMensaje("Datos Incorrectos");
            comunicacion.activarProgressBar(false);
        }
    }
}
