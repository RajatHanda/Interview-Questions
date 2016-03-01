import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by habib on 3/1/16.
 */
class PrampSort {

    public static void main(String[] args) {
        String pramp = "Practice Makes Perfect";
        System.out.println(pramp);

        PrampSort p = new PrampSort();
        int [] in;

        in = new int []{4, 5, -9, 0, 3};
        System.out.println(Arrays.toString(in));
        p.sort(in, 3);
        System.out.println(Arrays.toString(in));

        in = new int []{4, 5, -9, 0, 3};
        p.sortWtihHeap(in, 3);
        System.out.print(Arrays.toString(in));
    }

    public void sort(int [] in, int k){
        if(in == null) return;
        if(in.length < 2 || k == 0) return;

        for(int i = 0; i < in.length - 1; i++){
            if(k + i >= in.length) k = in.length - i - 1;
            int min = in[i], minIndex = i;
            for(int j = i + 1; j <= i + k; j++)
                if(min > in[j]){
                    min = in[j];
                    minIndex = j;
                }

            int intTemp = in[i];
            in[i] = min;
            in[minIndex] = intTemp;
        }
    }

    public void sortWtihHeap(int [] in, int k){
        if(in == null) return;
        if(in.length < 2 || k == 0) return;
        Queue<Integer> h = new PriorityQueue<>();

        for(int i = 0; i <= k; i++){
            h.add(in[i]);
        }

        for(int i = k + 1; i < in.length; i++){
            in[i - k - 1] = h.poll();
            h.add(in[i]);
        }

        for(int i = 0; i < k; i++){
            in[in.length - k + i - 1] = h.poll();
        }
    }
}

