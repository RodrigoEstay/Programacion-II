
package t2estaym;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

public class Forma extends JPanel{
    
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    
    public Forma(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public boolean estaDentro(int xx, int yy){
        if(xx<=dx && xx>=x && yy<=dy && yy>=y) return true;
        else return false;
    }
    
}

class Circulo extends Forma{
    
    public Circulo(int x, int y){
        super(x-20,y-20);
        dx=x+20;
        dy=y+20;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x, y, 40, 40);
    }
    
}

class Rectangulo extends Forma{
    
    public Rectangulo(int x, int y){
        super(x-28,y-20);
        dx=x+28;
        dy=y+20;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 56, 40);
    }
    
}

class Triangulo extends Forma{
    
    public Triangulo(int x, int y){
        super(x-20,y-20);
        dx=x+20;
        dy=y+20;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.blue);
        Polygon p = new Polygon();
        p.addPoint(x, y+40);
        p.addPoint(x+20,y);
        p.addPoint(x+40, y+40);
        g.fillPolygon(p);
    }
    
}
