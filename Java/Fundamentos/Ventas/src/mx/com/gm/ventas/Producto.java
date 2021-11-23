
package mx.com.gm.ventas;

public class Producto {
    
    //Atributos: 
    private int idProducto;
    private String nombre;
    private double precio;
    private static int contadorProductos;
    
    //Constructor
    private Producto()    
    {
        this.idProducto = ++Producto.contadorProductos;
    }
    
    public Producto(String nombre,double precio)
    {
        this();
        this.nombre = nombre;
        this.precio = precio;
        
    }
    
    //Get, Set And ToString

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{idProducto=").append(idProducto);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
