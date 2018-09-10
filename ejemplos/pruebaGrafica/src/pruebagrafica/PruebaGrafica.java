
package pruebagrafica;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PruebaGrafica {

    public static void main(String[] args) {
        Display x = new Display();
    }
    
}


class Display extends JFrame implements MouseListener{
    
    Rectangulo rec;
    Rectangulo rec1;
    public Display(){
        this.addMouseListener(this);
        this.setVisible(true);
        this.setSize(1366,768);
        rec = new Rectangulo(500,100, 111, 200, Color.blue);
        rec1 = new Rectangulo(100,600, 40, 20, Color.green);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,1366,768);
        g.setColor(Color.red);
        g.fillRect(100,100,100,50);
        rec.pintarme(g);
        rec1.pintarme(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("hola");
        rec.setxy(e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}

class Rectangulo{
    int a;
    int l;
    int x;
    int y;
    Color c;
    public Rectangulo(int x, int y, int alto, int largo, Color c){
        a=alto;
        l=largo;
        this.x=x;
        this.y=y;
        this.c=c;
    }
    public void setxy(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void pintarme(Graphics g){
        g.setColor(c);
        g.fillRect(x,y,a,l);
    }
}