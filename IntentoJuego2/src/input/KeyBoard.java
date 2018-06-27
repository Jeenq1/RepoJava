/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author 3268i
 */
public class KeyBoard implements KeyListener {
    
    private boolean [] keys = new boolean[256];
    public static boolean UP, DOWN, LEFT, RIGHT, MENU, UP2, DOWN2;
    
    public KeyBoard(){
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        MENU = false;
        UP2 = false;
        DOWN2 = false;
    }
    
    public void update () {
        UP = keys[KeyEvent.VK_W];
        DOWN = keys[KeyEvent.VK_S];
        LEFT = keys[KeyEvent.VK_A];
        RIGHT = keys[KeyEvent.VK_D];
        MENU = keys[KeyEvent.VK_SPACE];
        UP2 = keys[KeyEvent.VK_UP];
        DOWN2 = keys[KeyEvent.VK_DOWN];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_SPACE) {
            keys[e.getKeyCode()] = true;
        } else {
            if (MENU == true) {
                keys[e.getKeyCode()] = false;
            } else {
                keys[e.getKeyCode()] = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_SPACE) {
            keys[e.getKeyCode()] = false;
        }
        
    }
}
