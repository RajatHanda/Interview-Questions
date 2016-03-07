import java.util.Arrays;

/**
 * Created by habib on 3/7/16.
 */
public class AdjustedBudget {

    public double calculateC(int[] g, int b){

        if(g == null || g.length == 0 || b == 0) return 0;

        int sum = 0;
        for(int i : g)
            sum += i;

        double remaining = sum - b;
        Integer[] grants = new Integer[g.length];
        for(int i = 0; i < g.length; i++)
            grants[i] = g[i];
        //sorting the array in increasing order
        Arrays.sort(grants);

        double c = 0;

        if (remaining <= 0) return c;

        // the number of grants affected
        int count = 1;

        //when c cap is found
        boolean found = false;

        // the current index of the grant helping find the cap
        int index = g.length - 1;

        while(!found){
            int delta = grants[index] - grants[index - 1];

            // checking the remaining difference can be covered with the current grant
            if(delta * count < remaining){
                remaining -= delta * count;
                count++;
            }
            else {
                found = true;
                c =  grants[index] - remaining / count;
            }
            index--;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] grants;
        int b;

        grants = new int[]{1, 2, 3, 4, 5, 8, 9};
        b = 20;

        AdjustedBudget adjust = new AdjustedBudget();
        System.out.print(adjust.calculateC(grants, b));
    }
}
