/**
 * Created by habib on 3/1/16.
 */
public class DigitRemoval{

    public int findOneDigit(int x){
        String in = String.valueOf(x);
        int index = (x < 0) ? 1 : 0;
        int length = in.length();
        int max = Integer.MIN_VALUE;

        while(index < length - 1){
            if(in.charAt(index) == in.charAt(index + 1)){
                int pow = (int)Math.pow(10, length - index - 1);
                int output = x / (pow) * (pow / 10);
                output += x % (pow / 10);
                if (max < output) max = output;
            }
            index++;
        }
        return max;
    }

    public static void main(String [] args){
        int x = -22356623;
        DigitRemoval d = new DigitRemoval();
        System.out.println(d.findOneDigit(x));
    }
}