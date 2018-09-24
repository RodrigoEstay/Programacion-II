
package interfazhumanos;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.MouseMotionListener;

public class PanelDibujo extends JPanel implements MouseMotionListener{
    
    Circulo circ;
    public PanelDibujo(){
        circ = new Circulo(0,0,30,30);
        this.addMouseMotionListener(this);
        setBackground(Color.black);
    }
    
    public void paint(Graphics g){
        super.paint(g); // uso el paint de la super clase para que pinte un rectangulo
        circ.paint(g);
    }
    
    public void change(Color c){
        this.setBackground(c);
        repaint();
    }
    
    public void changeCirc(Color c){
        circ.c=c;
    }
    
    public void changeCircTam(boolean a){
        if(a){
            circ.xx=circ.xx+5;
            circ.yy=circ.yy+5;
        }
        else{
            circ.xx=circ.xx-5;
            circ.yy=circ.yy-5;
        }
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        circ.x=e.getX()-15;
        circ.y=e.getY()-15;
        repaint();
    }
    
}
