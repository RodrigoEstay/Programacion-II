
package problema21;


public class Problema21 {
    public Problema21(){
        
    }
    
    public static void main(String[] args) {
        Problema21 a = new Problema21();
        Moneda mon = new Moneda();
        Expendedor ex = new Expendedor(2);
        Bebida beb1 = ex.comprarBebida(mon, "cocacola");
        Bebida beb2 = ex.comprarBebida(mon, "sprite");
        Bebida beb3 = ex.comprarBebida(mon, "sprite");
        System.out.println(beb1.beber());
        System.out.println(beb2.beber());
        System.out.println(beb3.beber());
    }
    
}

class Expendedor{
    private Moneda m;
    private Bebida coca[];
    private Bebida sprite[];
    private int ncoca;
    private int nsprite;
    public Expendedor(int numero){
        ncoca=numero;
        nsprite=numero;
        int i;
        coca = new Bebida[numero];
        for(i=0;i<numero;i=i+1){
            coca[i] = new CocaCola(i);
        }
        sprite = new Bebida[numero];
        for(i=0;i<numero;i=i+1){
            sprite[i] = new Sprite(i);
        }
    }
    public Bebida comprarBebida(Moneda c, String t){
        if(t=="cocacola"){
            if(ncoca==0){
                return null;
            }
            else{
                ncoca=ncoca-1;
                return coca[ncoca];
            }
        }
        else if(t=="sprite"){
            if(nsprite==0){
                return null;
            }
            else{
                nsprite=nsprite-1;
                return sprite[nsprite];
            }
        }
        return null;
    }
}

abstract class Bebida{
    private int serie;
    public Bebida(int serie){
        this.serie=serie;
    }
    public abstract String beber();
}

class CocaCola extends Bebida{
    public CocaCola(int a){
        super(a);
    }
    public String beber(){
        String a="cocacola";
        return a;
    }
}

class Sprite extends Bebida{
    public Sprite(int a){
        super(a);
    }
    public String beber(){
        String a="sprite";
        return a;
    }
}

class Moneda{
    public Moneda(){
        
    }
}