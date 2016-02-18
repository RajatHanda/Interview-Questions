/**
 * Created by habib on 2/13/16.
 */
public class Island{
    int[][] map;
    boolean[][] visited;
    int maxRow, maxCol;

    public Island(int [][] map){
        this.map = map;
        maxRow = map.length - 1;
        maxCol = map[0].length - 1;
        visited = new boolean[maxRow + 1][maxCol + 1];
    }

    public int landCount(){
        int count = 0;

        for(int i = 0; i <= maxRow; i++ )
            for(int j = 0; j <= maxCol; j++ ){
                if(map[i][j] == 1 && !visited[i][j]){
                    runDFS(i, j);
                    count++;
                }
            }

        return count;
    }


    public void runDFS(int i, int j){
        if (i < 0 || j < 0 || i > maxRow || j > maxCol) return;

        if(!visited[i][j] && map[i][j] == 1) {
            visited[i][j] = true;
            runDFS(i - 1, j);
            runDFS(i , j + 1);
            runDFS(i + 1, j);
            runDFS(i , j + 1);
        }
    }
}