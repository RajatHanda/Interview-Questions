/**
 * Created by habib on 2/3/16.
 */

import java.util.*;

public class questions {
    public static void main(String[] args) {
//        int n = 5;
//        System.out.println(canWinNim(n));
//
//        int[] nArray = {1};
//        System.out.println(singleNumber(nArray));
//
//        n = 13;
//        System.out.println(addDigits(n));
//
//        String str = "abcda";
//        System.out.println(hashSet(str));
//
//        int[] prices = {2, 2, 2, 4};
//        System.out.println(maxProfit(prices));

//        String s = "a", t = "a";
//        System.out.println(isAnagram(s, t));

//        String s = "word";
//        System.out.println(abbreviation(s));
//        System.out.println(s.substring(0, 5));

//        int[] sortedArray = new int[]{10, 20, 30, 40, 50};
//        System.out.println(binarySearch(sortedArray, 11, 0, sortedArray.length));
//
//        int[] unsortedArray = new int[]{5, 1, 1, 2};
//        insertionSort(unsortedArray);
//        for(int in : unsortedArray){
//            System.out.print(in + " " );
//        }

//
//        int[] unsortedArray = new int[]{5, 1, 9, 3, 3, -1, 10, 0};
//        mergeSort(unsortedArray, 0, unsortedArray.length);
//        for(int in : unsortedArray){
//            System.out.print(String.valueOf(in) + " " );
//        }

//        int[] unsortedArray = new int[]{5, 1, 9, 3, 3, -1, 10, 0};
//        quickSort(unsortedArray, 0, unsortedArray.length);
//        for(int in : unsortedArray){
//            System.out.print(String.valueOf(in) + " " );
//        }

        Stack<Integer> tempStack = new Stack<>();
        Queue<Integer> tempQ = new PriorityQueue<>() ;
//        int [][] matrix = new int[][]{
//                {2, 2, 8},
//                {1, 3, -9}
//        };
//
//        result res = new result();
//        System.out.println("max sum = " + subMatrixSum(matrix, res));
//        System.out.print("row = " + res.row + " col = " + res.col + " row size =" + res.row_size + " col size = " + res.col_size);

//        double[][] intervals = new double[][]{
//                {2, 4},
//                {1, 3}
//        };
//
//        System.out.println(overlapping(intervals));


//        int[][] map = new int[][]{
//                {1, 1, 1, 1},
//                {1, 0, 0, 1},
//                {1, 0, 2, 1},
//                {1, 0, 0, 2},
//                {1, 1, 1, 1},
//        };
//
//        Node res = shortestSource(map);
//        System.out.print("row = " + res.row + " col = " + res.col + " distance =" + res.distance);


        int[][] pairs = new int[][]{
                {7, 1},
                {4, 4},
                {5, 2},
                {7, 0},
                {6, 1},
                {5, 0}
        };

        int [][] res = lineReconstruction(pairs);
//        System.out.print("row = " + res.row + " col = " + res.col + " distance =" + res.distance);

    }

    public static int[][] lineReconstruction(int[][] ppl){
        int [][] res = new int[ppl.length][2];
        int[] permutation = new int[ppl.length];
        Map<Integer, Person> lookupTable = new HashMap<>();

        for(int i=0 ; i < ppl.length; i++)
            permutation[i] = i;

        for(int i=0 ; i < ppl.length; i++)
            lookupTable.put(i, new Person(ppl[i][0], ppl[i][1]));


        generateAndCheckPerm(lookupTable, permutation, res, 0);

        return res;
    }

    public static boolean generateAndCheckPerm(Map<Integer, Person> lookupTable, int [] permutation, int[][]res, int index) {
        if (permutation.length == index)
            return checkPerm(lookupTable, permutation, res);

        int core = permutation[index], swap;
        for (int i = index; i < permutation.length; i++) {
            permutation[index] = permutation[i];
            permutation[i] = core;

            if (generateAndCheckPerm(lookupTable, permutation, res, index + 1))
                return true;

            permutation[i] = permutation[index];
            permutation[index] = core;
        }
        return false;
    }

