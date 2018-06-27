/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import gameObjects.*;
import graphics.Assets;
import java.awt.Graphics;
import math.Vector2D;

/**
 *
 * @author 3268i
 */
public class GameState1 {

    private Player player;
    private Mapa mapa1;
    private Menu menu;
    public static int bandera = 0;

    public GameState1() {
        player = new Player(new Vector2D(100, 130), Assets.player);
        mapa1 = new Mapa(new Vector2D(0, 0), Assets.mapa1);
        menu = new Menu(new Vector2D(0, 0), Assets.menu);
    }

    public void update() {
        if (bandera == 0) {
            player.update();
        }
        menu.update();
    }

    public void draw(Graphics g) {
        if (bandera == 0) {
            mapa1.draw(g);
            player.draw(g);
        } else {
            menu.draw(g);
        }

    }
}
