
package seccioncritica;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame implements MouseListener{
    
    CuentaHojas ch;
    
    public Ventana(CuentaHojas ch){
        this.setSize(900, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addMouseListener(this);
        this.ch=ch;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("AAAAAAAAA");
        ch.imprimirHoja(false);
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
