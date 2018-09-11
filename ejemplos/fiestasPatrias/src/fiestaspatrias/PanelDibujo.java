
package fiestaspatrias;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel{
    Bandera s;
    public PanelDibujo(){
        this.setSize(1280,720); //para que se inicie con un tamaño
        s = new Bandera();
    }
    public void paint (Graphics g){ //como ‘paint’ en JFrame
        s.paint(g);
    } 
}
