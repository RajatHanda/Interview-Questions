/**
 * Created by habib on 2/15/16.
 */
public class Item implements Comparable<Item>{
    int row, col, val;

    public Item(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public int compareTo(Item o){
        return (val - o.val);
    }
}