
package ParteLogica;

import java.awt.Color;
import java.awt.Graphics;


public class Figura {
    
    private int posX;
    private int posY;
    private int velocidad;
    private double direccion;
    private boolean colisiono;
    private int tiempoRestante;
    
    public Figura(int x,int y,int vel,double dir){
        posX=x-15;
        posY=y-15;
        velocidad=vel;
        direccion=Math.toRadians(dir);
        colisiono=false;
        tiempoRestante=30;
    }
    
    public int getX(){
        return posX;
    }
    
    public int getY(){
        return posY;
    }
    
    public int getVel(){
        return velocidad;
    }
    
    public double getDir(){
        return direccion;
    }
    
    public boolean haColisionado(){
        return colisiono;
    }
    
    public boolean moverse(){
        posX+=Math.cos(direccion)*velocidad;
        posY-=Math.sin(direccion)*velocidad;
        if(colisiono) tiempoRestante--;
        if(tiempoRestante<0 || posY>720 || posX>920 || posY<-20 || posX<-20) return true;
        else return false;
    }
    
    public void colisionar(int velC, double dirC){
        colisiono=true;
        int compX=(int)(Math.cos(direccion)*velocidad+Math.cos(dirC)*velC);
        int compY=(int)(Math.sin(direccion)*velocidad+Math.sin(dirC)*velC);
        velocidad=(int)(0.6*Math.sqrt(Math.pow(compX,2)+Math.pow(compY,2)));
        if(compX==0) direccion=Math.toDegrees(270);
        else direccion=Math.atan(compY/compX);
    }
    
    public void paint(Graphics g){
        if(colisiono) g.setColor(Color.BLUE);
        else g.setColor(Color.RED);
        g.fillOval(posX, posY, 30, 30);
    }
    
}
