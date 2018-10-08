
package t3estaym;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel{
    
    Raiz raiz;
    
    public PanelDibujo(){
        raiz=new Raiz(this,300,450);
        setBackground(Color.WHITE);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        raiz.paint(g);
    }

    public void empezar(){
        raiz.empezar();
    }
    
    public void detener(){
        raiz.detener();
    }
    
    public void cambiarVelocidad(int vel){
        raiz.cambiarVelocidad(vel);
    }
    
}
