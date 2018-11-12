

// Ejecucuon atomica, es un metodo que no puede interrumpirse.
// eso se soluciona con synchronize.
// Es decir:
// sin synchronize: se crean distintas hebras para el metodo (se ejecutan varios metodos en simultaneo)
// con synchronize: es una hebra dedicada al metodo. (un metodo ejecutado a la vez)

package seccioncritica;


public class CuentaHojas {
    
    int hojas;
    
    public CuentaHojas(){
        hojas=0;
    }
    
    public synchronized void imprimirHoja(boolean lento){
        int aux = hojas;
        aux++;
        if(lento){
            try{
                Thread.sleep(8000);
            }
            catch(Exception e){
                
            }
        }
        hojas=aux;
    }
    
    public void cuantasHojas(){
        System.out.println("BBBBBBBBBB " + hojas);
    }
    
}
