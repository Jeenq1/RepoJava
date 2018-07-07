/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author 3268i
 */
public class Raqueta {

    private int X, Y;
    static final int ANCHO = 12, ALTO = 50;

    public Raqueta(int x, int y) {
        this.X = x;
        this.Y = y;
    }
    
    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(this.X, this.Y, ANCHO, ALTO);
    }
    
    public void MoverR1(Rectangle Limites){
        if (ConfTeclas.W == true && this.Y > Limites.getMinY() + 10) {
            this.Y--;
        } else if (ConfTeclas.S == true && this.Y < Limites.getMaxY() - this.ALTO - 10) {
            this.Y++;
        }
    }
    
    public void MoverR2(Rectangle Limites){
        if (ConfTeclas.UP == true && this.Y > Limites.getMinY() + 10) {
            this.Y--;
        } else if (ConfTeclas.DOWN == true && this.Y < Limites.getMaxY() - this.ALTO - 10) {
            this.Y++;
        }
    }

}
