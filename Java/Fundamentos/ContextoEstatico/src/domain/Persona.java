/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Nahu_
 */
public class Persona {
    
    private int idPersona;
    private String nombrePersona;
    private static int contadorIdPersona;
    
    public Persona(String nombrePersona)       
    {
        this.nombrePersona = nombrePersona;
       
        Persona.contadorIdPersona++;
        
        this.idPersona = Persona.contadorIdPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    
     public static int getContadorIdPersona() {
        return contadorIdPersona;
    }

    public static void setContadorIdPersona(int aContadorIdPersona) {
        contadorIdPersona = aContadorIdPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombrePersona=" + nombrePersona + '}';
    }
    
    
}
