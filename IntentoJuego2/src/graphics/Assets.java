/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author 3268i
 */
public class Assets {
    
    public static BufferedImage player;
    public static BufferedImage mapa1;
    public static BufferedImage menu;
    public static BufferedImage mapaPong;
    
    public static void init(){
        player = Loader.ImageLoader("/personaje/personaje.png");
        mapa1 = Loader.ImageLoader("/mapa/mapa1.png");
        menu = Loader.ImageLoader("/varios/menu.png");
        mapaPong = Loader.ImageLoader("/mapa/mapaPong.png");
    }
}
