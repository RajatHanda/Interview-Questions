import java.util.*;

/**
 * Created by habib on 2/27/16.
 */
public class BinaryExp{
    public List<String> paranthesisGenerate(String str, boolean result){

        if(str == null) return null;
        if(str.equals("")) return new ArrayList<>();

        char resChar = (result) ? '1' : '0';

        if(str.length() == 1)
            if(str.charAt(0) == resChar)
                return(new ArrayList<String>(Arrays.asList(str)));
            else
                return new ArrayList<String>();


        List<String> finalRes = new ArrayList<>(), strLeft, strRight, tempRes, strLeftF, strLeftT, strRightF, strRightT;

        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case '^': tempRes = paranthesisGenerate(str.substring(1, str.length()), !result);
                    if (tempRes.size() != 0) {
                        for (String s : tempRes)
                            if (s.length() > 1) finalRes.add("^" + "(" + s + ")");
                            else finalRes.add("^" + s );
                    }
                    break;
                case '|':
                    strLeftF = paranthesisGenerate(str.substring(0, i), false);
                    strRightF = paranthesisGenerate(str.substring(i + 1, str.length()), false);


                    if(resChar == '0') {
                        if (strLeftF.size() != 0 && strRightF.size() != 0) {
                            for (String l : strLeftF)
                                for (String r : strRightF)
                                    if (l.length() > 1 || r.length() > 1) finalRes.add("(" + l + ")" + "|" + "(" + r + ")");
                                    else finalRes.add(l + "|" + r);

                        }
                    }
                    else {

                        strLeftT = paranthesisGenerate(str.substring(0, i), true);
                        strRightT = paranthesisGenerate(str.substring(i + 1, str.length()), true);

                        for(int k = 0; k < 2; k++)
                            for(int j = 0; j < 2; j++){
                                if (k == 1 || j == 1){

                                    if(k == 1) strLeft = strLeftT;
                                    else  strLeft = strLeftF;

                                    if(j == 1) strRight = strRightT;
                                    else  strRight = strRightF;

                                    if(strLeft.size() != 0 && strRight.size() != 0)
                                        for(String l : strLeft)
                                            for(String r : strRight)
                                                if (l.length() > 1 || r.length() > 1) finalRes.add("(" + l + ")" + "|" + "(" + r + ")");
                                                else finalRes.add(l + "|" + r);
                                }
                            }
                    }
                    break;

                case '&':
                    strLeftT = paranthesisGenerate(str.substring(0, i), true);
                    strRightT = paranthesisGenerate(str.substring(i + 1, str.length()), true);

                    if(resChar == '1'){
                        if(strLeftT.size() != 0 && strRightT.size() != 0)
                            for(String l : strLeftT)
                                for(String r : strRightT)
                                    if (l.length() > 1 || r.length() > 1) finalRes.add("(" + l + ")" + "&" + "(" + r + ")");
                                    else finalRes.add(l + "&" + r);
                    }
                    else {
                        strLeftF = paranthesisGenerate(str.substring(0, i), false);
                        strRightF = paranthesisGenerate(str.substring(i + 1, str.length()), false);

                        for(int k = 0; k < 2; k++)
                            for(int j = 0; j < 2; j++){
                                if (k == 0 || j == 0){

                                    if(k == 1) strLeft = strLeftT;
                                    else  strLeft = strLeftF;

                                    if(j == 1) strRight = strRightT;
                                    else  strRight = strRightF;

                                    if(strLeft.size() != 0 && strRight.size() != 0)
                                        for(String l : strLeft)
                                            for(String r : strRight)
                                                if (l.length() > 1 || r.length() > 1) finalRes.add("(" + l + ")" + "&" + "(" + r + ")");
                                                else finalRes.add(l + "&" + r);                                }
                            }
                    }
            }
        }

        return finalRes;
    }

    public static void main(String [] args){
        String in = "^1|0&1";
        boolean binaryRes = false;

        BinaryExp exp = new BinaryExp();
        List<String> res = exp.paranthesisGenerate(in, binaryRes);

        for(String s : res)
            System.out.println(s);
    }
}