/**
 * Created by habib on 3/2/16.
 */
public class AutoGame {
    private static final long MOD = 1000000007;

    public int wayscnt(int[] a, int K) {
        int N = a.length;
        K = Math.min(N, K);
        for(int i = 0; i < N; i++)
            a[i]--;

        int[] f = new int[N];
        for(int i = 0; i < N; i++) {
            int node = i;
            for(int j = 0; j < K; j++)
                node = a[node];
            f[node]++;
        }

        long ans = 1;
        for(int i = 0; i < N; i++)
            ans *= (f[i] + 1) %  MOD;

        return (int)ans;
    }

    public static void main(String[] args){
        int[] a = new int[] {2, 3, 4, 3};
        AutoGame game = new AutoGame();
        System.out.print(game.wayscnt(a, 3));
    }


}
