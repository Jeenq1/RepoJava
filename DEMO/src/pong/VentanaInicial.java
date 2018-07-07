/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author 3268i
 */
public class VentanaInicial extends JPanel{
    
    Image fondo;
    
    VentanaInicial(){
        //this.setBackground(Color.gray);
        setFondo("src/Imagenes/FondoInicial.png");
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, JuegoPong.ANCHO-15, JuegoPong.ALTO-27, null);
    }
    
    public void setFondo(String ruta){
        fondo = new ImageIcon(ruta).getImage();
    }
}
