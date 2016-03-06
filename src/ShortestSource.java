import java.util.*;

/**
 * Created by habib on 3/6/16.
 */

public class ShortestSource {

    private class Node {
        public int row, col, distance;

        public Node() {

        }

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        public boolean equals(Object o) {
            return (o instanceof Node &&
                    row == ((Node) o).row &&
                    col == ((Node) o).col);
        }

        public int hashCode() {
            return (row + 1) * (col + 1) + col; // tried to come up with a unique number hash function!
        }
    }

    public Node findShortestSource(int[][] map) {
        Map<Node, Integer> sourceMap = new HashMap<>();
        LinkedList<Node> q;
        Node res = new Node();
        boolean[][] visited;

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[i][j] == 2) {
                    Node goal = new Node(i, j, 0);
                    visited = new boolean[map.length][map[0].length];
                    q = new LinkedList<>();
                    q.addLast(goal);

                    do {
                        generateStates(q, map, visited);
                        Node returnedNode = q.removeFirst();
                        if (returnedNode.distance != 0) {
                            if (sourceMap.containsKey(returnedNode)) {
                                returnedNode.distance += sourceMap.get(returnedNode);
                                sourceMap.remove(returnedNode);
                            }
                            sourceMap.put(returnedNode, returnedNode.distance);
                        }

                    } while (!q.isEmpty());
                }

        Integer minDistance = Integer.MAX_VALUE;

        for (Map.Entry<Node, Integer> singleNode : sourceMap.entrySet()) {
            Node key = singleNode.getKey();
            if (minDistance > singleNode.getValue()) {
                res.distance = singleNode.getValue();
                res.row = key.row;
                res.col = key.col;
                minDistance = res.distance;
            }
        }
        return res;
    }


    private void generateStates(LinkedList<Node> q, int[][] map, boolean[][] visited) {
        Node nodeQ = q.getFirst();

        checkState(q, map, visited, nodeQ.row - 1, nodeQ.col);
        checkState(q, map, visited, nodeQ.row, nodeQ.col - 1);
        checkState(q, map, visited, nodeQ.row, nodeQ.col + 1);
        checkState(q, map, visited, nodeQ.row + 1, nodeQ.col);
    }

    private void checkState(LinkedList<Node> q, int[][] map, boolean[][] visited, int row, int col) {
        Node nodeQ = q.getFirst();
        Node checkingNode;

        if (row >= 0 && col >= 0 &&
                map[0].length - col > 0 && map.length - row > 0 &&
                map[row][col] == 0) {

            checkingNode = new Node(row, col, nodeQ.distance + 1);
            if (!visited[checkingNode.row][checkingNode.col]) {
                q.addLast(checkingNode);
                visited[checkingNode.row][checkingNode.col] = true;
            }
        }
    }


    public static void main(String[] args) {
        int[][] map;


//        map  = new int[][]{
//                {1, 2, 1, 1},
//                {1, 0, 0, 1},
//                {1, 0, 2, 1},
//                {1, 0, 0, 2},
//                {1, 1, 1, 1}
//                };

        map  = new int[][]{
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 2, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 0, 1, 2, 1, 1},
                {1, 2, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 2, 0, 0, 0, 0, 0, 1, 0},
        };

        ShortestSource source = new ShortestSource();
        Node res = source.findShortestSource(map);
        System.out.print("row = " + res.row + " col = " + res.col + " distance = " + res.distance);
    }
}
