
package interfazlistas;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel implements MouseListener{
    
    Stack s;
    
    public PanelDibujo(){
        s = new Stack();
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = new Point(e.getX(),e.getY());
        if(s!=null) s.push(p);
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
    
    public void paint(Graphics g){
        super.paint(g);
        if(s!=null) s.paint(g);
    }
    
}
