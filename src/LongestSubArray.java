/**
 * Created by habib on 2/15/16.
 */
import java.util.*;

public class LongestSubArray {

    int[][] matrix;
    int maxRow, maxCol;
    boolean[][] visited;
    Set<Integer> included = new HashSet<>();
    LinkedList<Integer> maxPath;
    int maxPathLength = 0;
    public LongestSubArray(int[][] matrix) {
        this.matrix = matrix;
        maxRow = matrix.length - 1;
        maxCol = matrix[0].length - 1;
    }

    public List<Integer> findLongestSubArray() {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                items.add(new Item(i, j, matrix[i][j]));

        Collections.sort(items);

        for (Item item : items) {
            if (!included.contains(item.val)) {
                visited = new boolean[maxRow + 1][maxCol + 1];
                visited[item.row][item.col] = true;
                findLongestPath(item);
            }
        }
        return maxPath;
    }

    public void findLongestPath(Item item) {

        LinkedList<Item> stack = new LinkedList<>();
        stack.addLast(item);
        Item currentItem;

        while (!stack.isEmpty()) {
            currentItem = stack.getLast();


            int minRow = -1, minCol = -1, minNeighbor = Integer.MAX_VALUE;

            if (currentItem.row + 1 <= maxRow && !visited[currentItem.row + 1][currentItem.col] &&
                    minNeighbor > matrix[currentItem.row + 1][currentItem.col] &&
                    matrix[currentItem.row + 1][currentItem.col] > matrix[currentItem.row][currentItem.col]) {
                minNeighbor = matrix[currentItem.row + 1][currentItem.col];
                minRow = currentItem.row + 1;
                minCol = currentItem.col;
            }

            if (currentItem.row - 1 >= 0 && !visited[currentItem.row - 1][currentItem.col] &&
                    minNeighbor > matrix[currentItem.row - 1][currentItem.col] &&
                    matrix[currentItem.row - 1][currentItem.col] > matrix[currentItem.row][currentItem.col]) {
                minNeighbor = matrix[currentItem.row - 1][currentItem.col];
                minRow = currentItem.row - 1;
                minCol = currentItem.col;
            }

            if (currentItem.col + 1 <= maxCol && !visited[currentItem.row][currentItem.col + 1] &&
                    minNeighbor > matrix[currentItem.row][currentItem.col + 1] &&
                    matrix[currentItem.row][currentItem.col + 1] > matrix[currentItem.row][currentItem.col]) {
                minNeighbor = matrix[currentItem.row][currentItem.col + 1];
                minRow = currentItem.row;
                minCol = currentItem.col + 1;
            }

            if (currentItem.col - 1 >= 0 && !visited[currentItem.row][currentItem.col - 1] &&
                    minNeighbor > matrix[currentItem.row][currentItem.col - 1] &&
                    matrix[currentItem.row][currentItem.col - 1] > matrix[currentItem.row][currentItem.col]) {
                minNeighbor = matrix[currentItem.row][currentItem.col - 1];
                minRow = currentItem.row;
                minCol = currentItem.col - 1;
            }


            if (minNeighbor < Integer.MAX_VALUE) {
                stack.addLast(new Item(minRow, minCol, minNeighbor));
                visited[minRow][minCol] = true;
            } else {
                if (maxPathLength < stack.size()) {
                    maxPath = new LinkedList<>();
                    for (Item tempItem : stack) {
                        maxPath.add(tempItem.val);
                        included.add(tempItem.val);
                    }
                    maxPathLength = maxPath.size();
                }
                stack.removeLast();
            }
        }
    }
}
