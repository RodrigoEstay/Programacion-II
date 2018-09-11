
package fiestaspatrias;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel{
    public PanelDibujo(){
        this.setSize(600,400); //para que se inicie con un tamaño
        this.setBackground(Color.white);
    }
    public void paint (Graphics g){ //como ‘paint’ en JFrame
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(100,100,100,100);
    } 
}
