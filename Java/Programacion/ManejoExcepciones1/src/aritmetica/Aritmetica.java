package aritmetica;

import excepciones.OperacionExcepcion;

public class Aritmetica {
    
    public static int division(int nominador, int denominador) throws OperacionExcepcion
    {
        if(denominador == 0)
        {
           throw new OperacionExcepcion("El denominador es 0(Cero)");
        }
        return nominador/denominador;
    }
    
}
