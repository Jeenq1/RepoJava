/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentojuego2;

import graphics.Assets;
import input.KeyBoard;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import state.*;

/**
 *
 * @author 3268i
 */
public class Principal extends JFrame implements Runnable{

    public static Dimension TAMVENTANA = new Dimension(500,300);
    private BufferStrategy bs;
    private Graphics g;
    
    private Canvas canvas;
    private Thread thread;
    private KeyBoard keyBoard;
    
    //NIVELES
    private GameState1 gamestate1;
    private GameState2 gamestate2;
    ///
    
    private boolean running = false;
    public static byte NIVEL = 0;
    
    public Principal(){
        setTitle("IGR - JUEGO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(TAMVENTANA);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        
        
        canvas = new Canvas();
        keyBoard = new KeyBoard();
        
        canvas.setPreferredSize(TAMVENTANA);
        canvas.setMinimumSize(TAMVENTANA);
        canvas.setMaximumSize(TAMVENTANA);
        
        add(canvas);
        canvas.addKeyListener(keyBoard);
    }
    
    public static void main(String[] args) {
        new Principal().start();
    }
    
    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private void update() {
        keyBoard.update();
        switch(NIVEL){
            case 0: gamestate1.update(); break;
            case 1: gamestate2.update(); break;
        }
        
    }
    
    public void draw(){
        bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0, 0, TAMVENTANA.width, TAMVENTANA.height);
        
        
        switch(NIVEL){
            case 0: gamestate1.draw(g); break;
            case 1: g.setColor(Color.white); gamestate2.draw(g); break;
        }
        
        g.dispose();
        bs.show();
        
    }
    
    public void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init(){
        Assets.init();
        gamestate1 = new GameState1();
        gamestate2 = new GameState2();
    }

    @Override
    public void run() {
        
        init();
        
        final int NS_POR_SEGUNDO = 1000000000;
        final int APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;
        requestFocus();
        
        while (running) {
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                update();
                draw();
                delta--;
            }
        }
        stop();
    }

    
        
    
}
