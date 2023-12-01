package Paquete.Modelos;

public class Mascota {
    private int codigo;
    private int numChip;
    private String nombre;
    private Boolean corrienteVacunacion;
    private Dueno dueno;

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Mascota(int numChip, String nombre, Boolean corrienteVacunacion, Dueno dniDueno){
        this.numChip = numChip;
        this.nombre = nombre;
        this.corrienteVacunacion = corrienteVacunacion;
        this.dueno = dniDueno;
    }

    public Mascota(){
    }

    public int getNumChip() {
        return numChip;
    }
    public void setNumChip(int numChip) {
        this.numChip = numChip;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getCorrienteVacunacion() {
        return corrienteVacunacion;
    }
    public void setCorrienteVacunacion(Boolean corrienteVacunacion) {
        this.corrienteVacunacion = corrienteVacunacion;
    }
    
}
