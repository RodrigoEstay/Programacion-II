
package problema12;

public class Problema12 {
    public Problema12(){
    Doble a = new Doble(1,2);
    }
    public static void main(String[] args) {
        Problema12 b = new Problema12();
    }
    
}

class Doble{
    private int x;
    private int y;
    public Doble(int a, int b){
        x=a;
        y=b;
    }
    public void intercambia(){
        int temp=x;
        x=y;
        y=temp;
    }
    public int sacaX(){
        return x;
    }
    public int sacaY(){
        return y;
    }
}