
package problema17;

public class Problema17 {
    public Problema17(){
        Panel a = new Panel(5,4,'a');
        a.despliega();
        a.setBorde('b');
        a.despliega();
        a.setChar(1,2,'c');
        a.despliega();
    }
    public static void main(String[] args) {
        Problema17 a = new Problema17();
    }
    
}

class Panel{
    private int fils;
    private int cols;
    private char visor[][];
    private char charfond;
    public Panel(int filas, int columnas, char caracter){
        fils=filas;
        cols=columnas;
        charfond=caracter;
        visor = new char[fils][cols];
        int i;
        int j;
        for(i=0;i<fils;i=i+1){
            for(j=0;j<cols;j=j+1){
                visor[i][j]=charfond;
            }
        }
    }
    public void despliega(){
        int i;
        int j;
        for(i=0;i<fils;i=i+1){
            for(j=0;j<cols;j=j+1){
                System.out.print(visor[i][j]);
            }
            System.out.println();
        }
    }
    public void setBorde(char c){
        int i;
        for(i=0;i<fils;i=i+1){
            visor[i][0]=c;
            visor[i][cols-1]=c;
        }
        for(i=0;i<cols;i=i+1){
            visor[0][i]=c;
            visor[fils-1][i]=c;
        }
    }
    public void setChar(int x, int y, char c){
        visor[y][x]=c;
    }
    public char[][] getVisor(){
        return visor;
    }
}
