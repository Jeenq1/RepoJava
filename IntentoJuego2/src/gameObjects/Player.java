/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import input.KeyBoard;
import intentojuego2.Principal;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.image.BufferedImage;
import math.Vector2D;
import state.GameState1;

/**
 *
 * @author 3268i
 */
public class Player extends GameObject {
    
    private static int VELOCIDAD = 2;

    public Player(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public void update() {
        if (KeyBoard.UP && (position.getY() >= 0)) {
            position.setY(getPosition().getY() - VELOCIDAD);
        } else if (KeyBoard.DOWN && (position.getY() < Principal.TAMVENTANA.getHeight() - 65)) {
            position.setY(getPosition().getY() + VELOCIDAD);
        }

        if (KeyBoard.LEFT) {
            position.setX(getPosition().getX() - VELOCIDAD);
        } else if (KeyBoard.RIGHT) {
            position.setX(getPosition().getX() + VELOCIDAD);
        }
        
        if ((position.getX() > 100 ) && (position.getY() < 5)) {
            //position.setY(Principal.TAMVENTANA.height-65);
            Principal.NIVEL = 1;
        }

    }

    public void draw(Graphics g) {
        g.drawImage(texture, (int) position.getX(), (int) position.getY(), 35, 35, null);
    }

}
