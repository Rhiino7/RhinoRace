/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.modelo;

import java.awt.Image;

/**
 *
 * @author rhino
 */
public interface Archivo {
    
    public Image loadImage(String path);
    
    public int[][] cargar(String path);
}
