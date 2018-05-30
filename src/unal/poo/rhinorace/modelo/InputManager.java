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
public class InputManager implements KeyListener, Runnable{
    
    private Engine juego;
    private int abc = 0;
    private boolean isWpressed = false;
    private boolean isSpressed = false;
    private boolean isDpressed = false;
    private boolean isApressed = false;
    private boolean diagonalTopLeft = false;
    private boolean diagonalTopRight = false;
    private boolean diagonalBotLeft = false;
    private boolean diagonalBotRight = false;
    
    
    public InputManager(Engine e) {
        this.juego = e;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        abc += 1;
    }
    
    //Controles que mueven la matriz
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_A){
            isApressed = true;
        }else if(key == KeyEvent.VK_D){
            isDpressed = true;
        }else if(key == KeyEvent.VK_S){
            isSpressed = true;
        }else if(key == KeyEvent.VK_W){
            isWpressed = true;
        }else if(key == KeyEvent.VK_SPACE){
            juego.setStartGame(true);
        }else if(key == KeyEvent.VK_H){
            juego.setStartGame(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {   
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_A){
            isApressed = false;
        }else if(key == KeyEvent.VK_D){
            isDpressed = false;
        }else if(key == KeyEvent.VK_S){
            isSpressed = false;
        }else if(key == KeyEvent.VK_W){
            isWpressed = false;
        }
        
        if(!isApressed){
            diagonalBotLeft = false;
            diagonalTopLeft = false;
        }
        if(!isDpressed){
            diagonalBotRight = false;
            diagonalTopRight = false;
        }
    }
    
    
    public void move(){
        
        if(isApressed && isWpressed){
            diagonalTopLeft = true;
        }else if (isApressed && isSpressed){
            diagonalBotLeft = true;
        }else if (isDpressed && isWpressed){
            diagonalTopRight = true;
        }else if (isDpressed && isSpressed){
            diagonalBotRight = true;
        }
        
        if(diagonalTopLeft){
            if(juego.getP1().getPosX() >= 165){
                if(juego.getP1().getPosY() >= 5){
                    juego.setMoverX(juego.getMoverX()-5);
                    juego.setMoverY(juego.getMoverY()+5);
                }
            }
                
        }
        
        if(diagonalTopRight){
            if(juego.getP1().getPosX() <= 410){
                if(juego.getP1().getPosY() >= 5){
                    juego.setMoverX(juego.getMoverX()+5);
                    juego.setMoverY(juego.getMoverY()+5);
                }
            }
        }
        
        if(diagonalBotLeft){
            if(juego.getP1().getPosX() >= 165){
                if(juego.getP1().getPosY() <=570){
                    juego.setMoverX(juego.getMoverX()-5);
                    juego.setMoverY(juego.getMoverY()-5);
                }
            }   
        }
        
        if(diagonalBotRight){
            if(juego.getP1().getPosX() <= 410){
                if(juego.getP1().getPosY() <=570){
                    juego.setMoverX(juego.getMoverX()+5);
                    juego.setMoverY(juego.getMoverY()-5);
                }
            }
        }
        
        if(isApressed){
            if(juego.getP1().getPosX() >= 165)
                juego.setMoverX(juego.getMoverX()-5);
        }else if(isDpressed){
            if(juego.getP1().getPosX() <= 410)
                juego.setMoverX(juego.getMoverX()+5);
        }else if(isSpressed){
            if(juego.getP1().getPosY() <=570){
                juego.setMoverY(juego.getMoverY()-5);
            }
        }else if (isWpressed){
            if(juego.getP1().getPosY() >= 5){
                juego.setMoverY(juego.getMoverY()+5);
            }
        }
    }

    @Override
    public void run() {
        move();
    }
}
