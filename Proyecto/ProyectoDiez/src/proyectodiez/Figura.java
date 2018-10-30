
package proyectodiez;

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
    
    public void setX(int x){
        System.out.println("No implementado aun.");
    }
    
    public void setY(int Y){
        System.out.println("No implementado aun.");
    }
    
    public void colisionar(){
        System.out.println("No implementado aun.");
    }
    
    public void paint(Graphics g){
        
    }
    
}
