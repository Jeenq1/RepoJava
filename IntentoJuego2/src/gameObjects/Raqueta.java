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

/**
 *
 * @author 3268i
 */
public class Raqueta extends GameObject {

    private static int VELOCIDAD = 3;
    private int np = 0;
    public static int X;
    public static int Y;
    public static int X2;
    public static int Y2;

    public Raqueta(Vector2D position, BufferedImage texture, int np) {
        super(position, texture);
        this.np = np;
        if (np == 1) {
            X = (int)position.getX();
            Y = (int)position.getY();
        } else {
            X2 = (int)position.getX();
            Y2 = (int)position.getY();
        }
        
    }

    @Override
    public void update() {
        if (np == 1) {
            if (KeyBoard.UP && (Y >= 0)) {
                Y -= VELOCIDAD;
            } else if (KeyBoard.DOWN && (Y < Principal.TAMVENTANA.getHeight() - 65)) {
                Y += VELOCIDAD;
            }
        } else {
            if (KeyBoard.UP2 && (Y2 >= 0)) {
                Y2 -= VELOCIDAD;
            } else if (KeyBoard.DOWN2 && (Y2 < Principal.TAMVENTANA.getHeight() - 65)) {
                Y2 += VELOCIDAD;
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        if (np == 1) {
            g.fillRect(X, Y, 10, 40);
        } else {
            g.fillRect(X2, Y2, 10, 40);
        }
        
    }

}
