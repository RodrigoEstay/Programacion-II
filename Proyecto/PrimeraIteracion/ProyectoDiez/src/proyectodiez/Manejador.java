
package proyectodiez;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Manejador extends JPanel{
    
    Manejador yo;
    Timer tiempo;
    EventoTiempo et;
    
    public Manejador(){
        tiempo = new Timer(30,null);
        et = new EventoTiempo();
        tiempo.addActionListener(et);
    }
    
    //Observamos si colisiona alguna figura.
    public void detectarColision(){
        System.out.println("No implementado aun.");
    }
    
    //Hacemos avanzar las figuras.
    public void moverFiguras(){
        System.out.println("No implementado aun.");
    }
    
    // pintamos las figuras.
    public void paint(Graphics g){
        System.out.println("No implementado aun.");
    }
    
    private class EventoTiempo implements ActionListener{
        
        //Se hara avanzar las figuras.
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("No implementado aun.");
        }
        
    }
    
}
