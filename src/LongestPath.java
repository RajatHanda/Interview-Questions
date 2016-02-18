/**
 * Created by habib on 2/14/16.
 */
import java.util.*;

public class LongestPath{
    public String findLongestPath(String input){
        Map<Integer, String> levels = new HashMap<>();
        int firstIndex = 0, lastIndex = 1, strLength = input.length(), maxLength, levelCount = 0, currentLevelCount;

        String maxPath, levelStr, filePath;

        while (input.charAt(lastIndex) != '\n' && lastIndex < strLength){
            lastIndex++;
        }

        levels.put(levelCount, input.substring(firstIndex, lastIndex));

        maxLength = 0;
        maxPath = "";

        while(lastIndex < strLength){
            lastIndex++;


            currentLevelCount = 0;

            while (input.charAt(lastIndex) == '\t'){
                currentLevelCount++;
                lastIndex++;
            }

            firstIndex = lastIndex;

            while (lastIndex < strLength && input.charAt(lastIndex) != '\n' ){
                lastIndex++;
            }


            levelStr = input.substring(firstIndex, lastIndex);

            if(isFileName(levelStr)){
                filePath = "";

                for(int i = 0; i < currentLevelCount; i++)
                    filePath += levels.get(i) + "/";

                filePath += levelStr;

                if(filePath.length() > maxLength){
                    maxLength = filePath.length();
                    maxPath = filePath;
                }
            }
            else {
                levelCount = currentLevelCount;
                levels.put(levelCount, levelStr);
            }
        }

        return maxPath;
    }

    public boolean isFileName(String input){

        for(int i = 0; i < input.length(); i++)
            if(input.charAt(i) == '.') return true;

        return false;
    }
}
