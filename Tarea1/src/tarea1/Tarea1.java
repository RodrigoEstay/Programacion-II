
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

class Comprador{
    private Moneda mon[];
    private Expendedor maquina;
    private Bebida bebida;
    public Comprador(){
        
    }
    public String recibirMonedas(Moneda mon){
        
    }
    public String comprar(){
        
    }
    public String recibirVuelto(){
    
    }
    public String beber(){
        return bebida.beber();
    }
}

class Expendedor{
    private Moneda monCincuenta[];
    private Moneda monCien[];
    private Moneda monQuinientos[];
    private Bebida coca[];
    private Bebida sprite[];
    private Bebida pepsi[];
    private int ncincuenta;
    private int ncien;
    private int nquinientos;
    private int ncoca;
    private int nsprite;
    private int npepsi;
    public Expendedor(int ncoca, int nsprite, int npepsi){
        this.ncoca=ncoca;
        this.nsprite=nsprite;
        this.npepsi=npepsi;
        int i;
        coca = new Bebida[ncoca];
        for(i=0;i<ncoca;i=i+1){
            coca[i] = new CocaCola(i);
        }
        sprite = new Bebida[nsprite];
        for(i=0;i<nsprite;i=i+1){
            sprite[i] = new Sprite(i);
        }
        pepsi = new Bebida[npepsi];
        for(i=0;i<npepsi;i=i+1){
            pepsi[i] = new Pepsi(i);
        }
    }
    public Bebida comprarBebida(Moneda c, String t){
        if(t=="cocacola"){
            if(ncoca==0) return null;
            else{
                ncoca=ncoca-1;
                return coca[ncoca];
            }
        }
        else if(t=="sprite"){
            if(nsprite==0) return null;
            else{
                nsprite=nsprite-1;
                return sprite[nsprite];
            }
        }
        else if(t=="pepsi"){
            if(npepsi==0) return null;
            else{
                npepsi=npepsi-1;
                return sprite[npepsi];
            }
        }
        return null;
    }
    public void recibirMonedas(Moneda mon){
        
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
        String a="sabe a cocacola";
        return a;
    }
}

class Sprite extends Bebida{
    public Sprite(int a){
        super(a);
    }
    public String beber(){
        String a="sabe a sprite";
        return a;
    }
}

class Pepsi extends Bebida{
    public Pepsi(int serie){
        super(serie);
    }
    public String beber(){
        String a="sabe a pepsi";
        return a;
    }
}

abstract class Moneda{
    public Moneda(){
        
    }
    public abstract int obtenerValor();
}

class MCincuenta extends Moneda{
    public MCincuenta(){
    
    }
    public int obtenerValor(){
        return 50;
    }
}

class MCien extends Moneda{
    public MCien(){

    }
    public int obtenerValor(){
        return 100;
    }
}

class MQuinientos extends Moneda{
    public MQuinientos(){
    
    }
    public int obtenerValor(){
        return 500;
    }
}