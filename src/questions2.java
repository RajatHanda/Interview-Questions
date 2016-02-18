import java.util.*;

/**
 * Created by habib on 2/8/16.
 */
public class questions2 {
    public static void main (String [] args) {

//        String str1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
//        String str2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
//        ResultMatrix res = new ResultMatrix(str1, str2);
//
//        LCS(str1, str2, res);
//        printResult(str1, str2, res);


//        int [] dim = {30, 35, 15, 5, 10, 20, 25};
//        int [] dim = {2, 2, 10, 500, 1};
//        int [] dim = {30, 3, 10, 5, 15};
//        int [] dim = {2, 3, 5};

//        MultiMatrix res = new MultiMatrix(dim.length);
//        multiMatrix(dim, res, 1, dim.length - 1);
//
//        System.out.println(res.matrix[1][dim.length - 1]);
//        printPoints(res);
//        System.out.println(res.multiPoints);
//        System.out.println(printPoints(res, 1, dim.length - 1));
//


//    Map<Integer, Integer[]> graph = new HashMap<>();
//    Map<Integer, Integer> resDFS = new HashMap<>();
//    LinkedList<Integer> stack = new LinkedList<>();
//
//
//    graph.put(1, new Integer []{2, 4});
//    graph.put(2, new Integer []{3});
//    graph.put(3, new Integer []{7});
//    graph.put(4, new Integer []{});
//    graph.put(5, new Integer []{3, 6});
//    graph.put(6, new Integer []{7});
//    graph.put(7, new Integer []{});
//    graph.put(8, new Integer []{4});
//    graph.put(9, new Integer []{});
//
//
//    stack.addFirst(9);
//    stack.addFirst(8);
//    stack.addFirst(5);
//    stack.addFirst(1);

//        graph.put(0, new Integer []{1, 2});
//        graph.put(1, new Integer []{});
//        graph.put(2, new Integer []{3});
//        graph.put(3, new Integer []{});

//        stack.addFirst(0);

//        graph.put(0, new Integer []{1, 2});
//        graph.put(1, new Integer []{});
//        graph.put(2, new Integer []{});

//
//        boolean [] visited = new boolean[graph.size() + 1];
//        Map<Integer, Vertex> res = new HashMap<>();
//        visited[9] = true;
//        visited[8] = true;
//        visited[5] = true;
//        visited[1] = true;
//
//
//        dfs(graph, visited, stack, res);

//        visited[0] = true;
//        stack.addFirst(0);
//        res.put(0, new Vertex(0));
//
//        dfs(graph, visited, stack, res);

//        System.out.println("");
//
//        stack = new LinkedList<>();
//        visited = new boolean[graph.size()];
//        res = new HashMap<>();
//        visited[0] = true;
//        stack.addFirst(0);
//        res.put(0, new Vertex(0));
//        bfs(graph, visited, stack, res);

//        List<Integer> finalResult = new ArrayList<>();
//
//
//        dfs(graph, visited, resDFS, stack, 0);
//
//        for (int item : resDFS.keySet())
//        finalResult.add(resDFS.get(item));
//
//    Collections.sort(finalResult);
//    System.out.println(finalResult);


//
//    int [][] adjMatrix = new int[][]{
//            {0, 2, 4, 0},
//            {0, 0, 1, 6},
//            {0, 0, 0, 4},
//            {0, 0, 0, 0}
//    };
//
//    LinkedList<Integer> queue = new LinkedList<Integer>();
//    boolean[] visited = new boolean[adjMatrix.length];
//    Map<Integer, Vertex> result = new HashMap<>();
//
//
//
//    int startingVertex = -1;
//
//    for(int i = 0; i < adjMatrix.length && startingVertex == -1 ; i++){
//        int j;
//        for(j = 0; j < adjMatrix[0].length && adjMatrix[j][i] == 0; j++){}
//        if (j == adjMatrix[0].length) startingVertex = i;
//    }
//
//    for(int i = 0; i < adjMatrix.length; i++){
//        Vertex newNode = new Vertex();
//        result.put(i, newNode);
//    }
//
//    result.put(startingVertex, new Vertex(0));
//    queue.addLast(startingVertex);
//    visited[startingVertex]	= true;
//
//    dijikstra(adjMatrix, queue, visited, result);
//
//        for(Map.Entry<Integer, Vertex> pair : result.entrySet()){
//            System.out.println(pair.getKey() + " = ["+ pair.getValue().vertex + ", " + pair.getValue().weight + "] - ");
//        }


//        String str = "acda3q45";
//        System.out.print(checkString(str));

//        String str1 = "abbbcccdddddd", str2 = "ddcaa";
//        System.out.print(permCheck(str1, str2));
//    Queue<Integer> q = new PriorityQueue<>();
//        System.out.println(compression2(str1));


//        int[][] in = new int[][]{
//                {2, 1, 1, 8},
//                {0, 1, 5, 9},
//                {2, 7, 8, 1}
//        }, out;
//
//        out = checkNConvert(in);
//        for (int i = 0; i < out.length; i++) {
//            for (int j = 0; j < out[0].length; j++)
//                System.out.print(out[i][j]+" ");
//            System.out.println();
//
//
//        }
//        String str1 = "waterbottle", str2 = "pottlewater";
//
//        System.out.println(isSubstring2(str1, str2));
//
//        System.out.println("No Change in Decision = " + montyHall(100, true));
//        System.out.println("Change in Decision = " + montyHall(100, false));

//
//        NodeTree n1 = new NodeTree(1);
//        NodeTree n2 = new NodeTree(2);
//        NodeTree n3 = new NodeTree(3);
//        NodeTree n4 = new NodeTree(4);
//        NodeTree n5 = new NodeTree(5);
//        NodeTree n6 = new NodeTree(6);
//        NodeTree n7 = new NodeTree(7);
//        NodeTree n8 = new NodeTree(8);
//        NodeTree n9 = new NodeTree(9);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n2.left = n5;
//        n2.right = n6;
//
//        n3.right = n4;
//
//        n5.left = n7;
//        n5.right = n8;
//
//        n7.left = n9;
//
//        System.out.println(commonAncestor(n1, 9, 6));
//
//    }


//        int [] in = new int[] {1, 2, 5, 7, 15, 25 , 34, 99};
//
//        System.out.println(binarySearch(in, 99, 0, in.length));
//        System.out.println(binarySearch(in, 1, 0, in.length));


//        NodeTree n1 = new NodeTree(1);
//        NodeTree n2 = new NodeTree(2);
//        NodeTree n3 = new NodeTree(3);
//        NodeTree n4 = new NodeTree(4);
//        NodeTree n5 = new NodeTree(5);
//        NodeTree n6 = new NodeTree(6);

//        n1.left = n2;
//        n1.right = n3;

//        n2.left = n4;
//        n2.right = n5;

//        n3.right = n6;

//        System.out.println(checkBalancedTree(n1));

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        HashSet<Integer> n1 = new HashSet<>();
        n1.add(2);
        graph.put(1, n1);

        HashSet<Integer> n2 = new HashSet<>();
        n2.add(3);
        n2.add(4);
        graph.put(2, n2);

        HashSet<Integer> n3 = new HashSet<>();
        n3.add(5);
        graph.put(3, n3);

        HashSet<Integer> n4 = new HashSet<>();
        n4.add(3);
        n4.add(6);
        graph.put(4, n4);

        HashSet<Integer> n5 = new HashSet<>();
        n5.add(2);
        graph.put(5, n5);

        HashSet<Integer> n6 = new HashSet<>();
        n6.add(5);
        graph.put(6, n6);

//        HashSet<Integer> n1 = new HashSet<>();
//        n1.add(2);
//        graph.put(1, n1);
//
//        HashSet<Integer> n2 = new HashSet<>();
//        n2.add(3);
//        n2.add(4);
//        graph.put(2, n2);
//
//        HashSet<Integer> n3 = new HashSet<>();
//        n3.add(5);
//        graph.put(3, n3);
//
//        HashSet<Integer> n4 = new HashSet<>();
//        n4.add(5);
//        n4.add(6);
//        graph.put(4, n4);
//
//        HashSet<Integer> n5 = new HashSet<>();
//        graph.put(5, n5);
//
//        HashSet<Integer> n6 = new HashSet<>();
////        n6.add(5);
//        graph.put(6, n6);

        System.out.println(routeFinder(graph, 6, 2));

    }


