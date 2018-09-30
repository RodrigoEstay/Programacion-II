
package t2estaym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDibujo extends JPanel implements MouseListener{
    
    private AlmacenFormas af;
    private int modo;
    private int modoForma;
    private int seleccionado;
    
    // Se inicializan valores.
    public PanelDibujo(AlmacenFormas af){
        this.af=af;
        this.addMouseListener(this);
        setBackground(Color.white);
        modo=0;
        modoForma=0;
        seleccionado=-1;
    }
    
    
    // Se dibujan todas las formas.
    public void paint(Graphics g){
        super.paint(g);
        af.dibujarFormas(g);
    }
    
    
    // Se cambia el modo (agregar, eliminar, modificar).
    public void setModo(int modo){
        this.modo=modo;
    }
    
    // Se cambia la forma de la figura a agregar.
    public void setForma(int modoForma){
        this.modoForma=modoForma;
    }

    // Lo que ocurre al hacer click en el panel blanco cambia segun el modo.
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
        else if(modo==2){
            af.eliminarForma(e.getX(), e.getY());
        }
        else if(modo==3){
            if(seleccionado >= 0){
                af.moverForma(e.getX(), e.getY(), seleccionado);
                seleccionado=-1;
            }
            else{
                seleccionado=af.seleccionarForma(e.getX(), e.getY());
            }
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
