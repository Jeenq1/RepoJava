/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import intentojuego2.Principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Vector2D;

/**
 *
 * @author 3268i
 */
public class Pelota extends GameObject {

    private int movX;
    private int movY;
    private int velocidad = 3;
    public static int X;
    public static int Y;

    public Pelota(Vector2D position, BufferedImage texture) {
        super(position, texture);
        movX = velocidad;
        movY = velocidad;
        X = (int) position.getX();
        Y = (int) position.getY();
    }

    @Override
    public void update() {
        X += movX;
        Y += movY;

        colision();
        movimientoNormal();

    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(X, Y, 20, 20);
    }

    private void movimientoNormal() {
        if (X == Principal.TAMVENTANA.getWidth() - 25) {
            movX = -movX;
            System.out.println("0");
        } else if (X <= 0) {
            movX = -movX;
            System.out.println("0");
        }

        if (Y >= Principal.TAMVENTANA.getHeight() - 50) {
            movY = -movY;
        } else if (Y <= 0) {
            movY = -movY;
        }
    }

    private void colision() {
        if (movX + movX == (velocidad * 2)) {
            if ((X >= Raqueta.X2 - 25) && (Y > Raqueta.Y2 - 20) && (Y < Raqueta.Y2 + 40)) {
                movX = -movX;
            }
        } else {
            if ((X <= Raqueta.X + 15) && (Y >= Raqueta.Y - 20) && (Y <= Raqueta.Y + 40)) {
                movX = -movX;
            }
        }
    }

}

