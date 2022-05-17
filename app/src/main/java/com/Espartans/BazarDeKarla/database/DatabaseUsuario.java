package com.Espartans.BazarDeKarla.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DatabaseUsuario extends DatabaseHelper{

    Context context;

    public DatabaseUsuario(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public boolean obtenerUsuario(String correo, String clave){
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT rol FROM " + TABLE_USUARIO + " where correo = '" + correo + "' and clave = '" + clave + "'", null);
        if (cursor.getCount() > 0){
            return true;
        }

        return false;
    }

}