    public static boolean checkPerm(Map<Integer, Person> lookupTable, int[] permutation, int[][] res){

        int count = 0;
        for(int k = 0; k < permutation.length; k++){
            count = 0;
            for(int j = k - 1; j >= 0; j--)
                if(lookupTable.get(permutation[j]).height >= lookupTable.get(permutation[k]).height) count++;

            if (count != lookupTable.get(permutation[k]).count) return false;
        }


        for(int item : permutation)
            System.out.print(item + " ");

        System.out.println("");

        for(int item : permutation)
            System.out.print("[" + lookupTable.get(item).height + ", " + lookupTable.get(item).count + "] ");

        System.out.println("");

        return true;
    }

    public static boolean checkPerm(int[] permutation, int[][] res){

        for(int k = permutation.length - 1; k >= 0; k--)
            if ((permutation[permutation.length - 1 - k] != k) && (permutation[k] != k)) return false;

        for(int item : permutation)
            System.out.print(item + " ");

        System.out.println("");

        return true;
    }

//    public static boolean checkPerm(int[] permutation, int[][] res){
//
//        for(int k = permutation.length - 1; k >= 0; k--)
//            if ((permutation[permutation.length - 1 - k] != k) && (permutation[k] != k)) return false;
//
//        for(int item : permutation)
//            System.out.print(item + " ");
//
//        System.out.println("");
//
//        return true;
//    }

    public static Node shortestSource(int[][] map) {
        Map<Node, Integer> sourceMap = new HashMap<>();
        Set<Node> stateSet;
        LinkedList<Node> q;
        Node res = new Node();
        boolean [][] visited = new boolean [map.length][map[0].length];

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (map[i][j] == 2) {
                    Node goal = new Node(i, j, 0);
                    visited = new boolean [map.length][map[0].length];
                    q = new LinkedList<>();
                    q.addLast(goal);

                    do {
                        generateStates(q, map, visited);
                        Node returnedNode = q.removeFirst();
                        if(returnedNode.distance != 0)
                            if (sourceMap.containsKey(returnedNode))
                                sourceMap.put(returnedNode, sourceMap.get(returnedNode) + returnedNode.distance);
                            else
                                sourceMap.put(returnedNode, returnedNode.distance);

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

    public static void generateStates(LinkedList<Node> q, int[][] map, boolean [][] visited) {
        Node nodeQ = q.getFirst();
        Node checkingNode;

        checkState(q, map, visited, nodeQ.row -1, nodeQ.col - 1);
        checkState(q, map, visited, nodeQ.row -1, nodeQ.col);
        checkState(q, map, visited, nodeQ.row -1, nodeQ.col + 1);
        checkState(q, map, visited, nodeQ.row   , nodeQ.col - 1);
        checkState(q, map, visited, nodeQ.row   , nodeQ.col + 1);
        checkState(q, map, visited, nodeQ.row +1, nodeQ.col - 1);
        checkState(q, map, visited, nodeQ.row +1, nodeQ.col);
        checkState(q, map, visited, nodeQ.row +1, nodeQ.col +1);

    }

    public static void checkState(LinkedList<Node> q, int[][] map, boolean [][] visited, int row, int col) {
            Node nodeQ = q.getFirst();
            Node checkingNode;

            if (row >= 0 && col >= 0 && map[0].length - col > 0 && map.length - row > 0 && map[row][col] == 0) {
                checkingNode = new Node(row, col, nodeQ.distance + 1);
                if (!visited[checkingNode.row][checkingNode.col]) {
                    q.addLast(checkingNode);
                    visited[checkingNode.row][checkingNode.col] = true;
                }
            }


        }

    public static boolean canWinNim(int n) {
//        if (n % 4 == 0)
//            return false;
//        else
//            return true;

        return !(n % 4 == 0);
    }

    public static int addDigits(int num) {
        int sum = 0, Num = num;

        while (Num != 0) {
            sum += Num % 10;
            Num /= 10;
        }


        while (sum > 9) {
            Num = sum;
            sum = 0;

            while (Num == 0)
                sum += Num % 10;
        }

        return sum;
    }

    public static int singleNumber(int[] nums) {
        List<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!(arrayList.contains(nums[i])))
                arrayList.add(nums[i]);
            else
                arrayList.remove(new Integer(nums[i]));
        }

        System.out.println(arrayList);

        return arrayList.get(0);
    }

    public static boolean hashSet(String str) {
        Set<Character> hashSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++)
            hashSet.add(str.charAt(i));

        return (str.length() == hashSet.size());


    }

