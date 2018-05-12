/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista.entities;

import unal.poo.rhinorace.modelo.MapsFiles;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import unal.poo.rhinorace.modelo.Archivo;


/**
 *
 * @author rhino
 */
public class Player implements Runnable{
    
    private Archivo archivo;
    private Image jugador;
    private ImageObserver io;
    private Graphics g;
    private int color;
    private double posX;
    private double posY = 570;
    private double velX;
    private double velY;
    private Rectangle carBox;

    public Player(ImageObserver io, Graphics g, int color, int posX, int velX, int velY) {
        this.archivo = new MapsFiles();
        this.io = io;
        this.g = g;
        this.color = color;
        this.posX = posX;
        this.velX = velX;
        this.velY = velY;
        this.carBox = new Rectangle(280, 500, 32, 64);
    }
    
    public void colision(){
        
    }
    
        
    public void render(){
        jugador = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\entities\\PlayerCar\\Player_"+ this.color +".png");
        this.posX +=this.velX;
        g.drawImage(jugador, (int)this.posX, (int)this.posY, io);
        g.drawRect(295+(int)this.velX, (int)this.posY, 32, 64);
        System.out.println("Y= "+this.posY+" X= "+this.posX);
        
    }
    

    @Override
    public void run() {
        this.render();
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
    
    
    
}
