package com.Espartans.BazarDeKarla.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "bazardekarla.db";
    public static final String TABLE_CATEGORIA = "categoria";
    public static final String TABLE_SUBCATEGORIA = "subcategoria";
    public static final String TABLE_ARTICULO = "articulo";
    public static final String TABLE_USUARIO = "usuario";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CATEGORIA + " (id_categoria INTEGER PRIMARY KEY, nombre TEXT NOT NULL);");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SUBCATEGORIA + " (id_subcategoria INTEGER PRIMARY KEY,id_categoria INTEGER,nombre TEXT NOT NULL,FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria) ON DELETE CASCADE ON UPDATE NO ACTION);");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ARTICULO + " (id_articulo INTEGER PRIMARY KEY,id_subcategoria INTEGER,medida_cm_alto real,medida_cm_ancho real,medida_cm_diametro real,color TEXT NOT NULL,precio INTEGER NOT NULL,descuento INTEGER DEFAULT 0 NOT NULL,stock INTEGER DEFAULT 0 NOT NULL,FOREIGN KEY (id_subcategoria) REFERENCES subcategoria (id_subcategoria) ON DELETE CASCADE ON UPDATE NO ACTION);");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USUARIO + " (id_usuario INTEGER PRIMARY KEY,rol TEXT NOT NULL,nombre TEXT NOT NULL,correo TEXT NOT NULL,clave TEXT NOT NULL,numero_celular INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