    public static LinkedList<Integer> routeFinder(HashMap<Integer, HashSet<Integer>> graph, Integer n1, Integer n2){
        LinkedList<Integer> route = new LinkedList<>(), stack = new LinkedList<>();

        HashSet<Integer> visited = new HashSet<>();

        stack.addFirst(n1);
        route.addLast(n1);

        visited.add(n1);
        Integer head;
        boolean anyVisited;

        while(!stack.isEmpty()){
            anyVisited = false;
            head = stack.getFirst();
            if(!route.getLast().equals(head))
                route.addLast(head);

            if (head.equals(n2))
                return route;

            for(Integer node : graph.get(head))
                if (!visited.contains(node)){
                    stack.addFirst(node);
                    visited.add(node);
                    anyVisited = true;
                }


            if(!anyVisited) {
                stack.removeFirst();
                route.removeLast();
            }
        }

        return route;
    }

    public static int checkBalancedTree(NodeTree root){

        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;

        int rightHeight =  checkBalancedTree(root.right);
        int leftHeight =  checkBalancedTree(root.left);

        if(leftHeight == -2 || rightHeight == -2) return -2;

        if((Math.abs(leftHeight - rightHeight) > 1 )) return -2;

        return (Math.max(leftHeight, rightHeight) + 1);

    }


