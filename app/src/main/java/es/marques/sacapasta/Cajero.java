package es.marques.sacapasta;

/**
 * Created by Josue on 18/03/2016.
 */
public class Cajero {

    private String nombre;
    private String direccion;
    private String tipo;

    public Cajero(String name, String direction, String type){
        this.setDireccion(direction);
        this.setNombre(name);
        this.setTipo(type);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
