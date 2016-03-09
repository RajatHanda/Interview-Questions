import java.util.Arrays;

/**
 * Created by habib on 3/8/16.
 */
public class MarbleGame {

    boolean playSmartConstant (int n){
        boolean[] calc = new boolean[2];

        calc[0] = false;
        calc[1] = true;

        for(int i = 2; i <= n; i++)
            calc[i % 2] = !calc[i % 2] || !calc[(i + 1) % 2];


        return calc[n % 2];
    }

    boolean[] playSmartArray (int n) {
            boolean[] calc = new boolean[n + 1];

            calc[0] = false;
            calc[1] = true;
            calc[2] = true;

            for (int i = 3; i <= n; i++)
                calc[i] = !calc[i - 1] || !calc[i - 2];


            return calc;
        }

    int[] playSmartRecWithArray (int n) {
        int[] calc = new int[n + 1];
        for(int i = 0; i <= n; i++)
            calc[i] = -1;

        playSmartRec(n, calc);
        return calc;
    }

    boolean playSmart (int remaining){
        if (remaining == 0) return false;
        if(remaining == 1 || remaining == 2 ) return true;


        return(!playSmart(remaining - 1) || !playSmart(remaining - 2));
    }

    void playSmartRec (int remaining, int[] calc){
        if (remaining == 0) {
            calc[0] = 0;
            return;
        }

        if (remaining == 1) {
            calc[1] = 1;
            return;
        }

        if (remaining == 2) {
            calc[2] = 1;
            return;
        }

//        if (calc[remaining - 1] == -1) playSmartRec();
        playSmartRec(remaining - 1, calc);
        playSmartRec(remaining - 2, calc);
        if (calc[remaining - 1] == 1 && calc[remaining - 2] == 1)
            calc[remaining] = 0;
        else
            calc[remaining] = 1;
    }


    public static void main(String[] args) {
        MarbleGame game = new MarbleGame();
        int n = 4;


        System.out.println(game.playSmart(n));
        System.out.println(Arrays.toString(game.playSmartArray(n)));
//        System.out.println(Arrays.toString(game.playSmartConstant(n)));
        System.out.println(game.playSmartConstant(n));
        System.out.println(Arrays.toString(game.playSmartRecWithArray(n)));
        char c = 'z';
        System.out.println((char) 97);

    }
}
