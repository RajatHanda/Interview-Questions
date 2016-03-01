import java.util.Arrays;

/**
 * Created by habib on 2/24/16.
 */
public class MinCoins{
    public  int findMinCoinsGreedy(final int[] coins, final int sum){

        if (sum <=0 || coins.length == 0) return 0;

        int count = 0;
        int [] coin = new int[coins.length];
        int remaining = sum, coinIndex = coins.length -1;

        for(int i = 0; i < coins.length; i++)
            coin[i] = coins[i];

        Arrays.sort(coin);

        while(remaining > 0 &&  coinIndex >= 0){
            count += remaining / coin[coinIndex];
            remaining %= coin[coinIndex];
            coinIndex--;
        }

        if (remaining == 0) return count;
        return 0;
    }

    public int findMinCoinsDP(final int[] coins, final int sum){

        if (sum <=0 || coins.length == 0) return 0;

        int [] count = new int [sum + 1] ;
        int minCount;
        count[0] = 0;

        for(int i = 1; i <= sum; i++){
            minCount = Integer.MAX_VALUE;
            for(int coin : coins)
                if(i - coin >= 0 ) minCount = Math.min(minCount, count[i - coin]);

            count[i] = (minCount == Integer.MAX_VALUE) ? Integer.MAX_VALUE : minCount + 1;
        }

        if(count[sum] == Integer.MAX_VALUE) return 0;
        return count[sum];
    }

    private static int findMinCoins(final int[]coins, final int sum){
        int[] calculationsCache = new int[sum+1];
        for(int i = 0; i <= sum; i++){
            calculationsCache[i] = Integer.MAX_VALUE;
        }
        calculationsCache[0]=0;/*sum 0 , can be made with 0 coins*/
        for(int i = 1; i <= sum; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && i - coins[j] >= 0 && calculationsCache[i-coins[j]]+1 < calculationsCache[i]){
                    calculationsCache[i] = calculationsCache[i-coins[j]]+1;
                }
            }
        }
        return calculationsCache[sum];
    }

    public static int findMinCoins2(final int[] coins, final int sum) {
        int[] minCoins = new int[sum + 1];
        for (int s = 1; s <= sum; s++) {
            minCoins[s] = Integer.MAX_VALUE - 1;
        }

        for (int s = 1; s <= sum; s++) {
            for (int coin : coins) {
                if (s >= coin) {
                    minCoins[s] = Math.min(minCoins[s], minCoins[s - coin] + 1);
                }
            }
        }
        return minCoins[sum];
    }

    public static void main(String [] args){

        int [] coins;
        int sum = 30;
        coins = new int []{1, 3, 5};
        coins = new int []{4, 17, 25};

        MinCoins minCoins = new MinCoins();
        System.out.println(minCoins.findMinCoinsGreedy(coins, sum));
        System.out.println(minCoins.findMinCoinsDP(coins, sum));
        System.out.println(MinCoins.findMinCoins(coins, sum));
        System.out.println(MinCoins.findMinCoins2(coins, sum));


    }
}