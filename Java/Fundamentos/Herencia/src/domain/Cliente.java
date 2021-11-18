package domain;

import java.util.Date;

public class Cliente extends Persona{

    private int idCliente;
    private static int contadorClientes;
    private Date fechaRegistro;
    private boolean vip;

    //Constructores
    public Cliente(Date fechaRegistro,boolean vip,String nombre, char genero, int edad, String direccion) {
        
        super(nombre,genero,edad,direccion);//Primero inicializamos las variables padre y despues las hijas
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
        this.idCliente = ++Cliente.contadorClientes;   
    }

    //Metodos
    public int getIdCliente() {
        return idCliente;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return this.vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
    //ToString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{idCliente=").append(idCliente);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", vip=").append(vip);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
    
}
