
package proyectodiez;

import java.awt.Graphics;
import java.util.ArrayList;

public class AlmacenFiguras {
    
    private ArrayList lista;
    
    public AlmacenFiguras(){
        lista = new ArrayList();
    }
    
    public void crearFigura(int x, int y, int vel, double dir){
        Figura aux = new Figura(x,y,vel,dir);
        lista.add(aux);
    }
    
    public void eliminarFigura(){
        System.out.println("No implementado aun.");
    }
    
    public void dibujarFiguras(Graphics g){
        System.out.println("No implementado aun.");
    }
    
    public void moverFormas(){
        System.out.println("No implementado aun.");
    }
    
    public void detectarColision(){
        
    }
    
}
