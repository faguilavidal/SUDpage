package DAL;

import BLL.Escribir;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CiudadDAL {
    
    private Conexion conn;
    
    public CiudadDAL(){
        conn = new Conexion();
    }
    
    public int insertCiudad(BLL.Ciudad c){
        try
        {
            String sql = "insert into ciudad values (?,?)";
            PreparedStatement insert = conn.crearSentencia(sql);
            insert.setInt(1, c.getIdciudad());
            insert.setString(2, c.getNombreCiudad());
            return insert.executeUpdate();
        }
        catch(SQLException e)
        {
            Escribir.escribir("***CiudadDAL: "+e.getMessage());
            return e.getErrorCode();
        }
    }
        
    public ArrayList<BLL.Ciudad> selectCiudades(){
        try
        {
            ArrayList<BLL.Ciudad> Ciudades = new ArrayList<>();
            String sql = "select * from ciudad order  by nombreciudad";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet listado = select.executeQuery();
            while(listado.next())
            {
                Ciudades.add(new BLL.Ciudad(listado.getInt(1), listado.getString(2)));
            }
            return Ciudades;
        }
        catch(SQLException e)
        {
            Escribir.escribir("***CiudadDAL: "+e.getMessage());
            return null;
        }
    }
    
    /////
    public ResultSet ciudadesDAL(){
        try
        {
            ArrayList<BLL.Ciudad> Ciudades = new ArrayList<>();
            String sql = "select * from ciudad order  by nombreciudad";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet listado = select.executeQuery();
            return listado;
        }
        catch(SQLException e)
        {
            Escribir.escribir("***CiudadDAL: "+e.getMessage());
            return null;
        }
    }
    /////
    
    public int maxCiudad(){
        try
        {
            String sql = "select max(idciudad) from ciudad";
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
            Escribir.escribir("***CiudadDAL: "+e.getMessage());
            return -1;
        }
    }
    
    public int obtenerIdCiudad(String nombre){
        try
        {
            String sql = "Select idciudad from ciudad where nombreciudad = ?";
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
            Escribir.escribir("***CiudadDAL: "+e.getMessage());
            return -1;
        }
    }
    
    public String obtenerNombreCiudad(int id){
        try
        {
            String sql = "Select nombreciudad from ciudad where idciudad = ?";
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
            Escribir.escribir("***CiudadDAL: "+e.getMessage());
            return null;
        }
    }

}














