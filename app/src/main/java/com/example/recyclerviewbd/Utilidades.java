package com.example.recyclerviewbd;



public class Utilidades {
    //Constantes campos tabla Alumnos
    public static final String TABLA_ALUMNOS="Alumnos";
    public static final String CAMPO_NOCONTROL="nocontrol";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APPATERNO="appaterno";
    public static final String CAMPO_APMATERNO="apmaterno";
    public static final String CAMPO_GRUPO="grupo";

    public static final String CREAR_TABLA_ALUMNOS="CREATE TABLE " +
            ""+TABLA_ALUMNOS+" ("+CAMPO_NOCONTROL+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE+" TEXT, "+CAMPO_APPATERNO+" TEXT,"+CAMPO_APMATERNO+" TEXT,"+CAMPO_GRUPO+" TEXT)";

}
