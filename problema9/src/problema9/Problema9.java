
package problema9;

public class Problema9 {
    public Problema9(){
        Promediador a = new Promediador();
    }
    public static void main(String[] args) {
        Problema9 b = new Problema9();
    }
    
}

class Promediador{
    private int s=0;
    private int n=0;
    public Promediador(){
    }
    public void agregaNumero(int x){
    s=s+x;
    n=n+1;
}
    public float promedio(){
        return (float)this.s/(float)this.n;
    }
    public int numero(){
        return this.n;
    }
}
