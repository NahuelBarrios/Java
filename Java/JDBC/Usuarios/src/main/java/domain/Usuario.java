package domain;

public class Usuario {
  
    //Atributos
    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;
    
    //Constructores

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombreUsuario, String passwordUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Usuario(int idUsuario, String nombreUsuario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }
    
    //gets and sets and ToString

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return this.passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", passwordUsuario=" + passwordUsuario + '}';
    }
    
    
    
    
    
}
