
package problema20;


public class Problema20 {
    public Problema20(){
        
    }
    
    public static void main(String[] args) {
        Problema20 a = new Problema20();
        Moneda mon = new Moneda();
        Expendedor ex = new Expendedor(2);
        Bebida beb1 = ex.comprarBebida(mon);
        Bebida beb2 = ex.comprarBebida(mon);
        Bebida beb3 = ex.comprarBebida(mon);
        System.out.println(beb1.beber());
        System.out.println(beb2.beber());
        System.out.println(beb3.beber());
    }
    
}

class Expendedor{
    private Moneda m;
    private Bebida deposito[];
    private int numero;
    public Expendedor(int numero){
        this.numero=numero;
        int i;
        deposito = new Bebida[numero];
        for(i=0;i<numero;i=i+1){
            deposito[i] = new Bebida(i);
        }
    }
    public Bebida comprarBebida(Moneda c){
        if(numero==0){
            return null;
        }
        else{
            numero=numero-1;
            return deposito[numero];
        }
    }
}

class Bebida{
    private int serie;
    public Bebida(int serie){
        this.serie=serie;
    }
    public String beber(){
        String a="gluglu";
        return a;
    }
}

class Moneda{
    public Moneda(){
        
    }
}