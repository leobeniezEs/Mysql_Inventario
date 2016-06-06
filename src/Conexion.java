import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    Connection cn;
    static String BD = "Inicio";
    static String login = "root";
    static String password = "nick132";
    static String url = "jdbc:mysql://localhost/"+ BD;
    private static Connection conexion = null;
    
    public Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(url, login, password);

            if (conexion != null) {
                System.out.println("Coneccion con DB exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        
    }
    
    public Connection getConnection() {
        return conexion;
    }

    
    public static void desconectar() {
        conexion = null;
    }
    
    public Connection conexion(){
      try{ 
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost/sistema","root","123");
        System.out.println("Se hizo la conexion exitosa");
      }catch(Exception e){
          System.out.println(e.getMessage());
      }return cn;
    }    
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }

}    