package BLL;

public class Validar{
    
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static boolean userIsNull(Usuario u){
        return false;
    }
    
}
