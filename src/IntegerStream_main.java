/**
 * Created by habib on 2/17/16.
 */
public class IntegerStream_main {
    public static void main(String [] args) {

        IntegerStream<Integer> is = new IntegerStream<>();

        is.add(1);
        is.add(2);
        is.add(3);
        is.add(4);
        is.add(5);

        is.add(1);
        is.add(2);
        is.add(3);
        is.add(4);
        is.add(5);

        is.add(15);

        is.activateIterator();

        IntegerStreamSolution isSolution = new IntegerStreamSolution();
        System.out.print(isSolution.avgLast10Integer(is));
    }
}