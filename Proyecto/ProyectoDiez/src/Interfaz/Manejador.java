
package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import ParteLogica.AlmacenFiguras;


public class Manejador extends JPanel implements MouseListener{
    
    private Timer tiempo;
    private EventoTiempo et;
    private AlmacenFiguras almacen;
    private int modo;
    private int userVel;
    private Random rand;
    
    public Manejador(int modo){
        tiempo = new Timer(30,null);
        et = new EventoTiempo();
        almacen = new AlmacenFiguras();
        rand = new Random();
        tiempo.addActionListener(et);
        this.addMouseListener(this);
        this.setBackground(Color.white);
        this.modo=modo;
    }
    
    public void cambiarModo(int modo){
        this.modo=modo;
    }
    
    public void cambiarVelocidad(int vel){
        userVel=vel;
    }
    
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
        almacen.crearFigura(x,y,vel,dir);
    }
    
    public void playPause(boolean play){
        if(play) tiempo.start();
        else tiempo.stop();
    }
    
    // pintamos las figuras.
    public void paint(Graphics g){
        super.paint(g);
        almacen.dibujarFiguras(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(modo==3) crearFigura(e.getX(),e.getY(),userVel,true);
        else if(modo==4) crearFigura(e.getX(),e.getY(),userVel,false);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    private class EventoTiempo implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            almacen.moverFormas();
            almacen.detectarColision();
            repaint();
            if((modo==1 || modo==2) && rand.nextInt(3)==0) crearFigura(0,0,0,false); 
        }
        
    }
    
}
