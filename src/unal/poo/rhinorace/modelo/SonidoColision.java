/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.modelo;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanc
 */
public class SonidoColision implements Runnable{
    
    private URL sonido;

    @Override
    public void run() {
       
           try {
               // archivo donde se encuentra 
           sonido = new URL("file:Est.wav");
       } catch (MalformedURLException ex) {
           Logger.getLogger(SonidoColision.class.getName()).log(Level.SEVERE, null, ex);
       }
         AudioClip ac = Applet.newAudioClip(sonido);
         ac.play();
        
    }
}
