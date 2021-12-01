package test;

import java.util.*;

public class TestDeColecciones {

    public static void main(String[] args) {
        List myList = new ArrayList(); // List Almacena los datos de forma ordenada a medida que se van agregando y no tiene "limite" como un array. Se pueden duplicar elementos
        
        myList.add("Lunes");
        myList.add("Martes");
        myList.add("Miercoles");
        myList.add("Jueves");
        myList.add("Viernes");
        myList.add("Sabado");
        myList.add("Domingo");
//        imprimir(myList);
        
        
        Set mySet = new HashSet(); // Set almacena datos. No de forma ordenada. No se pueden duplicar elementos, este los desecha
        mySet.add("Lunes");
        mySet.add("Martes");
        mySet.add("Miercoles");
        mySet.add("Jueves");
        mySet.add("Viernes");
        mySet.add("Sabado");
        mySet.add("Domingo");
        //imprimir(mySet);
        
        
        Map myMap = new HashMap();
        myMap.put("Valor1", "Nahuel");
        myMap.put("Valor2", "Cande");
        myMap.put("Valor3", "Maria");
        
        String elemento = (String)myMap.get("Valor1"); // hay que poner el llave y te muestra los valores
        System.out.println("elemento = " + elemento);
        
        imprimir(myMap.keySet()); // Muestra las llaves
        imprimir(myMap.values()); // Muestra los valores
        
        
    }
    
    public static void imprimir (Collection coleccion) //Collection se encuentra en el paquete java.util
    {
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
        
//         for(Object elemento: coleccion)
//        {
//            System.out.println("elemento = " + elemento);
//        }
        
    }
    
}
