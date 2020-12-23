package Interfaz;

import Dominio.Sistema;
import javax.swing.*;


public class VMenu extends javax.swing.JFrame {

    private Sistema sistema;

    public VMenu(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
    }

    public Sistema getSistema() {
        return this.sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuAgregarPiloto = new javax.swing.JMenuItem();
        saveMenuAgregarTecnico = new javax.swing.JMenuItem();
        saveAsMenuAgregarProducto = new javax.swing.JMenuItem();
        saveAsMenuRegistroIndividual = new javax.swing.JMenuItem();
        saveAsMenuConsulta = new javax.swing.JMenuItem();
        saveAsMenuRegistroArchivo = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Menu Opciones");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        openMenuAgregarPiloto.setMnemonic('o');
        openMenuAgregarPiloto.setText("Agregar Piloto");
        openMenuAgregarPiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuAgregarPilotoActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuAgregarPiloto);

        saveMenuAgregarTecnico.setMnemonic('s');
        saveMenuAgregarTecnico.setText("Agregar Tecnico");
        saveMenuAgregarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuAgregarTecnicoActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuAgregarTecnico);

        saveAsMenuAgregarProducto.setMnemonic('a');
        saveAsMenuAgregarProducto.setText("Agregar Producto");
        saveAsMenuAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuAgregarProductoActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuAgregarProducto);

        saveAsMenuRegistroIndividual.setMnemonic('a');
        saveAsMenuRegistroIndividual.setText("Registro Fumigacion Individual");
        saveAsMenuRegistroIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuRegistroIndividualActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuRegistroIndividual);

        saveAsMenuConsulta.setMnemonic('a');
        saveAsMenuConsulta.setText("Consulta");
        saveAsMenuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuConsultaActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuConsulta);

        saveAsMenuRegistroArchivo.setMnemonic('a');
        saveAsMenuRegistroArchivo.setText("Registro Fumigaciones de Archivo");
        saveAsMenuRegistroArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuRegistroArchivoActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuRegistroArchivo);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        try {
            Sistema.guardarDatosPrograma(getSistema());
            System.exit(0);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se pudieron almacenar los datos de forma correcta", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void saveMenuAgregarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuAgregarTecnicoActionPerformed
        VAgregarTecnico v = new VAgregarTecnico(sistema);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveMenuAgregarTecnicoActionPerformed

    private void saveAsMenuRegistroIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuRegistroIndividualActionPerformed
        if(sistema.getPiloto().size() > 0 && sistema.getTecnico().size() > 0
           && sistema.getProducto().size() > 0) {
        VRegistroFumigacionIndividual v = new VRegistroFumigacionIndividual(sistema);
        v.setVisible(true);
        this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe existir al menos un piloto, un tecnico y un producto para registrar una fumigacion","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveAsMenuRegistroIndividualActionPerformed

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed

    }//GEN-LAST:event_fileMenuActionPerformed

    private void openMenuAgregarPilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuAgregarPilotoActionPerformed
        VAgregarPiloto v = new VAgregarPiloto(sistema);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openMenuAgregarPilotoActionPerformed

    private void saveAsMenuAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuAgregarProductoActionPerformed
        VAgregarProducto v = new VAgregarProducto(sistema);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveAsMenuAgregarProductoActionPerformed

    private void saveAsMenuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuConsultaActionPerformed
        VConsulta v = new VConsulta(sistema);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveAsMenuConsultaActionPerformed

    private void saveAsMenuRegistroArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuRegistroArchivoActionPerformed
        VCargaDeFumigacionesDeArchivo v = new VCargaDeFumigacionesDeArchivo(sistema);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveAsMenuRegistroArchivoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            Sistema.guardarDatosPrograma(getSistema());
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se pudieron almacenar los datos de forma correcta", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuAgregarPiloto;
    private javax.swing.JMenuItem saveAsMenuAgregarProducto;
    private javax.swing.JMenuItem saveAsMenuConsulta;
    private javax.swing.JMenuItem saveAsMenuRegistroArchivo;
    private javax.swing.JMenuItem saveAsMenuRegistroIndividual;
    private javax.swing.JMenuItem saveMenuAgregarTecnico;
    // End of variables declaration//GEN-END:variables

}
