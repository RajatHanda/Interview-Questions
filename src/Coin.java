import java.util.*;

/**
 * Created by habib on 2/27/16.
 */
public class Coin{
    public int representWays(int n){
        if (n < 1) return 0;

        int [] ways = new int [n + 1];
        ways[0] = 1;

        for(int i = 1; i <= n; i++){
            ways[i] += ways[i - 1];
            if(i % 5 == 0) ways[i]++;
            if(i % 10 == 0) ways[i]++;
            if(i % 25 == 0) ways[i]++;
        }

        return ways[n];
    }

    public List<String> representWaysDP(int n){
        if (n < 1) return new ArrayList<String>(){{add("");}};

        List<String> [] ways = new ArrayList [n + 1];
        ways[0] = new ArrayList<String>(){{add("");}};

        for(int i = 1; i <= n; i++){
            ways[i] = new ArrayList<String>();
            for(String str : ways[i - 1])
                ways[i].add(str + "1");

            if(i >= 5)
                for(String str : ways[i - 5])
                    ways[i].add(str + "5");

            if(i >= 10)
                for(String str : ways[i - 10])
                    ways[i].add(str + "10");

            if(i >= 25)
                for(String str : ways[i - 25])
                    ways[i].add(str + "25");
        }

        return ways[n];
    }




    public int makeChange(int n, int denom) {
         int next_denom = 0;
         switch (denom) {
             case 25:
                 next_denom = 10;
                 break;
             case 10:
                 next_denom = 5;
                 break;
             case 5:
                 next_denom = 1;
                 break;
             case 1:
                 return 1;
         }

         int ways = 0;
         for (int i = 0; i * denom <= n; i++)
             ways += makeChange(n - i * denom, next_denom);
         return ways;
     }



    public static void main(String [] args){
        Coin c = new Coin();

        System.out.println(c.representWays(15));
        System.out.println(c.makeChange(20, 25));
        List<String> res = c.representWaysDP(15);
        for(String s : res)
            System.out.println(s);
    }
}