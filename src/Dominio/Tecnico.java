
package Dominio;

import java.io.Serializable;

public class Tecnico extends Persona implements Serializable {
    private String mail;
    
    public Tecnico(String unNombre, String unaCedula, String unMail){
        this.setMail(unMail);
        this.setNombre(unNombre);
        this.setCedula(unaCedula);
    }
    
    public Tecnico(){
        setNombre("sin nombre");
        setMail("sin mail");
    }
    
    public void setMail(String unMail){
        this.mail = unMail;
    }
    
    public String getMail(){
        return this.mail;
    }


    @Override
    public String toString(){
        return Sistema.toTitleCase(this.getNombre()) + " | " + this.getCedula();
    }
}
