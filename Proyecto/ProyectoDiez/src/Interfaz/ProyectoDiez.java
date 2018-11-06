
package Interfaz;

import Interfaz.Manejador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ProyectoDiez extends JFrame{
    
    private BotonesControles bCrearH;
    private BotonesControles bCrearV;
    private SlideVelocidad velSlider;
    private Manejador manejador;
    
    public static void main(String[] args) {
        ProyectoDiez a = new ProyectoDiez();
    }
    
    public ProyectoDiez(){
        this.setSize(900,700);
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
        SlideVelocidad velSlider = new SlideVelocidad(0,100,0);
        this.bCrearH=bCrearH;
        this.bCrearV=bCrearV;
        this.velSlider=velSlider;
        JPanel panelEditar = new JPanel();
        panelEditar.add(bCrearH);
        panelEditar.add(bCrearV);
        JPanel panelSlider = new JPanel();
        panelSlider.add(velSlider);
        JPanel panelPlayPauseUsuario = new JPanel();
        panelPlayPauseUsuario.add(bPlayPause);
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
        manejador = new Manejador(1);
        this.setLayout(new BorderLayout());
        this.add(manejador,BorderLayout.CENTER);
        this.add(panelUsuario,BorderLayout.SOUTH);
        mUniforme.doClick();
        this.setVisible(true);
    }
    
    private class BotonesControles extends JButton implements ActionListener{
        
        private int tipoControl;
        
        public BotonesControles(String nom, int tipo){
            super(nom);
            tipoControl=tipo;
            this.addActionListener(this);
        }

        //Debera definir la creacion de pelotas o sera un boton play.
        @Override
        public void actionPerformed(ActionEvent e) {
            if(tipoControl==1 || tipoControl==0) playPause();
            if(tipoControl==2) manejador.cambiarModo(3);
            if(tipoControl==3) manejador.cambiarModo(4);
        }
        
        //Empezara la simulacion o la detiene.
        public void playPause(){
            if(tipoControl==1){
                this.setText("Pause");
                tipoControl=0;
                manejador.playPause(true);
            }
            else{
                this.setText("Play");
                tipoControl=1;
                manejador.playPause(false);
            }
        }
        
    }
    
    private class BotonModo extends JRadioButton implements ActionListener{
        
        private int modo;
        
        public BotonModo(String nom, int modo){
            super(nom);
            this.modo=modo;
            this.addActionListener(this);
        }

        //Cambiara entre los modos posibles.
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
            manejador.cambiarModo(modo);
        }
        
    }
    
    private class SlideVelocidad extends JSlider implements ChangeListener{
        
        public SlideVelocidad(int min, int max, int val){
            super(min,max,val);
            this.addChangeListener(this);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            manejador.cambiarVelocidad(this.getValue());
        }
        
    }
    
}
