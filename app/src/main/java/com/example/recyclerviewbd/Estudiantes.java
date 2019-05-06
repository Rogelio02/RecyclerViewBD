package com.example.recyclerviewbd;


import java.io.Serializable;

public class Estudiantes implements  Serializable{

    private Integer nocontrol;
    private String nombre;
    private String appaterno;
    private String apmaterno;
    private String grupo;

    public Estudiantes(Integer nocontrol, String nombre, String appaterno, String apmaterno, String grupo) {
        this.nocontrol = nocontrol;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.grupo = grupo;
    }

    public Estudiantes(){

    }

    public Integer getnocotrol() {
        return nocontrol;
    }

    public void setnocontrol(Integer nocontrol) {
        this.nocontrol = nocontrol;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getappaterno() {
        return appaterno;
    }
    public void setappaterno(String appaterno) {
        this.appaterno = appaterno;
    }
    public String getapmaterno() {
        return apmaterno;
    }
    public void setapmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getgrupo() {
        return grupo;
    }
    public void setgrupo(String grupo) {
        this.grupo = grupo;
    }
}