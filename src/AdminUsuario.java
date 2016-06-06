import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminUsuario{

    Conexion conexionOBJ = new Conexion();
    private Connection conn;

    public AdminUsuario() {
        conn = conexionOBJ.getConnection();
    }

    public int guardar(Usuario user) {
        String query = "INSERT INTO Inicio VALUES (?, ?, ?,?)";
        int manejador = 0;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getNomUsuario());
            ps.setString(2, user.getPasswod());
            ps.setString(3, user.getNombre());
            ps.setInt(4, user.getTipoUsuario());
            manejador = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Error" +ex.getMessage());
                }
            }
        }

        return manejador;
    }
    
    public int editar(Usuario usuario) throws Exception {
        String query = "UPDATE inicio SET " +
                            "WHERE Usuario = ?, " +
                            "Contrasena = ?, " +
                            "Nombre = ? " +
                            "TipoUsuario= ?";
        
        int row = 0;
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNomUsuario());
            ps.setString(2, usuario.getPasswod());
            ps.setString(3, usuario.getNombre());
            ps.setInt(4, usuario.getTipoUsuario());
            
            row = ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        
        return row;
    }
    
    public int eliminar(Usuario usuario) throws Exception {
        String query = "DELETE FROM inicio WHERE Usuario = ?";
        
        int row = 0;
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNomUsuario());
            
            row = ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        
        return row;
    }
    
    public Usuario login(String usuario, String password) throws Exception {
        Usuario usuario1 = null;
        
        String query = "SELECT usuario, password, nombre, tipoUsuario FROM Inicio WHERE usuario = ? AND password = ?";
        
        int row = 0;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    usuario1 = new Usuario();
                    
                    usuario1.setNomUsuario(rs.getString("usuario"));
                    usuario1.setPassword(rs.getString("password"));
                    usuario1.setNombre(rs.getString("nombre"));
                    usuario1.setTipoUsuario(rs.getInt("tipoUsuario"));
                }
        
            }
            
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            
            if (ps != null) {
                ps.close();
            }
        }
        
        return usuario1;
    }

}