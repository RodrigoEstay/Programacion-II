
package Interfaz;

import ParteLogica.Manejador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Clase usada para crear el panel donde se moveran las figuras.
 * @author Rodrigo Estay
 */
public class PanelDibujo extends JPanel implements MouseListener{
    
    int userVel;
    boolean esHorizontal;
    boolean mouseHabilit;
    Manejador manejador;
    
    /**
     * Constructor de PanelDibujo.
     */
    public PanelDibujo(){
        manejador = new Manejador(1,this);
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        mouseHabilit=false;
    }
    
    /**
     * Metodo para cambiar el modo en el que funciona el programa,
     * normalmente solo hace cambiar el modo del manejador, pero si el
     * modo es 3, entonces se habilita la creacion de figuras con el mouse.
     * @param modo modo elegido por el usuario los que son:
     * 1 modo uniforme.
     * 2 modo aleatorio.
     * 3 modo definido por el usuario.
     */
    public void cambiarModo(int modo){
        manejador.cambiarModo(modo);
        if(modo==3) mouseHabilit=true;
        else mouseHabilit=false;
    }
    
    /**
     * Metodo ocupado para detener o empezar el Timer de manejador.
     * @param play Si es que se trata de empezar el Timer es true, si no
     * es false.
     */
    public void playPause(boolean play){
        manejador.playPause(play);
    }
    
    /**
     * Metodo para dibujar las figuras y el fondo.
     * @param g Graphics usados para enviar como parametro a los paint de las
     * figuras.
     */
    public void paint(Graphics g){
        super.paint(g);
        manejador.paint(g);
    }
    
    /**
     * Usado para cambiar las direcciones de las figuras creadas por el usuario.
     * @param esHorizontal si es true se trata de una direccion horizontal, en
     * caso contrario se trata de una direccion vertical.
     */
    public void cambiarDir(boolean esHorizontal){
        this.esHorizontal=esHorizontal;
    }
    
    /**
     * Defina la velocidad en la que se mueven las figuras creadas por el
     * usuario.
     * @param vel velocidad en la que se moveran las figuras creadas con el
     * mouse.
     */
    public void cambiarVel(int vel){
        userVel=vel;
    }

    /**
     * Metodo usado para el click del mouse.
     * @param e evento que se asocia al click del mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(mouseHabilit){
            manejador.crearFigura(e.getX(),e.getY(),userVel,esHorizontal);
            repaint();
        }
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
    
}
