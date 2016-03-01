import java.util.*;

/**
 * Created by habib on 2/28/16.
 */
public class TimePlanner{
    public static class Slot implements Comparable<Slot>{
        int start, finish;

        public Slot(){
            start = -1;
            finish = -1;
        }

        public Slot(int s, int f){
            start = s;
            finish = f;
        }

        public int compareTo(Slot o){
            return (start - o.start);
        }
    }

    public Slot timePlanner(List<Slot> timesA, List<Slot> timesB, int dur){
        if (timesA.size() == 0 || timesB.size() == 0) return new Slot();

        Collections.sort(timesA);
        Collections.sort(timesB);

        int indexA = 0, indexB = 0;
        int start, finish;

        while(indexA < timesA.size() && indexB < timesB.size()){
            start = Math.max(timesA.get(indexA).start, timesB.get(indexB).start);
            finish = Math.min(timesA.get(indexA).finish, timesB.get(indexB).finish);

            if(finish - start >= dur)
                return new Slot(start, start + dur);

            if (finish == timesA.get(indexA).finish) indexA++;
            else indexB++;
        }

        return new Slot();
    }

    public static void main(String [] args){
        Slot s11 = new Slot(3, 5);
        Slot s12 = new Slot(1, 4);
        Slot s13 = new Slot(2, 7);

        Slot s21 = new Slot(5, 8);
        Slot s22 = new Slot(3, 4);
        Slot s23 = new Slot(2, 3);

        List<Slot> timeA, timeB;
        timeA = new ArrayList<>();
        timeB = new ArrayList<>();

        timeA.add(s11);
        timeA.add(s12);
        timeA.add(s13);

        timeB.add(s21);
        timeB.add(s22);
        timeB.add(s23);

        TimePlanner planner = new TimePlanner();
        Slot res = planner.timePlanner(timeA, timeB, 2);

        System.out.println(res.start + " - " + res.finish);
    }

}