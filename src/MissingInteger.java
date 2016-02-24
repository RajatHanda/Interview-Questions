import java.util.*;

/**
 * Created by habib on 2/24/16.
 */
public class MissingInteger{
    public int firstMissingInteger(int[] nums){
        int res = 1;

        if (nums == null) return res;

        Set<Integer> positiveSet = new HashSet<>();
        int minVal = 1;

        for(int i : nums){
            if (i > 0){
                positiveSet.add(i);
                minVal = Math.min(minVal, i);
            }
        }

        if(!positiveSet.contains(minVal)) return minVal;
        for(int i : positiveSet){
            if(!positiveSet.contains(minVal + 1)) return (minVal + 1);
            minVal++;
        }
        return (minVal);
    }


    public static void main(String [] args){
        int [] in;
        in = new int[] {3, 2, 1};
//        in = new int[] {1, 2, 0};
//        in = new int[] {3, 4, -1, 1};
        in = new int[] {-1, 0};

        MissingInteger missInt = new MissingInteger();
        System.out.println(missInt.firstMissingInteger(in));
    }
}