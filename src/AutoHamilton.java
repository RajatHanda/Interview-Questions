import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by habib on 3/9/16.
 */
public class AutoHamilton {

    public String check(int[] z0, int[] z1) {
        String YES = "Exists";
        String NO = "Does not exist";

        if (z0 == null || z1 == null || z0.length == 0 || z1.length == 0) return NO;

        int[] vertex = new int[z0.length];
        boolean[][] edge = new boolean[z0.length][2];
        vertex[0] = 1;

        Stack<Integer> q = new Stack<>();
        q.push(0);

        while (!q.isEmpty()) {
            int top = q.peek();

            if (!edge[top][0]) {
                q.add(z0[top]);
                edge[top][0] = true;
                vertex[z0[top]]++;
            } else {
                if (!edge[top][1]) {
                    q.add(z1[top]);
                    edge[top][1] = true;
                    vertex[z1[top]]++;
                } else {
                    int i = 0;
                    while(i < vertex.length && vertex[i] > 0)
                        i++;

                    if (i == vertex.length) return YES;

                    top = q.pop();
                    vertex[top]--;
//                    if(!q.isEmpty())
//                        edge[q.peek()][top] = false;
                }
            }


        }
        for (int i : vertex)
            if (i == 0) return NO;

        return YES;
    }

    public static void main(String[] args) {
        int[] z0, z1;
        z0 = new int[]{1,2,0,4,4,5};
        z1 = new int[]{1,2,3,5,4,5};


        z0 = new int[]{33, 28, 16, 14, 30, 31, 31, 41, 5, 40, 23, 1, 16, 19, 33, 5, 38, 29, 27, 26, 41, 10, 30, 7, 42, 11, 33, 2, 4, 20, 18, 3, 24, 22, 8, 5, 29, 22, 25, 38, 43, 37, 43, 32};
        z1 = new int[]{34, 32, 11, 19, 20, 5, 18, 19, 35, 17, 19, 19, 13, 6, 13, 36, 30, 21, 42, 24, 6, 16, 22, 42, 21, 14, 15, 6, 12, 31, 13, 26, 29, 27, 42, 29, 23, 20, 39, 9, 31, 23, 23, 40};


        AutoHamilton auto = new AutoHamilton();
        System.out.print(auto.check(z0, z1));
    }
}
