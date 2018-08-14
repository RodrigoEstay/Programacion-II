
package problema6;


public class Problema6 {

    static int R[]={3,2,1,5,7,3,0,10,5};
    public static void main(String[] args) {
        int temp;
        int i;
        for(i=R.length - 1;i>=R.length/2;i=i-1){
            temp=R[i];
            R[i]=R[R.length - i - 1];
            R[R.length - i - 1]=temp;
        }
        for(i=0;i<R.length;i=i+1){
            if(i!=R.length-1) System.out.print(R[i] + ",");
            else System.out.println(R[i]);
        }
    }
    
}
