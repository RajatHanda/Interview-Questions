/**
 * Created by habib on 2/29/16.
 */
public class EqualSubstrings2{
    public int get(String s){
        if(s.length() < 2) return 0;

        int count = 0;

        for(int i = 1; i < s.length(); i++)
            for(int j = 0; j < i; j++){
                String ref = String.valueOf(s.substring(j, i));
                int length = i - j;
                int k = i;
                while((k + length) <= s.length()){
                    String subString = s.substring(k, k + length);
                    if(ref.equals(subString)) {
                        count++;
                    }
                    k++;

                }
            }

        return count;
    }

    public static void main (String [] args){
        String s = "onetwothreeonetwothree";
        EqualSubstrings2 eq = new EqualSubstrings2();
        System.out.println(eq.get(s));
    }
}