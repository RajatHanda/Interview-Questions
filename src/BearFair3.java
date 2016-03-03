

import java.util.*;

/**
 * Created by habib on 3/3/16.
 */
public class BearFair3 {

    Map<MapItems, Boolean> dp = new HashMap<>();
    public class MapItems{
            private int r0, r1, r2;

            public MapItems(int r0, int r1, int r2){
                this.r0 = r0;
                this.r1 = r1;
                this.r2 = r2;
            }
        @Override
        public boolean equals(Object o) {
                return(o instanceof MapItems &&
                        ((MapItems)o).r0 == r0 &&
                        ((MapItems)o).r1 == r1 &&
                        ((MapItems)o).r2 == r2 );
            }


        @Override
        public int hashCode(){
                return (r0 + 1) * (r1 + 1) * (r2 + 1);

            }

        }




        class Pair {

            public int upTo, quantity;

            public Pair(int upTo, int quantity) {
                this.upTo = upTo;
                this.quantity = quantity;
            }
        }



    private enum Order {UpTo, RemainingWindow}

    private class Comparators implements Comparator<Pair> {

        private Order sortingBy;

        Comparators(Order o) {
            sortingBy = o;
        }

        @Override
        public int compare(Pair p1, Pair p2) {
            int res = -1;
            switch (sortingBy) {
                case UpTo:
                    res = p1.upTo - p2.upTo;
            }
            return res;
        }
    }


    public String isFair(int n, int b, int[] upTo, int[] quantity) {

        List<Pair> bag = new ArrayList<>();

        for (int i = 0; i < upTo.length; i++)
            bag.add(new Pair(upTo[i], quantity[i]));

        int max = 0;
        for(int u : upTo)
            max = Math.max(u, max);

        if(max < b) bag.add(new Pair(b, n));

        Collections.sort(bag, new Comparators(Order.UpTo));

        if (isFairRec(bag, n / 3, n / 3, n / 3, bag.size() - 1)) return "fair";
        return "unfair";
    }

    private boolean isFairRec(List<Pair> bag, int rem0, int rem1, int rem2, int index) {
        if (index == 0) {
            boolean res = false;
            int[] limit = new int[3];
            for (int i = 1; i <= bag.get(0).upTo; i++)
                limit[i % 3]++;

            if (limit[0] < rem0 || limit[1] < rem1 || limit[2] < rem2) {
                res = false;

            }
            else
                res = (bag.get(0).quantity == rem0 + rem1 + rem2);

            dp.put(new MapItems(rem0, rem1, rem2), res);
            return res;
        }

        int quant = bag.get(index).quantity - bag.get(index - 1).quantity;
        if ( quant > rem0 + rem1 + rem2) return false;

        int[] limit = new int[3];

        for (int i = bag.get(index - 1).upTo + 1; i <= bag.get(index).upTo; i++)
            limit[i % 3]++;

//        if (limit[0] < rem0 || limit[1] < rem1 || limit[2] < rem2)
//            return false;
        boolean res = false;
        if(!dp.containsKey(new MapItems(rem0, rem1, rem2))) {
            for (int zero = 0; zero <= Math.min(rem0, limit[0]); zero++)
                for (int one = 0; one <= Math.min(rem1, limit[1]); one++)
                    for (int two = 0; two <= Math.min(rem2, limit[2]); two++)
                        if (zero + one + two == quant) {
                            if (!dp.containsKey(new MapItems(rem0 - zero, rem1 - one, rem2 - two)))
                                res = res || isFairRec(bag, rem0 - zero, rem1 - one, rem2 - two, index - 1);
                            else
                                res = res || dp.get(new MapItems(rem0 - zero, rem1 - one, rem2 - two));
                        }
            dp.put(new MapItems(rem0, rem1, rem2), res);
        }
        else
            res = dp.get(new MapItems(rem0, rem1, rem2));

        return res;
    }

    public static void main(String [] args){
        int n, b;
        int[] upTo, quant;


        n = 3;
        b = 4;
        upTo = new int[]{2, 3};
        quant = new int[]{1, 2};


        n = 6;
        b = 20;
        upTo = new int[]{5, 19, 10};
        quant = new int[]{0, 3, 2};
//
        n = 3;
        b = 6;
        upTo = new int[]{1,2,3,4};
        quant = new int[]{1,1,1,2};
////
        n  = 48;
        b = 1000;
        upTo = new int[]{38,450,202,685,971,661,946,226,901,353,12,937,655,108,31,908,845,908,981,896,296,987,77,790,679,
                152,412,492,286,54,214,651,59,189,107,445,728,327,438,523,527,663,825,67,523,400,65,892,587,995};
        quant = new int[]{1,19,8,32,48,31,48,8,43,13,0,46,30,8,1,45,42,45,48,43,13,48,6,40,32,8,17,20,13,3,8,30,3,8,8,19,
                37,13,19,21,21,31,41,4,21,16,4,43,23,48};
//
        n = 33;
        b = 863;
        upTo = new int[]{21, 68, 18, 15, 48, 66, 43, 61, 12, 51, 57, 27, 19, 24, 22, 56, 58, 63, 10, 30, 71, 40, 37, 45, 49, 34, 53, 7, 32, 74};
        quant = new int[]{11, 31, 11, 8, 22, 30, 21, 27, 8, 22, 26, 13, 11, 13, 12, 25, 27, 27, 8, 15, 31, 18, 16, 21, 22, 16, 22, 6, 15, 33};

//        n  = 48;
//        b = 1000;
//        upTo = new int[]{70, 70, 86, 103, 134, 150, 164, 182, 208, 214, 215, 217, 274, 334, 338, 371, 407, 418, 419, 446, 557,
//                587, 590, 617, 656, 672, 699, 711, 716, 722, 751, 770, 778, 782, 787, 806, 815, 831, 856, 865, 901, 911, 922, 937, 939, 947, 948, 975};
//        quant = new int[]{1, 2, 2, 3, 4, 4, 5, 5, 5, 7, 7, 9, 10, 10, 10, 11, 11, 13, 13, 13, 13, 18, 21, 21, 22, 22,
//                22, 23, 24, 26, 26, 27, 28, 29, 29, 30, 31, 32, 33, 41, 43, 43, 46, 47, 47, 47, 47, 48};

        BearFair3 bearFair3 = new BearFair3();
        System.out.print(bearFair3.isFair(n, b, upTo, quant));

    }

}