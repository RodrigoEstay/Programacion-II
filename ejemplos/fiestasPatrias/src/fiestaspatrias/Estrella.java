
package fiestaspatrias;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class Estrella extends JPanel{
    int x;
    int y;
    int size;
    Color color;
    Polygon p;
    public Estrella(int x, int y, int s, Color c){
        this.setSize(s,s); //para que se inicie con un tamaño
        color=c;
        size=s;
        this.x=x;
        this.y=y;
        p= new Polygon();
        p.addPoint(x+0, y+size/3); // punta
        p.addPoint(x+size*6/17, y+size/3);
        p.addPoint(x+size/2, y+0); // punta
        p.addPoint(x+size*11/17, y+size/3);
        p.addPoint(x+size, y+size/3); // punta
        p.addPoint(x+size*12/17, y+size*10/17);
        p.addPoint(x+size*5/6, y+size*17/17); // punta
        p.addPoint(x+size/2, y+size*13/17);
        p.addPoint(x+size*1/6, y+size*17/17); // punta
        p.addPoint(x+size*5/17, y+size*10/17);
    }
    public void paint (Graphics g){ //como ‘paint’ en JFrame
        g.setColor(color);
        g.fillPolygon(p);
    } 

}
