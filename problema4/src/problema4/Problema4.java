
package problema4;


public class Problema4 {

    
    public static void main(String[] args) {
        int R[]={3,2,1,5,7,3,0,10};
        int i;
        int mayor=R[0];
        for(i=1;i<R.length;i=i+1){
            if(mayor<R[i]) mayor=R[i];
        }
        System.out.println(mayor);
    }
    
}
