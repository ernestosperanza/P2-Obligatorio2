
package Interfaz;

import Dominio.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class VCargaDeFumigacionesDeArchivo extends javax.swing.JFrame {

    private Sistema sistema;

    public VCargaDeFumigacionesDeArchivo(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
    }

    public VCargaDeFumigacionesDeArchivo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxDiasArchivo = new javax.swing.JComboBox<>();
        lblDiaArchivo = new javax.swing.JLabel();
        fileChooserArchivo = new javax.swing.JFileChooser();

        setTitle("Carga de fumigaciones por archivo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        comboBoxDiasArchivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboBoxDiasArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDiasArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxDiasArchivo);
        comboBoxDiasArchivo.setBounds(80, 260, 90, 19);

        lblDiaArchivo.setText("Dia:");
        getContentPane().add(lblDiaArchivo);
        lblDiaArchivo.setBounds(40, 260, 40, 20);

        fileChooserArchivo.setControlButtonsAreShown(false);
        fileChooserArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(fileChooserArchivo);
        fileChooserArchivo.setBounds(10, 10, 540, 240);

        setBounds(0, 0, 560, 328);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxDiasArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDiasArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxDiasArchivoActionPerformed

    private void fileChooserArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserArchivoActionPerformed
        try {
            int dia = comboBoxDiasArchivo.getSelectedIndex() + 1;
            ArchivoLectura arch = new ArchivoLectura(fileChooserArchivo.getSelectedFile().getAbsolutePath());
            Piloto piloto = new Piloto();
            Tecnico tecnico = new Tecnico();
            Producto producto = new Producto();

            Scanner entrada = arch.getScanner();
            String primeraLinea = entrada.nextLine();
            String[] datos = primeraLinea.split("#");
            boolean huboErrores = false;
            boolean primero = false;
            boolean segundo = false;
            boolean tercero = false;

            String ciPiloto = datos[0];
            String ciTecnico = datos[1];
            String nombreProd = datos[2];

            //si estan correctos entonces leo toda la informacion y creo el registro
            primero = obtenerPiloto(piloto, primero, ciPiloto);
            segundo = obtenerTecnico(tecnico, segundo, ciTecnico);
            tercero = obtenerProducto(producto, tercero, nombreProd);

            if (primero && segundo && tercero) {
                tomarInformacionParaCargar(piloto, tecnico, producto, dia, arch, huboErrores, entrada);
            } else {
                JOptionPane.showMessageDialog(null, "Operación no realizada", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Archivo con datos no validos", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_fileChooserArchivoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Prueba.cargarMenu(sistema);
    }//GEN-LAST:event_formWindowClosing

    public void tomarInformacionParaCargar(Piloto unPil, Tecnico unTec, Producto unProd, 
                                           int unDia, ArchivoLectura unArch, boolean errores, Scanner entrada) {
        
        ArchivoGrabacion grab = new ArchivoGrabacion("ERROR.txt");
        String zona = entrada.nextLine();
        
        if (Prueba.verificarRangosDeZona(zona)) {
            int[] mapaDeRegistro = Prueba.descomponerInput(zona);
            sistema.crearRegistro(unPil, unTec, unProd, unDia, zona, mapaDeRegistro);
        } else { //Si no son correctos los valores, se graba en error
            grab.grabarLineas(zona);
        }
        while (unArch.hayMasLineas()) {
            zona = unArch.linea();
            if (Prueba.verificarRangosDeZona(zona)) {
                int[] mapaDeRegistro = Prueba.descomponerInput(zona);
                sistema.crearRegistro(unPil, unTec, unProd, unDia, zona, mapaDeRegistro);
            } else { //Si no son correctos los valores, se graba en error
                grab.grabarLineas(zona);
                errores = true;
            }
        }
        grab.cerrar();
        if (errores) {
            JOptionPane.showMessageDialog(null, "Operación realizada con éxito(con errores)", "", JOptionPane.ERROR_MESSAGE);
            comboBoxDiasArchivo.setSelectedIndex(0);
            entrada.close();
            this.dispose();
            Prueba.cargarMenu(sistema);
        } else {
            JOptionPane.showMessageDialog(null, "Operación realizada con éxito(sin errores)", "", JOptionPane.INFORMATION_MESSAGE);
            comboBoxDiasArchivo.setSelectedIndex(0);
            entrada.close();
            this.dispose();
            Prueba.cargarMenu(sistema);
        }
    }

    public boolean obtenerPiloto(Piloto piloto, boolean primerB, String cedula) {
        for (int i = 0; i < sistema.getPiloto().size(); i++) {
            if (sistema.getPiloto().get(i).getCedula().equalsIgnoreCase(cedula)) {
                piloto = sistema.getPiloto().get(i);
                primerB = true;
            }
        }
        return primerB;
    }

    public boolean obtenerTecnico(Tecnico tecnico, boolean segundoB, String cedula) {
        for (int i = 0; i < sistema.getTecnico().size(); i++) {
            if (sistema.getTecnico().get(i).getCedula().equalsIgnoreCase(cedula)) {
                tecnico = sistema.getTecnico().get(i);
                segundoB = true;
            }
        }
        return segundoB;
    }

    public boolean obtenerProducto(Producto producto, boolean terceroB, String nombre) {

        for (int i = 0; i < sistema.getProducto().size(); i++) {
            if (sistema.getProducto().get(i).getNombre().equalsIgnoreCase(nombre)) {
                producto = sistema.getProducto().get(i);
                terceroB = true;
            }
        }
        return terceroB;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxDiasArchivo;
    private javax.swing.JFileChooser fileChooserArchivo;
    private javax.swing.JLabel lblDiaArchivo;
    // End of variables declaration//GEN-END:variables
}