    public static int binarySearch(int[] in, int item, int firstInd, int lastInd){

        if (firstInd == lastInd) return -1;
        if (firstInd == lastInd - 1)
            if (item == in[firstInd])
                return firstInd;
            else
                return -1;

        int midInd = (lastInd - firstInd) / 2 + firstInd;

        if(item == in[midInd]) return midInd;

        if(item < in[midInd]) return binarySearch(in, item, firstInd, midInd);
        return binarySearch(in, item, midInd + 1, lastInd);
    }

    public static int commonAncestor(NodeTree root, int in1, int in2){

        LinkedList<NodeTree> stack = new LinkedList<>(), ancQ1 = new LinkedList<>(), ancQ2 = new LinkedList<>();


        findAncestor(in1, root, stack, ancQ1);

        stack.clear();
//		stack = new ArrayList<>();

        findAncestor(in2, root, stack, ancQ2);

        int commonAns = -1;
        boolean keepChecking = true;
        int minSize = Math.min(ancQ1.size(), ancQ2.size());

        for(int i = 0; i < minSize && keepChecking; i++){
            NodeTree n1 = ancQ1.removeFirst();
            NodeTree n2 = ancQ2.removeFirst();
            if (n1.num == n2.num)
                commonAns = n1.num;
            else
                keepChecking = false;
        }


        return commonAns;
    }

    public static void findAncestor(int n, NodeTree root, LinkedList<NodeTree> stack, LinkedList<NodeTree> ancQ){

        NodeTree head;
        Set<Integer> visited = new HashSet<>();

        stack.addFirst(root);
        visited.add(root.num);




        while(!stack.isEmpty()){

            head = stack.getFirst();

            if(head.num == n)
                return;

            if(head.left == null && head.right==null){
                stack.removeFirst();
            }
            else
                if((head.left != null && visited.contains(head.left.num)) ||
                        (head.right != null && visited.contains(head.right.num))) {

                    stack.removeFirst();
                    ancQ.removeLast();
                }
                else{

                    if(head.left != null ){
                        stack.addFirst(head.left);
                        visited.add(head.left.num);

                    }

                    if(head.right != null){
                        stack.addFirst(head.right);
                        visited.add(head.right.num);
                    }

                    ancQ.addLast(head);
            }
        }
    }

