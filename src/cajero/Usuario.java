package cajero;


public class Usuario {

    private String nombreUsuario;
    private String nombreTitular;
    private String contrasena;
    private int saldo;

    public Usuario(String nombreUsuario, String nombreTitular, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.nombreTitular = nombreTitular;
        this.contrasena = contrasena;
    }

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getNombreTitular() {
        return nombreTitular;
    }
}
