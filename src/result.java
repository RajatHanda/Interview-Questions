/**
 * Created by habib on 2/6/16.
 */
public class result {
    public int row, col, col_size, row_size;

    public int smallest, biggest;
    public boolean isBST;

    public result(int smallest, int biggest, boolean isBST){
        this.biggest = biggest;
        this.smallest = smallest;
        this.isBST = isBST;
    }

}
