
package interfazlistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfazListas extends JFrame{

    public static void main(String[] args) {
        InterfazListas a = new InterfazListas();
    }
    
    public InterfazListas(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel controles = new JPanel();
        //controles.setLayout(new GridLayout(2,1));
        Boton1 b1 = new Boton1("1");
        Boton2 b2 = new Boton2("2");
        controles.add(b1);
        controles.add(b2);
        PanelDibujo fondo = new PanelDibujo();
        this.setLayout(new BorderLayout());
        this.add(fondo,BorderLayout.CENTER);
        this.add(controles,BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private class Boton1 extends JButton implements ActionListener{
        
        public Boton1(String nom){
            super(nom);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    private class Boton2 extends JButton implements ActionListener{
        
        public Boton2(String nom){
            super(nom);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
}
