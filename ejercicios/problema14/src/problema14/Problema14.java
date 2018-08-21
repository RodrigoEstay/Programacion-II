package problema14;

public class Problema14 {
    public Problema14(){
        CuatroOperaciones a = new CuatroOperaciones((float)10.2, (float)5.13);
        System.out.println(a.suma());
        System.out.println(a.resta());
        System.out.println(a.divide());
        System.out.println(a.multiplica());
    }
    public static void main(String[] args) {
        Problema14 a = new Problema14();
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
    public float getUno(){
        return uno;
    }
    public float getDos(){
        return dos;
    }
}

class CuatroOperaciones extends SumaResta{
    public CuatroOperaciones(float f1, float f2){
        super(f1, f2);
    }
    public float multiplica(){
        return super.getUno()*super.getDos();
    }
    public float divide(){
        return super.getUno()/super.getDos();
    }
}