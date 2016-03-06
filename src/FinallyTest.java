/**
 * Created by habib on 3/5/16.
 */
public class FinallyTest {

    public static void main(String[] args) {
        Integer i = new Integer(1);
        System.out.print(test(i));
    }

    public static int test(int result){
//        Integer result = 1;

        try{
            return result;
        }
        finally {
            return result + 1;
        }

    }
}
