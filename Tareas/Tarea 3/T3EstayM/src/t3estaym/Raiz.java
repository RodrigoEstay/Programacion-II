
package t3estaym;

import java.awt.*;

public class Raiz{
    
    private int edad;
    private int posX;
    private int posY;
    private Rama tronco;
    
    public Raiz(int posX, int posY){
        this.posX=posX;
        this.posY=posY;
        edad=0;
        tronco=null;
    }
    
    public void crecer(){
        edad++;
        if(tronco!=null) tronco.crecer();
        else if(edad>100) tronco = new Rama(250,posX,posY,90.0,true);
    }
    
    public void paint(Graphics g){
        g.setColor(new Color(142,87,3));
        if(edad<160) g.fillOval(posX-edad/20, posY-edad/20, edad/10, edad/10);
        else g.fillOval(posX-8, posY-8, 16, 16);
        if(edad>100) tronco.paint(g);
    }
    
}
