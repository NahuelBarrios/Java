package excepciones;

public class OperacionExcepcion extends Exception{
    
    public OperacionExcepcion (String mensaje) //Recibo el msj donde hay una excepcion
    {
        super(mensaje);
    }
    
}
