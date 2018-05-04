/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista.entities;

import unal.poo.rhinorace.modelo.MapsFiles;
import java.awt.Graphics;
import java.awt.Image;
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

    public Player(ImageObserver io, Graphics g, int color) {
        this.archivo = new MapsFiles();
        this.io = io;
        this.g = g;
        this.color = color;
    }
        
    public void render(){
        jugador = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\entities\\PlayerCar\\Player_"+ this.color +".png");
        g.drawImage(jugador, 270, 480, io);
    }
    

    @Override
    public void run() {
        this.render();
    }
    
}
