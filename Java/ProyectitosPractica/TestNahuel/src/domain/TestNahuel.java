package domain;

import java.util.Arrays;
import java.util.Collections;

public class TestNahuel {

    public static void main(String[] args) {

        int numeros[] = {1, 2,33,8, 6, 3, 4, 28, 496};
        TestNahuel test = new TestNahuel();
        
        
        //test.ordenarMenorMayor(numeros);

        //test.ordenarMayorMenor(numeros);

        //test.numeroPerfecto(numeros);
        
        test.numeroPrimo(numeros);

    }

    public void ordenarMenorMayor(int array[]) {

        if (array != null) {
            Arrays.sort(array);

            for (int i = 0; i < array.length; i++) {
                System.out.println("" + array[i]);
            }
        }
        else
        {
            System.out.println("el array que usted subio, es nulo");
        }

    }

    public void ordenarMayorMenor(int array[]) {

        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println("" + array[i]);
        }
    }

    public void numeroPerfecto(int[] numero) {

        for (int j = 0; j < numero.length; j++) {
            int acumulador = 0;
            int contador = 0;
            for (int i = 1; i < numero[j]; i++) //No tengo q poner q i=0 pq sino no me deja dividir con el resto 0.
            {
                if (numero[j] % i == 0) {
                    acumulador = acumulador + i;
                }
            }

            if (numero[j] == acumulador) {
                System.out.println(numero[j] + " Es perfecto");
            } else {
                System.out.println(numero[j] + " No es perfecto");
            }

        }

    }
    
    public void numeroPrimo(int[] numero)
    {
        for(int i = 0;i < numero.length; i++)
        {
            int contador = 0;
            
            for(int j = 1; j <= numero[i]; j++)
            {
                if(numero[i] % j == 0)
                {
                    contador++;
                }
            }
            
            if(contador == 2)
            {
                System.out.println(numero[i] + " Es primo");
            }
            else{
                System.out.println(numero[i]+ " No es primo");
            }
            
        }
    }
    
}
