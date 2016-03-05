import java.util.Arrays;

/**
 * Created by habib on 3/3/16.
 */

public class ListeningSongs {
    public int listen(int[] dur1, int[] dur2, int minutes, int T) {
        if (minutes == 0 || T == 0 || T > dur1.length || T > dur2.length) return -1;

        int time = minutes * 60;

        Arrays.sort(dur1);
        Arrays.sort(dur2);

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < T; i++) {
            sum1 += dur1[i];
            sum2 += dur2[i];
        }

        if (sum1 + sum2 > time) return -1;
        int remaining = time - (sum1 + sum2);
        int count = 2 * T;
        int index1 = T, index2 = T;

        while (index1 < dur1.length && index2 < dur2.length) {
            if (dur1[index1] < dur2[index2]) {
                remaining -= dur1[index1];
                index1++;
                if (remaining >= 0)
                    count++;
                else
                    return count;
            } else {
                remaining -= dur2[index2];
                index2++;
                if (remaining >= 0)
                    count++;
                else
                    return count;
            }
        }

        if (index1 == dur1.length) {
            while (index2 < dur2.length) {
                remaining -= dur2[index2];
                index2++;
                if (remaining >= 0)
                    count++;
                else
                    return count;
            }

        } else {
            while (index1 < dur1.length) {

                remaining -= dur1[index1];
                index1++;
                if (remaining >= 0)
                    count++;
                else
                    return count;
            }
        }

        return count;


    }
}
