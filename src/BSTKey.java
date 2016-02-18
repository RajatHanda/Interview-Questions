/**
 * Created by habib on 2/12/16.
 */
public class BSTKey{
    public int firstIndex, lastIndex, depth;

    public BSTKey(int firstIndex, int lastIndex, int depth){
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        this.depth = depth;
    }

    public boolean equals(Object o){
        if (!(o instanceof BSTKey)) return false;

        BSTKey tmpKey = (BSTKey) o;
        return (tmpKey.firstIndex == firstIndex && tmpKey.lastIndex == lastIndex & tmpKey.depth == depth);
    }

    public int hashCode(){
        return (firstIndex * 100 + lastIndex * 10 + depth);
    }

}
