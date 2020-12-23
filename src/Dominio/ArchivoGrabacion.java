
package Dominio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class ArchivoGrabacion {
    
    private Formatter out;
    
    public ArchivoGrabacion(String unNombre){
        try{
            out = new Formatter(unNombre);
        }catch(FileNotFoundException e){
            System.out.println("no se puede crear");
            System.exit(1);
        }
    }
    
    public ArchivoGrabacion(String unNombre, boolean ext){
        try{
            FileWriter f = new FileWriter(unNombre, ext);
            out = new Formatter(f);
        }catch(IOException e){
            System.out.println("no se puede crear/extender");
            System.exit(1);
        }
    }
    
    public void grabarLineas(String unaLinea){
        out.format("%s%n", unaLinea);
    }
    
    public void cerrar(){
        out.close();
    }
}
