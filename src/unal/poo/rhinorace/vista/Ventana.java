/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.rhinorace.vista;

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
        add(new Engine());
        setSize(650, 679);
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
