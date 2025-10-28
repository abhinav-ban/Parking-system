/*okay so this file is now considered as empty becuase i will make the interface connection with it in the backend*/
package database;
import java.util.Scanner;
public class InterFaceConnector {
        public void Matrix(){
            Scanner scan = new Scanner(System.in);
            int[][] matrix = new int[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.println("ENTER THE VALUE->["+(i+1)+"]["+(j+1)+"]:");
                    matrix[i][j] = scan.nextInt();
                }
            }
            scan.close();
            System.out.println("The matrix is :");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(matrix[i][j]+"\t");
                }
                System.err.println();
            }
        }
        
    public static void main(String[] args){
        InterFaceConnector matrix = new InterFaceConnector();
        matrix.Matrix();
    }
    
}
