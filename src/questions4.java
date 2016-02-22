import java.util.*;

/**
 * Created by habib on 2/12/16.
 */
public class questions4{
    public static void main(String [] args) {
//
//        double [] p = new double[] {0.15, 0.10, 0.05, 0.10, 0.20};
//        double [] q = new double[] {0.05, 0.10, 0.05, 0.05, 0.05, 0.10};

//        double [] p = new double[] {0.10, 0.10};
//        double [] q = new double[] {0.05, 0.15, 0.10};

//        double [] p = new double[] {0.1, .1, .1};
//        double [] q = new double[] {0.1, 0.1, 0.1, 0.1};
//        BSTSolution bstSolution = new BSTSolution(p, q);
//        bstSolution.runBST();


//        String x = "algorithm", y = "altruistic";
//        Costs costs = new Costs(new double []{2, 2.4, 2, 2.6, 2.2, 4});
//        EditDistance editDistance = new EditDistance(x, y, costs);
//
//        editDistance.convertString();
//        editDistance.printResult();


//        int in = 30;
//        int [] changes = new int[]{1, 15, 25};
//
//        ChangingCoins coin = new ChangingCoins(in, changes);
//        System.out.println("Dynamic Programming:\n");
//        coin.findTheChange_DP();
//        coin.printResults_DP();
//
//        System.out.println("\nGreedy:\n");
//
//        coin.findTheChange_Greedy();
//        coin.printResults_Greedy();


//        int [][] map = new int [][]{
//                {1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 1},
//                {0, 0, 0, 0, 1},
//                {1, 0, 1, 0, 1}
//        };
//
//        Island island = new Island(map);
//        System.out.println("Number of islands = " + island.landCount() + "\n");

//        System.out.println("Clusters with size more or equal than 4:");
//        Island2 island2 = new Island2(map);
//        System.out.println("Number of islands = " + island2.landCount());
//

//        int [][] tree = new int [][]{
//                {0, -1},
//                {1, 0},
//                {2, 0},
//                {3, 1},
//                {4, 1},
//                {5, 4}
//        };
//
//
//        SubTree subTree = new SubTree(tree);
//        System.out.print(subTree.printSubTree(subTree.findSubTree(0)));

//            String str = "??";
//            QuestionMark qMark = new QuestionMark();
//            qMark.printComb(str);

//        String input = "dir\n\tfile.ext";
//        LongestPath path = new LongestPath();
//
//        System.out.println(input);
//        System.out.println(path.findLongestPath(input));
//
//        input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//        System.out.println(input);
//        System.out.println(path.findLongestPath(input));
//
//        renameLetter(input, '\n');


//        int[][] maze = new int[][]{
//                {1, 1, 1, 0, 1},
//                {1, 1, 1, 0, 1},
//                {1, 0, 0, 0, 1},
//                {1, 0, 1, 0, 1},
//                {1, 0, 1, 0, 1},
//                {1, 0, 0, 1, 1},
//                {1, 1, 0, 0, 1}
//        };
//
//        Maze mazeSolution = new Maze(maze, 0, 3);
//        mazeSolution.findThePath();
//        System.out.println("row = " + mazeSolution.resRow+ ", col = " + mazeSolution.resCol);

//        String input = "hi helloruokwithornotghas;ldf;ahsdf;k";
//        Capitalize cap = new Capitalize();
//        System.out.print(cap.capitalize(input));

//        int[][] in = new int[][]{
//
//                {1, 6, 7},
//                {2, 5, 8},
//                {3, 4, 9}
//        };

//        int[][] in = new int[][]{
//                {13, 2, 5, 6},
//                {12, 3, 0, 7},
//                {11, 10, 9, 8}
//        };


//        int[][] in = new int[][]{
//                {1, 3},
//                {2, 4}
//                };

//        LongestSubArray subArray = new LongestSubArray(in);
//        List<Integer> res = subArray.findLongestSubArray();
//
//        for(Integer i : res)
//            System.out.print(i + " -> ");


//        Node n1 = new Node(null, 1);
//        Node n2 = new Node(n1, 2);
//        Node n3 = new Node(n1, 3);
//        Node n4 = new Node(n2, 4);
//        Node n5 = new Node(n2, 5);
//
//        List<Node> tree = new LinkedList<>();
//
//        tree.add(n1);
//        tree.add(n2);
//        tree.add(n3);
//        tree.add(n4);
//        tree.add(n5);
//
//        SubTree2 subTree2 = new SubTree2();
//        List<Node> result = subTree2.findSubTree(tree, n2);
//
//        for(Node i : result)
//            System.out.print(i.id + " , ");
//
//        List<Integer> in = new LinkedList<>();
//
//        in.add(1);
//        in.add(2);
//        in.add(3);
//
//        Iterator it = in.iterator();
//        while(it.hasNext()) {
//            it.remove();
//        }


//
//        List<Integer> l11 = new ArrayList<>();
//        List<Integer> l21 = new ArrayList<>();
//        List<Integer> l22 = new ArrayList<>();
//
//        Iterator<Integer> it11, it21, it22;
//
//        List<Iterator<Integer>> l1 = new LinkedList<>(), l2 = new Vector<>();
//        List<List<Iterator<Integer>>> l = new ArrayList<>();
//
//
//
//        l11.add(3);
//        l11.add(2);
//        l11.add(1);
//
//        l21.add(31);
//        l21.add(32);
//
//        l22.add(52);
//        l22.add(42);
//        l22.add(32);
//        l22.add(22);
//        l22.add(11);
//
//        it11 = l11.iterator();
//        it21 = l21.iterator();
//        it22 = l22.iterator();
//
//        l1.add(it11);
//
//        l2.add(it21);
//        l2.add(it22);
//
//        l.add(l1);
//        l.add(l2);
//
//        SuperIterator<Integer> superIt = new SuperIterator<>(l);
//
//        for(Integer i : superIt)
//            System.out.print(i + ", ");

//        System.out.print(encode("abbbggga"));

//        Node n1 = new Node();
//        Node n2 = new Node();
//        Node n3 = new Node();
//        Node n4 = new Node();
//        Node n5 = new Node();
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n2.left = n4;
//
//        n4.right = n5;
//
//        DeepestNode deep = new DeepestNode();
//        deep.runDeepestNode(n1);
//
//        Queue<Integer> pQ = new PriorityQueue<>();
//

        IntegerStream<Integer> is = new IntegerStream<>();

        is.add(1);
        is.add(2);
        is.add(3);
        is.add(4);
        is.add(5);

        is.add(1);
        is.add(2);
        is.add(3);
        is.add(4);
        is.add(5);

        is.add(15);

        IntegerStreamSolution isSolution = new IntegerStreamSolution();
        System.out.print(isSolution.avgLast10Integer(is));


    }

    public static void renameLetter(String input, char c){
        char[] in = input.toCharArray();
        char[] out = new char[input.length()];

        for(int i=0; i < input.length(); i++){
            if(in[i] == c)
                out[i] = '1';
            else
                out[i] = '0';

        }
        System.out.println( new String(out));
    }

    public static String encode(String in){
        String res = new String();
        int count = 1;
        char currentChar = in.charAt(0);


        for(int i = 1; i < in.length(); i++){
            if(currentChar == in.charAt(i))
                count++;
            else{
                if(count > 1)
                    res += (String.valueOf(currentChar) + String.valueOf(count));
                else
                    res += String.valueOf(currentChar);

                currentChar = in.charAt(i);
                count = 1;

            }
        }
        if(count > 1)
            res += String.valueOf(currentChar) + String.valueOf(count);
        else
            res += String.valueOf(currentChar);

        if(res.length() < in.length())
            return res;
        else
            return in;


    }


}
