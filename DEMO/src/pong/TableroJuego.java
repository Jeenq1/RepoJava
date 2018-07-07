/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author 3268i
 */
public class TableroJuego extends JPanel {
    static int separacionraqueta = 10;
    
    Pelota pelota = new Pelota((int)(JuegoPong.ANCHO/2),(int)(JuegoPong.ALTO/2));
    Raqueta raqueta1 = new Raqueta(separacionraqueta, (int)(JuegoPong.ALTO/2));
    Raqueta raqueta2 = new Raqueta((int)(JuegoPong.ANCHO - separacionraqueta - Raqueta.ANCHO), (int)(JuegoPong.ALTO/2));
    Image fondo;
    Image pelotacuriosa;
    private int bandera = 0;

    static int puntosj1 = 0, puntosj2 = 0;

    public TableroJuego() {
        this.setBackground(Color.BLACK);
        this.setFondo("src/Imagenes/Fondo.png");
        this.setPelota("src/Imagenes/Santi.jpg");
    }

    private void setFondo(String imagePath) {

        // Construimos la imagen y se la asignamos al atributo background.
        
        this.fondo = new ImageIcon(imagePath).getImage();
        
    }
    
    private void setPelota(String imagePath) {

        // Construimos la imagen y se la asignamos al atributo background.
        
        this.pelotacuriosa = new ImageIcon(imagePath).getImage();
        
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D pelota = (Graphics2D) g;
        pelota.setColor(Color.white);
        
        Dibujar(pelota);

        Actualizar();
        ganador(g);
        
        
    }

    public void Dibujar(Graphics2D g) {
        g.drawLine((int)(JuegoPong.ANCHO/2), 0, (int)(JuegoPong.ANCHO/2), (int)JuegoPong.ALTO); //LINEA CENTRAL
        //g.drawImage(this.fondo, 0, 0, Ventana.ANCHO, Ventana.ALTO, null); //PONER IMAGEN DE FONDO
        //g.drawImage(this.pelotacuriosa, Pelota.X, Pelota.Y, Pelota.ANCHO, Pelota.ALTO, null); //INSERTAR PELOTA CON IMAGEN
        g.fill(pelota.getPelota()); //INSERTAR PELOTA COMO CUADRADO
        g.fill(raqueta1.getRaqueta());
        g.fill(raqueta2.getRaqueta());
        g.drawString("PUNTOS: " + this.puntosj1, (int)(JuegoPong.ANCHO/4), (int)(JuegoPong.ALTO/15));
        g.drawString("PUNTOS: " + this.puntosj2, (int)(JuegoPong.ANCHO/1.6), (int)(JuegoPong.ALTO/15));
    }

    public void Actualizar() {
        this.pelota.Mover(this.getBounds(), colision(raqueta1.getRaqueta()), colision(raqueta2.getRaqueta()));
        this.raqueta1.MoverR1(this.getBounds());
        this.raqueta2.MoverR2(this.getBounds());

    }

    private boolean colision(Rectangle2D r) {
        return this.pelota.getPelota().intersects(r);
    }

    private void ganador(Graphics g) {
        if (puntosj1 == 5) {
            g.drawString("GANADOR", (int)(JuegoPong.ANCHO/4), (int)(JuegoPong.ALTO/2));
        } else if (puntosj2 == 5) {
            g.drawString("GANADOR", (int)(JuegoPong.ANCHO/1.6), (int)(JuegoPong.ALTO/2));
        }
    }

    void MensajeInicio() {
        //this.getGraphics().drawString("---------------------------------\nPRESIONA ESPACIO PARA COMENZAR\n---------------------------------", (int)(Ventana.ANCHO/2),(int)(Ventana.ALTO/2));
    }
}
