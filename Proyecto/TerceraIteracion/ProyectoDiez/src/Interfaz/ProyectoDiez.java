
package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Clase principal usada para la creacion de la ventana del programa.
 * @author Rodrigo Estay
 */
public class ProyectoDiez extends JFrame{
    
    private PanelDibujo dp;
    
    public static void main(String[] args) {
        ProyectoDiez a = new ProyectoDiez();
    }
    
    /**
     * Constructor de la clase que crea la ventana, botones, PanelDibujo y
     * el slider de velocidad.
     */
    public ProyectoDiez(){
        this.setSize(1300,900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Creacion panel modos.
        BotonModo mUniforme = new BotonModo("Modo Uniforme", 1);
        BotonModo mAleatorio = new BotonModo("Modo Aleatorio", 2);
        BotonModo mUsuario = new BotonModo("Solo Usuario", 3);
        BotonModo sinDesaparecer = new BotonModo("Sin Desaparecer", 4);
        ButtonGroup modos = new ButtonGroup();
        modos.add(mUniforme);
        modos.add(mAleatorio);
        modos.add(mUsuario);
        modos.add(sinDesaparecer);
        JPanel panelModos = new JPanel();
        panelModos.add(mUniforme);
        panelModos.add(mAleatorio);
        panelModos.add(mUsuario);
        panelModos.add(sinDesaparecer);
        
        //Creamos Panel de Controles.
        BotonPlayPause bPlayPause = new BotonPlayPause("Play");
        BotonReinicio bReset = new BotonReinicio("Reset");
        
        Slider tiempSlider = new Slider(0,54,45);
        Hashtable<Integer, JLabel> tablaTiempo = new Hashtable<Integer, JLabel>();
        tablaTiempo.put(0, new JLabel("Lento"));
        tablaTiempo.put(50, new JLabel("Rapido"));
        tiempSlider.setLabelTable(tablaTiempo);
        
        JPanel panelSlider = new JPanel();
        panelSlider.add(tiempSlider);
        JPanel panelPlayPauseUsuario = new JPanel();
        panelPlayPauseUsuario.add(bPlayPause);
        panelPlayPauseUsuario.add(bReset);
        JPanel panelControlesUsuario = new JPanel();
        panelControlesUsuario.setLayout(new GridLayout(1,3));
        panelControlesUsuario.add(new JPanel());
        panelControlesUsuario.add(panelPlayPauseUsuario);
        panelControlesUsuario.add(panelSlider);
        
        //Terminamos la creacion del panel de abajo.
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new GridLayout(2,1));
        panelUsuario.add(panelControlesUsuario);
        panelUsuario.add(panelModos);
        panelUsuario.setBackground(Color.GRAY);
        
        //Anadimos el panel y empezamos con los valores iniciales.
        dp = new PanelDibujo();
        this.setLayout(new BorderLayout());
        this.add(dp,BorderLayout.CENTER);
        this.add(panelUsuario,BorderLayout.SOUTH);
        mUniforme.doClick();
        this.setVisible(true);
    }
    /**
     * Clase usada para el boton que pausa y comienza el programa.
     */
    private class BotonPlayPause extends JButton implements ActionListener{
        
        private boolean esPlay;
        
        /**
         * 
         * @param nom nombre inicial del boton.
         */
        public BotonPlayPause(String nom){
            super(nom);
            esPlay=true;
            this.addActionListener(this);
        }
        
        /**
         * Metodo ejecutado al clickear el boton.
         * @param e evento asociado al clickar el boton.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(esPlay){
                this.setText("Pause");
                esPlay=false;
                dp.playPause(true);
            }
            else{
                this.setText("Play");
                esPlay=true;
                dp.playPause(false);
            }
        }
        
    }
    
    /**
     * Clase usada para hacer el boton de reinicio.
     */
    private class BotonReinicio extends JButton implements ActionListener{

        /**
         * 
         * @param nom bombre del boton.
         */
        public BotonReinicio(String nom){
            super(nom);
            this.addActionListener(this);
        }
        
        /**
         * Metodo ejecutado al clickear el boton.
         * @param e evento asociado al clickar el boton.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            dp.reiniciar();
        }
        
    }
    
    
    /**
     * Botones para seleccionar el modo en el que opera el programa.
     */
    private class BotonModo extends JRadioButton implements ActionListener{
        
        private int modo;
        
        /**
         * Constructor del boton.
         * @param nom nombre del modo.
         * @param modo modo establecido por el boton:
         * 1 modo uniforme.
         * 2 modo aleatorio.
         * 3 modo solo usuario.
         * 4 modo sin desaparecer.
         */
        public BotonModo(String nom, int modo){
            super(nom);
            this.modo=modo;
            this.addActionListener(this);
        }

        /**
         * Metodo ejecutado al seleccionar el boton.
         * @param e evento asociado a la seleccion del boton.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            dp.cambiarModo(modo);
        }
        
    }
    
    /**
     * Slider para definir la velocidad escogida por el usuario.
     */
    private class Slider extends JSlider implements ChangeListener{
        
        /**
         * Contructor del slider.
         * @param min minimo valor.
         * @param max maximo valor.
         * @param val valor predeterminado.
         */
        public Slider(int min, int max, int val){
            super(min,max,val);
            this.addChangeListener(this);
            this.setPaintLabels(true);
        }

        /**
         * Metodo ejecutado cada vez que se cambia el valor del slider.
         * @param e evento asociado al cambio de estado del slider.
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            dp.cambiarTiempo(this.getValue());
        }
        
    }
    
}
