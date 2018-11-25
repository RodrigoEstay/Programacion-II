
package ParteLogica;

import Interfaz.PanelDibujo;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 * Clase que maneja la posicion de las figuras y sus respectivos moviemientos.
 * @author Rodrigo Estay
 */
public class Manejador{
    
    private AlmacenFiguras almacen;
    private Random rand;
    private int modo;
    private int contColision;
    
    /**
     * Constructor.
     * @param modo Define el modo predeterminado.
     */
    public Manejador(int modo){
        almacen = new AlmacenFiguras();
        rand = new Random();
        this.modo=modo;
        contColision=0;
    }
    /**
     * Metodo de consulta.
     * @return devuelve el numero de colisiones que han ocurrido.
     */
    public int getColisiones(){
        return contColision;
    }
    
    /**
     * Cambia el modo en el que se crean las figuras.
     * @param modo Modo seleccionado.
     */
    public void cambiarModo(int modo){
        this.modo=modo;
    }
    
    /**
     * Metodo usado para reiniciar el manejador.
     */
    public void reiniciar(){
        almacen.eliminarFiguras();
        contColision=0;
    }
    
    /**
     * Se crea una figura en posiciones y velocidades iniciales variadas
     * dependiendo del modo seleccionado.
     */
    public void crearFigura(){
        int x=0;
        int y=0;
        int vel=0;
        double dir;
        if(modo==1){
            if(rand.nextInt(3)!=0) return;
            if(rand.nextInt(2)==1){
                if(rand.nextInt(2)==0){
                    x=0;
                    dir=0;
                }
                else{
                    x=1300;
                    dir=180;
                }
                int posHModo1=rand.nextInt(8);
                if(posHModo1==0) y=100;
                if(posHModo1==1) y=200;
                if(posHModo1==2) y=300;
                if(posHModo1==3) y=400;
                if(posHModo1==4) y=500;
                if(posHModo1==5) y=600;
                if(posHModo1==6) y=700;
                if(posHModo1==7) y=800;
            }
            else{
                if(rand.nextInt(2)==0){
                    y=0;
                    dir=270;
                }
                else{
                    y=900;
                    dir=90;
                }
                int posVModo1=rand.nextInt(12);
                if(posVModo1==0) x=100;
                if(posVModo1==1) x=200;
                if(posVModo1==2) x=300;
                if(posVModo1==3) x=400;
                if(posVModo1==4) x=500;
                if(posVModo1==5) x=600;
                if(posVModo1==6) x=700;
                if(posVModo1==7) x=800;
                if(posVModo1==8) x=900;
                if(posVModo1==9) x=1000;
                if(posVModo1==10) x=1100;
                if(posVModo1==11) x=1200;
            }
            vel=rand.nextInt(8)+1;
        }
        else{
            if(rand.nextInt(3)!=0) return;
            if(rand.nextInt(2)==1){
                if(rand.nextInt(2)==0){
                    x=0;
                    dir=0;
                }
                else{
                    x=1300;
                    dir=180;
                }
                y=rand.nextInt(800)+30;
            }
            else{
                if(rand.nextInt(2)==0){
                    y=0;
                    dir=270;
                }
                else{
                    y=900;
                    dir=90;
                }
                x=rand.nextInt(1200)+30;
            }
            vel=rand.nextInt(8)+1;
        }
        int tipo=rand.nextInt(2);
        if(modo==4) tipo=0;
        almacen.crearFigura(x,y,vel,dir,tipo);
    }
    
    /**
     * Metodo usado para crear figuras con posiciones y velocidad definidas
     * por el usuario con el mouse.
     * @param xi posicion inicial del mouse en el eje X al hacer click.
     * @param yi posicion inicial del mouse en el eje Y al hacer click.
     * @param xf posicion final del mouse en el eje X al hacer click.
     * @param yf posicion final del mouse en el eje Y al hacer click.
     */
    public void mouseCrearFigura(int xi, int yi, int xf, int yf){
        double dif=Math.sqrt((xf-xi)*(xf-xi)+(yf-yi)*(yf-yi));
        double dir;
        double difX=xf-xi;
        double difY=yi-yf;
        if(yi-yf==0) dir=270;
        else dir=Math.toDegrees(Math.atan(difY/difX));
        if(difX<0 && difY>0) dir+=180;
        else if(difX<0 && difY<0) dir+=180;
        else if(difX>0 && difY<0) dir+=360;
        int vel;
        if(dif>900) vel=30;
        else vel=(int)(dif/30.0);
        if(vel==0) vel=1;
        int tipo=rand.nextInt(2);
        if(modo==4) tipo=0;
        almacen.crearFigura(xi, yi, vel, dir, tipo);
    }
    
    /**
     * detecta si ha ocurrido alguna colision entre figuras, y si ocurrio una,
     * se manda la informacion correspondiente a las figuras para que reboten.
     */
    public void detectarColision(){
        almacen.moverFormas();
        Figura aux=null;
        Figura aux2=null;
        int tam=almacen.getSize();
        for(int i=0 ; i<tam ; i++){
            aux=almacen.getFigura(i);
            if(aux.haColisionado()) continue;
            for(int j=0 ; j<tam ; j++){
                aux2=almacen.getFigura(j);
                if(i==j || aux2.haColisionado()) continue;
                int difX=Math.abs(aux.getX()-aux2.getX());
                if(difX>30) continue;
                int difY=Math.abs(aux.getY()-aux2.getY());
                if(difY>30) continue;
                double difT=Math.sqrt(difX*difX+difY*difY);
                if(aux.getTipo()==0 && aux2.getTipo()==0){
                    if(difT>30) continue;
                }
                if((aux.getTipo()==0 && aux2.getTipo()==1) || (aux.getTipo()==1 && aux2.getTipo()==0)){
                    if(difT>36) continue;
                }
                double vel=aux.getVel();
                double vel2=aux2.getVel();
                double dir=aux.getDir();
                double dir2=aux.getDir();
                boolean des=true;
                if(modo==4) des=false;
                aux.colisionar(0,aux2.getX(),aux2.getY(),aux2.getVel(),des);
                aux2.colisionar(difT,aux.getX(),aux.getY(),aux.getVel(),des);
                contColision++;
            }
        }
    }
    
    /**
     * Metodo que pinta las figuras.
     * @param g para poder dibujar las figuras.
     */
    public void paint(Graphics g){
        almacen.dibujarFiguras(g);
    }
      
}
