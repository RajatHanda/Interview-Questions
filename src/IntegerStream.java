/**
 * Created by habib on 2/16/16.
 */
import java.util.*;

public class IntegerStream<T>{
    private List<T> is = new ArrayList<>();
    private Iterator<T> it;

    public void add(T in){
        is.add(in);
    }
    private void activateIterator(){
        it = is.iterator();
    }

    public T next(){
        T t;
        try{
            if (it == null) activateIterator();
            t = it.next();
        }
        catch (Exception e){
            return null;
        };
        return t;
    }
}
