
package t2estaym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDibujo extends JPanel implements MouseListener{
    
    AlmacenFormas af;
    int modo;
    int modoForma;
       
    public PanelDibujo(AlmacenFormas af){
        this.af=af;
        this.addMouseListener(this);
        setBackground(Color.white);
        modo=0;
        modoForma=0;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        af.dibujarFormas(g);
    }
    
    public void setModo(int modo){
        this.modo=modo;
    }
    
    public void setForma(int modoForma){
        this.modoForma=modoForma;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(modo==1){
            if(modoForma==0) return;
            Forma f=null;
            if(modoForma==1) f = new Circulo(e.getX(),e.getY());
            if(modoForma==2) f = new Rectangulo(e.getX(),e.getY());
            if(modoForma==3) f = new Triangulo(e.getX(),e.getY());
            af.agregarForma(f);
        }
        if(modo==2){
            af.eliminarForma(e.getX(), e.getY());
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
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
