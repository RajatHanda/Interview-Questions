import java.util.*;

/**
 * Created by habib on 2/24/16.
 */
public class Robot{

    static class OffLimit{
        int row, col;

        OffLimit(int row, int col){
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object o){
            return(o instanceof OffLimit && row == ((OffLimit)o).row && col == ((OffLimit)o).col);
        }
    }


    public int possibleWays(int x, int y){

        if (x < 0 || y < 0) return 0;

        int count = 0;
        int [][] map = new int[y + 1][x + 1];

        for(int col = 0; col <= x ; col++)
            map[0][col] = 1;

        for(int row = 0; row <= y; row++)
            map[row][0] = 1;

        for(int row = 1; row <= y; row++)
            for(int col = 1; col <= x; col++)
                map[row][col] = map[row][col - 1] + map[row - 1][col];

        return map[y][x];
    }

    public String pathFinder(int x, int y, List<OffLimit> obs){

        if (x < 0 || y < 0) return "";
        if(obs.contains(new OffLimit(0, 0))) return "";

        //N = notReachable; R = Right; U = Up

        char [][] map = new char[y + 2][x + 2];

        for(int col = 0; col <= x + 1; col++)
            map[0][col] = 'N';

        for(int row = 2; row <= y + 1; row++)
            map[row][0] = 'N';

            map[1][0] = 'R';
        for(int row = 1; row <= y + 1; row++)
            for(int col = 1; col <= x + 1; col++)
                if(!obs.contains(new OffLimit(row - 1, col - 1))){
                    if(map[row][col - 1] != 'N')
                        map[row][col] = 'R';
                    else if (map[row - 1][col] != 'N')
                            map[row][col] = 'U';
                        else map[row][col] = 'N';
                } else {
                    map[row][col] = 'N';
                    }


        String path = "";
        int row = y + 1, col = x + 1;
        boolean notReachable = false;

        while(!notReachable && col >= 1 && row >= 1 && !(row == 1 && col == 1)){
            switch (map[row][col]){
                case 'R' : path = Character.toString('R') + path; col--;break;
                case 'U' : path = Character.toString('U') + path; row--;break;
                case 'N' : path = Character.toString('N') + path; notReachable = true;
            }
        }

        return path;
    }

    public String pathFinderDFS(int col, int row, List<OffLimit> obs){
        boolean [][] visited = new boolean[row + 1][col + 1];
        if (row == 0 && col == 0) return "";

        LinkedList<OffLimit> stack = new LinkedList<>();


        stack.add(new OffLimit(row, col));
        visited[row][col] = true;

        OffLimit current;

        while(!stack.isEmpty()){
            current = stack.getLast();

            if(current.row == 0 && current.col == 0){
                String path = "";
                for(OffLimit s : stack)
                    path += "(" + s.row + ", " + s.col + ")";
                return path;

            }

            if((current.row - 1) >= 0 && !visited[current.row - 1][current.col] && !obs.contains(current)){
                stack.add(new OffLimit(current.row - 1, current.col));
                visited[current.row - 1][current.col] = true;
            } else if((current.col - 1) >= 0 && !visited[current.row][current.col - 1] && !obs.contains(current)){
                        stack.add(new OffLimit(current.row, current.col - 1));
                        visited[current.row][current.col - 1] = true;
                    } else stack.removeLast();
        }
        return "N";
    }


    public static void main(String [] args){
        Robot rob = new Robot();
        System.out.println(rob.possibleWays(1, 2));

        List<OffLimit> offLimits = new ArrayList<>();
        OffLimit s1 = new OffLimit(1, 0);
        OffLimit s2 = new OffLimit(0, 1);

//        offLimits.add(s1);
        offLimits.add(s2);

        System.out.println(rob.pathFinder(2, 2, offLimits));
        System.out.println(rob.pathFinderDFS(2, 2, offLimits));

    }


}