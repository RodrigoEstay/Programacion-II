
package problema8;

public class Problema8 {
    public Problema8(){
        OtraClase a = new OtraClase(10);
        System.out.println(a.sacaDato());
    }
    public static void main(String[] args) {
        Problema8 b = new Problema8();
    }
}

class OtraClase{
    private int x;
    public OtraClase(int x){
    this.x=x;
}
    public int sacaDato(){
        return x;
    }
}