    public static int maxProfit(int[] prices) {
        int buying = -1, delta1 = -1, delta2 = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            delta2 = prices[i + 1] - prices[i];
            if (delta1 < 0 && delta2 >= 0) {
                buying = prices[i];
            }
            if (delta2 < 0 && delta1 > 0)
                profit += prices[i] - buying;

            if (i == prices.length - 2 && delta2 >= 0 && buying != -1)
                profit += prices[i + 1] - buying;

            delta1 = delta2;

        }
        return profit;


    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        List<Character> word = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            word.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++)
            if (word.contains(t.charAt(i)))
                word.remove((Character) t.charAt(i));
            else
                return false;

        return true;


    }

    public String convertToTitle(int n) {
        int sum = n;
        String res = new String();
        do {
            switch ((sum % 26) - 1) {
                case 0:
                    res += "A";
                    break;
                case 1:
                    res += "B";
                    break;
                case 2:
                    res += "C";
                    break;
                case 3:
                    res += "D";
                    break;
                case 4:
                    res += "E";
                    break;
                case 5:
                    res += "F";
                    break;
                case 6:
                    res += "G";
                    break;
                case 7:
                    res += "H";
                    break;
                case 8:
                    res += "I";
                    break;
                case 9:
                    res += "J";
                    break;
                case 10:
                    res += "K";
                    break;
                case 11:
                    res += "L";
                    break;
                case 12:
                    res += "M";
                    break;
                case 13:
                    res += "N";
                    break;
                case 14:
                    res += "O";
                    break;
                case 15:
                    res += "P";
                    break;
                case 16:
                    res += "Q";
                    break;
                case 17:
                    res += "R";
                    break;
                case 18:
                    res += "S";
                    break;
                case 19:
                    res += "T";
                    break;
                case 20:
                    res += "U";
                    break;
                case 21:
                    res += "V";
                    break;
                case 22:
                    res += "W";
                    break;
                case 23:
                    res += "X";
                    break;
                case 24:
                    res += "Y";
                    break;
                case -1:
                    res += "Z";
                    break;
            }

            sum /= 26;


        } while ((sum > 1) || (sum % 26 != 0));

        return res;
    }

    public static Set<String> abbreviation(String word) {
        Map<String, HashSet<String>> res = new HashMap<>();

        Abb(word, res);

        return res.get(word);
    }

    public static void Abb(String word, Map<String, HashSet<String>> res) {
        if (word.length() == 1) {
            if (!res.containsKey(String.valueOf(word.charAt(0)))) {
                HashSet<String> tmpSet = new HashSet<>();
                tmpSet.add(String.valueOf(word.charAt(0)));
                tmpSet.add(String.valueOf(1));

                res.put(String.valueOf(word.charAt(0)), tmpSet);
            }
        } else {
            Abb(word.substring(1), res);
            Abb(word.substring(0, (word.length() - 1)), res);
            HashSet<String> concatSet = new HashSet<>();

            for (String rightStr : res.get(word.substring(1)))
                for (String leftStr : res.get(word.substring(0, word.length() - 1)))
                    if (leftStr.substring(1, leftStr.length()).equals(rightStr.substring(0, rightStr.length() - 1)))
                        concatSet.add(leftStr.concat(String.valueOf(rightStr.charAt(rightStr.length() - 1))));

            res.put(word, concatSet);
        }
    }

    public static int binarySearch(int[] sortedArray, int item, int firstInd, int lastInd) {

        if (firstInd == lastInd) return -1;
        int median = (lastInd - firstInd) / 2 + firstInd;

        if (sortedArray[median] == item) return median;
        else if (sortedArray[median] < item)
            return binarySearch(sortedArray, item, median + 1, lastInd);
        else
            return binarySearch(sortedArray, item, firstInd, median);
    }

    public static int[] insertionSort(int[] in) {
        for (int l = 1; l < in.length; l++) {
            int j = l - 1;
            int swap = in[l];

            while (j >= 0 && in[j] > swap) {
                in[j + 1] = in[j];
                j--;

            }
            in[j + 1] = swap;
        }
        return in;
    }

    public static void mergeSort(int[] in, int firstInd, int lastInd){
        if (firstInd == lastInd || firstInd == lastInd - 1) return;
        int median = (lastInd - firstInd) / 2 + firstInd;
        mergeSort(in, firstInd, median);
        mergeSort(in, median, lastInd);
        merge(in, firstInd, lastInd);
    }

    public static void merge(int[] in, int firstInd, int lastInd){

        int length = lastInd - firstInd;
        int median = (lastInd - firstInd) / 2 + firstInd;
        int[] mergedArray = new int[length];

        int leftInd = firstInd;
        int rightInd = median;
        int mergedInd = 0;

        while (leftInd < median && rightInd < lastInd)
            if(in[leftInd] <= in[rightInd]) {
                mergedArray[mergedInd++] = in[leftInd++];
//                mergedInd++;
//                leftInd++;
            }
            else {
                mergedArray[mergedInd++] = in[rightInd++];
//                mergedInd++;
//                rightInd++;
            }

        if(leftInd == median)
            while (rightInd<lastInd){
                mergedArray[mergedInd++] = in[rightInd++];
//                rightInd++;
//                mergedInd++;
            }

        else
            while (leftInd < median){
                mergedArray[mergedInd++] = in[leftInd++];
//                leftInd++;
//                mergedInd++;
            }

        for(int index = firstInd; index < lastInd; index++)
            in[index] = mergedArray[index - firstInd];
    }

    public static void quickSort(int[] in, int firstInd, int lastInd){
        if (firstInd >= lastInd - 1) return;

        int pivot = in[firstInd];
        int biggerInd = firstInd + 1;
        int swap;

        for(int index = firstInd + 1; index < lastInd; index++) {
            if (in[index] < pivot) {
                if (index != biggerInd) {
                    swap = in[biggerInd];
                    in[biggerInd] = in[index];
                    in[index] = swap;

                }
                biggerInd++;
            }
        }

        in[firstInd] = in[biggerInd - 1];
        in[biggerInd - 1] = pivot;

        quickSort(in, firstInd, biggerInd);
        quickSort(in, biggerInd , lastInd);
    }

    public static int subMatrixSum(int[][] matrix, result res) {
        int maxSum = -Integer.MAX_VALUE;

        for (int i = 1; i <= matrix.length; i++)
            for (int j = 1; j <= matrix[0].length; j++)
                for (int iIndex = 0; iIndex < matrix.length - i + 1; iIndex++)
                    for (int jIndex = 0; jIndex < matrix[0].length - j + 1; jIndex++) {
                        int sum = 0;

                        for (int k_i = iIndex; k_i < iIndex + i; k_i++)
                            for (int k_j = jIndex; k_j < jIndex + j; k_j++)
                                sum += matrix[k_i][k_j];

                        if (maxSum < sum) {
                            maxSum = sum;
                            res.row = iIndex;
                            res.col = jIndex;
                            res.row_size = i;
                            res.col_size = j;
                        }
                    }
        return maxSum;
    }

    public static double overlapping(double[][] intervals){
        if (intervals[0][0] <  intervals[1][0])
            if(intervals[0][1] < intervals[1][1])
                return (intervals[0][1]  - intervals[1][0]);
            else
                return (intervals[1][1]  - intervals[1][0]);

        else
        if (intervals[0][0] >  intervals[1][0])
            if(intervals[1][1] < intervals[0][1])
                return (intervals[1][1]  - intervals[0][0]);
            else
                return(intervals[0][1]  - intervals[0][0]);
        else
            return (Math.min(intervals[0][1], intervals[1][1]) - intervals[0][0]);

    }

}
