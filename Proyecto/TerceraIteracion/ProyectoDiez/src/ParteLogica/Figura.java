
package ParteLogica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Clase abstracta que define el comportamiento de las figuras.
 * @author Rodrigo Estay
 */
abstract public class Figura {
    
    protected double posX;
    protected double posY;
    protected double velocidad;
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
        return (int)posX;
    }
    
    /**
     * @return posicion actual en el eje y.
     */
    public int getY(){
        return (int)posY;
    }
    
    /**
     * @return velocidad de la figura.
     */
    public double getVel(){
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
     * Revisa si la figura debe desaparecer, y rebota con la figura dependiendo
     * de la velocidad y posicion de la figura con la que choco respecto a esta
     * figura. Tambien evite que dos figuras queden una dentro de otra evitando
     * que se queden pegadas.
     * @param difT diferencia total entre los centros de ambas figuras.
     * @param x posicion en el eje x de la figura con la que se colisiono.
     * @param y posicion en el eje x de la figura con la que se colisiono.
     * @param vel velocidad de la figura con la que se colisiono.
     * @param desaparecer true si la figura debe desaparecer despues de
     * colisionar o false si es que no.
     */
    public void colisionar(double difT, int x, int y, double vel, boolean desaparecer){
        if(desaparecer){
            colisiono=true;
            color=color.BLUE;
        }
        velocidad=0.9*velocidad+vel*0.1;
        double ang;
        double difX=x-posX;
        double difY=posY-y;
        if (y-posY==0) ang=Math.toRadians(270);
        else ang=Math.atan(difY/difX);
        if(posX>x && posY>y) ang+=Math.toRadians(180);
        else if(posX>x && posY<y) ang+=Math.toRadians(180);
        else if(posX<x && posY<y) ang+=Math.toRadians(360);
        direccion=ang+Math.toRadians(180);
        if(direccion>Math.toRadians(360)) direccion-=Math.toRadians(360);
        if(direccion<0) direccion+=Math.toRadians(360);
        if(difT==0) return;
        double difDist=30-difT;
        posX-=Math.cos(ang)*difDist;
        if(Math.cos(ang)*difDist>0) posX++;
        else posX--;
        posY+=Math.sin(ang)*difDist;
        if(Math.sin(ang)*difDist>0) posY++;
        else posY--;
    }
    
    /**
     * @return 0 si es un circulo y 1 si es un cuadrado.
     */
    abstract public int getTipo();
    
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
        g.fillOval((int)posX, (int)posY, 30*tiempoRestante/30, 30*tiempoRestante/30);
    }

    /**
     * @return siempre 0.
     */
    @Override
    public int getTipo() {
        return 0;
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
        g.fillRect((int)posX, (int)posY, 30*tiempoRestante/30, 30*tiempoRestante/30);
    }

    /**
     * @return siempre 1.
     */
    @Override
    public int getTipo() {
        return 1;
    }
    
}