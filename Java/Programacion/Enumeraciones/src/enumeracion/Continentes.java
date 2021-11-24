package enumeracion;

public enum Continentes {
    
    //Enum
    AFRICA(53),
    ASIA(46),
    EUROPA(44),
    AMERICA(34),
    OCEANIA(14);
    
    //Atributo
    private final int paises;
    
    //Constructor
    Continentes(int paises)
    {
        this.paises = paises;
    }
    
    //get
    public int getPaises()
    {
        return this.paises;
    }
    
}
