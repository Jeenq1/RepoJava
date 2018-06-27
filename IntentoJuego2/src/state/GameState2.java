/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import gameObjects.Mapa;
import gameObjects.Raqueta;
import gameObjects.Pelota;
import graphics.Assets;
import intentojuego2.Principal;
import java.awt.Graphics;
import math.Vector2D;

/**
 *
 * @author 3268i
 */
public class GameState2 {

    private Raqueta r1;
    private Raqueta r2;
    private Pelota p;
    private Mapa m;

    public GameState2() {
        r1 = new Raqueta(new Vector2D(10, Principal.TAMVENTANA.getHeight() / 2 - 20), null, 1);
        r2 = new Raqueta(new Vector2D(Principal.TAMVENTANA.getWidth() - 20, Principal.TAMVENTANA.getHeight() / 2 - 20), null, 2);
        p = new Pelota(new Vector2D(Principal.TAMVENTANA.getWidth() / 2, Principal.TAMVENTANA.getHeight() / 2-10), null);
        m = new Mapa(new Vector2D(0,0), Assets.mapaPong);
    }

    public void update() {
        r1.update();
        r2.update();
        p.update();
    }

    public void draw(Graphics g) {
        m.draw(g);
        r1.draw(g);
        r2.draw(g);
        p.draw(g);
    }
}
