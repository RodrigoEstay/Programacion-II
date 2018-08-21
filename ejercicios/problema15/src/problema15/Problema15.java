package problema15;

public class Problema15 {
    public Problema15(){
        CuatroOperaciones a = new CuatroOperaciones((float)10.2, (float)5.13);
        System.out.println(a.suma());
        System.out.println(a.resta());
        System.out.println(a.divide());
        System.out.println(a.multiplica());
    }
    public static void main(String[] args) {
        Problema15 a = new Problema15();
    }
    
}

class SumaResta{
    protected float uno;
    protected float dos;
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

class CuatroOperaciones extends SumaResta{
    public CuatroOperaciones(float f1, float f2){
        super(f1, f2);
    }
    public float multiplica(){
        return uno*dos;
    }
    public float divide(){
        return uno/dos;
    }
}