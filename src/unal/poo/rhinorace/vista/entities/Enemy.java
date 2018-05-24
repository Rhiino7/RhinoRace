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
public class Enemy implements Runnable{
    private Archivo archivo;
    private Image enemigo;
    private ImageObserver io;
    private Graphics g;
    private double posX;
    private double posY;
    private double velX;
    private double velY;
    private Rectangle carBox;

    public Enemy(ImageObserver io, Graphics g, int posX, int posY, int velY) {
        this.archivo = new MapsFiles();
        this.io = io;
        this.g = g;
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        
    }
    
    public void render(){
        enemigo = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\entities\\PlayerCar\\Player_"+ 1 +".png");
        this.carBox = new Rectangle((int)this.posX, (int)this.posY-(int)this.velY, 30, 60);
        g.drawImage(enemigo, (int)this.posX, (int)this.posY-(int)this.velY, io);
        g.drawRect((int)this.posX+15, (int)this.posY-(int)this.velY, 32, 64);
        System.out.println("Y= "+this.posY+" X= "+this.posX);
        
    }

    public Rectangle getCarBox() {
        return carBox;
    }

    public void setCarBox(Rectangle carBox) {
        this.carBox = carBox;
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

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }
    
    
    

    @Override
    public void run() {
        render();
    }
}
