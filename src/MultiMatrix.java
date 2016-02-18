/**
 * Created by habib on 2/8/16.
 */
public class MultiMatrix{
    public int [][] matrix;
    public int [][] indexPoints;
    public String multiPoints = "";

    public MultiMatrix(int n){
        matrix = new int[n][n];
        indexPoints = new int[n][n];

        for(int i=0; i < n; i++)
            for(int j=0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                indexPoints[i][j] = -1;
            }


                for(int i=0; i < n; i++) {
                    matrix[i][i] = 0;
                    indexPoints[i][i] = i;
                }



    }
}