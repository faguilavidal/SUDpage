package BLL;
/*
*   Fabian Aguila
*/
import java.sql.ResultSet;
import java.util.ArrayList;

public class Ciudad {
    private int idciudad;
    private String nombreCiudad;

    public Ciudad() {
    }

    public Ciudad(int idciudad, String nombreCiudad) {
        this.idciudad = idciudad;
        this.nombreCiudad = nombreCiudad;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    @Override
    public String toString(){
        return nombreCiudad;
    }
    
    public int registroMaxCiudad(){
        return new DAL.CiudadDAL().maxCiudad();
    }
    
    public int registrarNuevaCiudad(int id, String nombreCiudad){        
        return new DAL.CiudadDAL().insertCiudad(new Ciudad(id,nombreCiudad));
    }
    
    public ArrayList<Ciudad> listadoCiudades(){
        return new DAL.CiudadDAL().selectCiudades();
    }
    
    public int obtenerIdCiudad(String nombre){
        return new DAL.CiudadDAL().obtenerIdCiudad(nombre);
    }
    
    public String obtenerNombreCiudad(int id){
        return new DAL.CiudadDAL().obtenerNombreCiudad(id);
    }
    
    public ResultSet ciudades(){
        return new DAL.CiudadDAL().ciudadesDAL();
    }
}
