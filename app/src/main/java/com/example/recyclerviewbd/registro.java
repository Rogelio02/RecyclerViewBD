package com.example.recyclerviewbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.app.AlertDialog;
import android.content.DialogInterface;


public class registro extends AppCompatActivity {
    private EditText edt_nocontrol, edt_nombre, edt_appaterno, edt_apmaterno, edt_grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
//PARA REGRESAR AL OTRO LAYOUT CON BOTON
       // Button btn2 = (Button) findViewById(R.id.btnatras);
        //btn2.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

          //      startActivity(new Intent(registro.this, MainActivity.class));

          //  }
        //});


        edt_nocontrol = (EditText) findViewById(R.id.txtnocontrol);
        edt_nombre = (EditText) findViewById(R.id.textNombre);
        edt_appaterno = (EditText) findViewById(R.id.txtappaterno);
        edt_apmaterno = (EditText) findViewById(R.id.textApmaterno);
        edt_grupo = (EditText) findViewById(R.id.textgrupo);
    }

    public void dialog(View view) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Acepta que se guarden los datos ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();
    }

    public void aceptar() {
        RegistrarAlumno();
    }

    public void cancelar() {
        Toast t=Toast.makeText(this,"Siga guardando datos", Toast.LENGTH_SHORT);
        t.show();
    }

    public void dialogcancelar(View  view)
    {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Desea regresar a la pantalla principal ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar1();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar1();
            }
        });
        dialogo1.show();
    }

    public void aceptar1() {
        finish();

    }

    public void cancelar1() {
        Toast t=Toast.makeText(this,"Siga guardando datos", Toast.LENGTH_SHORT);
        t.show();
    }


    public void RegistrarAlumno()
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
}
