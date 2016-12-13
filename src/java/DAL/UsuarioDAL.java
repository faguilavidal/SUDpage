package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAL {
    private final Conexion conn;
    
    public UsuarioDAL(){
        conn = new Conexion();
    }
    
    public int insertUser(BLL.Usuario u){
        try
        {
            String sql = "insert into usuario values(?,?,?,?)";
            PreparedStatement insert = conn.crearSentencia(sql);
            insert.setString(1,u.getUsuario());
            insert.setString(2, u.getContraseña());
            insert.setInt(3, u.getRut());
            insert.setString(4, u.getNombre());
            return insert.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }
    
    public BLL.Usuario buscarUser(String usuario){
        try
        {
            String sql = "select * from usuario where usuario = ?";
            PreparedStatement search = conn.crearSentencia(sql);
            search.setString(1, usuario);
            ResultSet User = search.executeQuery();
            if(User.next())
            {
                BLL.Usuario u = new BLL.Usuario();
                u.setUsuario(User.getString(1));
                u.setContraseña(User.getString(2));
                u.setRut(User.getInt(3));
                u.setNombre(User.getString(4));
                return u;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public boolean buscarRutDAL(int rut){
        try
        {
            String sql = "select * from usuario where rut = ?";
            PreparedStatement search = conn.crearSentencia(sql);
            search.setInt(1, rut);
            ResultSet User = search.executeQuery();
            return User.next();
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
     public ArrayList <BLL.Usuario> ConsultarUser(){
        try
        {
            ArrayList<BLL.Usuario> Usuario = new ArrayList<>();
            String sql = "select * from usuario";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet listado = select.executeQuery();
            while(listado.next())
            { 
                BLL.Usuario u = new BLL.Usuario();
                u.setUsuario(listado.getString(1));
                u.setContraseña(listado.getString(2));
                u.setRut(listado.getInt(3));
                u.setNombre(listado.getString(4));
                Usuario.add(u);
            }
            return Usuario;
        }
        catch(SQLException e)
        {
            return null;
        }
    } 
}