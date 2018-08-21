package problema13;

public class Problema13 {
    public Problema13(){
        SumaResta a = new SumaResta((float)10.2, (float)5.13);
        System.out.println(a.suma());
        System.out.println(a.resta());
    }
    public static void main(String[] args) {
        Problema13 a = new Problema13();
    }
    
}

class SumaResta{
    private float uno;
    private float dos;
    public SumaResta(float f1, float f2){
        uno=f1;
        dos=f2;
    }
    public float suma(){
        return uno+dos;
    }
    public float resta(){
        return uno-dos;
    }
}