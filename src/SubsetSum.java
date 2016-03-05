/**
 * Created by habib on 3/3/16.
 */
public class SubsetSum{
    String[] results;
    public String findSubsetSum(int[] a, int total){
        if(a == null || a.length == 0 || total < 0) return "";
        if(a.length == 1)
            if (a[0] == total)
                return " " + String.valueOf(a[0]);
            else
                return "";

        return findSubsetSumRec(a, total, 0);
    }

    private String findSubsetSumRec(int[] a, int total, int index){
        String resWO, resW;
        if(a.length - 1 == index)
            if (a[index] == total)
                return " " + String.valueOf(a[index]);
        else
            return "";

        resWO = findSubsetSumRec(a, total, index + 1);

        if(a[index] > total)
            return resWO;

        if(a[index] == total)
            return " " + String.valueOf(a[index]);

        if(!resWO.equals(""))
            return resWO;

        resW = findSubsetSumRec(a, total - a[index], index + 1);

        if(resW.equals(""))
            return "";

        return " " + String.valueOf(a[index]) + resW;
    }

    public static void main(String [] args){
        int[] a = new int[]{2, 3, 7, 8, 10};
        int total = 10;

        System.out.println(String.valueOf(new char[]{'a', 'b', 'c'}));
        System.out.println(Integer.parseInt("12", 3));

        System.out.println("hello".toCharArray());
        char i = Character.forDigit(8, 9);
        System.out.println(i);

        System.out.println(Integer.parseInt(Integer.toString(99, 2)));

        SubsetSum subset = new SubsetSum();
        System.out.print(subset.findSubsetSum(a, total));

    }
}