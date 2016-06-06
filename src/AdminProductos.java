import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdminProductos {
    Conexion conexionOBJ = new Conexion();
    private Connection conn;
    PreparedStatement st;

    public AdminProductos() {
        conn = conexionOBJ.getConnection();
    }
    
    public int guardar(Producto pro) {
        String query = "INSERT INTO Almacen VALUES (?,?,?,?,?,?)";
        int manejador = 0;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, pro.getClave());
            ps.setString(2, pro.getProveedor());
            ps.setString(3, pro.getTipoProducto());
            ps.setString(4, pro.getNombreProducto());
            ps.setInt(5, pro.getPiezas());
            ps.setInt(6, pro.getPrecio());
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
    public int editar(Producto producto) throws Exception {
        String query = "UPDATE producto SET " +
                            "WHERE Clave = ?, " +
                            "Proveedor = ?, " +
                            "Tipo = ?, " +
                            "Producto= ?, " +
                            "Piezas = ?, " +
                            "Precio= ?";
        
        int row = 0;
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, producto.getClave());
            ps.setString(2, producto.getProveedor());
            ps.setString(3, producto.getTipoProducto());
            ps.setString(4, producto.getNombreProducto());
            ps.setInt(5, producto.getPiezas());
            ps.setInt(6, producto.getPrecio());
            
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
    public int eliminar(Producto producto) throws Exception {
        String query = "DELETE FROM Almacen WHERE Clave = ?";
        
        int row = 0;
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, producto.getClave());
            
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
    public void Consulta(String valor){
        String sql = "";
        if(valor.equals("")){
            sql = "SELECT * FROM almacen";
        }
        else{
            sql = "SELECT * FROM almacen WHERE "+"Clave"+"='"+valor+"'";
        }
        try {
            conn = conexionOBJ.getConnection();
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}