/**
 * Created by habib on 2/23/16.
 */

public class DNASequence{

    public String maxStr;

    public int longestDNASequence(String sequence){

        if(sequence.length() == 0) return 0;

        int maxLen = 0, tempLen = 0;

        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == 'A' ||
                    sequence.charAt(i) == 'C' ||
                    sequence.charAt(i) == 'G' ||
                    sequence.charAt(i) == 'T')
                tempLen++;
            else {
                if (maxLen < tempLen) {
                    maxLen = tempLen;
                    maxStr = sequence.substring(i - tempLen, i);
                    tempLen = 0;
                }
            }
       }
        if(maxLen < tempLen)
            maxLen = tempLen;

        return maxLen;
    }

    public static void main(String [] args){

        String in = "VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA";
        in = "ANGRKUMFCGTATGOHCA";
        DNASequence dna = new DNASequence();
        System.out.print(dna.longestDNASequence(in) + " " + dna.maxStr);
    }
}