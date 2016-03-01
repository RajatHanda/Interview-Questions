/**
 * Created by habib on 2/27/16.
 */
public class Boxes{
    public boolean arrangeBoxesToTallest(double[] w, double[] l, double[] h, boolean [] placed, int index){
        if(w.length != l.length || w.length != h.length || w.length == 0 ||
                index < 0 || index > w.length)
            return false;


        if(w.length == index){
            boolean firstFound = false, valid = true;
            int first = 0;

            for(int i = 0; i < w.length && !firstFound; i++)
                if(placed[i]){
                    firstFound = true;
                    first = i;
                }

            if (!firstFound) return false;

            for(int i = first + 1; i < w.length && valid; i++)
                if(placed[i]){
                    if(w[first] > w[i] && l[first] > l[i])
                        first = i;
                    else
                        valid = false;
                }

            return valid;
        }


        double h1 = 0, h2 = 0;
        boolean [] res = new boolean[w.length];
        boolean s1, s2;

        placed[index] = true;
        s1 = arrangeBoxesToTallest(w, l, h, placed, index + 1);

        if (s1){
            res = placed.clone();
            for(int i = 0; i < w.length; i++)
                if(placed[i])
                    h1 += h[i];
        }

        placed[index] = false;
        s2 = arrangeBoxesToTallest(w, l, h, placed, index + 1);

        if (s2)
            for(int i = 0; i < w.length; i++)
                if(placed[i])
                    h2 += h[i];

        if(!s1 && !s2) return false;

        if (s1 && s2) {
            if (h1 > h2) System.arraycopy(res, 0, placed, 0, res.length);
        }
        else
            System.arraycopy(res, 0, placed, 0, res.length);

        return true;
    }

    public static void main(String [] args){
        Boxes box = new Boxes();

        double[] w, l , h;
        w = new double[] {3, 2, 1};
        l = new double[] {0.1, 1.2, 0.1};
        h = new double[] {1.3, 1.2, 1.1};

//        w = new double[] {3, 2};
//        l = new double[] {0.03, 0.2};
//        h = new double[] {1.3, 1.2};

        boolean [] placed = new boolean[w.length];
        if(box.arrangeBoxesToTallest(w, l, h, placed, 0))
            for(int i = 0; i < w.length; i++)
                if(placed[i]) System.out.print(i + " ");

    }

}