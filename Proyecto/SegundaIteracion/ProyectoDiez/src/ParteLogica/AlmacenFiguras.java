
package ParteLogica;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Clase que almacena todas las figuras.
 * @author Rodrigo Estay.
 */
public class AlmacenFiguras {
    
    private ArrayList af;
    
    /**
     * Constructor.
     */
    public AlmacenFiguras(){
        af = new ArrayList();
    }
    
    public int getSize(){
        return af.size();
    }
    
    public Figura getFigura(int i){
        return (Figura)af.get(i);
    }
    
    /**
     * Crea una figura.
     * @param x posicion inicial en el eje x.
     * @param y posicion inicial en el eje y.
     * @param vel velocidad de la figura.
     * @param dir direccion de la figura en grados.
     * @param tipo tipo de la figura, 0 es circulo, 1 es cuadrado y 2
     * es triangulo.
     */
    public void crearFigura(int x, int y, int vel, double dir, int tipo){
        Figura aux;
        if(tipo==0) aux = new Circulo(x,y,vel,dir);
        else if(tipo==1) aux = new Cuadrado(x,y,vel,dir);
        else aux = new Triangulo(x,y,vel,dir);
        af.add(aux);
    }
    
    /**
     * Dibuja todas las figuras.
     * @param g graficos necesarios para dibujar las figuras.
     */
    public void dibujarFiguras(Graphics g){
        Figura aux=null;
        for(int i=0 ; i<af.size() ; i++){
            aux=(Figura)af.get(i);
            aux.paint(g);
        }
    }
    
    /**
     * Mueve todas las figuras, y si una vez movidas se salen del panel, se
     * eliminan.
     */
    public void moverFormas(){
        Figura aux=null;
        boolean estaFuera;
        System.out.println(af.size());
        for(int i=0 ; i<af.size() ; i++){
            aux=(Figura)af.get(i);
            estaFuera=aux.moverse();
            if(estaFuera) af.remove(i);
        }
    }
    
}
