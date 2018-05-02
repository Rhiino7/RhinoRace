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
import javax.swing.JPanel;
import javax.swing.Timer;
import unal.poo.rhinorace.modelo.Archivo;
import unal.poo.rhinorace.modelo.InputManager;
import unal.poo.rhinorace.modelo.MapsFiles;

/**
 *
 * @author rhino
 */
public class Engine extends JPanel implements ActionListener{
    private Timer timer;
    private int[][] mapa;
    private int moverX = 0;
    private int moverY = 0;
    private Archivo archivo;
    private Image tile;
    

    public Engine() {
        //Cargando el mapa
        archivo = new MapsFiles();
        mapa = archivo.cargar("src\\unal\\poo\\rhinorace\\vista\\maps\\mapa_1.txt");
        
        //Agregar el KeyListener
        add(new InputManager(this));
        
        //Timer para refrescar el JFrame
        this.timer = new Timer(25, this);
        
        setFocusable(true);
        
        timer.start(); //Inicia el timer para refrescar el JFrame
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0;i<mapa.length;i++){
            for(int j=0;j<mapa[i].length;j++){
                switch(mapa[i][j]){
                    case 0:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\Nivel 1\\road"+mapa[i][j]+".png");
                        g.drawImage(tile, j*32+this.moverX, i*32+this.moverY, this);
//                        g.fillRect(j*32+this.moverX, i*32+this.moverY, 32, 32);
                        break;
                    case 1:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\Nivel 1\\road"+mapa[i][j]+".png");
                        g.drawImage(tile, j*32+this.moverX, i*32+this.moverY, this);
//                        g.fillRect(j*32+this.moverX, i*32+this.moverY, 32, 32);
                        break;
                    case 2:
                        tile = archivo.loadImage("src\\unal\\poo\\rhinorace\\vista\\maps\\Nivel 1\\road"+mapa[i][j]+".png");
                        g.drawImage(tile, j*32+this.moverX, i*32+this.moverY, this);
//                        g.fillRect(j*32+this.moverX, i*32+this.moverY, 32, 32);
                        break;
                    case 3:
                        g.setColor(Color.WHITE);
                        g.fillRect(j*32+this.moverX, i*32+this.moverY, 32, 32);
                        break;
                }
            }
            System.out.println("");
        }
        g.setColor(Color.BLUE);
        g.fillOval(270, 500, 29, 29);
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
        
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void add(InputManager inputManager) {
        addKeyListener(inputManager);
    }
    
    public void escribir(){
        System.out.println("Funciona");
    }
}
