package com.example.recyclerviewbd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.recyclerviewbd.R;
import com.example.recyclerviewbd.Estudiantes;

public class Listapersonasadapter extends RecyclerView.Adapter<Listapersonasadapter.estudiantesViewHolder> {

    ArrayList<Estudiantes> listaEstudiantes;

    public Listapersonasadapter(ArrayList<Estudiantes> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public estudiantesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_personas,null,false);
        return new estudiantesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(estudiantesViewHolder holder, int position) {
        holder.nocontrol.setText(listaEstudiantes.get(position).getnocotrol().toString());
        holder.nombre.setText(listaEstudiantes.get(position).getnombre());
        holder.appaterno.setText(listaEstudiantes.get(position).getappaterno());
        holder.apmaterno.setText(listaEstudiantes.get(position).getapmaterno());
        holder.grupo.setText(listaEstudiantes.get(position).getgrupo());
    }

    @Override
    public int getItemCount() {
        return listaEstudiantes.size();
    }

    public class estudiantesViewHolder extends RecyclerView.ViewHolder {

        EditText nocontrol,nombre, appaterno, apmaterno,grupo;

        public estudiantesViewHolder(View itemView) {
            super(itemView);
            nocontrol = (EditText) itemView.findViewById(R.id.textnocontrol);
            nombre = (EditText) itemView.findViewById(R.id.textNombre);
            appaterno = (EditText) itemView.findViewById(R.id.textAppaterno);
            apmaterno = (EditText) itemView.findViewById(R.id.textApmaterno);
            grupo = (EditText) itemView.findViewById(R.id.textgrupo);
        }
    }
}