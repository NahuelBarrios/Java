/* El famoso hola mundo
public class HolaMundo 
{
    public static void main(String args[])    
    {
        System.out.println("Hola mundo");
    }
}
*/

public class HolaMundo 
{
    public static void main(String args[])    
    {
        int numEntero = 10;
       System.out.println(numEntero);// sout + tab 
       
       String cadenaString ="Que onda wacho";
        System.out.println(cadenaString);
        
        // var - Inferencia de tipo de datos en Java
        var numDos = 8;
        System.out.println(numDos);
        
        var stringDos = "Como estas?";
        
        System.out.println("Hola " + stringDos); //soutv + tab
        
        //Concatenar 2 variables
        var concatenadoUno ="Walter";
        var concatenadoDos ="Barrios";
        var union= concatenadoUno + " " + concatenadoDos;
        System.out.println("nombre: " + union );
        
        var numOne = 3;
        var numTwo = 5;
        System.out.println(numOne+numTwo);
        System.out.println(numOne+numTwo+union);
        System.out.println(union+numOne+numTwo); // Si la cadena de string esta primero, concatena todo. si hay numeros primero, realiza la operacion
        System.out.println(union+(numOne+numTwo));// Se prioriza el parentesis, asi que si se realiza la operacion
    }
}