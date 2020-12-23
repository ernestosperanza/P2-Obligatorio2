
package Dominio;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String nombre;
    private String cedula;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String unaCedula) {
            this.cedula = unaCedula;
    }

    @Override
    public String toString() {
        return " --  ";
    }
}
