
package interfazhumanos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Ventana extends JFrame{
    PanelDibujo dp;
    public Ventana(){
        this.setLayout(new BorderLayout());
        dp = new PanelDibujo();
        this.add(dp,BorderLayout.CENTER);
        setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel controles = new JPanel();
        controles.setLayout(new GridLayout(3,1));
        //controles.add(new JButton("boton 1"));
        //controles.add(new JButton("boton 2"));
        //controles.add(new JButton("boton 3"));
        this.add(controles,BorderLayout.SOUTH);
        JPanel jp1 = new JPanel(); jp1.setBackground(Color.red);
        jp1.add(new BotonTam("Mas Grande", true));
        jp1.add(new BotonTam("Mas pequeño", false));
        JPanel jp2 = new JPanel(); jp2.setBackground(Color.blue);
        BotonColor bc1 = new BotonColor("Azul",Color.blue);
        BotonColor bc2 = new BotonColor("Rojo",Color.red);
        BotonColor bc3 = new BotonColor("Verde",Color.green);
        jp2.add(bc1);
        jp2.add(bc2);
        jp2.add(bc3);
        ButtonGroup bg = new ButtonGroup();
        bg.add(bc1);
        bg.add(bc2);
        bg.add(bc3);
        JPanel jp3 = new JPanel(); jp3.setBackground(Color.magenta); jp3.add(new BotonC("boton3"));
        controles.add(jp1);
        controles.add(jp2);
        controles.add(jp3);
        //JPanel a1 = new JPanel(); a1.setBackground(Color.WHITE);
        //JPanel a2 = new JPanel(); a1.setBackground(Color.GREEN);
        //JPanel a3 = new JPanel(); a1.setBackground(Color.GRAY);
        //this.add(a1,BorderLayout.NORTH);
        //this.add(a2,BorderLayout.EAST);
        //this.add(a3,BorderLayout.WEST);
        setVisible(true);
    }
    
    
    private class BotonTam extends JButton implements ActionListener{
        boolean a;
        BotonTam(String nom, boolean a){
            super(nom);
            this.a=a;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dp.changeCircTam(a);
        }
        
    }
    
    private class BotonColor extends JRadioButton implements ActionListener{
        Color c;
        BotonColor(String nom, Color c){
            super(nom);
            this.c=c;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dp.changeCirc(c);
        }
        
    }
    
    private class BotonC extends JButton implements ActionListener{
        
        BotonC(String nom){
            super(nom);
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("AAAA");
            dp.change(Color.cyan);
        }
        
    }
    
}
