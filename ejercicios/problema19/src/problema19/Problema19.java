
package problema19;


public class Problema19 {
    public Problema19(){
        Moneda mon = new Moneda();
        Expendedor ex = new Expendedor();
        Bebida beb = ex.comprarBebida(mon);
        System.out.println(beb.beber());
    }
    
    public static void main(String[] args) {
        Problema19 a = new Problema19();
    }
    
}

class Expendedor{
    public Expendedor(){
        
    }
    public Bebida comprarBebida(Moneda c){
        Bebida beb= new Bebida();
        return beb;
    }
}

class Bebida{
    public Bebida(){
        
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