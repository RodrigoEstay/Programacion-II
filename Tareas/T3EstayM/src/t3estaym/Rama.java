
package t3estaym;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Rama extends JPanel{
    
    private int tamano;
    private double anguloR;
    private double anguloG;
    private int baseX;
    private int baseY;
    private int finalX;
    private int finalY;
    private int edad;
    private int cantRamas;
    ArrayList ramas;
    
    public Rama(int tamano, int baseX, int baseY, double angulo){
        ramas = new ArrayList();
        this.tamano=tamano;
        this.baseX=baseX;
        this.baseY=baseY;
        anguloG=angulo;
        anguloR=Math.toRadians(angulo);
        finalX=baseX+(int)(tamano*Math.cos(anguloR));
        finalY=baseY-(int)(tamano*Math.sin(anguloR));
        edad=0;
        cantRamas=4;
    }
    
    public void paint(Graphics g){
        int x;
        int y;
        if(edad<100){
            x=baseX+(finalX-baseX)*1/(100-edad);
            y=baseY+(finalY-baseY)*1/(100-edad);
        }
        else{
            x=finalX;
            y=finalY;
        }
        g.drawLine(baseX,baseY,x,y);
        Rama aux=null;
        for(int i=0; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.paint(g);
        }
    }
    
    public void aumentarEdad(){
        edad++;
        Rama aux=null;
        if(tamano>70 && edad%100==0 && ramas.size()<=cantRamas){
            double ang;
            int tam=(int)(tamano*2.0/3.0);
            int posX=baseX+(int)(tam*Math.cos(anguloR));
            int posY=baseY-(int)(tam*Math.sin(anguloR));
            if(edad==100) ang=anguloG-40.0;
            else if(edad==200) ang=anguloG+40.0;
            else ang=anguloG-10.0;
            aux = new Rama(tam,posX,posY,ang);
            ramas.add(aux);
        }
        for(int i=0; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.aumentarEdad();
        }
    }
    
}
