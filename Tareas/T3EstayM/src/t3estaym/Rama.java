
package t3estaym;

import java.awt.*;
import java.util.*;

public class Rama{
    
    private int tamano;
    private int grosor;
    private double angulo;
    private double baseX;
    private double baseY;
    private double actualX;
    private double actualY;
    private int edad;
    private int maxRamas;
    private int maxHojas;
    private ArrayList ramas;
    private ArrayList hojas;
    private Random rand;
    private int ramasIzq;
    private int ramasDer;
    
    public Rama(int tamano, int baseX, int baseY, double angulo){
        ramas = new ArrayList();
        hojas = new ArrayList();
        rand = new Random();
        this.tamano=tamano;
        this.baseX=baseX;
        this.baseY=baseY;
        this.angulo=Math.toRadians(angulo);
        actualX=baseX;
        actualY=baseY;
        edad=0;
        grosor=1;
        maxRamas=rand.nextInt(5)+3;
        maxHojas=rand.nextInt(5)+10;
        ramasIzq=0;
        ramasDer=0;
    }
    
    public void paint(Graphics g){
        g.setColor(new Color(142,87,3));
        g.drawLine((int)baseX,(int)baseY,(int)actualX,(int)actualY);
        for(int i=1 ; i<grosor ; i++){
            g.drawLine((int)baseX+i,(int)baseY+i,(int)actualX+i,(int)actualY+i);
            g.drawLine((int)baseX-i,(int)baseY-i,(int)actualX-i,(int)actualY-i);
        }
        Rama aux=null;
        for(int i=0; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.paint(g);
        }
        Hoja aux2=null;
        for(int i=0 ; i<hojas.size() ; i++){
            aux2=(Hoja)hojas.get(i);
            aux2.paint(g);
        }
    }
    
    public void crecer(){
        edad++;
        Rama aux=null;
        Hoja aux2=null;
        if(edad<1000){
            double difX=(1.0/1000.0)*(tamano*Math.cos(angulo));
            double difY=(1.0/1000.0)*(tamano*Math.sin(angulo));
            actualX+=difX;
            actualY-=difY;
            for(int j=0 ; j<ramas.size() ; j++){
                aux=(Rama)ramas.get(j);
                aux.moverRama(difX,difY);
            }
            for(int j=0 ; j<hojas.size() ; j++){
                aux2=(Hoja)hojas.get(j);
                aux2.moverHoja(difX,difY);
            }
        }
        for(int i=0; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.crecer();
        }
        for(int i=0; i<hojas.size() ; i++){
            aux2=(Hoja)hojas.get(i);
            aux2.crecer();
        }
        if(tamano>70 && edad%300==0 && ramas.size()<maxRamas) crearRama();
        if(edad%100==0 && hojas.size()<maxHojas) crearHoja();
        if(edad%400==0 && grosor*50<tamano) grosor++;
    }
    
    public void crearRama(){
        double ang;
        int tam=(int)(tamano*(rand.nextDouble()+2)/5);
        int posX=(int)(baseX+(2.0/3.0)*(actualX-baseX));
        int posY=(int)(baseY+(2.0/3.0)*(actualY-baseY));
        if(ramasDer>ramasIzq){
            ang=Math.toDegrees(angulo)+rand.nextInt(30)-60;
            ramasIzq++;
        }
        else if(ramasIzq>ramasDer){
            ang=Math.toDegrees(angulo)+rand.nextInt(30)+30;
            ramasDer++;
        }
        else{
            ang=Math.toDegrees(angulo)+rand.nextInt(120)-60;
            if(ang-(Math.toDegrees(angulo))<0) ramasIzq++;
            else ramasDer++;
        }
        Rama aux = new Rama(tam,posX,posY,ang);
        ramas.add(aux);
    }
    
    public void crearHoja(){
        int posX=(int)(baseX+(2.0/3.0)*(actualX-baseX))+(rand.nextInt(6)-3);
        int posY=(int)(baseY+(2.0/3.0)*(actualY-baseY))+(rand.nextInt(6)-3);
        Hoja hoja = new Hoja(rand.nextDouble()+1,7,7,posX,posY);
        hojas.add(hoja);
    }
    
    public void moverRama(double sumX, double sumY){
        baseX+=sumX;
        baseY-=sumY;
        actualX+=sumX;
        actualY-=sumY;
        Rama aux=null;
        for(int i=0 ; i<ramas.size() ; i++){
            aux=(Rama)ramas.get(i);
            aux.moverRama(sumX, sumY);
        }
        Hoja aux2=null;
        for(int i=0 ; i<hojas.size() ; i++){
            aux2=(Hoja)hojas.get(i);
            aux2.moverHoja(sumX, sumY);
        }
    }
    
}
