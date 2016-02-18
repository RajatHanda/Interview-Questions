import java.util.Iterator;

/**
 * Created by habib on 2/15/16.
 */
import java.util.*;

public class SuperIterator<Type> implements Iterable<Type> {

    List<List<Iterator<Type>>> listOfLists;
    int listNum, listIndex, totalIterator, lastListIndex, lastItIndex, maxListSize;
    int[] itSize, itIndex;

    public SuperIterator(List<List<Iterator<Type>>> listOfLists) {
        this.listOfLists = listOfLists;
        listNum = listOfLists.size();
        itSize = new int[listNum];
        itIndex = new int[listNum];
        listIndex = 0;
        lastListIndex = 0;
        lastItIndex = 0;
        maxListSize = 0;

        for (int i = 0; i < listNum; i++) {
            itSize[i] = listOfLists.get(i).size();
            itIndex[i] = -1;
            if(maxListSize < itSize[i])
                maxListSize = itSize[i];
        }
        itIndex[0] = 0;
        totalIterator = maxListSize * listNum;

    }


    public Iterator<Type> iterator() {

        Iterator<Type> it =  new Iterator<Type>() {

            private boolean goToNextIndex() {
                int count = 0;

                do {
//                    itIndex[listIndex]++;
                    listIndex++;

                    if (listIndex == listNum) {
                        listIndex = 0;

                    }
                    itIndex[listIndex]++;
                    if (itIndex[listIndex] == itSize[listIndex])
                            itIndex[listIndex] = 0;

                        count++;

                }while(!listOfLists.get(listIndex).get(itIndex[listIndex]).hasNext() && (count < totalIterator));

                return (count < totalIterator);
            }

            public boolean hasNext() {

                return (listOfLists.get(listIndex).get(itIndex[listIndex]).hasNext());
            }

            public Type next() {
                Type t = listOfLists.get(listIndex).get(itIndex[listIndex]).next();
                lastListIndex = listIndex;
                lastItIndex = itIndex[listIndex];
                goToNextIndex();


                return t;
            }

            public void remove() {
                listOfLists.get(lastListIndex).get(lastListIndex).remove();
            }
        };

        return it;
    }
}