    public static double montyHall(int count, boolean noChangeInDecision){

        int decision, hitCount = 0;

        for(int i = 0; i < count; i++){
            decision = (int)(Math.random() * 3);
            if (!noChangeInDecision)
                if(decision == 0)
                    decision = 1;
                else
                    decision = 0;


            if(decision == 0) hitCount++;
        }

        return hitCount / (count + 0.0);

    }

    public static boolean isSubstring2(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        if (str1.equals("")) return true;

        for(int i = 0; i < str1.length(); i++)
            if (str1.charAt(0) == str2.charAt(i))
                if(str1.substring(0, str1.length() - i).equals(str2.substring(i)) &&
                        str1.substring(str1.length() - i).equals(str2.substring(0, i))) {
                    System.out.println(i);
                    return true;
                }


        return false;

    }

    public static boolean isSsdgfubstring(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        if (str1.equals("")) return true;

        Set<Integer> indexList = new HashSet<>();

        for(int i = 0; i < str1.length(); i++)
            if (str1.charAt(0) == str2.charAt(i))
                indexList.add(i);

        for(Integer ind : indexList){
            if(str1.equals(str2.substring(ind).concat(str2.substring(0, ind)))){
                System.out.println(ind);
                return true;
            }
        }

        return false;

    }

    public static int [][] checkNConvert(int[][] in){
            Set<Integer> row = new HashSet<Integer>(), col = new HashSet<Integer>();
            int[][] out = new int[in.length][in[0].length];

            for(int i = 0; i < in.length; i++)
                for(int j = 0; j < in[0].length; j++){
                    out[i][j] = in[i][j];
                    if(in[i][j] == 0){
                        row.add(i);
                        col.add(j);
                    }
                }


            for (int rowNum : row)
                for(int j = 0; j < in[0].length; j++)
                    out[rowNum][j] = 0;


            for (int colNum : col)
                for(int i = 0; i < in.length; i++)
                    out[i][colNum] = 0;

            return out;
        }

    public static String compression2(String str){
        char tmpChar = '\0';
        char [] res = new char[str.length()], cnt;

        for(int i = 0; i< str.length(); i++)
            res[i] = '\0';

        int count = 0, index = 0;


        for(int i = 0; i < str.length(); i++){
            if(tmpChar == str.charAt(i))
                count++;
            else{
                if(tmpChar != '\0'){
                    if(index >= str.length() - 1) return str;
                    res[index++] = tmpChar;
                    cnt = String.valueOf(count).toCharArray();
                    res[index++] = cnt[0];
                }
                tmpChar = str.charAt(i);
                count = 1;
            }
        }

        if(index >= str.length() - 1) return str;
        res[index++] = tmpChar;
        cnt = String.valueOf(count).toCharArray();
        res[index] = cnt[0];

        index = 0;
        for(char ch:res)
            if(ch == '\0')
                break;
            else
                index++;

        return String.valueOf(res).substring(0, index);
    }

    public static String compression(String str){
        char tmpChar = '\0';
        String res = "";
        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(tmpChar == str.charAt(i))
                count++;
            else{
                if(tmpChar != '\0')
                        res += String.valueOf(tmpChar) + count;
                tmpChar = str.charAt(i);
                count = 1;
            }
        }

        res += String.valueOf(tmpChar) + count;

