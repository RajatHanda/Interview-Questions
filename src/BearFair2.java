import java.util.*;

/**
 * Created by habib on 3/3/16.
 */
public class BearFair2{


    class Pair{
        public int upTo, quantity, quantityWindow, upToWindow, remainingWindow;

        public Pair(int upTo, int quantity){
            this.upTo = upTo;
            this.quantity = quantity;
        }
    }

    private enum Order {UpTo, RemainingWindow}

    private class Comparators implements Comparator<Pair> {

        private Order sortingBy;

        Comparators(Order o){
            sortingBy = o;
        }

        @Override
        public int compare(Pair p1, Pair p2) {
            switch(sortingBy) {
                case UpTo: return p1.upTo - p2.upTo;
                case RemainingWindow: return p1.remainingWindow - p2.remainingWindow;
            }
            return 0;
        }
    }


    public String isFair(int n, int b, int[] upTo, int[] quantity){

        List<Pair> bag = new ArrayList<>();

        for(int i = 0; i < upTo.length; i++)
            bag.add(new Pair(upTo[i], quantity[i]));

        bag.add(new Pair(b, n));

        Collections.sort(bag, new Comparators(Order.UpTo));

        bag.get(0).upToWindow = bag.get(0).upTo;
        bag.get(0).quantityWindow = bag.get(0).quantity;
        bag.get(0).remainingWindow = bag.get(0).upToWindow - bag.get(0).quantityWindow;

        for(int i = 1; i <= upTo.length; i++){
            bag.get(i).quantityWindow = bag.get(i).quantity - bag.get(i - 1).quantity;;
            bag.get(i).upToWindow = bag.get(i).upTo - bag.get(i - 1).upTo;
            bag.get(i).remainingWindow = bag.get(i).upToWindow - bag.get(i).quantityWindow;
        }


        if(bag.get(0).quantityWindow > bag.get(0).upTo) return "unfair";

        for(int i = 1; i <= upTo.length; i++)
            if(bag.get(i).quantityWindow < 0 || bag.get(i).upToWindow < bag.get(i).quantityWindow) return "unfair";


        Collections.sort(bag, new Comparators(Order.RemainingWindow));

        int[] remainder = new int[3];
        remainder[0] = n / 3;
        remainder[1] = n / 3;
        remainder[2] = n / 3;

        for(int i = 0; i <= upTo.length; i++){

            int quant = bag.get(i).quantityWindow;
            int currentIndex = bag.get(i).upTo;
            int remainingWindow = bag.get(i).remainingWindow;

            for(int j = 0; j < quant; j++){
                while(remainder[currentIndex % 3] == 0){
                    if(remainingWindow == 0){
                        if(bag.get(i).upTo == 74)
                            System.out.print(bag.get(i).upTo);
                        return "unfair";
                    }
                    remainingWindow--;
                    currentIndex--;
                }
                remainder[currentIndex % 3]--;
                currentIndex--;
            }
        }
        return "fair";
    }


    public static void main(String [] args){
        int n, b;
        int[] upTo, quant;

        n = 3;
        b = 5;
        upTo = new int[]{2, 3};
        quant = new int[]{1, 2};
//
//        n = 6;
//        b = 20;
//        upTo = new int[]{5, 19, 10};
//        quant = new int[]{0, 3, 2};

        n = 3;
        b = 6;
        upTo = new int[]{1,2,3,4};
        quant = new int[]{1,1,1,2};
//
        n  = 48;
        b = 1000;
        upTo = new int[]{38,450,202,685,971,661,946,226,901,353,12,937,655,108,31,908,845,908,981,896,296,987,77,790,679,
                152,412,492,286,54,214,651,59,189,107,445,728,327,438,523,527,663,825,67,523,400,65,892,587,995};
        quant = new int[]{1,19,8,32,48,31,48,8,43,13,0,46,30,8,1,45,42,45,48,43,13,48,6,40,32,8,17,20,13,3,8,30,3,8,8,19,
                37,13,19,21,21,31,41,4,21,16,4,43,23,48};

        n = 33;
        b = 863;
        upTo = new int[]{21, 68, 18, 15, 48, 66, 43, 61, 12, 51, 57, 27, 19, 24, 22, 56, 58, 63, 10, 30, 71, 40, 37, 45, 49, 34, 53, 7, 32, 74};
        quant = new int[]{11, 31, 11, 8, 22, 30, 21, 27, 8, 22, 26, 13, 11, 13, 12, 25, 27, 27, 8, 15, 31, 18, 16, 21, 22, 16, 22, 6, 15, 33};


//        {33, 863,
// {21, 68, 18, 15, 48, 66, 43, 61, 12, 51, 57, 27, 19, 24, 22, 56, 58, 63, 10, 30, 71, 40, 37, 45, 49, 34, 53, 7, 32, 74},
// {11, 31, 11, 8, 22, 30, 21, 27, 8, 22, 26, 13, 11, 13, 12, 25, 27, 27, 8, 15, 31, 18, 16, 21, 22, 16, 22, 6, 15, 33}}


        BearFair2 bearFair2 = new BearFair2();
        System.out.print(bearFair2.isFair(n, b, upTo, quant));

    }
}