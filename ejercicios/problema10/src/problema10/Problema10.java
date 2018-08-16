
package problema10;

public class Problema10 {
    public Problema10(){
    Persona a = new Persona("hola", true);
    
}
    public static void main(String[] args) {
        Problema10 b = new Problema10();
    }
    
}

class Persona{
    private String nombre;
    private boolean estado;
    public Persona(String n, boolean e){
        nombre=n;
        estado=e;
    }
    public boolean esCasado(){
        return estado;
    }
    public String elNombre(){
        return nombre;
    }
}
