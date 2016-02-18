import javax.xml.transform.Result;
import java.util.*;

/**
 * Created by habib on 2/10/16.
 */
    public class questions3{

    public static void main(String [] args){

    //        LinkedNode n1 = new LinkedNode(1);
    //        LinkedNode n2 = new LinkedNode(2);
    //        LinkedNode n3 = new LinkedNode(3);
    //        n1.next = n2;
    //        n2.next = n3;
    //
    //        LinkedNode root = reverseLinkedList(n1);
    //
    //        while(root != null){
    //            System.out.print(root.num + " ");
    //            root = root.next;
    //        }

//            LinkedNode n1 = new LinkedNode();
//            LinkedNode n2 = new LinkedNode();
//            LinkedNode n3 = new LinkedNode();
//            LinkedNode n4 = new LinkedNode();
//            LinkedNode n5 = new LinkedNode();
//            LinkedNode n6 = new LinkedNode();
//
//            n1.next = n2;
//            n2.next = n3;
//            n3.next = n4;
//            n4.next = n5;
//            n5.next = n6;
//            n6.next = n3;



//            System.out.print(checkLoopInLinkedList(n1));

//            NodeTree n1 = new NodeTree(1);
//            NodeTree n2 = new NodeTree(2);
//            NodeTree n3 = new NodeTree(3);
//            NodeTree n4 = new NodeTree(3);
//
//            LinkedList<NodeTree> list = new LinkedList<>();
//
//            list.add(n3);
//            list.add(n2);
//            list.add(n1);
//
//            System.out.println(list);
////            Collections.sort(list);
//            System.out.println(list);
//            System.out.println(list.contains(n4));
//
//

//            int[] in = new int [] {1};
//            System.out.println(Arrays.toString(in));
//            System.out.println(inorderTraversal(convertToBST(in, 0, in.length)));

//            NodeTree n1 = new NodeTree(1);
//            NodeTree n2 = new NodeTree(2);
//            NodeTree n3 = new NodeTree(3);
//            NodeTree n4 = new NodeTree(4);
//            NodeTree n5 = new NodeTree(5);
//            NodeTree n6 = new NodeTree(6);
//            NodeTree n7 = new NodeTree(7);
//
//            n1.left = n2;
//            n1.right = n3;
//
//            n2.left = n4;
//
//            n3.left = n5;
//            n3.right = n6;
//
//            n5.right = n7;
//
//            LinkedListCreation question = new LinkedListCreation();
//
//            LinkedNode res;
//
//            res = question.convertBTToLinkedLists(n1);
//            question.printBTLinkedList(res);

//            NodeTree n1 = new NodeTree(4);
//            NodeTree n2 = new NodeTree(2);
//            NodeTree n3 = new NodeTree(10);
//            NodeTree n4 = new NodeTree(1);
//            NodeTree n5 = new NodeTree(6);
//            NodeTree n6 = new NodeTree(11);
//
//            n1.left = n2;
//            n1.right = n3;
//
//            n2.left = n4;
//
//            n3.left = n5;
//            n3.right = n6;
//
//            result res = checkBST(n1);
//
//            System.out.println(res.isBST + " " + res.smallest + " " + res.biggest);
//        NodeTree n1 = new NodeTree(1);
//        NodeTree n2 = new NodeTree(2);
//        NodeTree n3 = new NodeTree(1);
//        NodeTree n4 = new NodeTree(2);
//        NodeTree n5 = new NodeTree(1);
//        NodeTree n6 = new NodeTree(-2);
//        NodeTree n7 = new NodeTree(1);
//        NodeTree n8 = new NodeTree(-2);
//        NodeTree n9 = new NodeTree(-2);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n2.left = n6;
//
//        n3.left = n4;
//        n3.right = n5;
//
//        n6.right = n7;
//
//        n4.left = n8;
//
//        n5.right = n9;
//
//
//        traversAndPrintBT(n1, 1);

//        int [][] items = new int[][]{
//                {10, 60},
//                {20, 100},
//                {30, 120}
//        };
//        Map<Bag, ResultBag> memory = new HashMap<>();
//
//        Bag initialBag = new Bag(new int[]{1, 1, 1}, 50);
//
//        binaryKNP(items, memory, initialBag);
//
//        ResultBag result = memory.get(initialBag);
//
//        System.out.println(result.value);
//        System.out.println(Arrays.toString(result.valueFlags));

//        int [][] matrix = new int[][]{
//                {1, 2, 3, 4, 5},
//                {1, 2, 3, 4, 5},
//                {16, 17, 18, 19, 20},
//                {1, 2, 3, 4, 5},
//                {16, 17, 18, 19, 20}
//        };

        int [][] matrix = new int[][]{
                {1, 2, 3},
                {3, 4, 5},
                {16, 17, 18}
        };

        System.out.println("Recursive result: [" + spiralMatrixRecursive(matrix) + "]");
        System.out.println("Iterative result: " + spiralMatrixIterative(matrix));

    }

    public static String spiralMatrixRecursive(int [][] matrix){


        if(matrix.length == 0) return "";
        if(matrix[0].length == 0) return "";

        String res = "";
        if(matrix.length == 1) {
            for(int item : matrix[0])
                res += item + ", ";

            return res;
        }

        if(matrix[0].length == 1) {
            for(int [] item : matrix)
                res += item[0] + ", ";

            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;


        int i;
        for(i = 0; i < n - 1; i++)
            res += matrix[0][i] + ", ";

        for(i = 0; i < m - 1; i++)
            res += matrix[i][n - 1] + ", ";

        for(i = n - 1; i >= 1; i--)
            res += matrix[m - 1][i] + ", ";

        for(i = m - 1; i >=1 ; i--)
        res += matrix[i][0] + ", ";

        int [][] newMatrix = new int [m - 2][n - 2];

        for(i = 1; i < m - 1; i++)
            for(int j = 1; j < n - 1; j++)
                newMatrix[i - 1][ j - 1] = matrix[i][j];

        return res.concat(spiralMatrixRecursive(newMatrix));
    }

    public static String spiralMatrixIterative(int [][] matrix){

        if(matrix.length == 0) return "";
        if(matrix[0].length == 0) return "";

        int m = matrix.length;
        int n = matrix[0].length;


        int count = Math.min(m, n) / 2;
        int i, k = 0, index = 0;
        int [] resMatrix = new int[m * n];

        while (k < count) {
            for (i = k; i < n - 1 - k; i++)
                resMatrix[index++] = matrix[k][i];

            for (i = k; i < m - 1 - k; i++)
                resMatrix[index++] = matrix[i][n - 1 - k];

            for (i = n - 1 - k; i >= 1 + k; i--)
                resMatrix[index++] = matrix[m - 1 - k][i];

            for (i = m - 1 - k; i >= 1 + k; i--)
                resMatrix[index++] = matrix[i][k];

            k++;
        }

        if(Math.min(m, n) % 2 != 0){
            if (m < n)
                for (i = count; i <= n - 1 - count; i++)
                    resMatrix[index++] = matrix[m / 2][i];
            else
                for (i = count; i <= m - 1 - count; i++)
                    resMatrix[index++] = matrix[i][n / 2];
        }
        return Arrays.toString(resMatrix);
    }

    public static void binaryKNP(int[][] items, Map<Bag, ResultBag>  memory, Bag currentBag) {

        Bag newBag = new Bag(currentBag.flags, currentBag.weight);

        if (currentBag.howManyAvail() == 1) {
            int index;
            for (index = 0; index < currentBag.flags.length; index++)
                if (currentBag.flags[index] == 1) break;

            ResultBag res = new ResultBag(0, currentBag.flags);
            if (items[index][0] > currentBag.weight)
                memory.put(newBag, res);
            else {
                res.value = items[index][1];
                res.valueFlags[index] = 1;
                memory.put(newBag, res);
            }


        } else {
            for (int i = 0; i < currentBag.flags.length; i++) {
                if (currentBag.flags[i] == 1) {

                    newBag.flags[i] = 0;

                    if (items[i][0] > currentBag.weight) {
                        if (!memory.containsKey(newBag))
                            binaryKNP(items, memory, newBag);

                        ResultBag newBagResult = memory.get(newBag);
                        newBag.flags[i] = 1;
                        memory.put(newBag, newBagResult);
                    } else {
                        ResultBag bagWithItem, bagWithoutItem;
                        if (!memory.containsKey(newBag))
                            binaryKNP(items, memory, newBag);

                        bagWithoutItem = memory.get(newBag);

                        newBag.weight = currentBag.weight - items[i][0];

                        if (!memory.containsKey(newBag))
                            binaryKNP(items, memory, newBag);

                        bagWithItem = memory.get(newBag);
                        bagWithItem.value += items[i][1];

                        if (bagWithItem.value > bagWithoutItem.value) {
                            newBag.flags[i] = 1;
                            bagWithItem.valueFlags[i] = 1;
                            bagWithItem.value += items[i][1];
                            memory.put(newBag, bagWithItem);
                        } else {
                            newBag.flags[i] = 1;
                            memory.put(newBag, bagWithoutItem);
                        }
                    }
                }
            }
        }
    }


    public static LinkedList<LinkedList<NodeTree>> checkPathSum(NodeTree root, int sum){
        LinkedList<LinkedList<NodeTree>> mainList = null, leftMainList = null, rightMainList = null;
        LinkedList<NodeTree> subMainList;

        if (root.num == sum){
            subMainList = new LinkedList<>();
            subMainList.add(root);
            mainList = new LinkedList<>();
            mainList.add(subMainList);
//            return mainList;
        }

        if(root.left == null && root.right == null)
            return mainList;
        if(root.left != null)
            leftMainList = checkPathSum(root.left, sum - root.num);
        if(root.right != null)
            rightMainList = checkPathSum(root.right, sum - root.num);

        if(leftMainList == null & rightMainList == null) return mainList;

        if(mainList == null)
            mainList = new LinkedList<>();

        if(leftMainList != null)
            for(LinkedList<NodeTree> list : leftMainList){
                list.addFirst(root);
                mainList.add(list);
            }

        if(rightMainList != null)
            for(LinkedList<NodeTree> list : rightMainList){
                list.addFirst(root);
                mainList.add(list);
            }

        return mainList;
    }

    public static void traversAndPrintBT(NodeTree root, int sum){
        if(root == null) return;

        LinkedList<NodeTree> queue = new LinkedList<>();
        LinkedList<LinkedList<NodeTree>> result;
        NodeTree currentNode;

        queue.addLast(root);

        while(!queue.isEmpty()){
            currentNode = queue.removeFirst();

            if(currentNode.left != null)
                queue.addLast(currentNode.left);

            if(currentNode.right != null)
                queue.addLast(currentNode.right);

            result = checkPathSum(currentNode, sum);

            if(result != null)
                for(LinkedList<NodeTree> list : result){
                    for(NodeTree node : list)
                        System.out.print(node.num + " ");
                    System.out.println();
                }
        }
    }

    public static result checkBST(NodeTree root) {
        if (root.left == null && root.right == null)
            return (new result(root.num, root.num, true));

        if (root.left == null) {
            result rightresult = checkBST(root.right);
            if (rightresult.isBST && root.num < rightresult.smallest)
                return (new result(root.num, rightresult.biggest, true));
            else
                return (new result(root.num, rightresult.biggest, false));
        }

        if (root.right == null) {
            result leftresult = checkBST(root.left);
            if (leftresult.isBST && root.num >= leftresult.biggest)
                return (new result(leftresult.smallest, root.num, true));
            else
                return (new result(leftresult.smallest, root.num, false));
        }

        result leftresult = checkBST(root.left);
        result rightresult = checkBST(root.right);

        if (leftresult.isBST && rightresult.isBST && root.num >= leftresult.biggest && root.num < rightresult.smallest)
            return (new result(leftresult.smallest, rightresult.biggest, true));
        else
            return (new result(leftresult.smallest, rightresult.biggest, false));
    }

    public static NodeTree convertToBST(int [] in, int firstInd, int lastInd){
        if (firstInd == lastInd) return null;
        if (firstInd == lastInd -1) return new NodeTree(in[firstInd]);

        int midInd = (lastInd + firstInd) / 2;

        NodeTree resNode = new NodeTree(in[midInd]);

        resNode.left = convertToBST(in, firstInd, midInd);
        resNode.right = convertToBST(in, midInd + 1, lastInd);

        return resNode;

    }

    public static String inorderTraversal(NodeTree root){
        String res = "";

        if (root == null) return res;

        return inorderTraversal(root.left) + String.valueOf(root.num) + inorderTraversal(root.right);

    }

    public static boolean checkLoopInLinkedList(LinkedNode root){


            if (root == null || root.next == null) return false;

            LinkedNode current1 = root, current2 = root.next, current3 = root.next.next;
            root.next = null;
            current2.next = current1;

            while(current3 != null){
                if(current3 == root) return true;

                current1 = current2;
                current2 = current3;
                current3 = current3.next;

                current2.next = current1;
            }

            return false;

        }

    public static LinkedNode reverseLinkedList(LinkedNode root){


            if (root == null || root.next == null) return root;

            LinkedNode current1 = root, current2 = root.next, current3 = root.next.next;
            root.next = null;
            current2.next = current1;

            while(current3 != null){

                current1 = current2;
                current2 = current3;
                current3 = current3.next;

                current2.next = current1;

            }


            return current2;

        }
}
