import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by habib on 3/9/16.
 */
public class CountCharacters {
    public int count(String s, int k)
    {
        if(s == null || s.equals("") || k < 0 || k >= s.length()) return 0;

        Map<Character, Integer> items = new HashMap<>();
        for(char c : s.toCharArray())
            if(!items.containsKey(c))
                items.put(c, 1);
            else
                items.put(c, items.get(c) + 1);

        int[] counts = new int[items.size()];

        int index = 0;
        for(Map.Entry<Character, Integer> e : items.entrySet())
            counts[index++] = e.getValue();

        Arrays.sort(counts);

        index = counts.length - 1;
        int remaining = k;
        int count = 1;

        while(remaining > 0 && index >= 1){
            int delta = counts[index] - counts[index - 1];
            if(delta * count <= remaining) {
                remaining -= delta * count;
                for (int i = counts.length - 1; i >= index; i--)
                    counts[i] -= delta;
                index--;
                count++;
            }
            else {
                while(remaining > 0){
                    for(int i = counts.length - 1; i >= index && remaining > 0; i--) {
                        remaining--;
                        counts[i]--;
                    }
                }
            }
        }

        if (remaining > 0 && index == 0){
            while(remaining > 0) {
                for (int i = counts.length - 1; i >= index && remaining > 0; i--) {
                    remaining--;
                    counts[i]--;
                }
            }
        }


        int sum = 0;
        for(int i : counts)
            sum += i * i;

        return sum;
    }

    public static void main(String[] args) {
        String s;
        int k;

        s = "abacaba";
        k = 3;
//        Returns: 6
//        s = "abacaba";
//        k = 1;

        s = "wersrsresesrsesrawsdsw";
        k = 11;

        s = "abababoabaobooobbbobabbaaobobooa";
        k = 26;

        CountCharacters cntChar = new CountCharacters();
        System.out.print(cntChar.count(s, k));
    }
}
