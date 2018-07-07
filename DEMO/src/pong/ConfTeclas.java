/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author 3268i
 */
public class ConfTeclas extends KeyAdapter{
    static boolean W, S, DOWN, UP, GO;
    
    public void keyPressed(KeyEvent e){
        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_W) {
            this.W = true;
        }
        if (id == KeyEvent.VK_S) {
            this.S = true;
        }
        if (id == KeyEvent.VK_DOWN) {
            this.DOWN = true;
        }
        if (id == KeyEvent.VK_UP) {
            this.UP = true;
        }
        if (id == KeyEvent.VK_SPACE) {
            //this.GO = true;
            if(this.GO == true)
                GO = false;
            else
                GO = true;
        }
    }
    
    public void keyReleased(KeyEvent e){
        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_W) {
            this.W = false;
        }
        if (id == KeyEvent.VK_S) {
            this.S = false;
        }
        if (id == KeyEvent.VK_DOWN) {
            this.DOWN = false;
        }
        if (id == KeyEvent.VK_UP) {
            this.UP = false;
        }
        
    }
}
