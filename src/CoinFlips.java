import java.util.ArrayList;

/**
 * Created by habib on 2/22/16.
 */
import java.util.*;

public class CoinFlips{

    double headProb, tailProb;

    public double getExpectation(int[] vals, int prob){

        headProb = prob / 1000000000d;
        tailProb = 1 - headProb;
        List<Integer> valsList = new ArrayList<>();

        for(int i : vals)
            valsList.add(i);

        return dfsExpectation(valsList);
//        return dfsExpectation_revised(valsList);
    }

    private double dfsExpectation(List<Integer> vals){

        if (vals.size() < 3) return 0;

        double expectedVals = 0;

        for(int i = 1; i < vals.size() - 1; i++)
            expectedVals += Math.pow(tailProb, i) * headProb * vals.get(i - 1) * vals.get(i + 1);

        List<Integer> tempVals;

        for(int i = 1; i < vals.size() - 1; i++){
            tempVals = new ArrayList<>();
            for(int j = 0; j < vals.size(); j++)
                tempVals.add(vals.get(j));
            tempVals.remove(i);
            expectedVals += Math.pow(tailProb, i) * headProb * dfsExpectation(tempVals);
        }

        return expectedVals;
    }

    private double dfsExpectation_revised(List<Integer> vals){

        if (vals.size() < 3) return 0;

        double expectedVals = 0;

//        for(int i = 1; i < vals.size() - 1; i++)
            expectedVals += tailProb * headProb * vals.get(0) * vals.get(2);

        List<Integer> tempVals;

//        for(int i = 1; i < vals.size() - 1; i++){
            tempVals = new ArrayList<>();
            for(int j = 0; j < vals.size(); j++)
                tempVals.add(vals.get(j));
            tempVals.remove(1);
            expectedVals += dfsExpectation_revised(tempVals);
//        }

        return expectedVals;
    }

    public static void main(String [] args){

        int [] vals;
        int prob;

        vals = new int[]{2, 3, 4, 5};
        prob = 500000000;

//        vals = new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,5,6,2,6,4,3,3,8,3,2,7,9,5};
//        prob = 123456789;

//        vals = new int[]{5,1,4,2,3};
//        prob = 100000000;

//        vals = new int[]{1,2,3,4,5,6,7,8,9,10};
//        prob = 250000000;





        CoinFlips coin = new CoinFlips();
        System.out.println(coin.getExpectation(vals, prob));
    }
}
