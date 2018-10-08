
package t3estaym;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Raiz extends JPanel implements ActionListener{
    
    private int edad;
    private int posX;
    private int posY;
    private Color colorRaiz;
    private Timer tiempo;
    private PanelDibujo dp;
    private Rama tronco;
    
    public Raiz(PanelDibujo dp, int posX, int posY){
        this.dp=dp;
        this.posX=posX;
        this.posY=posY;
        tiempo = new Timer(17,null);
        tiempo.addActionListener(this);
        edad=0;
        colorRaiz = new Color(142,87,3);
        tronco=null;
    }
    
    public void aumentarEdad(){
        edad++;
        if(tronco!=null) tronco.aumentarEdad();
        else if(edad>100) tronco = new Rama(250,posX,posY,90.0);
    }
    
    public void paint(Graphics g){
        g.setColor(colorRaiz);
        if(edad<160) g.fillOval(posX-edad/20, posY-edad/20, edad/10, edad/10);
        else g.fillOval(posX-8, posY-8, 16, 16);
        if(edad>100) tronco.paint(g);
    }
    
    public void empezar(){
        tiempo.start();
    }
    
    public void detener(){
        tiempo.stop();
    }
    
    public void cambiarVelocidad(int vel){
        tiempo.setDelay(vel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aumentarEdad();
        dp.repaint();
    }
    
}
