
package problema18;

public class Problema18 {
    public Problema18(){
        
    }
    public static void main(String[] args) {
        Panel p = new Panel(32,57,' ');
        Grafica g = new Grafica('x');
        p.setBorde('*');
        g.diagonalP(p,24,24,16);
        g.setCharLin('+');
        g.diagonalS(p,15,15,7);
        p.despliega();
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
        if(y>=fils || x>=cols){
            return;
        }
        visor[y][x]=c;
    }
    public char[][] getVisor(){
        return visor;
    }
}

class Grafica{
    private char charLin;
    public Grafica(char c){
        charLin=c;
    }
    public void diagonalP(Panel p, int x, int y, int n){
        int i;
        int j;
        for(i=0;i<n;i=i+1){
            p.setChar(x-i,y+i,charLin);
        }
    }
    public void diagonalS(Panel p, int x, int y, int n){
        int i;
        int j;
        for(i=0;i<n;i=i+1){
            p.setChar(x+i,y+i,charLin);
        }
    }
    public void setCharLin(char c){
        charLin=c;
    }
}