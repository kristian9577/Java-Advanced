import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] rowsCols=scan.nextLine().split("\\s+");
        int rows=Integer.parseInt(rowsCols[0]);
        int cols=Integer.parseInt(rowsCols[1]);

        int [][] firstMatrix=new int[rows][cols];

        for (int row = 0; row <rows ; row++) {
            String [] colData=scan.nextLine().split("\\s+");
            for (int col = 0; col <cols ; col++) {
                firstMatrix[row][col]=Integer.parseInt(colData[col]);
            }
        }

        rowsCols=scan.nextLine().split("\\s+");
         rows=Integer.parseInt(rowsCols[0]);
         cols=Integer.parseInt(rowsCols[1]);

        int [][] secondMatrix=new int[rows][cols];

        for (int row = 0; row <rows ; row++) {
            String [] colData=scan.nextLine().split("\\s+");
            for (int col = 0; col <cols ; col++) {
                secondMatrix[row][col]=Integer.parseInt(colData[col]);
            }
        }

        if(firstMatrix[0].length!=secondMatrix[0].length ||
        firstMatrix.length !=secondMatrix.length){
            System.out.println("not equal");
            return;
        }
        for (int row = 0; row <firstMatrix.length ; row++) {
            for (int col = 0; col <secondMatrix[0].length ; col++) {
                if(firstMatrix[row][col]!=secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }


}
