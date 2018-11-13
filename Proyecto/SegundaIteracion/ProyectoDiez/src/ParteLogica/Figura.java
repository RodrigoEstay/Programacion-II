
package ParteLogica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Clase abstracta que define el comportamiento de las figuras.
 * @author Rodrigo Estay
 */
abstract public class Figura {
    
    protected int posX;
    protected int posY;
    protected int velocidad;
    protected double direccion;
    protected boolean colisiono;
    protected int tiempoRestante;
    protected Color color;
    
    /**
     * Constructor
     * @param x Posicion inicial en el eje x.
     * @param y Posicion inicial en el eje y.
     * @param vel Velocidad de la figura.
     * @param dir Direccion de la figura en grados.
     */
    public Figura(int x,int y,int vel,double dir){
        posX=x-15;
        posY=y-15;
        velocidad=vel;
        direccion=Math.toRadians(dir);
        colisiono=false;
        tiempoRestante=30;
        color=Color.RED;
    }
    
    /**
     * @return posicion actual en el eje x.
     */
    public int getX(){
        return posX;
    }
    
    /**
     * @return posicion actual en el eje y.
     */
    public int getY(){
        return posY;
    }
    
    /**
     * @return velocidad de la figura.
     */
    public int getVel(){
        return velocidad;
    }
    
    /**
     * @return direccion de la figura en radianes.
     */
    public double getDir(){
        return direccion;
    }
    
    /**
     * @return retorna true si ya ha colisionado y false en caso contrario.
     */
    public boolean haColisionado(){
        return colisiono;
    }
    
    /**
     * Mueve la figura respecto a su velocidad y direccion.
     * @return true si se salio del panel, si no es false.
     */
    public boolean moverse(){
        posX+=Math.cos(direccion)*velocidad;
        posY-=Math.sin(direccion)*velocidad;
        if(colisiono) tiempoRestante--;
        if(tiempoRestante<0 || posY>915 || posX>1315 || posY<-15 || posX<-15) return true;
        else return false;
    }
    
    /**
     * Colisiona con una figura y rebota con esta respecto a las velocidades y
     * direcciones tanto de esta figura como con la que colisiono.
     * @param posX posicion X de la figura con la que colisiono.
     * @param posY posicion Y de la figura con la que colisiono.
     */
    public void colisionar(int posX, int posY){
        colisiono=true;
        color=color.BLUE;
        int compX=posX-this.posX;
        int compY=posY-this.posY;
        velocidad=(int)(0.3*velocidad);
        if(compX==0) direccion=Math.toDegrees(270);
        else direccion=Math.atan(compY/compX);
    }
    
    /**
     * Metodo abstracto para dibujar la figura.
     * @param g Graficos para dibujar la figura.
     */
    abstract public void paint(Graphics g);
    
}

/**
 * @author Rodrigo Estay
 */
class Circulo extends Figura{
    
    public Circulo(int x,int y,int vel,double dir){
        super(x,y,vel,dir);
    }
    
    /**
     * Se dibuja un circulo de radio 15 pixeles.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, 30*tiempoRestante/30, 30*tiempoRestante/30);
    }
    
}

/**
 * @author Rodrigo Estay
 */
class Cuadrado extends Figura{
    
    public Cuadrado(int x,int y,int vel,double dir){
        super(x,y,vel,dir);
    }

    /**
     * Se dibuja un cuadrado de ancho 30 pixeles.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, 30*tiempoRestante/30, 30*tiempoRestante/30);
    }
    
}

/**
 * @author Rodrigo Estay
 */
class Triangulo extends Figura{
    
    public Triangulo(int x,int y,int vel,double dir){
        super(x,y,vel,dir);
    }

    /**
     * Se dibuja un triangulo equilatero de altura 30 pixeles.
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        Polygon p = new Polygon();
        p.addPoint(posX, posY+30*tiempoRestante/30);
        p.addPoint(posX+15*tiempoRestante/30, posY);
        p.addPoint(posX+30*tiempoRestante/30, posY+30*tiempoRestante/30);
        g.fillPolygon(p);
    }
    
}