package vallegrande.edu.pe.modelo;

public class Sitio {
    private int id;
    private String Nombres;
    private String Pais;// Asegúrate que estos nombres coincidan con tu tabla
    private String Años;
    private String Estado;

    public Sitio() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return Nombres; }
    public void setNombre(String nombre) { this.Nombres = nombre; }

    public String getPais() { return Pais; }
    public void setPais(String pais) { this.Pais = pais; }

    public String getAños() { return Años; }
    public void setAños(String años) { this.Años = años; }

    public String getEstado() {return Estado;}
    public void setEstado(String estado) {this.Estado= estado;}

}
