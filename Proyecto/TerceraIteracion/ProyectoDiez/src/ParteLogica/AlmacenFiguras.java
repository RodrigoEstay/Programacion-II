
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
    
    /**
     * @return retorna la cantidad de figuras que existen.
     */
    public int getSize(){
        return af.size();
    }
    
    /**
     * @param i indice de la figura que se desea.
     * @return retorna objeto de clase Figura almacenada en el indice anterior.
     */
    public Figura getFigura(int i){
        return (Figura)af.get(i);
    }
    
    /**
     * Crea una figura.
     * @param x posicion inicial en el eje x.
     * @param y posicion inicial en el eje y.
     * @param vel velocidad de la figura.
     * @param dir direccion de la figura en grados.
     * @param tipo tipo de la figura, 0 es circulo y 1 es cuadrado.
     */
    public void crearFigura(int x, int y, int vel, double dir, int tipo){
        Figura aux=null;
        if(tipo==0) aux = new Circulo(x,y,vel,dir);
        else if(tipo==1) aux = new Cuadrado(x,y,vel,dir);
        af.add(aux);
    }
    
    /**
     * Elimina todas las figuras.
     */
    public void eliminarFiguras(){
        af.clear();
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
     * Mueve todas las figuras, y si una vez movidas se salen del panel o
     * colisionaron hace un tiempo, se eliminan.
     */
    public void moverFormas(){
        Figura aux=null;
        boolean estaFuera;
        for(int i=0 ; i<af.size() ; i++){
            aux=(Figura)af.get(i);
            estaFuera=aux.moverse();
            if(estaFuera) af.remove(i);
        }
    }
    
}
