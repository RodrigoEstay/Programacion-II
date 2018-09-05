package tarea1;


public class Tarea1 {
    public Tarea1(){
        
    }
    
    public static void main(String[] args) {
        Expendedor ex = new Expendedor(5,5,5);
        Comprador com = new Comprador(ex);
        int i;
        com.chequearMonedas();
        Moneda mon = new MQuinientos();
        com.recibirMonedas(mon);       
        System.out.println(com.beber());
        com.chequearMonedas();        
        com.comprar("pepsi");     
        com.chequearMonedas();
        com.recibirVuelto();
        System.out.println(com.beber());
        com.chequearMonedas();
        com.comprar("sprite");
        System.out.println(com.beber());
        com.chequearMonedas();
        com.recibirVuelto();
        com.chequearMonedas();
        Moneda m1 = new MCien();
        Moneda m2 = new MCien();
        Moneda m3 = new MQuinientos();
        
        com.recibirMonedas(m1);
        com.recibirMonedas(m2);
        com.recibirMonedas(m3);
        com.chequearMonedas();
        com.comprar("sprite");
        System.out.println(com.beber());
        com.chequearMonedas();
        com.recibirVuelto();
        com.chequearMonedas();
        com.comprar("cocacola");
        System.out.println(com.beber());
        com.chequearMonedas();
        com.recibirVuelto();
        com.chequearMonedas();
        
    }
    
}

//  Clase comprador, el cual interactua con Expendedor.
class Comprador{
    private Moneda monedas[];
    private Expendedor maquina;
    private Bebida bebida;
    private int nmon;
    
    //  En el constructor de comprador se crea un deposito interno de maximo 20
    // monedas, y se le hace conocer la maquina expendedora con la va a
    // interactuar.
    public Comprador(Expendedor ex){
        monedas = new Moneda[20];
        nmon=0;
        maquina = ex;
        bebida=null;
    }
    
    //  Metodo para recibir monedas y almacenarlas.
    public void recibirMonedas(Moneda mon){
        if(nmon==20) nmon=nmon-1;
        this.monedas[nmon]=mon;
        nmon=nmon+1;
    }
    
    //  Metodo para comprar bebidas a la maquina expendedora.
    //  Notar que la maquina expendedora retorna null si con las monedas
    // ingresadas no le alcanza para comprar una bebida, asi que el comprador
    // le da de sus monedas hasta que le alcanze o no le queden monedas.
    public void comprar(String beb){
        do{
            if(nmon==0) break;
            nmon=nmon-1;
            bebida=maquina.comprarBebida(monedas[nmon], beb);
        }while(bebida==null);
    }
    
    //  Metodo para recibir su vuelto de la maquina expendedora.
    public void recibirVuelto(){
        while(true){
            if(nmon==20) nmon=nmon-1;
            monedas[nmon]=maquina.vuelto();
            if(monedas[nmon]==null) break;
            nmon=nmon+1;
        }
    }
    
    //  Metodo que returna un string diciendo a que sabe la bebida.
    public String beber(){
        if(bebida==null) return null;
        return bebida.beber();
    }
    
    //  Metodo ocupado para saber cuantas y cuales monedas tiene el comprador
    // en su deposito interno.
    public void chequearMonedas(){
        int i;
        System.out.print("tengo "+nmon+" monedas: ");
        for(i=0;i<nmon;i=i+1){
            System.out.print(monedas[i].obtenerValor()+" ");
        }
        System.out.println();
    }
}

//  La clase expendedor tiene 2 objetos internos: un deposito de bebidas
// "deposito", un deposito de monedas "depositoMon".
class Expendedor{
    private DepositoBebidas depositoBeb;
    private DepositoMonedas depositoMon;
    private int valorTotal;
    
    //  Metodo constructor de Expendedor, se crean sus dos depositos.
    public Expendedor(int ncoca, int nsprite, int npepsi){
        depositoBeb = new DepositoBebidas(ncoca, nsprite, npepsi);
        depositoMon = new DepositoMonedas(50);
    }
    
    //  Metodo para comprar bebidas de la maquina expendedora, las cuales se
    // retiran de "deposito", y las monedas recibidas por Expendedor se mandan
    // al deposito de monedas "depositoMon".
    public Bebida comprarBebida(Moneda c, String t){
        valorTotal=valorTotal+c.obtenerValor();
        depositoMon.recibirMonedas(c);
        if(valorTotal<350) return null;
        valorTotal=valorTotal-350;
        if(t=="cocacola"){
            return depositoBeb.retirarBebida(1);
        }
        else if(t=="sprite"){
            return depositoBeb.retirarBebida(2);
        }
        else if(t=="pepsi"){
            return depositoBeb.retirarBebida(3);
        }
        return null;
    }
    
