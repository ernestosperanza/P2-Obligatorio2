
package Dominio;

import java.io.Serializable;

public class Piloto extends Persona implements Serializable {

    private String direccion;
    private int experiencia;

    public Piloto(String unNombre, String unaCedula, String unaDireccion, int unaExperiencia) {
        this.setExperiencia(unaExperiencia);
        this.setDireccion(unaDireccion);
        this.setNombre(unNombre);
        this.setCedula(unaCedula);
    }
    
    public Piloto(){
        setNombre("sin nombre");
        this.setExperiencia(15);
        this.setDireccion("sin direccion");
    }

    public void setDireccion(String unaDireccion) {
        this.direccion = unaDireccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setExperiencia(int unaExperiencia) {
        this.experiencia = unaExperiencia;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    @Override
    public String toString() {
        return Sistema.toTitleCase(this.getNombre()) + " | " + this.getCedula() + " | Años de experiencia: " + this.getExperiencia();
    }
}
