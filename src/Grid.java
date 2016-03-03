/**
 * Created by habib on 3/1/16.
 */

import java.util.*;

public class Grid {

    public class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
            int a = 8;
            Math.log(a);
        }
    }

    public List<List<Point>> findSameValueGrid(int[][] cells, int thresh) {
        if (cells == null) return null;
        if (cells.length == 0 || cells[0].length == 0) return null;

        boolean[][] visited = new boolean[cells.length][cells[0].length];

        List<List<Point>> finalRes = new ArrayList<>();


        for (int row = 0; row < cells.length; row++)
            for (int col = 0; col < cells[0].length; col++) {

                if (!visited[row][col]) {
                    int threshold = cells[row][col];
                    LinkedList<Point> stack = new LinkedList<>();
                    List<Point> res = new ArrayList<>();

                    stack.add(new Point(row, col));
                    visited[row][col] = true;

                    while (!stack.isEmpty()) {
                        Point current = stack.remove();
                        res.add(current);
                        if (current.row + 1 < cells.length && cells[current.row + 1][current.col] == threshold && !visited[current.row + 1][current.col]) {
                            stack.add(new Point(current.row + 1, current.col));
                            visited[current.row + 1][current.col] = true;
                        }
                        if (current.col + 1 < cells[0].length && cells[current.row][current.col + 1] == threshold && !visited[current.row][current.col + 1]) {
                            stack.add(new Point(current.row, current.col + 1));
                            visited[current.row][current.col + 1] = true;
                        }
                        if (current.col - 1 >= 0 && cells[current.row][current.col - 1] == threshold && !visited[current.row][current.col - 1]) {
                            stack.add(new Point(current.row, current.col - 1));
                            visited[current.row][current.col - 1] = true;
                        }
                    }
                    finalRes.add(res);
                }
            }
        return finalRes;
    }


    public static void main(String[] args) {
        int[][] cells = new int[][]{

                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
        };
        Grid grid = new Grid();

        List<List<Point>> finalRes = grid.findSameValueGrid(cells, 0);

        for (List<Point> list : finalRes) {
            for (Point p : list)
                System.out.print("(" + p.row + ", " + p.col + ") ");
            System.out.println();
        }
    }
}