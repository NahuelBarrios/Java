package test;

import enumeracion.Continentes;
import enumeracion.Dias;

public class TestEnumeraciones {
    public static void main(String[] args) {
        
//        System.out.println("Dia de hoy: " + Dias.LUNES);
//        
//        mostrarDia(Dias.MIERCOLES);

            System.out.println("Continente: "+Continentes.AMERICA+", cantidad de paises: "+Continentes.AMERICA.getPaises());
        
    }
    
    private static void mostrarDia(Dias dias)
    {
        switch(dias)
        {
            case LUNES:
                System.out.println("Hoy es lunes");
                break;
            case MARTES:
                System.out.println("Hoy es martes");
                break;
            case MIERCOLES:
                System.out.println("Hoy es miercoles, se fuma makelele");
                break;
        }
    }
}
