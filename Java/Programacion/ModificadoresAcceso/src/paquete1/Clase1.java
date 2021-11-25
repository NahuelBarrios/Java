package paquete1;

public class Clase1 { // el tipo Public es menos restrictivos. nos permite acceder a su info desde cualquier clase.
    
    // Atributo, constructor y metodo Protected. No se puede utilizar en otros paquetes/Clases. Tienen su uso las clases hijas en herencia
    
    // El modificador package(Sin definir), solo sirve para utilizarlo en el mismo paquete. 
    
    //Atributo
    public String atributoPublico = "Atributo publico";

    //Constructor
    public Clase1()
    {
        System.out.println("Constructor Publico");
    } 
    
    //Metodo
    public void metodoPublico()
    {
        System.out.println("Metodo publico");
    }
           
    
}
