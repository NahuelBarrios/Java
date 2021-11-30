package domain;

public class Rectangulo extends FiguraGeometrica{

    public Rectangulo(String tipoFigura)
    {
        super(tipoFigura);
    }
    
    @Override
    public void dibujar() // No lo estoy sobreescribiendo, lo estoy implementando
    {
        System.out.println("Se imprime un: " + this.getClass().getSimpleName()); // Imprime el nombre de la clase
        
    }
    
    
}
