/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.modelo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import unal.poo.rhinorace.vista.Engine;

/**
 *
 * @author rhino
 */
public class InputManager implements KeyListener{
    
    Engine juego;
    
    public InputManager(Engine e) {
        this.juego = e;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Aun no se configura keyTyped"); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Controles que mueven la matriz
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key){
            case KeyEvent.VK_W: juego.setMoverY(juego.getMoverY()+5);
                break;
            case KeyEvent.VK_S: juego.setMoverY(juego.getMoverY()-5);
                break;
            case KeyEvent.VK_D: juego.setMoverX(juego.getMoverX()-5);
                break;
            case KeyEvent.VK_A: juego.setMoverX(juego.getMoverX()+5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Aun no se configura keyReleased"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
