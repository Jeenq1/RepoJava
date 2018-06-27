/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import graphics.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Vector2D;

/**
 *
 * @author 3268i
 */
public class Mapa extends GameObject{

    public Mapa(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, 0, 0, null);
    }
    
}
