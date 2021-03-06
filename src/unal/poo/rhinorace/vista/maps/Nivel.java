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
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import unal.poo.rhinorace.modelo.Archivo;
import unal.poo.rhinorace.vista.Engine;

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
    private int numeroNivel;
    private String nivel;
    private Graphics g;
    private ImageObserver io;
    private Engine juego;

    public Nivel(Engine juego, String nivel,Graphics g, int x, int y, int numeroNivel, ImageObserver io) {
        this.juego = juego;
        //cargar el mapa
        archivo = new MapsFiles();
        mapa = archivo.cargar("src\\unal\\poo\\rhinorace\\vista\\maps\\mapa_"+numeroNivel+".txt");
        this.moverX = x;
        this.moverY = y;
        this.nivel = nivel;
        this.numeroNivel = numeroNivel;
        this.g = g;
        this.io = io;
    }
        
    public void render(){
        
        for(int i = 0;i<mapa.length;i++){
            for(int j=0;j<mapa[i].length;j++){
                switch(mapa[i][j]){
                    case 0:
                        this.tile = this.archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 1:
                        this.tile = this.archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 2:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 3:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\road"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 4:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\grass4.png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 5:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\tree_base"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);
                        }
                        break;
                    case 6:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\tree_top"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 7:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\tree_base"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 8:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\tree_top"+mapa[i][j]+".png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 9:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\"+nivel+"\\grass0.png");
                        if(!juego.isStartGame()){
                            this.g.drawImage(tile, j*32, i*32, io);
                        }else{
                            this.g.drawImage(tile, j*32, i*32-moverY, io);

                        }
                        break;
                    case 10:
                        break;
                    default:
                        this.g.setColor(Color.BLUE);
                        this.g.fillRect(j*32+this.moverX, i*32, 32, 32);
                        break;
                }
            }
        }
        
        //tileMap(tile, j*32, i*32, io);
        //tileMap(tile, j*32, i*32-moverY, io);
    }
    
    public void tileMap(Image tile, int j, int i, ImageObserver io){
//        
    }
    
    
    public int[][] rotarMatriz(int[][] matriz){
        int[][] mat = matriz;
        for (int i = 0; i <= matriz.length/2; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = mat[matriz.length-i-1][j];
            }
        }
        return mat;
    }

    @Override
    public void run() {
        render();
    }

    
}
