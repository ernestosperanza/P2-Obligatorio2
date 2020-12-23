package Dominio;

import java.util.*;
import java.io.Serializable;

public class Registro implements Serializable {

    private Piloto piloto;
    private Tecnico tecnico;
    private Producto producto;
    private int dia;
    private String zona;
    private int[][] mapa;

    public Registro(Piloto unPiloto, Tecnico unTecnico, Producto unProducto, int unDia, String unaZona, int[] mapaDeF) {
        this.setPiloto(unPiloto);
        this.setTecnico(unTecnico);
        this.setProducto(unProducto);
        this.setDia(unDia);
        this.setZona(unaZona);
        mapa = new int[16][51];
        agregarFumigacion(mapaDeF);
    }

    public void agregarFumigacion(int[] mapaDeFumigacion) {
        int filaInicial = mapaDeFumigacion[0];
        int filaFinal = mapaDeFumigacion[1];
        int columnaInicial = mapaDeFumigacion[2];
        int columnaFinal = mapaDeFumigacion[3];

        for (int i = filaInicial; i <= filaFinal; i++) {
            for (int j = columnaInicial; j <= columnaFinal; j++) {
                mapa[i][j] = +1;
            }
        }
    }

    public void setPiloto(Piloto unPiloto) {
        this.piloto = unPiloto;
    }

    public Piloto getPiloto() {
        return this.piloto;
    }

    public void setTecnico(Tecnico unTecnico) {
        this.tecnico = unTecnico;
    }

    public Tecnico getTecnico() {
        return this.tecnico;
    }

    public void setProducto(Producto unProducto) {
        this.producto = unProducto;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setDia(int unDia) {
        this.dia = unDia;
    }

    public int getDia() {
        return this.dia;
    }

    public void setZona(String unaZona) {
        this.zona = unaZona;
    }

    public String getZona() {
        return this.zona;
    }

    public void setMapa(int[][] unMapa) {
        this.mapa = unMapa;
    }

    public int[][] getMapa() {
        return this.mapa;
    }

    public void iniciarMapa() {
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 51; j++) {
                mapa[i][j] = 0;
            }
        }
    }
    
    @Override
    public String toString(){
        return this.getPiloto()+ "dia: "+this.getDia()+" zona: " + this.getZona();
    }
}