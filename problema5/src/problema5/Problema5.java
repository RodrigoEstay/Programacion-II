
package problema5;


public class Problema5 {

    static int b[]={3,2,1,5,7,3,0,10,5};
    public static void main(String[] args) {
        int i;
        int sum=0;
        for(i=0;i<b.length;i=i+1){
            sum=sum+b[i];
        }
        float f=(float)sum/(float)b.length;
        System.out.println(f);
    }
    
}
