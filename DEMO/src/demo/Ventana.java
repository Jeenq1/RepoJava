/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author 3268i
 */
public class Ventana extends JFrame {

    private Dimension tamaño = new Dimension(500, 300);
    private Dimension bTamaño = new Dimension(200,50);
    
    private JButton bJugar;
    private JButton bSalir;
    private JButton bCR;
    
    Ventana() {
        conf();
    }
    
    Ventana(int x, int y) {
        tamaño = new Dimension(x, y);
        conf();
    }
    
    private void conf(){
        setSize(tamaño);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("IG - JU - JE");
        
        bJugar = new JButton("Jugar");
        bSalir = new JButton("Salir");
        
        
        bJugar.addActionListener(new Jugar());
        bSalir.addActionListener(new Salir());
        
        if (tamaño.width == 500) {
            bCR = new JButton("Cambiar a: 800 x 500");
            bCR.addActionListener(new CambiarR1());
        } else {
            bCR = new JButton("Cambiar a: 500 x 300");
            bCR.addActionListener(new CambiarR2());
        }
        
        bJugar.setSize(bTamaño);
        bSalir.setSize(bTamaño);
        bCR.setSize(bTamaño);
        
        bJugar.setLocation((tamaño.width/2 - bTamaño.width/2), tamaño.height/6);
        bSalir.setLocation((tamaño.width/2 - bTamaño.width/2), tamaño.height/3);
        bCR.setLocation((tamaño.width/2 - bTamaño.width/2), tamaño.height/2);
        
        add(bJugar);
        add(bSalir);
        add(bCR);
    }
    

    class Jugar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DEMO.menu.dispose();
            DEMO.crearPong(tamaño);
        }
        
    }
    
    class Salir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    class CambiarR1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            DEMO.menu.dispose();
            DEMO.menu = new Ventana(800,500);
        }
    }
    class CambiarR2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            DEMO.menu.dispose();
            DEMO.menu = new Ventana(500,300);
        }
    }
}


