
package t3estaym;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Rama extends JPanel{
    
    private int tamano;
    private double angulo;
    private double baseX;
    private double baseY;
    private double actualX;
    private double actualY;
    private int edad;
    private int cantRamas;
    ArrayList ramas;
    
    public Rama(int tamano, int baseX, int baseY, double angulo){
        ramas = new ArrayList();
        this.tamano=tamano;
        this.baseX=baseX;
        this.baseY=baseY;
        this.angulo=Math.toRadians(angulo);
        actualX=baseX;
        actualY=baseY;
        edad=0;
        cantRamas=4;
    }
    
    public void paint(Graphics g){
        g.drawLine((int)baseX,(int)baseY,(int)actualX,(int)actualY);
        Rama aux=null;
        for(int i=0; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.paint(g);
        }
    }
    
    public void crecer(){
        edad++;
        Rama aux=null;
        if(edad<1000){
            double difX=(1.0/1000.0)*(tamano*Math.cos(angulo));
            double difY=(1.0/1000.0)*(tamano*Math.sin(angulo));
            actualX+=difX;
            actualY-=difY;
            for(int j=0 ; j<ramas.size() ; j++){
                aux=(Rama)ramas.get(j);
                aux.moverRama(difX,difY);
            }
        }
        for(int i=0; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.crecer();
        }
        if(tamano>70 && edad%300==0 && ramas.size()<=cantRamas) crearRama();
    }
    
    public void crearRama(){
        double ang;
        int tam=(int)(tamano*2.0/3.0);
        //int posX=(int)baseX+(int)(tam*Math.cos(angulo));
        //int posY=(int)baseY-(int)(tam*Math.sin(angulo));
        int posX=(int)(baseX+(2.0/3.0)*(actualX-baseX));
        int posY=(int)(baseY+(2.0/3.0)*(actualY-baseY));
        if(edad==300) ang=Math.toDegrees(angulo)-40.0;
        else if(edad==600) ang=Math.toDegrees(angulo)+40.0;
        else ang=Math.toDegrees(angulo)-10.0;
        Rama aux = new Rama(tam,posX,posY,ang);
        ramas.add(aux);
    }
    
    public void moverRama(double sumX, double sumY){
        baseX+=sumX;
        baseY-=sumY;
        actualX+=sumX;
        actualY-=sumY;
    }
    
}
