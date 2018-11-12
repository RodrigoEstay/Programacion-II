
package seccioncritica;


public class MiHebra extends Thread implements Runnable {
    private String s;
    
    public MiHebra(String s){
        this.s=s;
    }
    
    public void run(){
        while(true){
            System.out.println("hebra: "+s);
        }
    }
    
    
}
