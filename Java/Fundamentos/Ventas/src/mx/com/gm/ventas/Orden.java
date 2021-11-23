
package mx.com.gm.ventas;


public class Orden {
    
    private int idOrden;
    private Producto productos[];
    private static int contadorOrdenes;
    private static final int MAX_PRODUCTOS = 10;
    private int contadorProductos;
    
    public Orden()
    {
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }
    
    //Metodos
    
    public void agregarProducto(Producto producto)
    {
        if(this.contadorProductos < Orden.MAX_PRODUCTOS)
            this.productos[this.contadorProductos++] = producto;
        else
            System.out.println("Se ha superado el maximo de productos" + Orden.MAX_PRODUCTOS);
    }
    
    public double calcularTotal()
    {
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) 
        {
            //Producto producto = this.productos[i];
            //total += producto.getPrecio();
            total += this.productos[i].getPrecio();
            
        }
        return total;  
    }
    
    public void mostrarOden()
    {
        System.out.println("Id Oden = " + this.idOrden);
        double total = this.calcularTotal();
        System.out.println("Total de la orden = $" +total);
        System.out.println("Productos de la orden: ");
        for (int i = 0; i < this.contadorProductos; i++) 
        {
            System.out.println(this.productos[i]);
        }
        
    }
    
}
