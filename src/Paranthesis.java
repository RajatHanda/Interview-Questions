import java.util.*;

/**
 * Created by habib on 2/27/16.
 */
public class Paranthesis{
    public List<String> paranGenerate(int n){
        if (n <= 0) return new ArrayList<String>(){{add("");}};

        List<String> res = paranGenerate(n - 1), finalRes = new ArrayList<>();
        int size = res.size();

        for(int i = 0; i < size; i++){
            String str = res.get(i);
            if(!finalRes.contains(str + "()"))
                finalRes.add(str + "()");
            if(!finalRes.contains("()" + str))
                finalRes.add("()" + str);
            if(!finalRes.contains("(" + str + ")"))
                finalRes.add("(" + str + ")");
        }
        return finalRes;
    }

    public static void main(String [] args){

        Paranthesis para = new Paranthesis();
        List<String> res = para.paranGenerate(4);
        for(String str: res)
            System.out.println(str);
    }
}