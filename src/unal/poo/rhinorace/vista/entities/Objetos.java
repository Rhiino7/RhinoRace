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
public class Objetos implements Runnable{
    private Archivo archivo;
    private Image dibujo;
    private ImageObserver io;
    private Graphics g;
    private double posX, posY, velX, velY;
    private Rectangle objBox;
    private int nivel;

    public Objetos(ImageObserver io, Graphics g, int posX, int posY, int velY, int nivel) {
        this.archivo = new MapsFiles();
        this.io = io;
        this.g = g;
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        this.nivel = nivel;
    }
    
    public void render(){
        dibujo = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\objetos\\obj_"+ nivel +".png");
        this.objBox = new Rectangle((int)this.posX, (int)this.posY-(int)this.velY, 24, 24);
        g.drawImage(dibujo, (int)this.posX+10, (int)this.posY-(int)this.velY, io);
        g.drawRect((int)this.posX+15, (int)this.posY-(int)this.velY, 24, 24);
//        System.out.println("Y= "+this.posY+" X= "+this.posX);
        
    }

    public Image getDibujo() {
        return dibujo;
    }

    public void setDibujo(Image dibujo) {
        this.dibujo = dibujo;
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

    public Rectangle getObjBox() {
        return objBox;
    }

    public void setObjBox(Rectangle objBox) {
        this.objBox = objBox;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    

    @Override
    public void run() {
        render();
    }
    
}
