/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista.maps;

import unal.poo.rhinorace.modelo.MapsFiles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import unal.poo.rhinorace.modelo.Archivo;

/**
 *
 * @author rhino
 */
public class Nivel implements Runnable{
    
    private int[][] mapa;
    private Archivo archivo;
    private Image tile;
    private int moverX;
    private int moverY;
    private String nivel;
    private Graphics g;
    ImageObserver io;

    public Nivel(String nivel,Graphics g, int x, int y, ImageObserver io) {
        //cargar el mapa
        archivo = new MapsFiles();
        mapa = archivo.cargar("src\\unal\\poo\\rhinorace\\vista\\maps\\mapa_1.txt");
        this.moverX = x;
        this.moverY = y;
        this.nivel = nivel;
        this.g = g;
        this.io = io;
    }
    
//    public void mapa(String nivel,Graphics g, int x, int y, ImageObserver io){
//        this.moverX = x;
//        this.moverY = y;
//    }
    
    public void render(){
        for(int i = 0;i<mapa.length;i++){
            for(int j=0;j<mapa[i].length;j++){
                switch(mapa[i][j]){
                    case 0:
                        this.tile = this.archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        this.g.drawImage(tile, j*32+moverX, i*32+this.moverY, io);
                        break;
                    case 1:
                        this.tile = this.archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        this.g.drawImage(tile, j*32+moverX, i*32+this.moverY, io);
                        break;
                    case 2:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        this.g.drawImage(tile, j*32+this.moverX, i*32+this.moverY, io);
                        break;
                    case 3:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        this.g.drawImage(tile, j*32+this.moverX, i*32+this.moverY, io);
                        break;
                    case 4:
                        this.g.setColor(Color.BLUE);
                        this.g.fillRect(j*32+this.moverX, i*32+this.moverY, 32, 32);
                        break;
                }
            }
            System.out.println("");
        }
    }

    @Override
    public void run() {
        render();
    }

    
}
