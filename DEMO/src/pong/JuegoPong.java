/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JFrame;

/**
 *
 * @author 3268i
 */
public class JuegoPong extends JFrame {

    static int ANCHO = 800;
    static int ALTO = 500;
    private VentanaInicial Inicio;
    private TableroJuego Juego; //CREAMOS JPanel
    private Hilo hilo; //CREAMOS HILO DONDE IRÁ TODO EL PROCESO DEL JUEGO

    public JuegoPong() {
        conf();
    }
    public JuegoPong(int x, int y){
        ANCHO = x;
        ALTO = y;
        conf();
    }
    
    private void conf(){
        this.setTitle("IGR - PONG"); //ASIGNAMOS NOMBRE A LA VENTANA
        this.setSize(ANCHO, ALTO); //ASIGNAMOS LAS DIMENSIONES DE LA VENTANA
        this.setLocationRelativeTo(null); //ABRIR LA VENTANA EN EL CENTRO DE LA PANTALLA
        this.setResizable(false); //PONEMOS QUE NO TENGA LA BARRA DE NAVEGACIÓN
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //DECIMOS QUE AL CERRAR LA VENTANA, SE CIERRE EL JFRAME, ES DECIR, EL PROGRAMA ENTERO
        
        this.Inicio = new VentanaInicial(); //INSERTAMOS JPanle del menu inicial
        this.Juego = new TableroJuego(); //INSERTAMOS JPanel del juego
        
        this.add(Inicio); //AÑADIMOS PRIMERO EL MENU INICIAL
        
        this.setVisible(true); //HABILITAMOS QUE SE VEA LA VENTANA
        
        this.addKeyListener(new ConfTeclas()); //AÑADIMOS UN CONTROL DEL TECLADO
        
        this.add(Juego); //POSTERIORMENTE AÑADIMOS Juego(JPanel) EN Ventana(JFrame)        
        
        this.hilo = new Hilo(Juego, Inicio); //CREAMOS UN HILO CON EL JPanel
        
        hilo.start(); //INICIAMOS EL HILO
    }

}
