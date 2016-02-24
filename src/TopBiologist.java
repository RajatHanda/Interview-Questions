import java.util.*;

/**
 * Created by habib on 2/22/16.
 */
public class TopBiologist{

    public String findShortestNewSequence(String sequence) {
        if (sequence.length() == 0) return "A";

        String shortestStr = "";
        int strLength = 1;
        List<String> perm;

        while (strLength <= sequence.length()) {
            perm = generatePerm(strLength);
            for (String str : perm) {
                if (!hasSubstring(str, sequence))
                    return str;
            }

            strLength++;
        }
        return shortestStr;
    }

    private List<String> generatePerm(int length) {
        List<String> res = new ArrayList<>();

        if (length == 1) {
            res.add("A");
            res.add("G");
            res.add("C");
            res.add("T");
        } else {
            List<String> tempLL;

            tempLL = generatePerm(length - 1);

            for (String str : tempLL) {
                res.add("A".concat(str));
                res.add("G".concat(str));
                res.add("C".concat(str));
                res.add("T".concat(str));
            }
        }
        return res;
    }

    private boolean hasSubstring(String perm, String seq){

        int permLen = perm.length(), seqLen = seq.length();

        int i, currentIndex = 0, currentSubIndex = 0, firstIndex = -1;

        while((currentIndex + currentSubIndex) < seqLen){
            if(seq.charAt(currentIndex + currentSubIndex) == perm.charAt(currentSubIndex))
                if (currentSubIndex == permLen - 1) return true;
                else currentSubIndex++;
            else{
                currentSubIndex = 0;
                currentIndex++;
            }
        }
        return false;
    }
}
