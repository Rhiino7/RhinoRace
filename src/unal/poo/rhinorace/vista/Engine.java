/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;
import javax.swing.Timer;
import unal.poo.rhinorace.modelo.Archivo;
import unal.poo.rhinorace.modelo.InputManager;
import unal.poo.rhinorace.modelo.MapsFiles;
import unal.poo.rhinorace.vista.entities.Player;
import unal.poo.rhinorace.vista.maps.Nivel;

/**
 *
 * @author rhino
 */
public class Engine extends JPanel implements ActionListener{
    private int width = 650;
    private int height = 679;
    private Timer timer;
    private int[][] mapa;
    private int moverX = 0;
    private int moverY = 0;
    private Archivo archivo;
    private Image jugador;
    private Nivel n1;
    private String nivel;
    private Player p1;
    private int colorCarro;
    private InputManager input;
    private double velMatriz = 0.0;
    private boolean startGame = false;

    public Engine() {
        //Usado para cargar imagenes
        archivo = new MapsFiles();
        
        //Agregar el KeyListener
        add(new InputManager(this));
        
        //Timer para refrescar el JFrame
        this.timer = new Timer(25, this);
        
        setFocusable(true);
        timer.start(); //Inicia el timer para refrescar el JFrame
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        this.input.move();
        this.nivel = "Nivel 1";
        n1 = new Nivel(this, nivel, g, this.moverX, this.moverY, this);            
        n1.run();
        
        this.colorCarro = 1;
        p1 = new Player(this, g, this.colorCarro, 280, this.moverX, this.moverY);
        p1.run();
        
    }
    
    public int getMoverX() {
        return moverX;
    }

    public void setMoverX(int moverX) {
        this.moverX = moverX;
    }
    
    public int getMoverY() {
        return moverY;
    }

    public void setMoverY(int moverY) {
        this.moverY = moverY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public double getVelMatriz() {
        return velMatriz;
    }

    public void setVelMatriz(double velMatriz) {
        this.velMatriz = velMatriz;
    }
    
    
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void add(InputManager inputManager) {
        input = inputManager;
        addKeyListener(inputManager);
    }
    
    public void escribir(){
        System.out.println("Funciona");
    }
}
