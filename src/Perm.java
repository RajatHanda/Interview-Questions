import java.util.*;

/**
 * Created by habib on 2/27/16.
 */


public class Perm{
    public List<String> permGenerate(String str, int index){

        if(str == null || str.equals("") || index < 0 || index > str.length() - 1) return new ArrayList<>(Arrays.asList(""));
        if(index == str.length() - 1) return new ArrayList<>(Arrays.asList(str));

        List<String> res = permGenerate(str, index + 1);
        int length = res.size();

        for(int i = 0; i < length; i++)
            for(int j = index + 1; j < str.length(); j++){
                char[] tmp = res.get(i).toCharArray();
                char tmpChar = tmp[j];
                tmp[j] = tmp[index];
                tmp[index] = tmpChar;
                res.add(String.valueOf(tmp));
            }

        return res;

    }

    public static void main(String [] args){
        String s = "abc";
        Perm perm = new Perm();

        List<String> res = perm.permGenerate(s, 0);

        for(String str : res)
            System.out.println(str);
    }
}