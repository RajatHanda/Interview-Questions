/**
 * Created by habib on 2/3/16.
 */
import java.util.*;

public class collectionTest {
    public static void main(String [] args){
        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        List<String> vector = new Vector<String>();
        Stack<String> stack = new Stack<String>();
        List inkedList = new LinkedList();

        Integer intObj = 110;

        System.out.println(intObj.hashCode());

        stack.push("3");
        stack.push("2");
        stack.push("4");
        stack.push("1");

        System.out.println(stack);
        System.out.println(stack.search("1"));

        arrayList.add("c");
        arrayList.add("b");
        arrayList.add("a");


        if (!linkedList.contains("1"))
            linkedList.add("1");


        vector.add("3");
        vector.add("2");
        vector.add("3");
        vector.add("1");
        vector.add("3");

        System.out.println(vector.indexOf("3"));
        System.out.println(vector.lastIndexOf("3"));

        List<String> tmpLst = new ArrayList<String>();
        tmpLst.add("3");

//        stack

        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(vector);




        vector.remove("3");
        System.out.println(vector);

        vector.removeAll(tmpLst);

        vector.remove("3");
        System.out.println(vector);

        vector.remove("3");
        System.out.println(vector);

        System.out.println(arrayList);

        for(String str : arrayList){
            System.out.println(str);
        }

        Iterator itr = arrayList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }

        System.out.println(arrayList);

        String[] strs = {"alpha", "beta", "charlie"};
        System.out.println(Arrays.toString(strs));   // [alpha, beta, charlie]
//        Collections.

    }
}