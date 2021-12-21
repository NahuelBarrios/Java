package utileria;

import java.text.SimpleDateFormat;
import java.util.*;

public class Conversiones {

    private static final String FORMATO_FECHA = "dd-MM"; // La constante contiene el formato de fecha
    
    public static String format(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
        
    }
    
    public static String format(String fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
        
    }
}
