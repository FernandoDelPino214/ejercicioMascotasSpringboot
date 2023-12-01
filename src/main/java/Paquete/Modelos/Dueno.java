package Paquete.Modelos;


public class Dueno {
    private String dni;
    private String nombre;

    public Dueno(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }

    public Dueno(){
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}