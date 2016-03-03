import java.util.*;

/**
 * Created by habib on 3/2/16.
 */
public class LIS{
    public List<Integer> findLIS(int[] num) {
        if (num == null) return new ArrayList<Integer>();
        if (num.length == 0) return new ArrayList<Integer>();

        List<List<Integer>> longestIS = new ArrayList<>();
        List<Integer> newNum = new ArrayList<>(Arrays.asList(num[num.length - 1]));
        longestIS.add(newNum);

        for (int i = num.length - 2; i >= 0; i--) {
            List<List<Integer>> tempLIS = new ArrayList<>();
            List<Integer> longestInt = new ArrayList<>();
            boolean appended = false;


            for (List<Integer> number : longestIS) {

                if (number.get(0) > num[i]) {
                    List<Integer> newInt = new ArrayList<>();
                    appended = true;
                    newInt.add(num[i]);
                    for (Integer digit : number)
                        newInt.add(digit);

                    tempLIS.add(newInt);


                } else if (!appended) {
                    int index;
                    boolean found = false;

                    for (index = 1; index < number.size() && !found; index++) {
                        if (number.get(index) > num[i]) {
                            found = true;
                            if (longestInt.size() < number.size() - index + 1) {
                                longestInt = new ArrayList<>();
                                longestInt.add(num[i]);
                                for (int k = index; k < number.size(); k++)
                                    longestInt.add(number.get(k));
                            }
                        }
                    }
                     tempLIS.add(number);
                }
            }

            if (!appended) {
                if (longestInt.size() == 0)
                    longestInt.add(num[i]);
                longestIS.add(longestInt);
            } else
                longestIS = tempLIS;
        }


        List<Integer> longest = new ArrayList<>();

        for (List<Integer> number : longestIS)
            if (number.size() > longest.size())
                longest = number;

        return longest;
    }


        public static void main(String [] args){
            int[] num;

            num = new int[] {1, 3, 2};
            num = new int[] {2, 5, 1, 8, 3};
            num = new int[] {7, 5, 6, 8};
            num = new int[] {3, 4, -1, 0, 6, 2, 3};
            num = new int[] {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};

            LIS lis = new LIS();
            List<Integer> res = lis.findLIS(num);
            for(Integer i : res)
                System.out.print(i + " ");
        }
    }