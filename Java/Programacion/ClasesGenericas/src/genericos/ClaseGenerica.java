package genericos;

public class ClaseGenerica <T>{ // Indica un tipo generico
    
   private T objeto;
    
    public ClaseGenerica(T obecjto)
    {
        this.objeto = obecjto;
    }
    
    public void obtenerTipo()
    {
        System.out.println("El tipo T es: " + objeto.getClass().getSimpleName());
    }
    
}
