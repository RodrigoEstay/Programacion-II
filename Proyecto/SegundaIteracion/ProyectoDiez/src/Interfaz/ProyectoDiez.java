
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
    
    private BotonesControles bCrearH;
    private BotonesControles bCrearV;
    private Slider velSlider;
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
        BotonModo mUsuario = new BotonModo("Definir Posiciones", 3);
        ButtonGroup modos = new ButtonGroup();
        modos.add(mUniforme);
        modos.add(mAleatorio);
        modos.add(mUsuario);
        JPanel panelModos = new JPanel();
        panelModos.add(mUniforme);
        panelModos.add(mAleatorio);
        panelModos.add(mUsuario);
        
        //Creamos Panel de Controles.
        BotonesControles bPlayPause = new BotonesControles("Play",1);
        BotonesControles bCrearH = new BotonesControles("Crear Horizontal",2);
        BotonesControles bCrearV = new BotonesControles("Crear Vertical",3);
        BotonesControles bReset = new BotonesControles("Reset", 4);
        
        Slider velSlider = new Slider(0,100,0,0);
        Slider tiempSlider = new Slider(0,50,25,1);
        Hashtable<Integer, JLabel> tablaVel = new Hashtable<Integer, JLabel>();
        tablaVel.put(0, new JLabel("Rand"));
        tablaVel.put(25, new JLabel("25"));
        tablaVel.put(50, new JLabel("50"));
        tablaVel.put(75, new JLabel("75"));
        tablaVel.put(100, new JLabel("100"));
        velSlider.setLabelTable(tablaVel);
        Hashtable<Integer, JLabel> tablaTiempo = new Hashtable<Integer, JLabel>();
        tablaTiempo.put(0, new JLabel("Lento"));
        tablaTiempo.put(50, new JLabel("Rapido"));
        tiempSlider.setLabelTable(tablaTiempo);
        
        this.bCrearH=bCrearH;
        this.bCrearV=bCrearV;
        this.velSlider=velSlider;
        JPanel panelEditar = new JPanel();
        panelEditar.add(bCrearH);
        panelEditar.add(bCrearV);
        JPanel panelSlider = new JPanel();
        panelSlider.add(velSlider);
        panelSlider.add(tiempSlider);
        JPanel panelPlayPauseUsuario = new JPanel();
        panelPlayPauseUsuario.add(bPlayPause);
        panelPlayPauseUsuario.add(bReset);
        JPanel panelControlesUsuario = new JPanel();
        panelControlesUsuario.setLayout(new GridLayout(1,3));
        panelControlesUsuario.add(panelEditar);
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
     * Esta clase define botones para distintas funciones, actualmente, puede
     * ser un boton para play, pause y definir direcciones. 
     */
    private class BotonesControles extends JButton implements ActionListener{
        
        private int tipoControl;
        
        /**
         * Constructor del boton.
         * @param nom nombre del boton.
         * @param tipo tipo de control que sera el boton:
         * 0 es pause.
         * 1 es play.
         * 2 es para crear figuras horizontales.
         * 3 es para crear figuras verticales.
         * 4 es un boton para reiniciar el programa.
         */
        public BotonesControles(String nom, int tipo){
            super(nom);
            tipoControl=tipo;
            this.addActionListener(this);
        }

        /**
         * Metodo ejecutado al apretar el boton.
         * @param e Evento asociado a presionar el boton.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(tipoControl==1 || tipoControl==0) playPause();
            else if(tipoControl==2) dp.cambiarDir(true);
            else if(tipoControl==3) dp.cambiarDir(false);
            else if(tipoControl==4) dp.reiniciar();
        }
        
        /**
         * Metodo privado para cuando se presione un boton de play o pause
         * cambie a pause o play respectivamente y ejecute su funcion.
         */
        private void playPause(){
            if(tipoControl==1){
                this.setText("Pause");
                tipoControl=0;
                dp.playPause(true);
            }
            else{
                this.setText("Play");
                tipoControl=1;
                dp.playPause(false);
            }
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
         * 3 modo definido por el usuario.
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
            if(modo==1 || modo==2){
                bCrearH.setEnabled(false);
                bCrearV.setEnabled(false);
                velSlider.setEnabled(false);
            }
            else if(modo==3){
                bCrearH.setEnabled(true);
                bCrearV.setEnabled(true);
                velSlider.setEnabled(true);
            }
            dp.cambiarModo(modo);
        }
        
    }
    
    /**
     * Slider para definir la velocidad escogida por el usuario.
     */
    private class Slider extends JSlider implements ChangeListener{
        
        int tipo;
        
        /**
         * Contructor del slider.
         * @param min minimo valor.
         * @param max maximo valor.
         * @param val valor predeterminado.
         */
        public Slider(int min, int max, int val, int tipoSlider){
            super(min,max,val);
            this.addChangeListener(this);
            tipo=tipoSlider;
            this.setPaintLabels(true);
        }

        /**
         * Metodo ejecutado cada vez que se cambia el valor del slider.
         * @param e evento asociado al cambio de estado del slider.
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            if(tipo==0) dp.cambiarVel(this.getValue());
            else if(tipo==1) dp.cambiarTiempo(this.getValue());
        }
        
    }
    
}
