/**
 * Created by habib on 3/11/16.
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        if(s == null || s.equals("")) return "";

        String[] words = s.split("\\s+");
        String res = "";

        int i = 0;
        if (words[0].equals("")) i++;

        for(; i < words.length - 1; i++)
            res += words[i] + " ";

        if(words.length == 0) return "";
        return (res + words[words.length - 1]);
    }

    public String reverseWords2(String s) {
        if(s == null || s.equals("")) return "";

        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder("");


        int i = words.length - 1, ending = 0;
        if (words[0].equals("")) ending++;




        for(; i > ending; i--)
            res.append(words[i]).append(" ");

        if(words.length == 0) return "";
        return (res.append(words[ending]).toString());
    }

    public static void main(String[] args) {
        ReverseWordsInString reverse = new ReverseWordsInString();
        String s;

        s = "  1  2 ";

        System.out.println(reverse.reverseWords(s));
        System.out.println(reverse.reverseWords2(s));

    }
}
