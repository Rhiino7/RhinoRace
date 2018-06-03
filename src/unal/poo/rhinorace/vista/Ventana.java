/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author rhino
 */
public class Ventana extends JFrame {
    
    public Ventana() {
        initUI();
    }
    
    public void initUI() {
        
        setLayout(new BorderLayout());    
        
        add(new Engine(),BorderLayout.CENTER);
        setSize(850, 679);
        setTitle("RhinoRace");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        Ventana prueba = new Ventana();
        prueba.setVisible(true);
    }
}
