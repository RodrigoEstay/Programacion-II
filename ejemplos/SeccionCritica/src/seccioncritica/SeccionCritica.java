
package seccioncritica;

import javax.swing.JFrame;

public class SeccionCritica extends JFrame{

    public static void main(String[] args) {
        MiHebra uno = new MiHebra("uno");
        uno.start();
        MiHebra dos = new MiHebra("dos");
        dos.start();
        while(true){
            System.out.println("hebra: main");
        }
        /*
        int x=0;
        CuentaHojas ch = new CuentaHojas();
        Ventana v = new Ventana(ch);
        while(true){
            System.out.println(x++);
            ch.imprimirHoja(true);
            ch.cuantasHojas();
        }
*/
    }
    
    public SeccionCritica(){
        
    }
    
}
