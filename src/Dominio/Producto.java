
package Dominio;

import java.io.Serializable;

public class Producto implements Serializable {
    
    private String nombre;
    private float costo;
    private String origen;
    
    public Producto(String unNombre, float unCosto, String unOrigen){
        this.setNombre(unNombre);
        this.setCosto(unCosto);
        this.setOrigen(unOrigen);
    }
    
    public Producto(){
        this.setNombre("sin nombre");
        this.setCosto(0);
        this.setOrigen("sin origen");
    }
    
    public Producto(String unNombre){
        this.setNombre(unNombre);
        this.setCosto(0);
        this.setOrigen("");
    }
    
    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setCosto(float unCosto) {
        this.costo = unCosto;
    }
    
    public float getCosto() {
        return this.costo;
    }
    
    public void setOrigen(String unOrigen) {
        this.origen = unOrigen;
    }
    
    public String getOrigen() {
        return this.origen;
    }
    
    @Override
    public String toString(){
       return Sistema.toTitleCase(this.getNombre());
    }
    
}

