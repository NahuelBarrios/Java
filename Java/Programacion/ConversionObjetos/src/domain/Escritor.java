package domain;

public class Escritor extends Empleado{
    
    private final TipoEscritura escritura;
    
    public Escritor(String nombre,double sueldo,TipoEscritura escritura)
    {
        super(nombre,sueldo);
        this.escritura = escritura;
    }
    
    @Override
    public String obtenerDetalles()
    {
        return super.obtenerDetalles() + ", tipo De escritura: "+ escritura.getDescripcion();
    }

    public TipoEscritura getEscritura() {
        return escritura;
    }
    
    
    
}
