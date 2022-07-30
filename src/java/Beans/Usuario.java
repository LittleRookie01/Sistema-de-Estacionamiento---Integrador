package Beans;

public class Usuario {
    
private String dni;
private String usuario;
private String email;
private String contrasena;
private String cargo;

//Constructor

    public Usuario(String dni, String usuario, String email, String contrasena, String cargo) {
        this.dni = dni;
        this.usuario = usuario;
        this.email = email;
        this.contrasena = contrasena;
        this.cargo = cargo;
    }

//Getter and Setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
