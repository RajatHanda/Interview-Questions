/**
 * Created by habib on 2/13/16.
 */
public class ChangingCoins{

    int [] cost, changeCoins, changes, greedyResult;
    int numberOfChanges;
    int input;

    public ChangingCoins(int in, int [] changes){
        this.changes = changes;
        input = in;

        numberOfChanges = changes.length;
        cost = new int [input + 1];
        changeCoins = new int [input + 1];
        greedyResult = new int[numberOfChanges];

        cost[0] = 0;
        changeCoins[0] = -1;
    }

    public void findTheChange_DP(){

        int minCost;
        int minChange;

        for(int i = 1; i < input + 1; i++){
            minCost = Integer.MAX_VALUE;
            minChange = -1;

            for(int j = 0; j < numberOfChanges; j++)
                if( (i - changes[j]) >= 0 && minCost > cost[i- changes[j]]){
                    minCost = cost[i- changes[j]] + 1;
                    minChange = j;
                }
            cost[i] = minCost;
            changeCoins[i] = minChange;

        }
    }

    public void findTheChange_Greedy(){
        int coinIndex = numberOfChanges - 1;
        int currentCoin = changes[coinIndex];
        int remainingAmount = input;

        while(remainingAmount > 0 && coinIndex >= 0){
            if (remainingAmount >= currentCoin){
                greedyResult[coinIndex]++;
                remainingAmount -= currentCoin;
            }
            else
                currentCoin = changes[--coinIndex];

        }
    }

    public void printResults_Greedy() {
        for(int i = 0; i < greedyResult.length; i++){

            System.out.println(changes[i] + " = " + greedyResult[i]);
        }
    }


    public void printResults_DP(){
        System.out.println("Number of coins needed = " + cost[input]);
        int [] countChanges = new int [numberOfChanges];

        int currentIndex = input;
        int currentMinChange = changeCoins[currentIndex];


        while(currentMinChange != -1){
            countChanges[currentMinChange]++;
            currentIndex -=  changes[changeCoins[currentIndex]];
            currentMinChange = changeCoins[currentIndex];

        }

        for(int i = 0; i < countChanges.length; i++){

            System.out.println(changes[i] + " = " + countChanges[i]);
        }

    }


}