
package t2estaym;

import java.util.ArrayList;
import java.awt.Graphics;


public class AlmacenFormas {
    
    private ArrayList lista;
    
    // Se crea la lista de formas.
    public AlmacenFormas(){
         lista = new ArrayList();
    }
    
    // Se agrega una forma a la lista.
    public void agregarForma(Forma f){
        lista.add(f);
    }
    
    // Se recorre la lista para dibujar todas las formas.
    public void dibujarFormas(Graphics g){
        Forma aux=null;
        for( int i=0 ; i<lista.size() ; i++){
            aux=(Forma)lista.get(i);
            aux.paint(g);
        }
    }
    
    // Se busca la forma que se le hizo click y se elimina.
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
    
    // Se busca la forma que se le hizo click y se selecciona.
    public int seleccionarForma(int x, int y){
        Forma aux=null;
        for(int i=lista.size()-1 ; i>=0 ; i--){
            aux=(Forma)lista.get(i);
            if(aux.estaDentro(x, y)){
                return i;
            }
        }
        return -1;
    }
    
    // Se mueve la forma seleccionada a donde se hizo click.
    public void moverForma(int x, int y, int pos){
        Forma aux=null;
        aux=(Forma)lista.get(pos);
        aux.setXY(x, y);
    }
    
}
