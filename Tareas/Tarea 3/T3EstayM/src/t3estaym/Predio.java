
package t3estaym;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Predio extends JPanel{
    
    private Predio yo;
    private Raiz raiz;
    private Timer tiempo;
    private EventoTiempo et;
    
    public Predio(){
        yo=this;
        raiz = new Raiz(300,450);
        setBackground(Color.WHITE);
        tiempo = new Timer(30,null);
        et = new EventoTiempo();
        tiempo.addActionListener(et);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        raiz.paint(g);
    }
    
    public void empezar(){
        tiempo.start();
    }
    
    public void detener(){
        tiempo.stop();
    }
    
    public void cambiarVelocidad(int vel){
        tiempo.setDelay(vel);
    }
    
    class EventoTiempo implements ActionListener{

        public EventoTiempo(){
    
        }   

        @Override
        public void actionPerformed(ActionEvent e) {
            raiz.crecer();
            yo.repaint();
        }
    
    }
    
}
