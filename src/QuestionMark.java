/**
 * Created by habib on 2/14/16.
 */
import java.util.*;

public class QuestionMark{
    public void printComb(String str){

        char[] input = str.toCharArray(), output = new char[str.length()];
        Map<Integer, Integer> qIndex = new HashMap<>();
        int count = 0;

        //find ? indexes
        for(int i = 0; i < input.length; i++)
            if(input[i] == '?')
                qIndex.put(count++, i);

        int [] qNum = new int[count];

        // find combination

        double endNum = Math.pow(2, count);

        for(int i = 0; i < endNum; i++){
            //convert i-> binary and store in qNum
            int currentNum = i, currentIndex = 0;
            while(currentIndex < count){
                qNum[currentIndex] = currentNum % 2;
                currentIndex++;
                currentNum /= 2;
            }

            int currentCount = 0, currentQIndex = qIndex.get(currentCount++);
            for(int j = 0; j < input.length; j++){

                if (j == currentQIndex){
                    output[j] = Character.forDigit(qNum[currentCount - 1], 10);
                    if(currentCount < count)
                        currentQIndex = qIndex.get(currentCount++);
                    else
                        currentQIndex = input.length;
                }
                else
                    output[j] = input[j];
            }

            //print each of them
            System.out.println(Arrays.toString(output));

        }
    }
}
