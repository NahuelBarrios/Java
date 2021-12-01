package accesorios;

public interface IAccesoDatos { 

    int MAX_REGISTRO = 10; // Es un atributo constante Public static final

    // Automanticamente se le agrega el Public Abstract al metodo
    void insertar();

    void listar();

    void actualizar();

    void eliminar();

}
