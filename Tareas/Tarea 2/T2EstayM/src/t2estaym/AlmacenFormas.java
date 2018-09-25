
package t2estaym;

import java.util.ArrayList;
import java.awt.Graphics;


public class AlmacenFormas {
    
    ArrayList lista;
    
    public AlmacenFormas(){
         lista = new ArrayList();
    }
    
    public void agregarForma(Forma f){
        lista.add(f);
    }
    
    public void dibujarFormas(Graphics g){
        Forma aux=null;
        for( int i=0 ; i<lista.size() ; i++){
            aux=(Forma)lista.get(i);
            aux.paint(g);
        }
    }
    
    public void eliminarForma(int x, int y){
        Forma aux=null;
        for( int i=lista.size()-1 ; i>=0 ; i--){
            aux=(Forma)lista.get(i);
            if(aux.estaDentro(x, y)){ 
                lista.remove(i);
                break;
            }
        }
    }
    
}
