package com.example.recyclerviewbd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt_nocontrol, edt_nombre, edt_appaterno, edt_apmaterno, edt_grupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton btn = findViewById(R.id.btnadd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, registro.class));


            }
        });
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"Escuela",null,1);


        edt_nocontrol = (EditText) findViewById(R.id.textnocontrol);
        edt_nombre = (EditText) findViewById(R.id.textNombre);
        edt_appaterno = (EditText) findViewById(R.id.textAppaterno);
        edt_apmaterno= (EditText) findViewById(R.id.textApmaterno);
        edt_grupo= (EditText) findViewById(R.id.textgrupo);
    }

    public void RegistrarAlumno(View view)
    {
        Conexion CN = new Conexion(this, "Escuela", null, 1);
        SQLiteDatabase cn = CN.getWritableDatabase();

        String nocontrol = edt_nocontrol.getText().toString();
        String nombre = edt_nombre.getText().toString();
        String appaterno = edt_appaterno.getText().toString();
        String apmaterno = edt_apmaterno.getText().toString();
        String grupo = edt_grupo.getText().toString();

        if (!nocontrol.isEmpty() && !nombre.isEmpty() && !appaterno.isEmpty() && !appaterno.isEmpty() &&!grupo.isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("nocontrol", nocontrol);
            registro.put("nombre", nombre);
            registro.put("appaterno", appaterno);
            registro.put("apmaterno", apmaterno);
            registro.put("grupo", grupo);

            cn.insert("Alumnos", null, registro);

            cn.close();

            edt_nocontrol.setText("");
            edt_nombre.setText("");
            edt_appaterno.setText("");
            edt_apmaterno.setText("");
            edt_grupo.setText("");

            Toast.makeText(this, "Registro guardado con exito!", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, "El llenado de todos los campos es obligatorio", Toast.LENGTH_SHORT).show();
        }
    }

    public void BuscarAlumno(View view)
    {
        Conexion CN = new Conexion(this, "Escuela", null, 1);
        SQLiteDatabase cn = CN.getWritableDatabase();

        String nocontrol = edt_nocontrol.getText().toString();

        if (!nocontrol.isEmpty())
        {
            Cursor fila = cn.rawQuery
                    ("Select nombre, appaterno, Apmaterno, grupo from Alumnos WHERE nocontrol =" + nocontrol, null);

            if (fila.moveToFirst())
            {
                edt_nombre.setText(fila.getString(0));
                edt_appaterno.setText(fila.getString(1));
                edt_apmaterno.setText(fila.getString(2));
                edt_apmaterno.setText(fila.getString(3));
                cn.close();
            }
            else
            {
                Toast.makeText(this, "Alumno no registrado, lo siento", Toast.LENGTH_SHORT).show();
                cn.close();
            }
        }
        else
        {
            Toast.makeText(this, "Ingresa un nocontrol", Toast.LENGTH_SHORT).show();
        }
    }

    public void BuscarRegistros(View view)
    {
        String registros = "";
        Conexion CN = new Conexion(this, "Escuela", null, 1);
        SQLiteDatabase cn = CN.getWritableDatabase();

        if (cn != null) {

            Cursor cursor = cn.rawQuery("SELECT * FROM Alumnos", null);

            if (cursor.moveToFirst())
            {
                do
                {
                    registros += cursor.getInt(cursor.getColumnIndex("nocontrol"));
                    registros += " ";
                    registros += cursor.getString(cursor.getColumnIndex("nombre"));
                    registros += " ";
                    registros += cursor.getString(cursor.getColumnIndex("appaterno"));
                    registros += " ";
                    registros += cursor.getString(cursor.getColumnIndex("apmaterno"));
                    registros += " ";
                    registros += cursor.getString(cursor.getColumnIndex("grupo"));
                    registros += "\n";
                }
                while (cursor.moveToNext());
            }
            if (registros.equals(""))
            {
                Toast.makeText(MainActivity.this, "No hay registros", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, registros, Toast.LENGTH_LONG).show();
                cn.close();
            }
            cn.close();
        }
    }

    public void ActualizarAlumno(View view)
    {
        Conexion CN = new Conexion(this, "Escuela", null, 1);
        SQLiteDatabase cn = CN.getWritableDatabase();

        String nocontrol = edt_nocontrol.getText().toString();
        String nombre = edt_nombre.getText().toString();
        String appaterno = edt_appaterno.getText().toString();
        String apmaterno = edt_apmaterno.getText().toString();
        String grupo = edt_grupo.getText().toString();

        if (!nocontrol.isEmpty() && !nombre.isEmpty() && !appaterno.isEmpty() && !apmaterno.isEmpty() && !grupo.isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("nocontrol", nocontrol);
            registro.put("nombre", nombre);
            registro.put("appaterno", appaterno);
            registro.put("apmaterno", apmaterno);
            registro.put("grupo", grupo);

            int Actualizados = cn.update
                    ("Alumnos", registro, "nocontrol =" + nocontrol, null);
            cn.close();

            if(Actualizados == 1)
            {
                Toast.makeText(this, "Los datos se han actualizado con exito", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Alumno no registrado, lo siento", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void EliminarAlumno(View view)
    {
        Conexion CN = new Conexion(this, "Escuela", null, 1);
        SQLiteDatabase cn = CN.getWritableDatabase();

        String nocontrol = edt_nocontrol.getText().toString();

        if (!nocontrol.isEmpty())
        {
            int Eliminados = cn.delete
                    ("Alumnos", "nocontrol =" + nocontrol, null);
            cn.close();

            edt_nocontrol.setText("");
            edt_nombre.setText("");
            edt_appaterno.setText("");
            edt_apmaterno.setText("");
            edt_grupo.setText("");

            if(Eliminados == 1)
            {
                Toast.makeText(this, "Alumno dado de baja", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "El alumno no está registrado", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Introduce una matricula", Toast.LENGTH_SHORT).show();
        }
    }
}