
package problema3;

public class Problema3 {

    public static void main(String[] args) {
        int i;
        int sum=0;
        int cont=0;
        for(i=0;cont<100;i=i+1){
            if(i%2!=0){
                cont=cont+1;
                sum=sum+i;
            }
        }
        System.out.println("La suma es: " + sum);
    }
    
}
