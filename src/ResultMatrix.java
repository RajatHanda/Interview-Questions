/**
 * Created by habib on 2/8/16.
 */
public class ResultMatrix {

    public String[][] dir;
    public int [][] weight;
    public String subStringResult = "";

    public ResultMatrix(String str1, String str2){
        dir = new String[str2.length() + 1][str1.length() + 1];
        weight = new int[str2.length() + 1][str1.length() + 1];

        for(int i = 1; i < str2.length() + 1; i++)
            for(int j = 1; j < str1.length() + 1; j++)
                weight[i][j] = -1;

        dir[0][0] = "D";
        for(int i = 1; i < str2.length() + 1; i++)
            dir[i][0] = "U";

        for(int i= 1; i < str1.length() + 1; i++)
            dir[0][i] = "L";

    }
}
