
package Interfaz;

import ParteLogica.Manejador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Clase usada para crear el panel donde se moveran las figuras.
 * @author Rodrigo Estay
 */
public class PanelDibujo extends JPanel implements MouseListener{
    
    private boolean crear;
    private int mouseX;
    private int mouseY;
    private Manejador manejador;
    private Timer tiempo;
    private EventoTiempo et;
    
    /**
     * Constructor de PanelDibujo.
     */
    public PanelDibujo(){
        manejador = new Manejador(1);
        tiempo = new Timer(10,null);
        et = new EventoTiempo();
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        crear=false;
        tiempo.addActionListener(et);
    }
    
    /**
     * Metodo para cambiar el modo en el que funciona el programa.
     * @param modo modo elegido por el usuario los que son:
     * 1 modo uniforme.
     * 2 modo aleatorio.
     * 3 modo solo usuario.
     * 4 modo sin desaparecer.
     */
    public void cambiarModo(int modo){
        manejador.cambiarModo(modo);
        if(modo==3) crear=true;
        else crear=false;
    }
    
    /**
     * Metodo ocupado para detener o empezar el Timer de manejador.
     * @param play Si es que se trata de empezar el Timer es true, si no
     * es false.
     */
    public void playPause(boolean play){
        if(play) tiempo.start();
        else tiempo.stop();
    }
    
    /**
     * Metodo usado para reiniciar el panel.
     */
    public void reiniciar(){
        manejador.reiniciar();
        repaint();
    }
    
    /**
     * Metodo para dibujar las figuras y el fondo.
     * @param g Graphics usados para enviar como parametro a los paint de las
     * figuras.
     */
    public void paint(Graphics g){
        super.paint(g);
        manejador.paint(g);
        g.setColor(Color.BLACK);
        g.drawString("Colisiones: "+manejador.getColisiones(), 1190, 770);
    }
    
    /**
     * Metodo que cambia la frecuencia que se ejecuta el evento de tiempo.
     * @param tiemp Define la velocidad del programa, mientras mayor, mas rapido
     * es el programa.
     */
    public void cambiarTiempo(int tiemp){
        tiempo.setDelay(55-tiemp);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    /**
     * Registra la posicion inicial del mouse al hacer click.
     * @param e evento asociado a presionar algun boton del mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }

    /**
     * Registra la posicion final del mouse al hacer click, y se crea una figura.
     * @param e evento asociado a soltar un boton del mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        manejador.mouseCrearFigura(mouseX, mouseY, e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    /**
     * Clase interna que ejecuta los metodos dependientes del tiempo.
     */
    private class EventoTiempo implements ActionListener{
        
        /**
         * Metodo ejecutado cada cierta cantidad de tiempo.
         * @param e evento asociado al timer.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            manejador.detectarColision();
            repaint();
            if(!crear) manejador.crearFigura(); 
        }
        
    }
    
}
