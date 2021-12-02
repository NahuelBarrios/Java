package manejoarchivos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoArchivos {

    public static void ManejoArchivos(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            //PrintWriter salida = new PrintWriter(archivo); Con ayuda del ide lo hacemos excepcion TRY CATCH. Es posible que el valor del archivo sea null por eso es una excepcion
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se creo el archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            //PrintWriter salida = new PrintWriter(archivo); Con ayuda del ide lo hacemos excepcion TRY CATCH. Es posible que el valor del archivo sea null por eso es una excepcion
            PrintWriter salida = new PrintWriter(archivo); // De esta forma solo se pisa el archivo con el contenido una y otra vez
            salida.println(contenido);
            salida.close();
            System.out.println("Se cargo la escritura el archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void anexarArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            //PrintWriter salida = new PrintWriter(archivo); Con ayuda del ide lo hacemos excepcion TRY CATCH. Es posible que el valor del archivo sea null por eso es una excepcion
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));// Al poner true. estamos diciendo que vamos a hacer un anexo ded la info
            salida.println(contenido);
            salida.close();
            System.out.println("Se cargo la anexacion el archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        try {                                           //Creo el objeto FileReader dentro de otro objeto buffer, ya que buffer lee todo 
            var entrada = new BufferedReader(new FileReader(archivo));// BufferedReader = Podemos leer lineas completas del archivo
            var lectura = entrada.readLine();//Permite leer lineas completas
            while(lectura != null)
            {// Hago un bucle while para imprimir todo. ya que readLine solo lee una sola linea
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
