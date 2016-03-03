import java.util.HashSet;
import java.util.Set;

/**
 * Created by habib on 3/1/16.
 */
public class Similars {

    public int maxsim(int L, int R){

        int maxSim = 0;

        for(int i = L; i <= R; i++)
            for(int j = i + 1; j <= R; j++){
                Set<Character> found = new HashSet<>();

                String iStr = String.valueOf(i);
                String jStr = String.valueOf(j);

                for(int ii = 0; ii < iStr.length(); ii++)
                    for(int jj = 0; jj < jStr.length(); jj++)
                        if(iStr.charAt(ii) == jStr.charAt(jj) && !found.contains(jStr.charAt(jj)))
                            found.add(jStr.charAt(jj));

                maxSim = Math.max(maxSim, found.size());
            }
        return maxSim;
    }

    public static void main(String[] args){
        Similars s = new Similars();
        System.out.print(s.maxsim(444, 454));
    }
}
