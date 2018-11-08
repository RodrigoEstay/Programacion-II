
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
    
    private Timer tiempo;
    private EventoTiempo et;
    private AlmacenFiguras almacen;
    private int modo;
    private int userVel;
    private Random rand;
    
    /**
     * Constructor.
     * @param modo Define el modo predeterminado.
     * @param dp Referencia al PanelDibujo para poder hacer repaint.
     */
    public Manejador(int modo, PanelDibujo dp){
        tiempo = new Timer(30,null);
        et = new EventoTiempo(dp);
        almacen = new AlmacenFiguras();
        rand = new Random();
        tiempo.addActionListener(et);
        this.modo=modo;
    }
    
    /**
     * Cambia el modo en el que se crean las figuras.
     * @param modo Modo seleccionado.
     */
    public void cambiarModo(int modo){
        this.modo=modo;
    }
    
    /**
     * Cambia la velocidad de las figuras para el modo definido por el usuario.
     * @param vel velocidad escogida.
     */
    public void cambiarVelocidad(int vel){
        userVel=vel;
    }
    
    /**
     * Crea las figuras.
     * @param x posicion inicial en el eje x.
     * @param y posicion inicial en el eje y.
     * @param vel velocidad de la figura.
     * @param esHorizontal define si es horizontal o vertical.
     */
    public void crearFigura(int x, int y, int vel, boolean esHorizontal){
        double dir;
        if(modo==1){
            if(rand.nextInt(2)==1){
                x=0;
                dir=0;
                int posHModo1=rand.nextInt(6);
                if(posHModo1==0) y=100;
                if(posHModo1==1) y=200;
                if(posHModo1==2) y=300;
                if(posHModo1==3) y=400;
                if(posHModo1==4) y=500;
                if(posHModo1==5) y=600;
            }
            else{
                y=0;
                dir=270;
                int posVModo1=rand.nextInt(8);
                if(posVModo1==0) x=100;
                if(posVModo1==1) x=200;
                if(posVModo1==2) x=300;
                if(posVModo1==3) x=400;
                if(posVModo1==4) x=500;
                if(posVModo1==5) x=600;
                if(posVModo1==6) x=700;
                if(posVModo1==7) x=800;
            }
            vel=rand.nextInt(13)+1;
        }
        else if(modo==2){
            if(rand.nextInt(2)==1){
                x=0;
                dir=0;
                y=rand.nextInt(590)+10;
            }
            else{
                y=0;
                dir=270;
                x=rand.nextInt(590)+10;
            }
            vel=rand.nextInt(28)+3;
        }
        else{
            if(esHorizontal) dir=0;
            else dir=270;
            if(vel==0) vel=rand.nextInt(28)+3;
        }
        int tipo=rand.nextInt(3);
        almacen.crearFigura(x,y,vel,dir,tipo);
    }
    
    /**
     * Empieza o detiene el timer.
     * @param play true para empezarlo y false para detenerlo.
     */
    public void playPause(boolean play){
        if(play) tiempo.start();
        else tiempo.stop();
    }
    
    /**
     * Metodo que pinta las figuras.
     * @param g para poder dibujar las figuras.
     */
    public void paint(Graphics g){
        almacen.dibujarFiguras(g);
    }
    
    /**
     * Clase privada que ejecuta un evento cada cierto tiempo.
     */
    private class EventoTiempo implements ActionListener{
        
        private PanelDibujo dp;
        
        /**
         * Contructor
         * @param dp referencia a PanelDibujo para usar repaint.
         */
        public EventoTiempo(PanelDibujo dp){
            this.dp=dp;
        }
        
        /**
         * Metodo ejecutado cada cierta cantidad de tiempo.
         * @param e evento asociado al timer.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            almacen.moverFormas();
            almacen.detectarColision();
            dp.repaint();
            if((modo==1 || modo==2) && rand.nextInt(3)==0) crearFigura(0,0,0,false); 
        }
        
    }
    
}
