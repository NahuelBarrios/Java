package accesorios;

public class ImplementacionMySql implements IAccesoDatos { // Implemento los metodos definidos en la interface

    @Override
    public void insertar() {
        System.out.println("Insertar desde MySql");
    }

    @Override
    public void listar() {
        System.out.println("Listar desde MySql");
    }

    @Override
    public void actualizar() {
        System.out.println("Actualizar desde MySql");
    }

    @Override
    public void eliminar() {
        System.out.println("Eliminar desde MySql");
    }

}
