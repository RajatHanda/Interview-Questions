/**
 * Created by habib on 3/1/16.
 */
public class SubString{

    public String shortestSubString(String s, String t1, String t2, String t3){
        if(s == null || t1 == null || t2 == null || t3 == null) return "";
        int lengthT1 = t1.length(), lengthT2 = t2.length(), lengthT3 = t3.length();
        if( lengthT1 > s.length() ||  lengthT2 > s.length() || lengthT3 > s.length()) return "";

        int indexT1, indexT2, indexT3;

        indexT1 = checkSubString(s, t1);
        if(indexT1 != -1){
            indexT2 = checkSubString(s, t2);
            if(indexT2 != -1){
                indexT3 = checkSubString(s, t3);
                if(indexT3 != -1){
                    int startingIndex, finishingIndex;
                    startingIndex = Math.min(indexT1, Math.min(indexT2, indexT3));
                    finishingIndex = Math.max(indexT1 + lengthT1, Math.max(indexT2 + lengthT2, indexT3 + lengthT3));
                    return s.substring(startingIndex, finishingIndex);
                }
            }
        }
        return "";
    }

    private int checkSubString(String base, String a){

        if(base == null || a == null || a.length() > base.length()) return -1;

        int indexCurrent = 0, index = 0;

        while(indexCurrent + index < base.length()){
            if(base.charAt(indexCurrent + index) == a.charAt(index)){
                if(index == a.length() - 1)
                    return indexCurrent;
                index++;
            }
            else {
                indexCurrent++;
                index = 0;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        String s, t1, t2, t3;
        s = "abcdefghijklmnopqrst";
        t1 = "abc";
        t2 = "cde";
        t3 = "klmn";

        SubString sub = new SubString();
        System.out.println(sub.shortestSubString(s, t1, t2, t3));
    }

}