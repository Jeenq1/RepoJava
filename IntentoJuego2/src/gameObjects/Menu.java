/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import input.KeyBoard;
import intentojuego2.Principal;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Vector2D;
import state.GameState1;

/**
 *
 * @author 3268i
 */
public class Menu extends GameObject {

    public Menu(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, 0, 0, Principal.TAMVENTANA.width, Principal.TAMVENTANA.height, null);
        //g.fillRect(0, 0, Principal.TAMVENTANA.width, Principal.TAMVENTANA.height);
    }

    @Override
    public void update() {
        if (KeyBoard.MENU) {
            GameState1.bandera = 1;
        } else {
            GameState1.bandera = 0;
        }
    }
    
}
