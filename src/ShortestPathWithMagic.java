import java.util.*;

/**
 * Created by habib on 3/6/16.
 */
public class ShortestPathWithMagic
{
    static class Node implements Comparable<Node>{
        int id;
        int dist = Integer.MAX_VALUE;
        int parentID;
        int height;

        Node(int id){
            this.id = id;
        }
        Node(int id, int dist, int parentID, int height){
            this.id = id;
            this.dist = dist;
            this.parentID = parentID;
            this.height = height;
        }

        Node(int id, int dist, int parentID){
            this.id = id;
            this.dist = dist;
            this.parentID = parentID;
        }

        public int compareTo(Node n){
            return (dist - n.dist < 0) ? -1 : (dist - n.dist == 0) ? 0 : 1;
        }

        public boolean equals(Object n){
            return (n instanceof Node && id == ((Node) n).id);
        }
    }

//    public class ComparatorForHeap implements Comparator<Node> {
//
//        public int compare(Node n1, Node n2){
//            return (n1.dist - n2.dist < 0) ? -1 : (n1.dist - n2.dist == 0) ? 0 : 1;
//        }
//    }

    public double getTime(String[] dist, int k)
    {

        int[][] matrix = new int[dist.length][dist.length];

        for(int i = 0; i < dist.length; i++)
            for(int j = 0; j < dist[i].length(); j++){
                int val = Character.getNumericValue(dist[i].charAt(j));
//                if(val == 0) matrix[i][j] = 10000;
//                else
                matrix[i][j] = val;
            }

        if (matrix[0][1] == 0) return 0.0;


        Queue<Node> heap = new PriorityQueue<>();
        boolean[] visited = new boolean[dist.length];
        int[] distance = new int[dist.length];

        distance[0] = 0;
        visited[0] = true;

        for(int i = 1; i < dist.length; i++){
            heap.add(new Node(i, matrix[0][i], 0));
            distance[i] = matrix[0][i];
        }

        Node top;
        List<Node> res = new ArrayList<>();
        boolean found = false;

        while(!heap.isEmpty() && !found) {
            top = heap.poll();
            if (!visited[top.id]) {
                res.add(top);
                visited[top.id] = true;

			if(top.id == 1) found = true;
            else
                for (int i = 1; i < dist.length; i++) {
                    if (!visited[i]) {
                        if (top.dist + matrix[top.id][i] < distance[i]) {
                            distance[i] = top.dist + matrix[top.id][i];
                            heap.add(new Node(i, distance[i], top.id));
                        }
                    }
                }
            }
        }

        if(k == 0) return res.get(res.lastIndexOf(new Node(1))).dist;

        int parentID = res.get(res.lastIndexOf(new Node(1))).parentID;
        int shortestPathLength = 1;
        while (parentID != 0) {
            parentID = res.get(res.lastIndexOf(new Node(parentID))).parentID;
            shortestPathLength++;
        }
        double shortestPath = res.get(res.lastIndexOf(new Node(1))).dist;
        double bfsResult = bfsTraversal(matrix, k);

        if(k >= shortestPathLength) return shortestPath / 2;


        if (bfsResult < shortestPath) return bfsResult;
        return shortestPath / 2;

   }

    private double bfsTraversal(int[][] matrix, int k){
        double shortestPath = Integer.MAX_VALUE;
        boolean[] visited = new boolean[matrix.length];
        LinkedList<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 0, 0));
        int height = 0;
        while(!q.isEmpty()){
            Node top = q.removeLast();
            visited[top.id] = true;

                for (int i = 0; i < matrix.length; i++) {
                    if (!visited[i]) {
                        q.addFirst(new Node(i, top.dist + matrix[top.id][i], top.id, top.height + 1));
                        if(i == 1)
                            shortestPath = Math.min(shortestPath, top.dist + matrix[top.id][i]) / 2;
                    }
                }

        }
        return shortestPath;
    }

    public static void main(String[] args){
        String[] adj;
        int k;

        adj = new String[]{
                "076237",
                "708937",
                "680641",
                "296059",
                "334508",
                "771980"
        };
        k = 1;

        adj = new String[]{
            "094",
                "904",
                "440"};
        k = 2;

        adj = new String[]{
                "056998476599558689478",
                "502146030849262764588",
                "620919995209221769820",
                "919068146420804527896",
                "941603087557165394341", "869830545472333706527", "409105017021051001804", "739484109955552943666", "605675790163957329686", "582454091057902124824", "940257256505081454287", "999072153750950319670", "522813059909040388597", "562063555085404884572", "821453127210040383225", "677537093143383039138", "866290042251888301056", "949746139449843910876", "458835866826552108015", "782942068287972357107", "880617466470725866570"};

        k = 9;

//        Expected:
//        2.0
        adj = new String[]{
                "0919", "9091", "1904", "9140"};
        k = 1;

//        Expected:
//        4.0


        ShortestPathWithMagic magic = new ShortestPathWithMagic();
//        List<Node> res = magic.getTime(adj, 1);
//        for(Node n : res) {
//            System.out.println("Node number: " + n.id + ", distance = " + n.dist);
//            int parentID = n.parentID;
//            while (parentID != 0) {
//                System.out.println(" " + parentID);
//                parentID = res.get(res.lastIndexOf(new Node(parentID))).parentID;
//            }
//
//        }


        System.out.println(magic.getTime(adj, k));


    }

}