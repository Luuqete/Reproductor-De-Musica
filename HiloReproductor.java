/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v5;

import sonidopapa.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

public class HiloReproductor extends Thread {

    String Cancion;
    public Player ply;
    public boolean banderas, stop;

    public void Sonar(String Cancion, String Ruta) {
        this.Cancion = Ruta + "\\" + Cancion;
        banderas = true;
        //System.err.println(this.Cancion);
    }

    @Override
    public void run() {

        try {

            stop = MusicaConInterfaz.Stop;
            ply = new Player(new FileInputStream(Cancion));
            while (stop) {
                banderas = MusicaConInterfaz.Pausa;
                while (banderas) {
                    ply.play(10);

                    //System.out.println("Aaá");
                    banderas = MusicaConInterfaz.Pausa;
                    if (ply.isComplete() == true && MusicaConInterfaz.getBotonReproducirOStop().getText().equals("Stop")) {
                        MusicaConInterfaz.setBotonReproducirOStop("Reproducir");
                        MusicaConInterfaz.BanderaInt = 0;
                        
                        this.stop();
                    }
                }
                System.err.print("");
                stop = MusicaConInterfaz.Stop;

            }

        } catch (JavaLayerException | FileNotFoundException ex) {
            System.err.print("Error en el Hilo " + ex);
        }

    }

}
