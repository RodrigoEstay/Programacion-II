
package problema11;


public class Problema11 {
    
    public Problema11(){

    }
    public static void main(String[] args) {
        Directa a = new Directa(9);
        System.out.println(a.getX());
    }
    
}

class Directa{
    private Indirecta a;
    public Directa(int x){
        a = new Indirecta(x);
    }
    public int getX(){
        return a.getX();
    }
}

class Indirecta{
    private int x;
    public Indirecta(int y){
        x=y;
    }
    public int getX(){
        return x;
    }
}
