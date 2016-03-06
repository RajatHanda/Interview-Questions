/**
 * Created by habib on 3/5/16.
 */
public class AttacksOfClones
{
    public int count(int[] firstWeek, int[] lastWeek)
    {
        int lowest = Integer.MAX_VALUE;

        for(int i = 0 ; i < firstWeek.length; i++){
            int j = 0;
            while(lastWeek[j] != firstWeek[i])
                j++;

            lowest = Math.min(lowest, j - i);
        }
        return lowest + 1;
    }


}