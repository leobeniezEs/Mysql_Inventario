import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class Productos {
    private ArrayList<Producto> pro;
    public Productos() {
        pro = new ArrayList<Producto>();
    }
     public void agregar(Producto p) {
        pro.add(p);
    }
    
    public void borrar(Producto p) {
        pro.remove(p);
    }
    
    public Producto obtener(int pos) {
        return pro.get(pos);
    }
    
    public Producto buscar(String clave) {
        for (int i = 0; i < pro.size(); i++) {
            if(clave.equals(pro.get(i).getClave()))
                return pro.get(i);
        }
        return null;
    }
    
    public int numElementos() {
        return pro.size();
    }
    
    public void leerDatos() {
        cargar();
    }
    
    void cargar() {
        try {
            File archivo = new File("productos.txt");
            if(archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
                String linea;
                while((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    String clave = st.nextToken().trim();
                    String proveedor = st.nextToken().trim();
                    String tipo = st.nextToken().trim();
                    String producto = st.nextToken().trim();
                    int piezas = Integer.parseInt(st.nextToken().trim());
                    int precio = Integer.parseInt(st.nextToken().trim());
//                    Producto p2 = new Producto(clave, proveedor, tipo, producto, piezas, precio);
//                    agregar(p2);
                }
            }     
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e);
        }   
    }
    public void guardar() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("productos.txt"));
            for(int i=0; i<numElementos(); i++) {
                pw.println(obtener(i).getClave()+","+obtener(i).getProveedor()+","+
                        obtener(i).getTipoProducto()+","+obtener(i).getNombreProducto()+","+obtener(i).getPiezas()+","+obtener(i).getPrecio());
                 JOptionPane.showMessageDialog(null, "el producto se guardo con exito: ");
            }
            pw.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e);
        }
    }

    void borrar(int fila) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
