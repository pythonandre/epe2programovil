package com.Espartans.BazarDeKarla.sesion;

public class UserInfo {

    private static String rol = "";
    private static String nombre = "";
    private static String numeroCelular = "";
    private static String correo = "";

    public static String getRol() {
        return rol;
    }

    public static void setRol(String rol) {
        UserInfo.rol = rol;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        UserInfo.nombre = nombre;
    }

    public static String getNumeroCelular() {
        return numeroCelular;
    }

    public static void setNumeroCelular(String numeroCelular) {
        UserInfo.numeroCelular = numeroCelular;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        UserInfo.correo = correo;
    }
}
