import java.util.*;

/**
 * Created by habib on 2/28/16.
 */
public class Heap{

    public void heapSort(int[] in){

        makeHeap(in);
        int swap;

        for(int i = in.length - 1; i > 0; i--){
            swap = in[i];
            in[i] = in[0];
            in[0] = swap;
            heapify(in, 0, i);

        }

    }

    private void makeHeap(int[] in){
        int length = in.length;

        for(int i = (length - 1) / 2 ; i >= 0; i--)
            heapify(in, i, length);

    }

    private void heapify(int[] in, int startIndex, int length){
        int index = startIndex;
        int swap, swapIndex, max;
        boolean cont = true;

        while(index <= ((length - 1) / 2) && cont){
            if (2 * index + 1 == length)
                max = in[2 * index];
            else
                max = Math.max(in[2 * index], in[2 * index + 1]);

            if (in[index] < max){
                if(in[2 * index] == max)
                    swapIndex = 2 * index;
                else
                    swapIndex = 2 * index + 1;

                swap = in[index];
                in[index] = in[swapIndex];
                in[swapIndex] = swap;
                index = swapIndex;
                cont = true;
            }
            else
                cont = false;
        }
    }

    public static void main(String [] args){
        int [] in;
        in = new int[] {5, 2, 3, 7, 4, 10, 1};
//        in = new int[] {3, 2, 1};


        Heap heap = new Heap();
        heap.heapSort(in);
        System.out.print(Arrays.toString(in));
    }
}