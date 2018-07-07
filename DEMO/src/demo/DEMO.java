/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.awt.Dimension;
import pong.JuegoPong;

/**
 *
 * @author 3268i
 */
public class DEMO {

    static Ventana menu;
    static JuegoPong juego;
    
    public static void main(String[] args) {
        menu = new Ventana();
    }
    
    static void crearPong(Dimension x){
        juego = new JuegoPong(x.width, x.height);
    }
    
}
