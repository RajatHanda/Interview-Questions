import java.util.*;

/**
 * Created by habib on 3/3/16.
 */
public class BearChairs{


    public class Person
    {
        private String name;
        private Integer age;
        private String country;
    }
    private enum Order {Name, Age, Country}

    private class Comparators implements Comparator<Person> {

        private Order sortingBy;
        Comparators(Order o){
            sortingBy = o;
        }

        @Override
        public int compare(Person person1, Person person2) {
            switch(sortingBy) {
                case Name: return person1.name.compareTo(person2.name);
                case Age: return person1.age.compareTo(person2.age);
                case Country: return person1.country.compareTo(person2.country);
            }
            return 0;
        }
    }

    public void sortPersonsBy(Order o) {
        List<Person> persons = new ArrayList<>();  // useless line, just for clarification
        Collections.sort(persons, new Comparators(o)); // now we have a sorted list
    }

    public int[] findPositions(int[] least, int d){

        int[] res = new int[least.length];
        res[0] = least[0];

        for(int i = 1; i < least.length; i++){
            int pos = least[i];

            for(int j = 0; j < i; j++){
                if(!(pos <= res[j] - d || pos >= res[j] + d)){
                    pos = res[j] + d;
                    j = -1;
                }
            }
            res[i] = pos;
        }
        return res;
    }

    public static void main(String [] args){
        BearChairs bearChairs = new BearChairs();
        int[] chairs;
        int d;

        chairs = new int[] {1,21,11,7};
        d = 11;

        chairs = new int[] {1000000,1000000,1000000,1};
        d = 1000000 - 1;

        chairs = new int[] {250, 135, 150, 150, 97, 263, 182, 246, 258, 190, 145, 253, 119, 142, 98, 132, 136, 229, 159, 137, 238,
                231, 189, 264, 133, 224, 229, 147, 181, 162, 265, 162, 201, 98, 216, 202, 218, 254, 132, 207, 175, 133, 192, 151};

        chairs = new int[] {250, 238,
                231, 189, 264, 133, 224, 229, 147, 181, 162, 265, 162, 201, 98, 216, 202, 218, 254, 132, 207, 175, 133, 192, 151};

        d = 10;

//        Args:
//        {{250, 135, 150, 150, 97, 263, 182, 246, 258, 190, 145, 253, 119, 142, 98,
// 132, 136, 229, 159, 137, 238, 231, 189, 264, 133, 224, 229, 147, 181, 162, 265, 162, 201, 98,
// 216, 202, 218, 254, 132, 207, 175, 133, 192, 151}, 10}
//
//        Expected:
//        {250, 135, 150, 160, 97, 263, 182, 273, 283, 192, 170, 293, 119, 202, 107,
// 212, 222, 232, 303, 313, 323, 333, 343, 353, 363, 373, 383, 393, 403, 413, 423,
// 433, 443, 453, 463, 473, 483, 493, 503, 513, 523, 533, 543, 553}


        System.out.print(Arrays.toString(bearChairs.findPositions(chairs, d)));



    }
}