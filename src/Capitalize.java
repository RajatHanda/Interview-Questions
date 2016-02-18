import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by habib on 2/15/16.
 */
public class Capitalize{
    public String capitalize(String str){

        int index = 2;
        char[] input = str.toCharArray();

        while(index <= str.length()){
            input[index] = Character.toUpperCase(str.charAt(index));
            index *= 2 ;
        }
        return String.valueOf(input);
    }
}