
package interfazhumanos;

import java.awt.*;

public class Circulo{
    public int x;
    public int y;
    public int xx;
    public int yy;
    public Color c;
    public Circulo(int X,int Y,int XX,int YY){
        x=X;
        y=Y;
        xx=XX;
        yy=YY;
        c=Color.red;
    }
    
    public void paint(Graphics g){
        g.setColor(c);
        g.fillOval(x, y, xx, yy);
    }
    
}
