package BLL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Local {
    private int idlocal;
    private String nombreLocal;

    public Local() {
    }

    public Local(int idlocal, String nombreLocal) {
        this.idlocal = idlocal;
        this.nombreLocal = nombreLocal;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    
    @Override
    public String toString(){
        return nombreLocal;
    }
    
    public int registroMaxLocal(){
        return new DAL.LocalDAL().maxLocal();
    }
    
    public int registrarNuevaLocal(int id, String nombreLocal){        
        return new DAL.LocalDAL().insertLocal(new Local(id,nombreLocal));
    }
    
    public ArrayList<Local> listadoLocales(){
        return new DAL.LocalDAL().selectLocales();
    }
    
    public int obtenerIdLocal(String nombre){
        return new DAL.LocalDAL().obtenerIdLocal(nombre);
    }
    
    public String obtenerNombreLocal(int id){
        return new DAL.LocalDAL().obtenerNombreLocal(id);
    }
    
    public ResultSet locales(){
        return new DAL.LocalDAL().localesDAL();
    }
}
