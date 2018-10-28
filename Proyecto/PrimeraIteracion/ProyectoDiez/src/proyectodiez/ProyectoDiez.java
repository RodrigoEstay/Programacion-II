
package proyectodiez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;


public class ProyectoDiez extends JFrame{

    
    public static void main(String[] args) {
        
    }
    
    public ProyectoDiez(){
        // Creara la ventana.
    }
    
    private class BotonesControles extends JButton implements ActionListener{
        
        public BotonesControles(){
            
        }

        //Debera definir la creacion de pelotas o sera un boton play.
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("No implementado aun.");
        }
        
        //Empezara la simulacion o la detiene.
        public void PlayPause(){
            System.out.println("No implementado aun.");
        }
        
        //Creara las formas donde decida el usuario.
        public void CrearFormas(){
            System.out.println("No implementado aun.");
        }
        
    }
    
    private class BotonModo extends JRadioButton implements ActionListener{
        
        public BotonModo(){
            
        }

        //Cambiara entre los modos posibles.
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("No implementado aun.");
        }
        
    }
    
    private class SlideVelocidad extends JSlider{
        
        public SlideVelocidad(){
            
        }
        
        //Definira la velocidad de los objetos creados
        public void DefinirVelocidad(){
            System.out.println("No implementado aun.");
        }
        
    }
    
}
