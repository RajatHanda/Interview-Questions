import java.util.HashMap;

/**
 * Created by habib on 3/11/16.
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "N/A";
        if(numerator == denominator) return "1";

        double res;
        res = (double) numerator / denominator;
        int fractionIndex = String.valueOf(res).indexOf('.');
        if(fractionIndex == -1)
            return String.valueOf(res);

        String integerPart = String.valueOf(res).substring(0, fractionIndex);
        String fractionalPart = String.valueOf(res).substring(fractionIndex + 1);
        int index = fractionalPart.length() - 1;
        char c = fractionalPart.charAt(index);
        index--;
        while(index >= 0){
            if(c == fractionalPart.charAt(index))
                index--;
            else {
                if(index == fractionalPart.length() - 2) return String.valueOf(res);
                return integerPart + "." + fractionalPart.substring(0, index + 1) + "(" + c + ")";
            }
        }

        if(fractionalPart.length() == 1) return String.valueOf(res);
        return integerPart + "." + "(" + c + ")";
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "N/A";
        if(numerator == denominator) return "1";

        double res;
        res = (double) numerator / denominator;
        int fractionIndex = String.valueOf(res).indexOf('.');
        if(fractionIndex == -1)
            return String.valueOf(res);

        String integerPart = String.valueOf(res).substring(0, fractionIndex);
        String fractionalPart = String.valueOf(res).substring(fractionIndex + 1);
        int fractLength = fractionalPart.length();

        for(int index = 0; index < fractLength - 1; index++) {
            for (int i = index + 1; i < fractLength; i++) {
                int count = 1;
                String recurringStr = fractionalPart.substring(index, i);
                int j;
                for (j = i; j <= fractLength - recurringStr.length(); j += recurringStr.length())
                    if (recurringStr.equals(fractionalPart.substring(j, j + recurringStr.length())))
                        count++;
                    else
                        break;

                if ((j + 1) * recurringStr.length() >= fractLength && count > 1)
                    if((recurringStr.length() > 1) ||
                            (recurringStr.length() == 1 &&
                            (fractionalPart.charAt(fractLength - 1) == fractionalPart.charAt(fractLength - 2) ||
                                    fractionalPart.charAt(fractLength - 2) + 1 == fractionalPart.charAt(fractLength - 1))))
                        if(index == 0)
                            return integerPart + "." + "(" + fractionalPart.substring(index, i) + ")";
                        else
                            return integerPart + "." + fractionalPart.substring(0, index) +
                                        "(" + fractionalPart.substring(index, i) + ")";
            }
        }


        return String.valueOf(res);


    }

    public String fractionToDecimal3(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";

        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }

        return result;
    }
    public static void main(String[] args) {
        FractiontoRecurringDecimal test = new FractiontoRecurringDecimal();
        int numerator, denominator;

        numerator = 5;
        denominator = 30;

        numerator = 1;
        denominator = 910;

        numerator = 5;
        denominator = 3;

        numerator = 1;
        denominator = 17;

        System.out.println((double) numerator / denominator);
        System.out.println(test.fractionToDecimal(numerator, denominator));
        System.out.println(test.fractionToDecimal2(numerator, denominator));
        System.out.println(test.fractionToDecimal3(numerator, denominator));
        System.out.println(Integer.MIN_VALUE / (double)Integer.MAX_VALUE);

    }

}
