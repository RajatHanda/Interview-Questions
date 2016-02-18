import java.util.List;

/**
 * Created by habib on 2/16/16.
 */
public class IntegerStreamSolution{
    public double avgLast10Integer(IntegerStream<Integer> is){

        if (is == null) return 0;

        double divisor = 1;
        int count = 0, sum = 0;
        Integer currentInteger = is.next();
        int[] listInteger = new int[10];

        while (currentInteger != null){
            listInteger[count % 10] = currentInteger;
            currentInteger = is.next();
            count++;
        }

        if (count > 10)
            divisor = 10;
        else
            divisor = count;

        for(int i : listInteger)
            sum += i;


        return sum / divisor;
    }
}