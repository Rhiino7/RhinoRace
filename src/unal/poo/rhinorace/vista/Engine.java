/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;
import unal.poo.rhinorace.modelo.Archivo;
import unal.poo.rhinorace.modelo.InputManager;
import unal.poo.rhinorace.modelo.MapsFiles;
import unal.poo.rhinorace.modelo.SonidoColision;
import unal.poo.rhinorace.vista.entities.Enemy;
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
    private int moverX = 0, moverY = 0, colorCarro, velY, velX;
    private Archivo archivo;
    private Image jugador;
    private Nivel n1;
    private String nivel;
    private Player p1;
    private Enemy e1;
    private InputManager input;
    private double velMatriz = 0.0;
    private boolean startGame = false;
    private boolean playerAlive = true;
    private Random r;
    private Enemy[] enemigos;
    private boolean colision = false ;

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
        
        
                
        this.nivel = "Nivel 1";
        n1 = new Nivel(this, nivel, g, this.moverX, this.moverY, this);            
        n1.run();
        
        this.colorCarro = 1;
        if(playerAlive){
            this.input.move();
            p1 = new Player(this, g, this.colorCarro, 280, this.moverX, this.moverY);
            p1.run();
        }
        
        if(enemigos == null){
            int n = 20;
            crearEnemigos(g, n);
        }else{
            dibujarEnemigos(g);
        }
            
        
        colission();

        
    }
    
    // Movimiento automatico enemigos
     public void move() {
       for(int i= 0; i < 5 ; i++  ){
           moverY++;             
       }
    }

    
    public void crearEnemigos(Graphics g, int n){
        this.enemigos = new Enemy[n];
        int cambio = 100;
        this.velY = -this.moverY;
        int posY = 300;
        r = new Random();
        for(int i=0;i<enemigos.length;i++){
            int caso = r.nextInt(3);
            switch(caso){
                case 0:{
                    if(i!= 0){
                        posY += 150;
                        this.enemigos[i] = new Enemy(this, g, 280-cambio, posY, this.velY);
                    }else{
                        this.enemigos[i] = new Enemy(this, g, 280-cambio, posY, velY);
                    }
                    break;
                }
                case 1:{
                    if(i!= 0){
                        posY += 150; 
                        this.enemigos[i] = new Enemy(this, g, 280, posY, this.velY);
                    }else{
                        this.enemigos[i] = new Enemy(this, g, 280, posY, this.velY);
                    }
                    break;
                }
                case 2:{
                    if(i!= 0){
                        posY += 150; 
                        this.enemigos[i] = new Enemy(this, g, 280+cambio, posY, this.velY);
                    }else{
                        this.enemigos[i] = new Enemy(this, g, 280+cambio, posY, this.velY);
                    }
                    break;
                }
            }
        }
    }
    
    public void dibujarEnemigos(Graphics g){
        for(int i=0;i<enemigos.length-1;i++){
            int velocidad = this.moverY;
            this.enemigos[i] = new Enemy(this, g, (int)enemigos[i].getPosX(), (int)enemigos[i].getPosY(), velocidad);
            enemigos[i].run();
        }
    }
    
    public void colission(){
        Rectangle cajaJugador = p1.getCarBox();
        Rectangle[] enemys = new Rectangle[enemigos.length];
        for(int i=0;i<enemigos.length-1;i++){
            try{
                   enemys[i] = enemigos[i].getCarBox();
                if(cajaJugador.intersects(enemys[i])){
                    System.out.println("PERRRROOOOOOOO");
                    this.playerAlive = false;
                    colision= true;
                    Thread sonido = new Thread(new SonidoColision());
                     sonido.start();
                }
            }catch(NullPointerException e){
            }
        }     
        
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

    public Enemy getE1() {
        return e1;
    }

    public void setE1(Enemy e1) {
        this.e1 = e1;
    }
       
        
    @Override
    public void actionPerformed(ActionEvent e) {
        // al colisionar detiene el movimiento
        
        if(colision==false)
          move(); 
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
