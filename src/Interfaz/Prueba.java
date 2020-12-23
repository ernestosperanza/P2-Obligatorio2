package Interfaz;

import Dominio.*;


public class Prueba {

    public static void main(String[] args) {

        Sistema sistema;

        try {
            sistema = Sistema.leerDatosPrograma();

        } catch (Exception e) {

            sistema = new Sistema();
        }

        cargarMenu(sistema);
        

    }
    
    public static void cargarMenu(Sistema sistema) {
        VMenu vent = new VMenu(sistema);
        vent.setVisible(true);
    }

    public static void recorerMatriz(int filaInicial, int filaFinal, int columnaInicial,
            int columnaFinal, int[][] matriz) {

        for (int i = filaInicial; i <= filaFinal; i++) {
            for (int j = columnaInicial; j <= columnaFinal; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[] descomponerInput(String input) {

        input = input.trim();
        String[] coordenadas = input.split("-");

        int filaInicial;
        int filaFinal;
        int columnaInicial;
        int columnaFinal;

        if (devolverIndex(coordenadas[0]) > devolverIndex(coordenadas[2])) {
            filaInicial = devolverIndex(coordenadas[2]);
            filaFinal = devolverIndex(coordenadas[0]);
        } else {
            filaInicial = devolverIndex(coordenadas[0]);
            filaFinal = devolverIndex(coordenadas[2]);
        }

        if (Integer.parseInt(coordenadas[1]) > Integer.parseInt(coordenadas[3])) {
            columnaInicial = Integer.parseInt(coordenadas[3]);
            columnaFinal = Integer.parseInt(coordenadas[1]);
        } else {
            columnaInicial = Integer.parseInt(coordenadas[1]);
            columnaFinal = Integer.parseInt(coordenadas[3]);
        }

        int[] resultados = {filaInicial, filaFinal, columnaInicial, columnaFinal};
        return resultados;
    }

    public static int devolverIndex(String letra) {
        String referencia = "ZABCDEFGHIJKLMNO";
        return referencia.indexOf(letra);
    }

    public static boolean verificarRangosDeZona(String unaZona) {

        boolean correcto = true;
        String validas = "ABCDEFGHIJKLMNO";

        try {

            String[] partes = unaZona.split("-");
            String letra1 = partes[0];
            int numero1 = Integer.parseInt(partes[1]);
            String letra2 = partes[2];
            int numero2 = Integer.parseInt(partes[3]);

            if (!validas.contains(letra1) || !validas.contains(letra2)) {
                correcto = false;
            }
            if (numero1 < 1 || numero1 > 50 || numero2 < 1 || numero2 > 50) {
                correcto = false;
            }
        } catch (Exception e) {
            correcto = false;
        }
        return correcto;
    }
}
