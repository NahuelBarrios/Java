package com.catalogo.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UsuarioResponse {

    public UsuarioResponse() {
    }

    public UsuarioResponse(String nombreUsuario, String apellidoUsuario, String direccionUsuario, String telefono) {

        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.telefono = telefono;
    }

    @JsonInclude(Include.NON_NULL)
    public Long idUsuario;

    public String nombreUsuario;

    public String apellidoUsuario;

    public String direccionUsuario;

    public String telefono;

}
