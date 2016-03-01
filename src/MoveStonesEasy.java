/**
 * Created by habib on 2/29/16.
 */
import java.util.*;

public class MoveStonesEasy
{
    public int get(int[] a, int[] b)
    {
        if(a == null || b == null) return -1;
        if(a.length != b.length) return -1;

        int sumA = 0, sumB = 0;

        for(int ai : a)
            sumA += ai;

        for(int ai : b)
            sumB += ai;

        if(sumA != sumB) return -1;


        LinkedList<int []> q = new LinkedList<>();


        q.add(a.clone());
        int level = 0;

        while(!q.isEmpty()){
            int [] current = q.getLast();
            boolean equal = true;

            for(int i = 0; i < current.length & equal; i++)
                if(current[i] != b[i])
                    equal = false;

            if (equal) return level;




        }
        return -1;
    }

    public static void main(String [] args){


    }
}