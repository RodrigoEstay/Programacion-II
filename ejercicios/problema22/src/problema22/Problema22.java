
package problema22;


public class Problema22 {
    public Problema22(){
        
    }
    public static void main(String[] args) {
        Geometrica rect = new Rectangulo(1.0f,1.0f);
        Geometrica tri = new Triangulo(1.0f,1.0f);
        System.out.println(rect.area());
        System.out.println(tri.area());
        System.out.println(rect.perimetro());
        System.out.println(tri.perimetro());
    }
    
}

abstract class Geometrica{
    protected float ancho;
    protected float alto;
    public Geometrica(float an, float al){
        ancho=(float)an;
        alto=(float)al;
    }
    public abstract float area();
    public abstract float perimetro();
}

class Triangulo extends Geometrica{
    public Triangulo(float an, float al){
        super(an, al);
    }
    public float area(){
        return (ancho*alto)/2;
    }
    public float perimetro(){
        return ancho+alto+(float)Math.sqrt(alto*alto+ancho*ancho);
    }
}

class Rectangulo extends Geometrica{
    public Rectangulo(float an, float al){
        super(an, al);
    }
    public float area(){
        return (ancho*alto);
    }
    public float perimetro(){
        return ancho*2+alto*2;
    }
}