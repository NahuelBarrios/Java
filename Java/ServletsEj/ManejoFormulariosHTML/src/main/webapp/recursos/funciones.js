function validarForma(forma)
{
    //****************************************************************************************
    var usuario = forma.usuario;
    if (usuario.value == "" || usuario.value == "Escribir Usuario") {
        alert("Debe poner el nombre de usuario");
        //Para marcar al usuario lo que debe completar
        usuario.focus();
        usuario.select();
        return false;
    }
    //****************************************************************************************
    var password = forma.password;
    if (password.value == "" || password.value < 3)
    {
        alert("Debe proporcionar un password de al menos 3 caracteres");
        password.focus();
        password.select();
        return false;
    }
    //****************************************************************************************
//    var tecnologias = forma.tecnologia;
//    var checkSeleccionado = false;
//    for (var i = 0; i < tecnologias.length; i++) {
//        if (tecnologias[i].cheked)
//        {
//            checkSeleccionado = true;
//        }
//    }
//
//    if (!checkSeleccionado)
//    {
//        alert("Debe seleccionar una tecnologia");
//        return false;
//    }
      var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    
    for(var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){
            checkSeleccionado = true;
        }
    }
    
    if(!checkSeleccionado){
        alert("Debe seleccionar una tecnología");
        return false;
    }
//    
    //****************************************************************************************
    var generos = forma.genero;
    var radioSeleccionado = false;
    
    for(var i = 0; i < generos.length; i++){
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }
    //****************************************************************************************
    
    var ocupacion = forma.ocupacion;
    if(ocupacion.value == "")
    {
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    //****************************************************************************************
    alert("Anduvo bien chinchulin");
    return true;
    

}

