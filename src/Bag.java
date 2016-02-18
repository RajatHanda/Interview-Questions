/**
 * Created by habib on 2/11/16.
 */
public class Bag{
    public int [] flags;
    public int weight;


    public Bag(){
    }

    public Bag(int [] flags, int weight){
        this.flags = new int[flags.length];

        for(int i = 0; i < flags.length; i++)
            this.flags[i] = flags[i];
        this.weight = weight;
    }

    public int howManyAvail(){
        int count = 0;
        for(int i : flags)
            if (i == 1) count++;

        return count;
    }

    public boolean equals(Object in){
        if (!(in instanceof Bag)) return false;

        if (flags.length != ((Bag)in).flags.length) return false;

        for(int i = 0; i < flags.length; i++)
            if(flags[i] != ((Bag)in).flags[i])
                return false;

        return (weight == ((Bag)in).weight);
    }

    public int hashCode(){
        int sum = 0;
        for(int i = 0; i < flags.length; i++)
            sum = 10 * sum + flags[i];

        return sum;
    }

}