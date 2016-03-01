/**
 * Created by habib on 2/27/16.
 */
public class MagicIndex{

    public int magicSlow(int[] array){
        if (array == null) return -1;

        return magicSlowSearch(array, 0, array.length -1);
    }

    public int magicSlowSearch(int[] array, int firstIndex, int lastIndex){
        if (array == null || firstIndex > lastIndex) return -1;
        if (firstIndex == lastIndex)
            if(array[firstIndex] == firstIndex) return firstIndex;
            else return -1;

        int median = (firstIndex + lastIndex) / 2;
        if(array[median] == median) return median;
        if(array[median] > median) return magicSlowSearch(array, firstIndex, median - 1);
        return magicSlowSearch(array, median + 1, lastIndex);
    }

    public int magicSlowDuplicate(int[] array){
        if (array == null) return -1;

        return magicSlowSearchDuplicate(array, 0, array.length -1);
    }

    public int magicSlowSearchDuplicate(int[] array, int firstIndex, int lastIndex){
        if (array == null || firstIndex > lastIndex) return -1;
        if (firstIndex == lastIndex)
            if(array[firstIndex] == firstIndex) return firstIndex;
            else return -1;

        int median = (firstIndex + lastIndex) / 2;
        if(array[median] == median) return median;

        int res = magicSlowSearch(array, median + 1, lastIndex);
        if(res == -1)
            if(median < array[median]) magicSlowSearch(array, firstIndex, median);
            else return magicSlowSearch(array, firstIndex, array[median]);
        return res;
    }

    public static void main(String [] args){
        int [] a;
        a = new int []{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        MagicIndex magic = new MagicIndex();

        System.out.println(magic.magicSlow(a));

        a = new int []{-10, -5, 2, 2, 2, 3, 4, 6, 9, 12, 13};
        System.out.println(magic.magicSlowDuplicate(a));

    }
}