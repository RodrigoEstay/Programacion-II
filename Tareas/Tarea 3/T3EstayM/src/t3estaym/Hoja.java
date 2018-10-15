
package t3estaym;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Hoja extends JPanel {
    
    private double posX;
    private double posY;
    private double maxTam;
    private double actualTam;
    private int ancho;
    private int alto;
    
    public Hoja(double tam, int ancho, int alto, int posX, int posY){
        maxTam=tam;
        this.posX=posX;
        this.posY=posY;
        this.alto=alto;
        this.ancho=ancho;
        actualTam=0;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval((int)posX, (int)posY, (int)(actualTam*ancho), (int)(actualTam*alto));
    }
    
    public void crecer(){
        if(actualTam<maxTam) actualTam+=(1.0/100.0)*maxTam;
    }
    
    public void moverHoja(double sumX, double sumY){
        posX+=sumX;
        posY-=sumY;
    }
    
}
