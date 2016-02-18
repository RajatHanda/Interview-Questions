import java.util.*;

/**
 * Created by habib on 2/13/16.
 */
public class Island2{
    int[][] map;
    boolean[][] visited;
    int maxRow, maxCol;

    public Island2(int [][] map){
        this.map = map;
        maxRow = map.length - 1;
        maxCol = map[0].length - 1;
        visited = new boolean[maxRow + 1][maxCol + 1];
    }

    public int landCount(){
        int count = 0;
        Set<int[]> points;


        for(int i = 0; i <= maxRow; i++ )
            for(int j = 0; j <= maxCol; j++ ){
                if(map[i][j] == 1 && !visited[i][j]){
                    points = new HashSet<>();
                    runDFS(i, j, points);
                    count++;
                    if(points.size() >= 4){
                        System.out.print(count + " : ");
                        for(int[] point : points)
                            System.out.print("(" + point[0] + ", " + point[1] + ")");

                        System.out.println();
                    }
                }
            }

        return count;
    }


    public void runDFS(int i, int j, Set<int[]> points){
        if (i < 0 || j < 0 || i > maxRow || j > maxCol) return;

        if(!visited[i][j] && map[i][j] == 1) {
            visited[i][j] = true;
            points.add(new int[]{i, j});

            runDFS(i - 1, j, points);
            runDFS(i , j + 1, points);
            runDFS(i + 1, j, points);
            runDFS(i , j + 1, points);

            runDFS(i - 1, j - 1, points);
            runDFS(i + 1, j - 1, points);
            runDFS(i - 1, j + 1, points);
            runDFS(i + 1, j - 1, points);


        }
    }
}