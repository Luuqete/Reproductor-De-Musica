/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

/**
 *
 * @author fvg
 */
import sonidopapa.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

import java.io.*;

public class MusicaConInterfaz extends javax.swing.JFrame {

    /**
     * Creates new form MusicaConInterfaz
     */
    String Musica[];// = new String[20];
    Player ply;
    String Cancion;
    public static boolean bandera = true, Stop = true;

    public MusicaConInterfaz() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /* Musica[0] = "Metallica - Nothing else matters (sub. español).mp3";
         Musica[1] = "Rusherking, Maria Becerra - ANTES DE TI (Official Video).mp3";
         Musica[2] = "R.E.M. - Losing My Religion - Subtitulada en español e inglés.mp3";*/
        LlenarVector();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelCancion = new javax.swing.JLabel();
        ComboCanciones = new javax.swing.JComboBox();
        BotonReproducir = new javax.swing.JButton();
        BotonPausaOPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelCancion.setText("Canción: ");

        ComboCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCancionesActionPerformed(evt);
            }
        });

        BotonReproducir.setText("Reproducir");
        BotonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReproducirActionPerformed(evt);
            }
        });

        BotonPausaOPlay.setText("Pausa");
        BotonPausaOPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPausaOPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(BotonReproducir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonPausaOPlay))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ComboCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelCancion))
                .addGap(0, 156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelCancion)
                .addGap(33, 33, 33)
                .addComponent(ComboCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonReproducir)
                    .addComponent(BotonPausaOPlay)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCancionesActionPerformed
        Cancion = ComboCanciones.getSelectedItem().toString();

        try {
            if (Cancion.equals("") || Cancion.equals(" ") || Cancion.equals("  ") || Cancion.equals("   ")) {
                LabelCancion.setText("Canción: ");
            } else {
                LabelCancion.setText("Canción: " + Cancion);
                //ply = new Player(new FileInputStream("C:\\Users\\fvg\\Downloads\\Musica\\" + Cancion));
            }

        } catch (/*FileNotFoundException | JavaLayer*/Exception ex) {
            System.err.print(ex);
        }
    }//GEN-LAST:event_ComboCancionesActionPerformed
    int BanderaInt = 0;
    private void BotonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReproducirActionPerformed
        Pruebitaas p = new Pruebitaas();
        if (BanderaInt == 0) {

            //LabelCancion.setText("Canción: ");
            p.Sonar(Cancion);
            p.start();
            bandera = true;
            Stop = true;
            BanderaInt++;
            BotonReproducir.setText("Stop");
        } else {
            BanderaInt = 0;
            BotonReproducir.setText("Reproducir");
            parar();
        }

    }//GEN-LAST:event_BotonReproducirActionPerformed

    private void BotonPausaOPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPausaOPlayActionPerformed
        if (bandera == true) {
            bandera = false;
            BotonPausaOPlay.setText("Play");
        } else {
            bandera = true;
            BotonPausaOPlay.setText("Pausa");
        }
    }//GEN-LAST:event_BotonPausaOPlayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicaConInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicaConInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicaConInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicaConInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicaConInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonPausaOPlay;
    private javax.swing.JButton BotonReproducir;
    private javax.swing.JComboBox ComboCanciones;
    private javax.swing.JLabel LabelCancion;
    // End of variables declaration//GEN-END:variables

    void LlenarBox() {
        ComboCanciones.addItem("  ");
        for (int i = 0; i < Musica.length; i++) {
            ComboCanciones.addItem(Musica[i]);
        }
    }

    void LlenarVector() {
        File musica = new File("C:\\Users\\fvg\\Downloads\\Musica");
        FilenameFilter Filtro = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".mp3")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        String VectorMusica[] = musica.list(Filtro);
        Musica = VectorMusica;
        LlenarBox();
        //  System.out.println(musica.getAbsolutePath());
    }

    void parar() {
        bandera = false;
        Stop = false;
        BanderaInt = 0;
        Pruebitaas p = new Pruebitaas();
        p.stop();
    }                     //con estado me refuero a donde esta
  
}
