import java.util.Arrays;

/**
 * Created by habib on 2/27/16.
 */
public class Color{
    public void paintFill(int[][] pic, int row, int col, int origColor, int fillingColor){
        if(row < 0 || row >= pic.length || col < 0 || col >= pic[0].length) return;

        if(origColor != pic[row][col]) return;
        pic[row][col] = fillingColor;

        paintFill(pic, row - 1, col, origColor, fillingColor);
        paintFill(pic, row + 1, col, origColor, fillingColor);
        paintFill(pic, row , col - 1, origColor, fillingColor);
        paintFill(pic, row , col + 1, origColor, fillingColor);
    }

    public static void main(String [] args){
        int[][] pic = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0}
        };
        Color col = new Color();
        col.paintFill(pic, 2, 1, 0, 3);

        for(int[] row : pic)
            System.out.println(Arrays.toString(row));
    }
}