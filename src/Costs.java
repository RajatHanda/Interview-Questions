/**
 * Created by habib on 2/13/16.
 */
public class Costs{
    public double copy, replace, delete, insert, twiddle, kill;

    public Costs(double [] costs){
//         C, R, D, I, T, K , E (END)

        copy = costs[0];
        replace = costs[1];
        delete = costs[2];
        insert = costs[3];
        twiddle = costs[4];
        kill = costs[5];
    }
}
