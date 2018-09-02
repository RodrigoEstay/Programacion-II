// TODO: cuando comprador tiene mas de 20 monedas.
//       cuando expendedor tiene mas de 50 monedas.
//       chequear que se recibe bien el vuelto.
//       chequear si se puede comprar con monedas de cien y 50.
package tarea1;


public class Tarea1 {
    public Tarea1(){
        
    }
    
    public static void main(String[] args) {
        Expendedor ex = new Expendedor(5,5,5);
        Comprador com = new Comprador(ex);
        int i;
        Moneda mon1[];
        Moneda mon2[];
        Moneda mon3[];
        mon1 = new Moneda[20];
        mon2 = new Moneda[20];
        mon3 = new Moneda[20];
        for(i=0;i<20;i=i+1){
            mon1[i] = new MCincuenta();
            mon2[i] = new MCien();
            mon3[i] = new MQuinientos();
            ex.recibirMonedas(mon1[i]);
            ex.recibirMonedas(mon2[i]);
            ex.recibirMonedas(mon3[i]);
        }
        Moneda mon = new MQuinientos();
        com.recibirMonedas(mon);
        com.comprar("pepsi");
        com.recibirVuelto();
        com.beber();
    }
    
}

class Comprador{
    private Moneda mon[];
    private Expendedor maquina;
    private Bebida bebida;
    private int nmon;
    public Comprador(Expendedor ex){
        mon = new Moneda[20];
        nmon=0;
        maquina = ex;
    }
    public void recibirMonedas(Moneda mon){
        this.mon[nmon]=mon;
        nmon=nmon+1;
    }
    public void comprar(String beb){
        do{
            nmon=nmon-1;
            bebida=maquina.comprarBebida(mon[nmon], beb);
            System.out.println("hola");
            System.out.println(bebida.beber());
        }while(bebida==null || nmon!=0);
    }
    public void recibirVuelto(){
        while(true){
            mon[nmon]=maquina.vuelto();
            if(mon[nmon]==null) break;
            nmon=nmon+1;
        }
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
    private int valorTotal;
    public Expendedor(int ncoca, int nsprite, int npepsi){
        monCincuenta = new MCincuenta[50];
        monCien = new MCien[50];
        monQuinientos = new MQuinientos[50];
        ncincuenta=0;
        ncien=0;
        nquinientos=0;
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
        valorTotal=valorTotal+c.obtenerValor();
        recibirMonedas(c);
        if(valorTotal<350) return null;
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
                return pepsi[npepsi];
            }
        }
        return null;
    }
    public void recibirMonedas(Moneda mon){
        if(mon.obtenerValor()==50){
            monCincuenta[ncincuenta]=mon;
            ncincuenta=ncincuenta+1;
        }
        else if(mon.obtenerValor()==100){
            monCien[ncien]=mon;
            ncien=ncien+1;
        }
        else if(mon.obtenerValor()==500){
            monQuinientos[nquinientos]=mon;
            nquinientos=nquinientos+1;
        }
    }
    public Moneda vuelto(){
        if(valorTotal>=500 && nquinientos>0){
            valorTotal=valorTotal-500;
            nquinientos=nquinientos-1;
            return monQuinientos[nquinientos];
        }
        else if(valorTotal>=100 && ncien>0){
            valorTotal=valorTotal-100;
            ncien=ncien-1;
            return monCien[ncien];
        }
        else if(valorTotal>=50 && ncincuenta>0){
            valorTotal=valorTotal-50;
            ncincuenta=ncincuenta-1;
            return monCincuenta[ncincuenta];
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