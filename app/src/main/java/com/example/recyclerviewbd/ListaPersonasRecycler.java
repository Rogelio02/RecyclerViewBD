package com.example.recyclerviewbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.recyclerviewbd.Listapersonasadapter;
import com.example.recyclerviewbd.Estudiantes;
import com.example.recyclerviewbd.Utilidades;

public class ListaPersonasRecycler extends AppCompatActivity {

    ArrayList<Estudiantes> listEstudiantes;
    RecyclerView recyclerViewEstudiantes;

    //Conexion conn;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"Escuela",null,1);

        listEstudiantes=new ArrayList<>();

        recyclerViewEstudiantes= (RecyclerView) findViewById(R.id.recyclerestudiantes);
        recyclerViewEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        consultarListaEstudiantes();

        Listapersonasadapter adapter=new Listapersonasadapter(listEstudiantes);
        recyclerViewEstudiantes.setAdapter(adapter);

    }

    private void consultarListaEstudiantes() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Estudiantes estudiantes=null;
        // listaEstudiantes=new ArrayList<Estudiantes>();
        //select * from Alumnos
       Cursor cursor=db.rawQuery(" SELECT * FROM " +Utilidades.TABLA_ALUMNOS,null);

        while (cursor.moveToNext()){
            estudiantes=new Estudiantes();
            estudiantes.setnocontrol(cursor.getInt(0));
            estudiantes.setnombre(cursor.getString(1));
            estudiantes.setappaterno(cursor.getString(2));
            estudiantes.setapmaterno(cursor.getString(3));
            estudiantes.setgrupo(cursor.getString(4));

            listEstudiantes.add(estudiantes);
        }
    }

    private void llenarListaEstudiantes() {
        listEstudiantes.add(new Estudiantes(1,"Carlos","Avendaño","Castellanos","12"));
        listEstudiantes.add(new Estudiantes(2,"Manuel","Ramirez","Gonzales","11"));
        listEstudiantes.add(new Estudiantes(3,"Sofia","Soledad","Perez","13"));
        listEstudiantes.add(new Estudiantes(4,"Marcela","Marquez","Sosa","14"));
        listEstudiantes.add(new Estudiantes(5,"Victoria","Agustin","Lopez","15"));
        listEstudiantes.add(new Estudiantes(6,"Karla","Rodriguez","Garcia","16"));
        listEstudiantes.add(new Estudiantes(7,"Luis","Salazar","Hernandez","17"));
    }
}