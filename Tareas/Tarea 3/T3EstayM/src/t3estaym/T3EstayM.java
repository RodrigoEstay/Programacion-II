
package t3estaym;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class T3EstayM extends JFrame{
    
    private Predio pd;
    
    public T3EstayM(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel controlesVelocidad = new JPanel();
        JPanel playPause = new JPanel();
        BotonVelocidad velocidad1 = new BotonVelocidad("Lento", 40);
        BotonVelocidad velocidad2 = new BotonVelocidad("Normal", 30);
        BotonVelocidad velocidad3 = new BotonVelocidad("Rapido", 20);
        BotonVelocidad velocidad4 = new BotonVelocidad("Muy Rapido", 10);
        ButtonGroup bg = new ButtonGroup();
        bg.add(velocidad1);
        bg.add(velocidad2);
        bg.add(velocidad3);
        bg.add(velocidad4);
        controlesVelocidad.add(velocidad1);
        controlesVelocidad.add(velocidad2);
        controlesVelocidad.add(velocidad3);
        controlesVelocidad.add(velocidad4);
        BotonPlayPause bPlayPause = new BotonPlayPause();
        playPause.add(bPlayPause);
        JPanel controles = new JPanel();
        controles.setLayout(new GridLayout(2,1));
        controles.add(controlesVelocidad);
        controles.add(playPause);
        controles.setBackground(Color.GRAY);
        velocidad2.setSelected(true);
        pd = new Predio();
        this.setLayout(new BorderLayout());
        this.add(controles,BorderLayout.NORTH);
        this.add(pd,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        T3EstayM a = new T3EstayM();
    }
    
    private class BotonVelocidad extends JRadioButton implements ActionListener{
        
        private int velocidad;
        
        public BotonVelocidad(String nom, int vel){
            super(nom);
            velocidad=vel;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            pd.cambiarVelocidad(velocidad);
        }
        
    }
    
    private class BotonPlayPause extends JButton implements ActionListener{
        
        boolean esPlay;
        
        public BotonPlayPause(){
            super("Play");
            esPlay=true;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(esPlay){
                pd.empezar();
                this.setText("Pause");
                esPlay=false;
            }
            else{
                pd.detener();
                this.setText("Play");
                esPlay=true;
            }
        }
        
    }
    
}
