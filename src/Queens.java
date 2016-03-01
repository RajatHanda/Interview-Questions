import java.util.*;

/**
 * Created by habib on 2/27/16.
 */
public class Queens{
    public List<int []> arrangements(int [] board, int index){

        if(index >= board.length) {
            return new ArrayList<>(Arrays.asList(board.clone()));
        }
        List<int []> finalRes = new ArrayList<>(), res;

        for(int i = 0; i < board.length; i++){
            boolean valid = true;

            for(int j = 0; j < index  && valid; j++)
                if(board[j] == i || Math.abs(board[j] - i) == Math.abs(j - index))
                    valid = false;

            if(valid){
                board[index] = i;
                res = arrangements(board, index + 1);

                for(int [] s : res)
                    finalRes.add(s);
            }
        }
        return finalRes;
    }

    public static void main(String [] args){
        Queens q = new Queens();
        List<int []> res = q.arrangements(new int[4], 0);

        for(int [] i : res)
            System.out.println(Arrays.toString(i));
    }
}