        if(res.length() < str.length())
            return res;
        else
            return str;
    }

    public static boolean permCheck(String str1, String str2){
        if (str1.length() != str2.length()) return false;
        HashMap<Integer, Integer> lookup = new HashMap<>();

        for(int i = 0; i < str1.length(); i++)
            if(!lookup.containsKey(Integer.valueOf(str1.charAt(i))))
                lookup.put(Integer.valueOf(str1.charAt(i)), 1);
            else
                lookup.put(Integer.valueOf(str1.charAt(i)), lookup.get(Integer.valueOf(str1.charAt(i))) + 1);

        for(int i = 0; i < str2.length(); i++){
            if(!lookup.containsKey(Integer.valueOf(str2.charAt(i)))) return false;
            if(lookup.get(Integer.valueOf(str2.charAt(i))) == 0) return false;
            lookup.put(Integer.valueOf(str2.charAt(i)), lookup.get(Integer.valueOf(str2.charAt(i))) - 1);

        }
        return true;
    }

    public static boolean checkString(String str){
        Set<Character> stringChar = new HashSet<Character>();
        for(int i = 0; i < str.length(); i++){
            if(!stringChar.contains(str.charAt(i)))
                stringChar.add(str.charAt(i));
            else return false;
        }
        return true;
    }

    public static void dijikstra(int [][] adjMatrix, LinkedList<Integer> queue, boolean[] visited, Map<Integer, Vertex> result){

        while(!queue.isEmpty()){
            int head = queue.removeFirst();

            for(int i = 0; i < adjMatrix.length; i++){
                if(adjMatrix[head][i] > 0){
                    if(!visited[i]){
                        queue.addLast(i);
                        visited[i] = true;
                    }
                    if(result.get(head).weight + adjMatrix[head][i] < result.get(i).weight)
                        result.put(i, new Vertex(result.get(head).weight + adjMatrix[head][i], head));
                }
            }
        }
    }

    public static void dfs(Map<Integer, Integer[]> graph, boolean [] visited, LinkedList<Integer> stack, Map<Integer, Vertex> res){
        int count = 0;
        while(!stack.isEmpty()){
            int head = stack.getFirst();
            if(!res.containsKey(head))
                res.put(head, new Vertex(head, count++));
            boolean anyUnvisited = false;

            for(int i = 0; i < graph.get(head).length; i++)
                if(!visited[graph.get(head)[i]]){
                    stack.addFirst(graph.get(head)[i]);
                    visited[graph.get(head)[i]] = true;

                    anyUnvisited = true;
                }


            if(!anyUnvisited){
                res.get(head).leaving = count;
                System.out.print(res.get(head).nodeNum + "[" + res.get(head).visiting + ", " + count + "] - ");
                stack.removeFirst();
                count++;
            }

        }
    }

    public static void bfs(Map<Integer, Integer[]> graph, boolean [] visited, LinkedList<Integer> stack, Map<Integer, Vertex> res){
        int count = 1;
        while(!stack.isEmpty()){
            int head = stack.getFirst();
            if(!res.containsKey(head))
                res.put(head, new Vertex(head, count++));

            for(int i = 0; i < graph.get(head).length; i++)
                if(!visited[graph.get(head)[i]]){
                    stack.addLast(graph.get(head)[i]);
                    visited[graph.get(head)[i]] = true;

             }


                res.get(head).leaving = count;
                System.out.print("[" + res.get(head).visiting + ", " + count + "] - ");
                stack.removeFirst();
                count++;

        }
    }

    public static void dfs(Map<Integer, Integer[]> graph, boolean [] visited, Map<Integer, Integer> resDFS, LinkedList<Integer> stack, int count) {
        int tempCount = count;

        while (!stack.isEmpty())
            tempCount = topoSort(graph, visited, resDFS, stack, tempCount) + 1 ;


    }

    public static int topoSort(Map<Integer, Integer[]> graph, boolean [] visited, Map<Integer, Integer> resDFS, LinkedList<Integer> stack, int count){

        int head;
        head = stack.getFirst();
        visited[head] = true;

        if (graph.get(head).length == 0) {
            head = stack.removeFirst();
            resDFS.put(head, ++count);
            return count;
        }


        boolean anyUnvisited = false;
        for(int i = 0; i < graph.get(head).length; i++)
            if(!visited[graph.get(head)[i]]){
                visited[graph.get(head)[i]] = true;
                anyUnvisited = true;
                stack.addFirst(graph.get(head)[i]);
            }


        if (anyUnvisited)
            count = topoSort(graph, visited, resDFS, stack, count + 1);
        else {
            head = stack.removeFirst();
            resDFS.put(head, count);
        }


        return count;
    }

    public static String printPoints(MultiMatrix res, int firstInd, int lastInd) {
        if (firstInd == lastInd - 1 || firstInd == lastInd) return "";

        return printPoints(res, firstInd, res.indexPoints[firstInd][lastInd]) +
                res.indexPoints[firstInd][lastInd] +
                printPoints(res, res.indexPoints[firstInd][lastInd] + 1, lastInd);
    }

    public static void printPoints(MultiMatrix res) {

        for(int[] row : res.indexPoints) {
            for (int item : row)
                System.out.print(item + "\t");
            System.out.println();
        }
    }

    public static void multiMatrix(int[] dim, MultiMatrix res, int firstInd, int lastInd){

        if (firstInd == lastInd) return;

        int minCost = Integer.MAX_VALUE, minCostIndex = -1;

        if (res.matrix[firstInd][lastInd] == Integer.MAX_VALUE) {
            for (int k = firstInd; k < lastInd; k++) {

                if (res.matrix[firstInd][k] == Integer.MAX_VALUE)
                    multiMatrix(dim, res, firstInd, k);

                if (res.matrix[k][lastInd] == Integer.MAX_VALUE)
                    multiMatrix(dim, res, k + 1, lastInd);

                if (minCost > res.matrix[firstInd][k] + res.matrix[k + 1][lastInd] + dim[firstInd - 1] * dim[k] * dim[lastInd]) {
                    minCost = res.matrix[firstInd][k] + res.matrix[k + 1][lastInd] + dim[firstInd - 1] * dim[k] * dim[lastInd];
                    minCostIndex = k;
                }


            }

            res.matrix[firstInd][lastInd] = minCost;

            if (res.indexPoints[firstInd][lastInd] == -1) {
                res.indexPoints[firstInd][lastInd] = minCostIndex;
                if (lastInd > firstInd - 1)
                    res.multiPoints = res.multiPoints + minCostIndex;
            }
        }

    }

    public static void LCS(String str1, String str2, ResultMatrix res){
        if (str1.length() == 0 || str2.length() == 0) return;

        int lengthStr1 = str1.length();
        int lengthStr2 = str2.length();

        if (str1.charAt(lengthStr1 - 1) == str2.charAt(lengthStr2 - 1)) {

            res.dir[lengthStr2][lengthStr1] = "D";
            if (res.weight[lengthStr2 - 1][lengthStr1 - 1] == -1){
                LCS(str1.substring(0, lengthStr1 - 1), str2.substring(0, lengthStr2 - 1), res);
            }
            res.weight[lengthStr2][lengthStr1] = res.weight[lengthStr2 - 1][lengthStr1 - 1] + 1;
            return;
        }

        if (res.weight[lengthStr2][lengthStr1 - 1] == -1)
            LCS(str1.substring(0, lengthStr1 - 1), str2.substring(0, lengthStr2), res);

        if (res.weight[lengthStr2 - 1][lengthStr1] == -1)
            LCS(str1.substring(0, lengthStr1), str2.substring(0, lengthStr2 - 1), res);

        if (res.weight[lengthStr2 - 1][lengthStr1] >= res.weight[lengthStr2][lengthStr1 - 1]){
            res.weight[lengthStr2][lengthStr1] = res.weight[lengthStr2 - 1][lengthStr1];
            res.dir[lengthStr2][lengthStr1]	= "U";
        }
        else {
            res.weight[lengthStr2][lengthStr1] = res.weight[lengthStr2][lengthStr1 - 1];
            res.dir[lengthStr2][lengthStr1]	= "L";
        }
    }

    public static void printResult(String str1, String str2, ResultMatrix res){

        int row = res.dir.length - 1, col = res.dir[0].length - 1;

        while(row > 0 && col > 0){
            switch (res.dir[row][col]){
                case "U":
                    row--;
                    break;
                case "L":
                    col--;
                    break;
                case "D":
                    res.subStringResult = str1.charAt(col - 1) + res.subStringResult;
                    row--;
                    col--;
                    break;

            }
        }
        System.out.println(res.subStringResult);

    }
}
