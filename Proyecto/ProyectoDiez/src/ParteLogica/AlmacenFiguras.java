
package ParteLogica;

import java.awt.Graphics;
import java.util.ArrayList;

public class AlmacenFiguras {
    
    private ArrayList af;
    
    public AlmacenFiguras(){
        af = new ArrayList();
    }
    
    public void crearFigura(int x, int y, int vel, double dir){
        Figura aux = new Figura(x,y,vel,dir);
        af.add(aux);
    }
    
    public void dibujarFiguras(Graphics g){
        Figura aux=null;
        for(int i=0 ; i<af.size() ; i++){
            aux=(Figura)af.get(i);
            aux.paint(g);
        }
    }
    
    public void moverFormas(){
        Figura aux=null;
        boolean estaFuera;
        System.out.println(af.size());
        for(int i=0 ; i<af.size() ; i++){
            aux=(Figura)af.get(i);
            estaFuera=aux.moverse();
            if(estaFuera) af.remove(i);
        }
    }
    
    public void detectarColision(){
        Figura aux=null;
        Figura aux2=null;
        for(int i=0 ; i<af.size() ; i++){
            aux=(Figura)af.get(i);
            if(aux.haColisionado()) continue;
            for(int j=0 ; j<af.size() ; j++){
                aux2=(Figura)af.get(j);
                if(i==j || aux2.haColisionado()) continue;
                int difX=Math.abs(aux.getX()-aux2.getX());
                if(difX>30) continue;
                int difY=Math.abs(aux.getY()-aux2.getY());
                if(difY>30) continue;
                aux.colisionar(aux2.getVel(),aux2.getDir());
                aux2.colisionar(aux.getVel(),aux.getDir());
            }
        }
    }
    
}
