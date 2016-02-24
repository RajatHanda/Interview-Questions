/**
 * Created by habib on 2/22/16.
 */
public class FriendlyRobot{

    public int findMaximumReturns(String instructions, int changesAllowed){
        int x = 0, y = 0, count = 0, index = 0, changes = 0;
        char[] instr = instructions.toCharArray();

        while(index < instr.length - 1 && changes <= changesAllowed){
            switch (instr[index]){
                case 'U': if (instr[index + 1] != 'D') instr[index + 1] = 'D'; changes++; break;
                case 'D': if (instr[index + 1] != 'U') instr[index + 1] = 'U'; changes++; break;
                case 'R': if (instr[index + 1] != 'L') instr[index + 1] = 'L'; changes++; break;
                case 'L': if (instr[index + 1] != 'R') instr[index + 1] = 'R'; changes++; break;
            }
            index += 2;
        }



        for(int i = 0; i < instr.length; i++){
            switch (instr[i]){
                case 'U': y++; break;
                case 'D': y--; break;
                case 'R': x++; break;
                case 'L': x--; break;
            }

            if(x == 0 && y == 0) count++;
        }

        return count;

    }


}