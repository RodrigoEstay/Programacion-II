
package fiestaspatrias;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
    PanelDibujo dp;
    Bandera s;
    public Ventana(){
        this.setLayout(new BorderLayout());
        s = new Bandera();
        this.add(s,BorderLayout.CENTER);
        //dp = new PanelDibujo();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//cerrar aplicación
        //this.add(dp,BorderLayout.CENTER);//se agrega al centro
        this.add(new JButton("boton"),BorderLayout.NORTH);
        JPanel jp = new JPanel();
        this.add(jp, BorderLayout.SOUTH);
        jp.add(new JButton("oof"));
        jp.add(new JButton("oofies"));
        this.setSize(1280,720);//this.pack();
        this.setVisible(true);
    }
}

// JFrame es una venrtana, no puede haber un Jframe dentro de otro.
// JPanel es un panel, puede estar dentro de otro panel.
