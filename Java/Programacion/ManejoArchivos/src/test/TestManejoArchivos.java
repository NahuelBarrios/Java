package test;

import static manejoarchivos.ManejoArchivos.*;

public class TestManejoArchivos {

    public static void main(String[] args) {
        
        var nombreArchivo = "prueba.txt";
        //ManejoArchivos(nombreArchivo);
        
        escribirArchivo(nombreArchivo,"Hola");
        anexarArchivo(nombreArchivo,"Q onmda");
        leerArchivo(nombreArchivo);
    }
    
}
