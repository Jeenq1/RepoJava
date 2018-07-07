/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author 3268i
 */
public class Pelota {

    static int X, Y; //POSICION DE LA PELOTA
    private int MX = 1, MY = 1; //NUMERO DE "PIXELES" QUE SE VAN A MOVER (MovimientoX, MovimientoY)
    static final int ANCHO = 15, ALTO = 15;
    static final int velocidadPelotaBase = 5;
    static int velocidadPelota = 5;
    private Clip rebote = null, punto = null;
    private Image imagen;
    
    public Pelota(int x, int y) {
        setFondo("src/Imagenes/Santi.jpg");
        añadirSonido();
        this.X = x;
        this.Y = y;
    }
    
    public void setFondo(String imagePath) {

        // Construimos la imagen y se la asignamos al atributo background.
        
        this.imagen = new ImageIcon(imagePath).getImage();
        
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(this.X, this.Y, ANCHO, ALTO);
    }
    
    public Image getPelota2(){
        return imagen;
    }

    public void Mover(Rectangle rectanguloLamina, boolean colr1, boolean colr2) {
        
        this.X += this.MX;
        this.Y += this.MY;

        if (colr1) {
            rebote.setMicrosecondPosition(0);
            rebote.start();
            this.MX = -this.MX;
            this.X = (int) TableroJuego.separacionraqueta + this.ANCHO;
            if (velocidadPelota > 1) {
                this.velocidadPelota--;
            }

        } else if (colr2) {
            rebote.setMicrosecondPosition(0);
            rebote.start();
            this.MX = -this.MX;
            this.X = (int) (rectanguloLamina.getBounds().getMaxX() - this.ANCHO*2 - Raqueta.ANCHO);
            if (velocidadPelota > 1) {

                this.velocidadPelota--;

            }
        }

        if (this.X > rectanguloLamina.getMaxX() - this.ANCHO) { //EL -15 ES PORQUE EL TAMAÑO DE LA PELOTA ES DE 15X15, Y LA POSICION CUENTA COMO LA ESQUINA SUPERIOR IZQUIERDA, LO CUAL SI HACEMOS ESTO, SIMULAMOS UN MEJOR CHOQUE CON LA PARED
            this.MX = -this.MX;
            if (colr2 == false) {
                punto.setMicrosecondPosition(punto.getMicrosecondLength() / 2);
                punto.start();
                velocidadPelota = velocidadPelotaBase;
                TableroJuego.puntosj1++;
                this.X = (int) rectanguloLamina.getBounds().getCenterX();
                this.Y = (int) rectanguloLamina.getBounds().getCenterY();

            }

        }

        if (this.Y > rectanguloLamina.getMaxY() - this.ALTO) {
            rebote.setMicrosecondPosition(0);
            rebote.start();
            this.MY = -this.MY;

        }

        if (this.X < rectanguloLamina.getMinX()) {
            punto.setMicrosecondPosition(punto.getMicrosecondLength() / 2);
            punto.start();
            this.MX = -this.MX;
            if (colr1 == false) {
                velocidadPelota = velocidadPelotaBase;
                TableroJuego.puntosj2++;
                this.X = (int) rectanguloLamina.getBounds().getCenterX();
                this.Y = (int) rectanguloLamina.getBounds().getCenterY();

            }
        }

        if (this.Y < rectanguloLamina.getMinY()) {
            rebote.setMicrosecondPosition(0);
            rebote.start();
            this.MY = -this.MY;

        }

    }

    private void añadirSonido() {
        try {
            rebote = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            punto = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        }

        File sonidorebote = new File("src/Sonidos/Rebote.wav");
        File sonidopunto = new File("src/Sonidos/Marcar.wav");

        try {
            rebote.open(AudioSystem.getAudioInputStream(sonidorebote));
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            punto.open(AudioSystem.getAudioInputStream(sonidopunto));
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
