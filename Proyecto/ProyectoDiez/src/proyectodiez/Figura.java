
package proyectodiez;

import java.awt.Color;
import java.awt.Graphics;


public class Figura {
    
    private int posX;
    private int posY;
    private int velocidad;
    private double direccion;
    private boolean colisiono;
    
    public Figura(int x,int y,int vel,double dir){
        posX=x;
        posY=y;
        velocidad=vel;
        direccion=Math.toRadians(dir);
        colisiono=false;
    }
    
    public int getX(){
        return posX;
    }
    
    public int getY(){
        return posY;
    }
    
    public boolean haColisionado(){
        return colisiono;
    }
    
    public void moverse(){
        posX+=Math.cos(direccion)*velocidad;
        posY-=Math.sin(direccion)*velocidad;
    }
    
    public void colisionar(){
        colisiono=true;
    }
    
    public void paint(Graphics g){
        if(colisiono) g.setColor(Color.BLUE);
        else g.setColor(Color.RED);
        g.fillOval(posX-10, posY-10, 20, 20);
    }
    
}
