package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Conexion {
    private Connection conn;
    
    public Conexion(){
        verificarControlador();
        conectarse();
    }
    
    private void verificarControlador(){
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Controlador verificado...");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Falta cargar controlador..." + e.getMessage());
        }
    }
    
    private void conectarse(){
        try
        {   
            String database = "SUD";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/" + database,user,password);
            System.out.println("Conectado correctamente a " + database);
        }
        catch(SQLException e)
        {
            System.out.println("Base de datos desconocida..." + e.getMessage());
        }
    }
    
    public PreparedStatement crearSentencia(String sql){
        try
        {
            return conn.prepareStatement(sql);
        }
        catch(SQLException e)
        {
            System.out.println("***SQLException: "+e.getMessage());
            return null;
        }
    }
}
