/**
 * Created by habib on 3/2/16.
 */
public class BearPair{

    public int bigDistance(String s){
        if(s.length() == 0) return -1;
        if(s.length() == 1) return 0;

        char base = s.charAt(s.length() - 1);
        boolean found = false;
        int j1 = -1, j2 = -1;

        for(int i = 0; i < s.length() - 1 && !found; i++)
            if(base != s.charAt(i)){
                j1 = i;
                found = true;
            }

        base = s.charAt(0);
        found = false;
        for(int i = s.length() - 1; i >= 1 && !found; i--)
            if(base != s.charAt(i)){
                j2 = i;
                found = true;
            }

        if(j1 == -1 || j2 == -1) return -1;
        return(Math.max(s.length() - 1 - j1, j2));

    }

    public static void main(String [] args){

        BearPair bear = new BearPair();
//        System.out.print(bear.bigDistance("qwwwwwqw"));
        System.out.print(bear.bigDistance("oooohyeahpotato"));

    }

}