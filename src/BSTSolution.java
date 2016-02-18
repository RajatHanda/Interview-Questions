import java.util.*;

/**
 * Created by habib on 2/12/16.
 */
public class BSTSolution {
    Map<BSTKey, BSTResult> memory = new HashMap<>();
    BSTResult finalResult;
    double[] p, q;
    double [][][] costTable;
    int [][][] indexTable;
    int keyNum;

    public BSTSolution(double[] p, double[] q) {
        this.p = p;
        this.q = q;
        keyNum = p.length;
    }

    public void runBST() {
        BSTKey initKey = new BSTKey(0, keyNum, 0);

        MBSTRecursive(initKey);
        printResult(initKey);


        MBSTIterative();
        System.out.println(costTable[0][keyNum - 1][0]);
        System.out.println(printNodesInIterativeMode(0, keyNum - 1, 0));
    }

    public String printNodesInIterativeMode(int firstIndex, int lastIndex, int depth){

        int midNode = indexTable[firstIndex][lastIndex][depth];

        if(firstIndex == lastIndex) return "(" + midNode + ")";

        if(midNode == firstIndex) return ("(" + String.valueOf(midNode) + printNodesInIterativeMode(midNode + 1, lastIndex, depth + 1) + ")");

        if(midNode == lastIndex) return ("(" + printNodesInIterativeMode(firstIndex, midNode - 1, depth + 1) +  String.valueOf(midNode) + ")");

        return "(" + printNodesInIterativeMode(firstIndex, midNode - 1, depth + 1)
                + "" + String.valueOf(midNode) + "" +
                printNodesInIterativeMode(midNode + 1, lastIndex, depth + 1) + ")" ;


    }

    public void MBSTIterative() {

        int nodeNum = p.length;
        costTable = new double[nodeNum][nodeNum][nodeNum];
        indexTable = new int[nodeNum][nodeNum][nodeNum];


        for(int i = 0; i < nodeNum; i++)
            for(int d = 0; d < nodeNum; d++){
                costTable[i][i][d] = (d + 1) * (q[i] + q[i + 1]) + d * p[i];
                indexTable[i][i][d] = i;
            }

        int i = 0, j = 1, minCostIndex, count = 1;
        double tempCost, minCost;

        while(count < nodeNum){

            for(int d = 0; d < nodeNum - count; d++){

                minCost = q[i] * (d + 1) + p[i] * d + costTable[i + 1][j][d + 1];
                minCostIndex = i;

                for(int k = i + 1; k < j; k++){
                    tempCost = costTable[i][k - 1][d + 1] +  costTable[k + 1][j][d + 1] + p[k] * d;
                    if (minCost > tempCost){
                        minCost = tempCost;
                        minCostIndex = k;
                    }
                }

                tempCost = costTable[i][j - 1][d + 1] + q[j + 1] * (d + 1) + p[j] * d;
                if (minCost > tempCost){
                    minCost = tempCost;
                    minCostIndex = j;
                }
                costTable[i][j][d] = minCost;
                indexTable[i][j][d] = minCostIndex;
            }



            j = count + ++i;
            if (j >= keyNum ){
                count++;
                i = 0;
                j = count;
            }
        }
    }





    public void MBSTRecursive(BSTKey rootKey) {

        if (!memory.containsKey(rootKey)) {
            if (rootKey.firstIndex == rootKey.lastIndex) return;

            BSTKey newKey;
            BSTResult newResult, newResultLeft, newResultRight;
            int minCostIndex,
                    firstIndex = rootKey.firstIndex,
                    lastIndex = rootKey.lastIndex,
                    depth = rootKey.depth;

            if (firstIndex == lastIndex - 1)
                if (!memory.containsKey(rootKey)) {
                    newKey = new BSTKey(firstIndex, lastIndex, depth);
                    newResult = new BSTResult(firstIndex, depth * p[firstIndex] + (depth + 1) * (q[firstIndex] + q[lastIndex]));

                    memory.put(newKey, newResult);
                    return;
                }

            double minCost, tempMinCost;

            newKey = new BSTKey(firstIndex + 1, lastIndex, depth + 1);
            if (!memory.containsKey(newKey))
                MBSTRecursive(newKey);

            newResult = memory.get(newKey);
            minCost = newResult.minCost + rootKey.depth * p[firstIndex] + (depth + 1) * q[firstIndex];
            minCostIndex = firstIndex;

            for (int i = firstIndex + 1; i < lastIndex - 1; i++) {

                newKey = new BSTKey(firstIndex, i, depth + 1);

                if (!memory.containsKey(newKey))
                    MBSTRecursive(newKey);

                newResultLeft = memory.get(newKey);

                newKey = new BSTKey(i + 1, lastIndex, depth + 1);

                if (!memory.containsKey(newKey))
                    MBSTRecursive(newKey);

                newResultRight = memory.get(newKey);

                tempMinCost = newResultLeft.minCost + newResultRight.minCost + depth * p[i];
                if (minCost > tempMinCost) {
                    minCost = tempMinCost;
                    minCostIndex = i;
                }
            }

            newKey = new BSTKey(firstIndex, lastIndex - 1, depth + 1);
            if (!memory.containsKey(newKey))
                MBSTRecursive(newKey);

            newResult = memory.get(newKey);
            tempMinCost = newResult.minCost + depth * p[lastIndex - 1] + (depth + 1) * q[lastIndex];

            if (minCost > tempMinCost) {
                minCost = tempMinCost;
                minCostIndex = lastIndex - 1;
            }

            newKey = new BSTKey(firstIndex, lastIndex, depth);
            newResult = new BSTResult(minCostIndex, minCost);
            memory.put(newKey, newResult);

        }

    }


    public void printResult(BSTKey initKey) {

        System.out.println("Minimum Cost = " + memory.get(initKey).minCost);

        System.out.println(printResultNodes(initKey));
    }

    public String printResultNodes(BSTKey rootKey) {

        if (rootKey.firstIndex == rootKey.lastIndex) return "";
        BSTKey leftKey = new BSTKey(rootKey.firstIndex, memory.get(rootKey).minCostIndex, rootKey.depth + 1);
        BSTKey rightKey = new BSTKey(memory.get(rootKey).minCostIndex + 1, rootKey.lastIndex, rootKey.depth + 1);

        return ("(" + printResultNodes(leftKey) + memory.get(rootKey).minCostIndex + printResultNodes(rightKey) + ")");

    }
}