import java.util.Arrays;

/**
 * Created by habib on 2/27/16.
 */
public class Subset{

    public String [] subSetGenerate(int [] items, int length){
        if(length == 0) return new String[]{""};

        String [] res = subSetGenerate(items, length - 1), finalRes = new String[(int)Math.pow(2, length)];

        for(int i = 0; i < res.length; i++){
            finalRes[i] = res[i];
            finalRes[i + res.length] = res[i] + String.valueOf(items[length - 1]);
        }

        return finalRes;
    }

    public static void main(String [] args){
        int [] items = new int[]{1, 3, 5};
        Subset set = new Subset();

        System.out.println(Arrays.toString(set.subSetGenerate(items, items.length)));

        }
        }