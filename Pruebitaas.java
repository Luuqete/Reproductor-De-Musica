/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v1;

import sonidopapa.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

public class Pruebitaas extends Thread {

    String Cancion;
    public Player ply;
    public boolean banderas, stop;
    MusicaConInterfaz m = new MusicaConInterfaz();
    

    public void Sonar(String Cancion) {
        this.Cancion = Cancion;
        banderas = true;
    }

    @Override
    public void run() {

        try {
            stop = MusicaConInterfaz.Stop;
            ply = new Player(new FileInputStream("C:\\Users\\fvg\\Downloads\\Musica\\" + Cancion));
            while (stop) {
                 banderas = MusicaConInterfaz.bandera;
                while (banderas) {                    
                    ply.play(10);
                    
                    //System.out.println("Aaá");
                    banderas = MusicaConInterfaz.bandera;
                }
                 System.err.print("");
                stop = MusicaConInterfaz.Stop;
                
            }

        } catch (JavaLayerException | FileNotFoundException  ex) {
            System.err.print("Error en la " + ex);
        }

    }

    
}
