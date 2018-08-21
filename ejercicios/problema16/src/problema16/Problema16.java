package problema16;

public class Problema16 {
    public Problema16(){
        CuatroOperaciones a = new CuatroOperaciones((float)10.2, (float)5.13);
        System.out.println(a.suma());
        System.out.println(a.resta());
        System.out.println(a.divide());
        System.out.println(a.multiplica());
    }
    public static void main(String[] args) {
        Problema16 a = new Problema16();
    }
    
}

class CuatroOperaciones{
    SumaResta interna;
    public CuatroOperaciones(float f1, float f2){
        interna = new SumaResta(f1,f2);
    }
    public float suma(){
        return interna.suma(); 
    }
    public float resta(){
        return interna.resta(); 
    }
    public float multiplica(){
        return interna.getUno()*interna.getDos();
    }
    public float divide(){
        return interna.getUno()/interna.getDos();
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
