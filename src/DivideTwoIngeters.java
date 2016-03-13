/**
 * Created by habib on 3/11/16.
 */
public class DivideTwoIngeters {
    public int divide(int dividend, int divisor) {
        //handle special cases
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //get positive values
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int result = 0;
        while(pDividend>=pDivisor){
            //calculate number of left shifts
            int numShift = 0;
            while(pDividend>=(pDivisor<<numShift)){
                System.out.println(pDivisor<<numShift);
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }
    }

    public static void main(String[] args) {
        DivideTwoIngeters test = new DivideTwoIngeters();
        int dividend, divisor;

        dividend = Integer.MAX_VALUE;
        divisor = 1;

        System.out.print(test.divide(dividend, divisor));
    }

}
