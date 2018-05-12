/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author rhino
 */
public class MapsFiles implements Archivo{
    protected Dificultad d;
    protected int hola;
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    //Carga el mapa
    @Override
    public int[][] cargar(String path) {
        int matriz[][] = new int[21][20];
        File map = new File(path);
            
        try {
            Scanner lectura = new Scanner(map);
            if(map.exists()){
                for(int i=0;i<matriz.length;i++){
                    for(int j=0;j<matriz[i].length;j++){
                        if(lectura.hasNextInt())
                            matriz[i][j] = lectura.nextInt();
                    }
                }
                return matriz;
            }else{
                return null;
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(MapsFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
