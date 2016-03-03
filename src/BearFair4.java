import java.util.*;

/**
 * Created by habib on 3/3/16.
 */
public class BearFair4{

    Map<MapItems, Boolean> dp = new HashMap<>();
    class MapItems{
        int r0, r1, r2;

        MapItems(int r0, int r1, int r2){
            this.r0 = r0;
            this.r1 = r1;
            this.r2 = r2;
        }
        public boolean equals(Object o){
            return(o instanceof MapItems &&
                    ((MapItems)o).r0 == r0 &&
                    ((MapItems)o).r1 == r1 &&
                    ((MapItems)o).r2 == r2 );
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
}