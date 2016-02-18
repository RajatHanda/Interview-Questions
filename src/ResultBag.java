/**
 * Created by habib on 2/11/16.
 */
public class ResultBag {
    public int [] valueFlags;
    public int value;

    public ResultBag(int value, int [] valFlags) {
        this.value = value;

        this.valueFlags = new int[valFlags.length];

        for(int i = 0; i < valueFlags.length; i++)
            valueFlags[i] = 0;
    }

}
