
package t2estaym;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

abstract public class Forma extends JPanel{
    
    protected int x;
    protected int y;
    
    // Se inicializan valores.
    public Forma(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    // Se pinta la forma.
    abstract public void paint(Graphics g);
    
    // Revisa si el pixel esta dentro de la forma.
    abstract public boolean estaDentro(int xx, int yy);
    
    // Se cambia la posicion de la forma.
    public void setXY(int xx, int yy){
        x=xx;
        y=yy;
    }
    
}

class Circulo extends Forma{
    
    public Circulo(int x, int y){
        super(x-20,y-20);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x, y, 40, 40);
    }
    
    public boolean estaDentro(int xx, int yy){
        if(xx<=x+40 && xx>=x && yy<=y+40 && yy>=y){
            int difx=x+20-xx;
            int dify=y+20-yy;
            if((int)Math.sqrt(difx*difx+dify*dify) <= 20) return true;
            else return false;
        }
        else return false;
    }
    
}

class Rectangulo extends Forma{
    
    public Rectangulo(int x, int y){
        super(x-28,y-20);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 56, 40);
    }
    
    public boolean estaDentro(int xx, int yy){
        if(xx<=x+56 && xx>=x && yy<=y+40 && yy>=y) return true;
        else return false;
    }
    
}

class Triangulo extends Forma{
    
    public Triangulo(int x, int y){
        super(x-20,y-20);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.blue);
        Polygon p = new Polygon();
        p.addPoint(x, y+40);
        p.addPoint(x+20,y);
        p.addPoint(x+40, y+40);
        g.fillPolygon(p);
    }
    
    public boolean estaDentro(int xx, int yy){
        if(xx<=x+40 && xx>=x && yy<=y+40 && yy>=y){
            if(xx == x+20) return true;
            else if(xx < x+20 && (yy-y) > (-2*(xx-x)+40)) return true;
            else if(xx > x+20 && (yy-y) > (2*(xx-x)-40)) return true;
            else return false;
        }
        else return false;
    }
    
}
