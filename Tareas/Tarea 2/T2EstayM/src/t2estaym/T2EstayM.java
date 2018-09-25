
package t2estaym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class T2EstayM extends JFrame{
    
    public T2EstayM(){
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        AlmacenFormas al = new AlmacenFormas();
        PanelDibujo dp = new PanelDibujo(al);
        this.setLayout(new BorderLayout());
        this.add(dp,BorderLayout.CENTER);
        JPanel controles = new JPanel();
        controles.setLayout(new GridLayout(2,1));
        controles.setBackground(Color.gray);
        BotonForma bf1 = new BotonForma("Circulo",1,dp);
        BotonForma bf2 = new BotonForma("Rectangulo",2,dp);
        BotonForma bf3 = new BotonForma("Triangulo",3,dp);
        BotonModo bm1 = new BotonModo("Agregar",1,dp);
        BotonModo bm2 = new BotonModo("Eliminar",2,dp);
        BotonModo bm3 = new BotonModo("Modificar",3,dp);
        ButtonGroup bg1 = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        bg1.add(bf1);
        bg1.add(bf2);
        bg1.add(bf3);
        bg2.add(bm1);
        bg2.add(bm2);
        bg2.add(bm3);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        jp1.add(bf1);
        jp1.add(bf2);
        jp1.add(bf3);
        jp2.add(bm1);
        jp2.add(bm2);
        jp2.add(bm3);
        controles.add(jp1);
        controles.add(jp2);
        this.add(controles,BorderLayout.SOUTH);
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        T2EstayM a = new T2EstayM();
    }
    
    private class BotonForma extends JRadioButton implements ActionListener{
        int forma;
        PanelDibujo dp;
        BotonForma(String nom, int forma, PanelDibujo dp){
            super(nom);
            this.dp=dp;
            this.forma=forma;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dp.setForma(forma);
        }
        
    }
    
    private class BotonModo extends JRadioButton implements ActionListener{
        int modo;
        PanelDibujo dp;
        BotonModo(String nom, int modo, PanelDibujo dp){
            super(nom);
            this.dp=dp;
            this.modo=modo;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dp.setModo(modo);
        }
        
    }
    
}
