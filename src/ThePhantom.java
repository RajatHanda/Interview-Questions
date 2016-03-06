import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by habib on 3/5/16.
 */
public class ThePhantom
{
    public int find(int[] doors, int[] droids)
    {
        class Comp implements Comparator<Integer>{
            int pivot;

            Comp(int pivot){
                this.pivot = pivot;
            }

            public int compare(Integer o1, Integer o2) {
                return Math.abs(pivot - o1) - Math.abs(pivot - o2);
            }
        }
        Integer[] d =  new Integer[droids.length];
        for(int i = 0; i < droids.length; i++)
            d[i] = droids[i];

        int max = 0;

        for(int door : doors){
            Arrays.sort(d, new Comp(door));
            max = Math.max(Math.abs(door - d[0]), max);
        }

        return max;
    }

    public static void main(String [] args){
        int[] a, b;
        a = new int[]{2,1};
        b = new int[]{4,3};

        ThePhantom phantom = new ThePhantom();
        System.out.print(phantom.find(a, b));
    }

}