package Dominio;

import java.util.*;
import java.io.*;

public class Sistema implements Serializable {

    private ArrayList<Piloto> listaPilotos;
    private ArrayList<Tecnico> listaTecnicos;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Registro> listaRegistros;
    private int[][] mapaPrincipal;

    public Sistema() {
        listaPilotos = new ArrayList<>();
        listaTecnicos = new ArrayList<>();
        listaProductos = new ArrayList<>();
        listaRegistros = new ArrayList<>();
        mapaPrincipal = new int[16][51];
        iniciarMapa(mapaPrincipal);
    }

    //----------------- Metodos relacionados con Piloto ----------------------//
    public void setPiloto(Piloto unPiloto) {
        listaPilotos.add(unPiloto);
    }

    public ArrayList<Piloto> getPiloto() {
        return listaPilotos;
    }

    // Retornar la lista de pilotos ordenada por nombre en forma decreciente.
    public ArrayList<Piloto> listaDePilotosOrdenadaDecrecientemente() {
        Collections.sort(this.getPiloto(), new Comparator<Piloto>() {
            @Override
            public int compare(Piloto obj1, Piloto obj2) {
                int x = obj2.getExperiencia();
                int y = obj1.getExperiencia();
                if (x < y) {
                    return -1;
                }
                if (x > y) {
                    return 1;
                }
                return 0;
            }
        });
        return this.getPiloto();
    }

    // Validar la no existencia de la Cedula Piloto
    public boolean validarCedulaPiloto(String unaCedula) {

        for (int i = 0; i < this.getPiloto().size(); i++) {
            if (this.getPiloto().get(i).getCedula().equalsIgnoreCase(unaCedula)) {
                return false;
            }
        }
        
        return validarNumeroDeCedula(unaCedula);
    }

    // Metodo que llama al constructor en la clase piloto
    public void crearPiloto(String nombre, String cedula,
            String direccion, int añosDeExperiencia) {

        Piloto piloto = new Piloto(nombre, cedula, direccion, añosDeExperiencia);
        this.setPiloto(piloto);
    }

    //----------------- Metodos relacionados con Tecnico ---------------------//
    public void setTecnico(Tecnico unTecnico) {
        listaTecnicos.add(unTecnico);
    }

    public ArrayList<Tecnico> getTecnico() {
        return listaTecnicos;
    }

    // Retornar la lista de Tecnicos ordenada por nombre.
    public ArrayList<Tecnico> listaDeTecnicosOrdenadaCrecientemente() {
        Collections.sort(this.getTecnico(), new Comparator<Tecnico>() {
            @Override
            public int compare(Tecnico obj1, Tecnico obj2) {
                return obj1.getNombre().compareTo(obj2.getNombre());
            }
        });
        return this.getTecnico();
    }

    // Validar la no existencia de la Cedula Tecnico
    public boolean validarCedulaTecnico(String unaCedula) {

        for (int i = 0; i < this.getTecnico().size(); i++) {
            if (this.getTecnico().get(i).getCedula().equalsIgnoreCase(unaCedula)) {
                return false;
            }
        }
        
        return validarNumeroDeCedula(unaCedula);
    }

    // Validar que el mail usado no este registrado en la lista
    public boolean validarMail(String unMail) {
        boolean esCorrecto = true;

        for (int i = 0; i < this.getTecnico().size(); i++) {
            if (this.getTecnico().get(i).getMail().equals(unMail)) {
                esCorrecto = false;
            }
        }
        return esCorrecto;
    }

    // Metodo que llama al constructor en la clase tecnico
    public void crearTecnico(String nombre, String cedula, String mail) {
        Tecnico tecnico = new Tecnico(nombre, cedula, mail);
        this.setTecnico(tecnico);

    }

    //---------------- Metodos relacionados con Producto ---------------------//
    public void setProducto(Producto unProducto) {
        listaProductos.add(unProducto);
    }

    public ArrayList<Producto> getProducto() {
        return listaProductos;
    }

