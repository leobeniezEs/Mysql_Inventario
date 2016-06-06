
import javax.swing.JTextField;

public class Producto {
    private String clave;
    private String proveedor;
    private String tipoProducto;
    private String nombreProducto;
    private int piezas;
    private int precio;   

    public Producto() {
    }
    
    Producto(String clave, String proveedor,String tipoProducto, 
    String nombreProducto, int piezas, int precio) {
    this.clave = clave;
    this.proveedor = proveedor;
    this.tipoProducto = tipoProducto;
    this.nombreProducto = nombreProducto;
    this.piezas = piezas;
    this.precio = precio;
}

    Producto(String string, String string0, String string1, String string2, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Producto(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTextField jTextField6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Producto(String Dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int totalPiezas(String producto,int piezas) {
        int total = 0;
        if (producto != null) {
            
        }
        return total;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
