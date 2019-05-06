package com.example.recyclerviewbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.recyclerviewbd.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Escuela) {
        Escuela.execSQL(Utilidades.CREAR_TABLA_ALUMNOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Escuela, int versionAntigua, int versionNueva) {
        Escuela.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ALUMNOS);
        onCreate(Escuela);
    }
}
