
package interfazlistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Stack {
    
    Nodo tope;
    
    public Stack(){
        tope=null;
    }
    
    public void push(Point p){
        Nodo aux = new Nodo();
        aux.p=p;
        aux.prox=tope;
        tope=aux;
    }
    
    public Point pop(){
        Point p=null;
        Nodo aux=tope;
        if(tope!=null){
            p=tope.p;
            tope=tope.prox;
        }
        return p;
    }
    
    public boolean empty(){
        if(tope==null) return true;
        else return false;
    }
    
    public void paint(Graphics g){
        Nodo aux=tope;
        String s;
        int prevX=-1;
        int prevY=-1;
        while(aux!=null){
            g.setColor(Color.BLACK);
            g.drawRect(aux.p.x,aux.p.y,60,15);
            s=Integer.toString(aux.p.x)+", "+Integer.toString(aux.p.y);
            g.drawString(s,aux.p.x+3,aux.p.y+12);
            g.setColor(Color.RED);
            if(prevX>=0) g.drawLine(prevX, prevY, aux.p.x, aux.p.y);
            prevX=aux.p.x;
            prevY=aux.p.y;
            aux=aux.prox;
        }
    }
    
}

class Nodo{
    
    Point p;
    Nodo prox;

}
