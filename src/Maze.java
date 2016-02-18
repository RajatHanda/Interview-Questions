/**
 * Created by habib on 2/14/16.
 */
public class Maze{
    boolean found = false;
    int col, row, resRow, resCol = -1, maxRow = -1, maxCol;

    int[][] maze;
    boolean [][] visited;

    public Maze(int [][] maze, int row, int col){
        this.maze = maze;
        this.row = row;
        this.col = col;
        maxRow = maze.length - 1;
        maxCol = maze[0].length - 1;
        this.visited = new boolean[maxRow + 1][maxCol + 1];

    }

    public void findThePath() {
        findThePath(row, col);
    }


        public void findThePath(int currentRow, int currentCol){

        if(currentRow < 0 || currentRow > maxRow || currentCol < 0 || currentCol > maxCol ||
                visited[currentRow][currentCol] || maze[currentRow][currentCol] == 1)
            return;

        if (maze[currentRow][currentCol] == 0 &&
                (currentRow == 0 || currentRow == maxRow || currentCol == 0 || currentCol == maxCol) &&
                !(currentRow == row && currentCol == col)){
            visited[currentRow][currentCol] = true;
            found = true;
            resRow = currentRow;
            resCol = currentCol;
        }
        else {
            visited[currentRow][currentCol] = true;
            if(!found) findThePath(currentRow, currentCol + 1);
            if(!found) findThePath(currentRow + 1, currentCol);
            if(!found) findThePath(currentRow, currentCol -1);
            if(!found) findThePath(currentRow - 1, currentCol);
        }
    }
}
