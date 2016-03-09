import java.util.HashMap;
import java.util.Map;

/**
 * Created by habib on 3/9/16.
 */
public class DivisorCount {

    public int count(int n, int k)
    {
//		if(n == 1) return k;

        long MOD = 1000000007;
        long res;

        res = (long)Math.pow(k, n);
        Map<Integer, Integer> divisor = new HashMap<>();

        long count = 0;
        for(int i = 2; i <= k; i++) {
            if(!(i % 2 == 0 && divisor.containsKey(i / 2))) {
                int div = divisorCount(i);
                divisor.put(i, div);
                count += div - 1;
            }
            else{
                int log2 = 31 - Integer.numberOfLeadingZeros(i);
                int div;
                if(Math.pow(2, log2) == i){
                    div = divisor.get(i / 2) + 1;

                }
                else
                    div = divisor.get(i / 2) * 2;

                divisor.put(i, div);
                count += div - 1;

            }

        }

        res -= (n - 1) * Math.pow(k, n - 2) * count;
        return (int)(res % MOD);
    }

    private int divisorCount(int num){
        int incrementer = 1, count = 0;
        if (num % 2 != 0)
        {
            incrementer = 2; //only test the odd ones
        }
        for (int i = 1; i <= num / 2; i = i + incrementer)
        {
            if (num % i == 0)
            {
                count++;
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        DivisorCount count = new DivisorCount();

        int n, k;

        n = 2;
        k = 10;


        n = 3;
        k = 8;

        n = 10;
        k = 100000;

        System.out.print(count.count(n, k));
    }
}
