/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author españita
 */
public class Hilo extends Thread {

    TableroJuego Lamina;
    VentanaInicial Inicio;

    public Hilo(TableroJuego lamina, VentanaInicial inicio) {
        this.Inicio = inicio;
        this.Lamina = lamina;
        
    }

    public void run() {
        
        while (TableroJuego.puntosj1 < 5 && TableroJuego.puntosj2 < 5) {
            
            try {
                Thread.sleep(Pelota.velocidadPelota);
            } catch (Exception e) {
                System.out.println("Fallo en el programa equisde");
            }
            if (ConfTeclas.GO == true) {
                this.Lamina.repaint();
            } else {
                this.Inicio.repaint();
            }
            
        }
    }
}