    //  Metodo para devolver el vuelto, este metodo retorna da a una moneda, es
    // decir, que para obtener todo el vuelto debe ser llamado hasta que retorne
    // null, cuendo lo hace significa que ya no queda vuelto para devolver o que
    // ya no hay monedas en el deposito de monedas de Expendedor.
    public Moneda vuelto(){
        if(valorTotal>=500 && depositoMon.obtenerCantidadMon(500)>0){
            valorTotal=valorTotal-500;
            return depositoMon.retirarMoneda(500);
        }
        else if(valorTotal>=100 && depositoMon.obtenerCantidadMon(100)>0){
            valorTotal=valorTotal-100;
            return depositoMon.retirarMoneda(100);
        }
        else if(valorTotal>=50 && depositoMon.obtenerCantidadMon(50)>0){
            valorTotal=valorTotal-50;
            return depositoMon.retirarMoneda(50);
        }
        return null;
    }
}

//  Clase que es un deposito de bebidas, usada para crear un objeto interno de
// Expendedor.
class DepositoBebidas{
    private Bebida coca[];
    private Bebida sprite[];
    private Bebida pepsi[];
    private int ncoca;
    private int nsprite;
    private int npepsi;
    
    //  Se generan las bebidas deseadas de cada una de las 3 marcas.
    public DepositoBebidas(int ncoca, int nsprite, int npepsi){
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
    
    //  Metodo para retirar bebidas desde este deposito.
    public Bebida retirarBebida(int marca){
        if(marca==1 && ncoca!=0){
            ncoca=ncoca-1;
            return coca[ncoca];
        }
        else if(marca==2 && nsprite!=0){
            nsprite=nsprite-1;
            return sprite[nsprite];
        }
        else if(marca==3 && npepsi!=0){
            npepsi=npepsi-1;
            return pepsi[npepsi];
        }
        return null;
    }
}

//  Deposito de monedas, clase usada por Expendedor para generar un objeto
// interno a este.
class DepositoMonedas{
    private Moneda monCincuenta[];
    private Moneda monCien[];
    private Moneda monQuinientos[];
    private int ncincuenta;
    private int ncien;
    private int nquinientos;
    
    //  El metodo constructor recibe la cantidad de monedas que se quieren crear
    // luego se generan la misma cantidad recibida de las 3 monedas. Notar que
    // existe un maximo de 130 monedas que puede almacenar.
    public DepositoMonedas(int nmon){
        monCincuenta = new MCincuenta[130];
        monCien = new MCien[130];
        monQuinientos = new MQuinientos[130];
        ncincuenta=nmon;
        ncien=nmon;
        nquinientos=nmon;
        int i;
        for(i=0;i<nmon;i=i+1){
            monCincuenta[i] = new MCincuenta();
            monCien[i] = new MCien();
            monQuinientos[i] = new MQuinientos();
        }
    }
    
    //  Metodo para retirar monedas de a una, recibe el valor deseado de la
    // moneda a retirar. Retorna null si ya no quedan monedas de ese valor o si
    // el valor ingresado es invalido.
    public Moneda retirarMoneda(int valor){
        if(valor==50 && ncincuenta>0){
            ncincuenta=ncincuenta-1;
            return monCincuenta[ncincuenta];
        }
        else if(valor==100 && ncien>0){
            ncien=ncien-1;
            return monCien[ncien];
        }
        else if(valor==500 && nquinientos>0){
            nquinientos=nquinientos-1;
            return monQuinientos[nquinientos];
        }
        return null;
    }
    
    //  Metodo que solamente retorna la cantidad de monedas restantes de cada
    // valor.
    public int obtenerCantidadMon(int valor){
        if(valor==50) return ncincuenta;
        else if(valor==100) return ncien;
        else if(valor==500) return nquinientos;
        return 0;
    }
    
    //  Metodo que recibe monedas para almacenarlas en su deposito interno, si
    // los depositos internos estan llenos, la moneda se pierde.
    public void recibirMonedas(Moneda mon){
        if(mon.obtenerValor()==50){
            if(ncincuenta==130) return;
            monCincuenta[ncincuenta]=mon;
            ncincuenta=ncincuenta+1;
        }
        else if(mon.obtenerValor()==100){
            if(ncien==130) return;
            monCien[ncien]=mon;
            ncien=ncien+1;
        }
        else if(mon.obtenerValor()==500){
            if(nquinientos==130) return;
            monQuinientos[nquinientos]=mon;
            nquinientos=nquinientos+1;
        }
    }
}

//  Clase abstracta de Bebidas, usada para generar distintas marcas de bebidas.
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

//  Clase abstracta de moneda, usada para generar monedas de distintos valores.
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