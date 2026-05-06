package vallegrande.edu.pe.modelo;

public class usuario {
    private int id;
    private String nombre;
    private String correo; // Asegúrate que estos nombres coincidan con tu tabla

    public usuario() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
