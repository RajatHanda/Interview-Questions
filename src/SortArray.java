import java.util.Arrays;

/**
 * Created by habib on 2/28/16.
 */
public class SortArray{

    public void sort(int[] a, int[] b, int length){
        int indexA = length - 1, indexB = b.length - 1, current = indexA + indexB + 1;

        while(indexA >= 0 && indexB >= 0){
            if(a[indexA] > b[indexB]){
                a[current] = a[indexA];
                indexA--;
            }
            else {
                a[current] = b[indexB];
                indexB--;
            }
            current--;
        }
        int index = (indexA == -1) ? indexA : indexB;

        if(indexB == -1)
            for(int i = indexA; i >= 0; i--){
                a[current] = a[indexA];
                indexA--;
                current--;
            }
        else
            for(int i = indexB; i >= 0; i--){
                a[current] = b[indexB];
                indexB--;
                current--;
            }
    }

    public static void main(String [] args){
        int[] b = new int[]{2, 4, 9};
        int[] a = new int[]{3, 5, 6, 7, 0, 0, 0};

        SortArray sortArray = new SortArray();
        sortArray.sort(a, b, 4);
        System.out.println(Arrays.toString(a));
    }

}