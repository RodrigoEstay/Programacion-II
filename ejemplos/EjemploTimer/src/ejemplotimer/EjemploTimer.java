
package ejemplotimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EjemploTimer {

    public static void main(String[] args) {
        new A();
        while(true);
    }
    
}

class A implements ActionListener{
    
    int i;
    private Timer t;
    
    public A(){
        i=11;
        t = new Timer(1000,null);
        t.addActionListener(this);
        t.start();
        
    }
    
    public void actionPerformed(ActionEvent ae){
        i--;
        System.out.println(i);
        if(i==0) System.exit(0);
    }
    
}
