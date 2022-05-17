package com.Espartans.BazarDeKarla;

public interface Comunicacion {

    void activarProgressBar(boolean status);
    void lanzarActividad(Class<?> tipoActividad);
    void mostrarMensaje(String msg);

}
