package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAL {
    
    private Conexion conn;
    
    public PersonaDAL(){
        conn = new Conexion();
    }
    
    public int insertPersona(BLL.Persona p){
        try
        {
            String sql = "insert into persona values(?,?,?,?,?,?,?,?)";
            PreparedStatement insert = conn.crearSentencia(sql);
            insert.setInt(1,p.getRut());
            insert.setString(2, p.getNombre());
            insert.setInt(3, p.getContacto());
            insert.setInt(4, p.getFolio());
            insert.setString(5, p.getAlojamiento());
            insert.setInt(6, p.getIdciudad());
            insert.setInt(7, p.getIdiglesia());
            insert.setInt(8, p.getAño());
            return insert.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }
    
    public int deletePersona(int rut){
        try
        {
            String sql = "delete from persona where rut = ?";
            PreparedStatement delete = conn.crearSentencia(sql);
            delete.setInt(1, rut);
            return delete.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }
    
    public int updatePersona(BLL.Persona p){
        try
        {
            String sql = "update persona set nombre = ?, Contacto = ?, Folio = ?, Alojamiento = ?, idciudad = ?, idiglesia = ?, año = ? where rut = ?";
            PreparedStatement update = conn.crearSentencia(sql);
            update.setString(1, p.getNombre());
            update.setInt(2, p.getContacto());
            update.setInt(3, p.getFolio());
            update.setString(4, p.getAlojamiento());
            update.setInt(5, p.getIdciudad());
            update.setInt(6, p.getIdiglesia());
            update.setInt(7, p.getAño());
            update.setInt(8,p.getRut());
            return update.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }
    
    public BLL.Persona buscarPersona(int rut){
        try
        {
            String sql = "select * from persona where rut = ?";
            PreparedStatement search = conn.crearSentencia(sql);
            search.setInt(1, rut);
            ResultSet persona = search.executeQuery();
            if(persona.next())
            {
                BLL.Persona p = new BLL.Persona();
                p.setRut(persona.getInt(1));
                p.setNombre(persona.getString(2));
                p.setContacto(persona.getInt(3));
                p.setFolio(persona.getInt(4));
                p.setAlojamiento(persona.getString(5));
                p.setIdciudad(persona.getInt(6));
                p.setIdiglesia(persona.getInt(7));
                p.setAño(persona.getInt(8));
                return p;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            return null;
        }
    }
    
    public ArrayList<BLL.Persona> selectPersonas(){
        try
        {
            ArrayList<BLL.Persona> personas = new ArrayList<>();
            String sql = "select * from persona order by idciudad";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet listado = select.executeQuery();
            while(listado.next())
            {
                BLL.Persona p = new BLL.Persona();
                p.setRut(listado.getInt(1));
                p.setNombre(listado.getString(2));
                p.setContacto(listado.getInt(3));
                p.setFolio(listado.getInt(4));
                p.setAlojamiento(listado.getString(5));
                p.setIdciudad(listado.getInt(6));
                p.setIdiglesia(listado.getInt(7));
                p.setAño(listado.getInt(8));
                personas.add(p);
            }
            return personas;
        }
        catch(SQLException e)
        {
            return null;
        }
    }  
}
