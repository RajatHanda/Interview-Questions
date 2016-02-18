/**
 * Created by habib on 2/13/16.
 */
public class EditDistance{
    char[][] actionTable;
    double[][] costTable;
    char[] x, y;
    Costs costs;
    DNACosts dnaCosts;
    int maxRow, maxCol;

    public EditDistance(String x, String y, Costs costs){
        this.x = ("\\" + x ).toCharArray();
        this.y = ("\\" + y ).toCharArray();
        this.costs = costs;
        maxRow = this.y.length - 1;
        maxCol = this.x.length - 1;

        actionTable = new char[maxRow + 1][maxCol + 1];
        costTable = new double[maxRow + 1][maxCol + 1];

        for(int i = 0; i <= maxCol; i++){
            actionTable[maxRow][i] = 'K';
            costTable[maxRow][i] = costs.kill;
        }
        actionTable[maxRow][maxCol] = 'E';
        costTable[maxRow][maxCol] = 0;
    }

    public EditDistance(String x, String y, DNACosts dnaCosts){
        this.x = x.toCharArray();
        this.y = y.toCharArray();
        this.dnaCosts = dnaCosts;





        maxRow = this.y.length - 1;
        maxCol = this.x.length - 1;

        actionTable = new char[maxRow + 1][maxCol + 1];
        costTable = new double[maxRow + 1][maxCol + 1];

        for(int i = 0; i <= maxCol; i++){
            actionTable[maxRow][i] = 'K';
            costTable[maxRow][i] = costs.kill;
        }
        actionTable[maxRow][maxCol] = 'E';
        costTable[maxRow][maxCol] = 0;
    }

    public void convertString(){

        double minCost;
        char minAction;

        for(int row = maxRow - 1; row >= 0; row--){

            actionTable[row][maxCol] = 'I';
            costTable[row][maxCol] = costTable[row + 1][maxCol] + costs.insert;

            for(int col = maxCol - 1; col >= 0; col--){

                minCost = Integer.MAX_VALUE;
                minAction = 'E';

                //                Copy
                if(x[col + 1] == y[row + 1])
                    if(minCost > costTable[row + 1][col + 1] + costs.copy){
                        minCost = costTable[row + 1][col + 1] + costs.copy;
                        minAction = 'C';
                    }

//               Replace
                if(minCost > costTable[row + 1][col + 1] + costs.replace){
                    minCost = costTable[row + 1][col + 1] + costs.replace;
                    minAction = 'R';
                }


//                    Delete
                if(minCost > costTable[row][col + 1] + costs.delete){
                    minCost = costTable[row][col + 1] + costs.delete;
                    minAction = 'D';
                }

//                    Insert
                if(minCost > costTable[row + 1][col] + costs.insert) {
                    minCost = costTable[row + 1][col] + costs.insert;
                    minAction = 'I';
                }
//                     Twiddle
                if(col <= maxCol - 2 && row <= maxRow - 2 && x[col + 1] == y[row + 2] && x[col + 2] == y[row + 1])
                    if(minCost > costTable[row + 2][col + 2] + costs.twiddle) {
                        minCost = costTable[row + 2][col + 2] + costs.twiddle;
                        minAction = 'T';
                    }

                costTable[row][col] = minCost;
                actionTable[row][col] = minAction;

                }
            }
        }


    public void DNAAlignment(){

        double minCost;
        char minAction;

        for(int row = maxRow - 1; row >= 0; row--){

            actionTable[row][maxCol] = 'I';
            costTable[row][maxCol] = costTable[row + 1][maxCol] + costs.insert;

            for(int col = maxCol - 1; col >= 0; col--){

                minCost = Integer.MAX_VALUE;
                minAction = 'E';

//                Copy
                if(x[col + 1] == y[row + 1])
                    if(minCost > costTable[row + 1][col + 1] + costs.copy){
                        minCost = costTable[row + 1][col + 1] + costs.copy;
                        minAction = 'C';
                    }

//               Replace
                if(minCost > costTable[row + 1][col + 1] + costs.replace){
                    minCost = costTable[row + 1][col + 1] + costs.replace;
                    minAction = 'R';
                }


//                    Delete
                if(minCost > costTable[row][col + 1] + costs.delete){
                    minCost = costTable[row][col + 1] + costs.delete;
                    minAction = 'D';
                }

//                    Insert
                if(minCost > costTable[row + 1][col] + costs.insert) {
                    minCost = costTable[row + 1][col] + costs.insert;
                    minAction = 'I';
                }
//                     Twiddle
                if(col <= maxCol - 2 && row <= maxRow - 2 && x[col + 1] == y[row + 2] && x[col + 2] == y[row + 1])
                    if(minCost > costTable[row + 2][col + 2] + costs.twiddle) {
                        minCost = costTable[row + 2][col + 2] + costs.twiddle;
                        minAction = 'T';
                    }

                costTable[row][col] = minCost;
                actionTable[row][col] = minAction;

            }
        }
    }

    public void printResult(){
            System.out.println("Min Edit Distance = " + costTable[0][0]);

            int currentX = 0, currentY = 0;
            char currentAction = actionTable[currentY][currentX];
            System.out.print(currentAction);

            while(currentAction != 'E' && currentAction != 'K'){
                switch (currentAction){
                    case 'C': currentX++; currentY++; break;
                    case 'R': currentX++; currentY++; break;
                    case 'D': currentX++; break;
                    case 'I': currentY++; break;
                    case 'T': currentY += 2; currentX += 2; break;
                }
                currentAction = actionTable[currentY][currentX];

                System.out.print(" -> " + currentAction );

            }
        }
    }