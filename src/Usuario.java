public class Usuario {
    private String nomUsuario;
    private String password;
    private int cveTipo;
    private String nombre;

    public void Usuario(String strNomUsuario, String strPassword, String strNombre, 
        int nCveTipo) {
        this.nomUsuario = strNomUsuario;
        this.password = strPassword;
        this.cveTipo = nCveTipo;
        this.nombre = strNombre;
    }
        
    public void setNomUsuario(String strNomUsuario) {
        this.nomUsuario = strNomUsuario;
    }
    
    public void setPassword(String strPassword) {
        this.password = strPassword;
    }
    
    public void setTipoUsuario(int nCveTipo) {
        this.cveTipo = nCveTipo;
    }
    
    public void setNombre(String strNombre) {
        this.nombre = strNombre;
    }
    
    public String getNomUsuario() {
        return nomUsuario;
    }
    
    public String getPasswod() {
        return password;
    }
    
    public int getTipoUsuario() {
        return cveTipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
}