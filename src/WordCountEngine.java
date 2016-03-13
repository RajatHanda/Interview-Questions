import java.util.*;

/**
 * Created by habib on 3/9/16.
 */
class WordCountEngine {

    public class Word implements Comparable<Word>{
        String val;
        int count = 1;

        Word(String val){
            this.val = val;
        }

        Word(String val, int count){
            this.val = val;
            this.count = count;
        }

        public boolean equals(Object o){
            return (o instanceof Word && val.equals(((Word)o).val));


        }
        public int compareTo(Word w){
            return w.count - count;
        }
    }

    public List<Word> countWords(String str){

        if(str == null || str.length() == 0) return new ArrayList<Word>();

        String[] words = str.split("\\s+");
        List<Word> res = new ArrayList<>();

        for(String word : words){
            String[] finalWords = word.split("\\p{Punct}");
            for(String finalWord : finalWords){
                Word tempWord = new Word(finalWord.toLowerCase());
                if(res.contains(tempWord)){
                    res.get(res.lastIndexOf(tempWord)).count++;
                }
                else {
                    res.add(new Word(finalWord));
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    public List<Word> countWords2(String str){

        if(str == null || str.length() == 0) return new ArrayList<Word>();

        String[] words = str.split("\\s+");
        Map<String, Integer> dictionary = new HashMap<>();
        List<Word> res = new ArrayList<>();

        for(String word : words){
            String[] finalWords = word.split("\\p{Punct}");
            for(String finalWord : finalWords){
                finalWord = finalWord.toLowerCase();
                if(dictionary.containsKey(finalWord)){
                    dictionary.put(finalWord, dictionary.get(finalWord) + 1);
                }
                else {
                    dictionary.put(finalWord, 1);
                }
            }
        }

        for(Map.Entry<String, Integer> pair : dictionary.entrySet()){
            res.add(new Word(pair.getKey(), pair.getValue()));
        }

        Collections.sort(res);
        return res;
    }




    public static void main(String[] args) {
        String pramp = "Practice Makes Perfect";
        System.out.println(pramp);

        WordCountEngine wordEngine  = new WordCountEngine();
        String input = "practice makes perfect. get perfect by practice. just practice!";

        List<Word> res = wordEngine.countWords(input);

        for(Word w : res)
            System.out.println(w.val + " = " + w.count);


        res = wordEngine.countWords2(input);

        for(Word w : res)
            System.out.println(w.val + " = " + w.count);

    }
}


