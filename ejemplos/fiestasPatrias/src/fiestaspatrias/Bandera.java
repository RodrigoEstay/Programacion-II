
package fiestaspatrias;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Bandera extends JPanel{
    Estrella es;
    public Bandera(){
        this.setSize(600,400); //para que se inicie con un tamaño
        this.setBackground(Color.blue);
        es = new Estrella(35,35,130, Color.white);
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0,200, 600, 200);
        g.setColor(Color.blue);
        g.fillRect(0, 0, 200, 200);
        g.setColor(Color.white);
        g.fillRect(200, 0, 400, 200);
        es.paint(g);
    }
}
