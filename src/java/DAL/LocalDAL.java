package DAL;

import BLL.Escribir;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalDAL {
    
    private Conexion conn;
    
    public LocalDAL(){
        conn = new Conexion();
    }
    
    public int insertLocal(BLL.Local i){
        try
        {
            String sql = "insert into local values (?,?)";
            PreparedStatement insert = conn.crearSentencia(sql);
            insert.setInt(1, i.getIdlocal());
            insert.setString(2, i.getNombreLocal());
            return insert.executeUpdate();
        }
        catch(SQLException e)
        {
            Escribir.escribir("***LocalDAL.java --> insertLocal(BLL.Local i): " + e.getMessage());
            return e.getErrorCode();
        }
    }
        
    public ArrayList<BLL.Local> selectLocales(){
        try
        {
            ArrayList<BLL.Local> Locales = new ArrayList<>();
            String sql = "select * from local order  by nombrelocal";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet listado = select.executeQuery();
            while(listado.next())
            {
                Locales.add(new BLL.Local(listado.getInt(1), listado.getString(2)));
            }
            return Locales;
        }
        catch(SQLException e)
        {
            Escribir.escribir("***LocalDAL.java --> selectLocales(): " + e.getMessage());
            return null;
        }
    }
    
    public int maxLocal(){
        try
        {
            String sql = "select max(idlocal) from local";
            PreparedStatement count = conn.crearSentencia(sql);
            ResultSet valor = count.executeQuery();
            if(valor.next())
            {
                return valor.getInt(1);
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            Escribir.escribir("***LocalDAL.java --> maxLocal(): " + e.getMessage());
            return -1;
        }
    }

    public int obtenerIdLocal(String nombre){
        try
        {
            String sql = "Select idlocal from local where nombrelocal = ?";
            PreparedStatement obtener = conn.crearSentencia(sql);
            obtener.setString(1, nombre);
            ResultSet valor = obtener.executeQuery();
            if(valor.next())
            {
                return valor.getInt(1);
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            Escribir.escribir("***LocalDAL.java --> obtenerIdLocal(String nombre): " + e.getMessage());
            return -1;
        }
    }
    
    public String obtenerNombreLocal(int id){
        try
        {
            String sql = "Select nombrelocal from local where idlocal = ?";
            PreparedStatement obtener = conn.crearSentencia(sql);
            obtener.setInt(1, id);
            ResultSet valor = obtener.executeQuery();
            if(valor.next())
            {
                return valor.getString(1);
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            Escribir.escribir("***LocalDAL.java --> obtenerNombreLocal(int id): " + e.getMessage());
            return null;
        }
    }
    
    /////
    public ResultSet localesDAL(){
        try
        {
            String sql = "select * from local order  by nombrelocal";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet listado = select.executeQuery();
            return listado;
        }
        catch(SQLException e)
        {
            Escribir.escribir("***LocalDAL: "+e.getMessage());
            return null;
        }
    }
    /////

}














