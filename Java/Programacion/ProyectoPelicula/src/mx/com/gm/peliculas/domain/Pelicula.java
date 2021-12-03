package mx.com.gm.peliculas.domain;

public class Pelicula {
    
    //Atributo
    private String pelicula;
    
    //Constructor
    
    public Pelicula()
    {
        
    }
    
    public Pelicula(String pelicula)
    {
        this.pelicula = pelicula;
    }
            
    //Get/Set/ToString

    public String getPelicula() {
        return this.pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return this.pelicula;
    }
    
}
