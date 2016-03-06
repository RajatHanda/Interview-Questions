import java.util.Arrays;

/**
 * Created by habib on 3/5/16.
 */
public class RevengeOfTheSith
{
    public int move(int[] steps, int T, int D)
    {
        if(steps == null || steps.length == 0) return 0;

        int lifePoints = 0;
        if(T > steps.length - 1) T = steps.length - 1;

        Arrays.sort(steps);

        int sum = 0;
        for(int i : steps)
            sum += i;

        int floor = sum;
        for(int i = 0; i <= T; i++ )
            floor -= steps[steps.length - 1 - i];

        if (T > 0){
            int increment = (sum - floor) / (T + 1);
            if (increment > D) {
                lifePoints = (increment - D) * (increment - D) * T;
                lifePoints += (sum - T * increment - floor - D) * (sum - T * increment - floor - D);

            }
            else
                return 0;
        }

        int remaining = steps.length - T - 2;

        while(remaining >= 0 && (steps[remaining] - D) > 0) {
            lifePoints += (steps[remaining] - D) * (steps[remaining] - D);
            remaining--;
        }

        return lifePoints;
    }

    public static void main(String[] args) {
        RevengeOfTheSith sith = new RevengeOfTheSith();
        int[] steps;
        int T, D;

        steps = new int[]{2,3,5};
        T = D = 1;

        steps = new int[]{50, 22, 63, 28, 91, 60, 64, 27, 41, 27, 73, 37, 12};
        T = 3;
        D = 69;

        steps = new int[]{1, 90, 100, 105};
        T = 2;
        D = 1;

//        Expected:
//        22598

        System.out.println(sith.move(steps, T, D));
        System.out.println(101 * 101 + 102 * 102 + 89 * 89);
        System.out.println(9);
        System.out.println(Math.sqrt(22598 / 3));
        System.out.println(105 * 105 + 3 * 63 * 63);

    }

}