    // Retornar la lista de Productos ordenada por nombre.
    public ArrayList<Producto> listaDeProductosOrdenadaPorNombre() {
        Collections.sort(this.getProducto(), new Comparator<Producto>() {
            @Override
            public int compare(Producto obj1, Producto obj2) {
                return obj1.getNombre().compareTo(obj2.getNombre());
            }
        });
        return this.getProducto();
    }

    // Validar la no existencia de el nombre del Producto
    public boolean validarNombreProducto(String unNombre) {

        boolean esCorrecto = true;

        for (int i = 0; i < this.getProducto().size(); i++) {
            if (this.getProducto().get(i).getNombre().equalsIgnoreCase(unNombre)) {
                esCorrecto = false;
            }
        }
        if (unNombre.length() < 1) { //Tiene que tener al menos 3 letras
            esCorrecto = false;
        }
        return esCorrecto;
    }

    // Metodo que llama al constructor en la clase producto
    public void crearProducto(String nombre, float costo, String origen) {
        Producto producto = new Producto(nombre, costo, origen);
        this.setProducto(producto);
    }

    //--------------- Metodos relacionados con Registros ---------------------//
    public void setRegistro(Registro unRegistro) {
        listaRegistros.add(unRegistro);
    }

    public ArrayList<Registro> getRegistro() {
        return listaRegistros;
    }

    public void crearRegistro(Piloto unPiloto, Tecnico unTecnico, Producto unProducto,
            int unDia, String unaZona, int[] unMapaDeRegistro) {

        Registro registro = new Registro(unPiloto, unTecnico, unProducto, unDia, unaZona, unMapaDeRegistro);
        this.actualizarMapaPrincipal(registro.getMapa());
        this.setRegistro(registro);
    }

    //---------------- Metodos relacionados con el Mapa ----------------------//
    public void setMapaPrincipal(int[][] unMapa) {
        mapaPrincipal = unMapa;
    }

    public int[][] getMapaPrincipal() {
        return mapaPrincipal;
    }

    public void iniciarMapa(int[][] unMapa) {
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 51; j++) {
                unMapa[i][j] = 0;
            }
        }
    }

    public void actualizarMapaPrincipal(int[][] unMapa) {
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 51; j++) {
                if (unMapa[i][j] != 0) {
                    mapaPrincipal[i][j] += 1;
                }
            }
        }
    }

    public void actualizarMapa(int[][] unMapa, int[][] otroMapa) {
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 51; j++) {
                if (unMapa[i][j] == 1) {
                    otroMapa[i][j] += 1;
                }
            }
        }
    }

    public void imprimirMapa(int[][] unMapa) {
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 51; j++) {
                System.out.print(unMapa[i][j]);
            }
            System.out.println("");
        }
    }
    

    @Override
    public String toString() {
        return " --  ";
    }
    
    //----------------------- Metodos Auxiliares -----------------------------//
    
    public boolean validarNumeroDeCedula(String unaCedula) {

        boolean esCorrecto = true;

        if (unaCedula.indexOf("-") != -1) {

            String cedulaSinGuion = unaCedula.replaceAll("-", "");

            try {
                Integer.parseInt(cedulaSinGuion);

                if (cedulaSinGuion.length() != 8) {
                    esCorrecto = false;
                }

            } catch (Exception e) {
                esCorrecto = false;
            }
        } else {
            esCorrecto = false;
        }
        return esCorrecto;
    }
    
    public static void guardarDatosPrograma(Sistema unSistema) throws IOException {
        
        try {
            
            FileOutputStream archivo = new FileOutputStream("Datos");
            ObjectOutputStream datos = new ObjectOutputStream(archivo);

            datos.writeObject(unSistema);

            datos.close();
            
        } catch (IOException e) {
            
            System.out.println("Error de archivo");
        }
    }
    
    public static Sistema leerDatosPrograma() throws IOException, ClassNotFoundException {
        
        try {
            
            FileInputStream archivo = new FileInputStream("Datos");
            ObjectInputStream datos = new ObjectInputStream(archivo);
        
            Sistema sistema = (Sistema)datos.readObject();
        
            return sistema;
            
        } catch (IOException|ClassNotFoundException e) {
            
            System.out.println("No existen datos hitoricos, se procede a crear un nuevo archivo");
            return new Sistema();
        }
    }
    
    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

}
