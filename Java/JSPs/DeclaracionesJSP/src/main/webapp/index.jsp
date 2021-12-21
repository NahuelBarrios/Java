<%-- Agregamos una declaracion de JSP. Al utilizar Declaraciones, podemos utilizar los metodos y si es publico, privado, etc. y las variables se declaran en la clase . en cambio se 
declararian en un try--%>
<%! 
    //Declaramos un atributo con su metodo get
    private String nombre = "Nahuel";
    
    public String getNombre(){
        return this.nombre;
    }

    //Declaramos contador de visitas
    private int contadorVisitas = 1;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones con JSP</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSP!</h1>
        Valor de usuario por medio de atributo: <%= this.nombre %>
        <br>
        Valor de usuario por Metodo getNombre: <%= this.getNombre() %>
        <br>
        Contador de visitas: <%= this.contadorVisitas++ %>
    </body>
</html>
