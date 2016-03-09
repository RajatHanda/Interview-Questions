import java.util.*;

/**
 * Created by habib on 3/8/16.
 */
public class WordLadder2 {
    public class Node{
        String val;
        List<String> stack;
        Node parent = null;
        Set<Node> visited;
        int height;

        Node(String val, Node parent, int height){
            this.val = val;
            this.parent = parent;
            this.height = height;
        }
        Node(String val, int height){
            this.val = val;
            this.height = height;
        }

        Node(String val, Node parent){
            this.val = val;
            this.parent = parent;
        }

        Node(String val, Node parent, Set<Node> visited){
            this.val = val;
            this.parent = parent;
            this.visited = visited;
        }

        Node(String val, List<String> stack){
            this.val = val;
            this.stack = stack;
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        if(beginWord ==  null || endWord == null ||
                beginWord.length() != endWord.length() || beginWord.length() == 0 ||
                wordList == null || wordList.size() == 0) return null;

//        if(beginWord.equals(endWord))
//            return new ArrayList<List<String>>(new ArrayList<String>(Arrays.asList(beginWord, endWord)));

        List<List<String>> res = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int minStackSize = Integer.MAX_VALUE;

        q.add(new Node(beginWord, new ArrayList<String>(Arrays.asList(beginWord))));
        visited.add(beginWord);


        while(!q.isEmpty()){
            Node top = q.poll();
            for(int i = 0; i < beginWord.length(); i++){
                for(int j = 97; j < 123; j++){

                    String newStr;
                    StringBuilder stringBuilder = new StringBuilder(top.val);
                    stringBuilder.replace(i, i + 1, String.valueOf((char)j));
                    newStr = stringBuilder.toString();

                    if(check(top, newStr) && wordList.contains(newStr)){
                        List<String> newList = new ArrayList<>();
                        for(String s : top.stack)
                            newList.add(s);

                        newList.add(newStr);
//                        visited.add(newStr);
//                        minStackSize = newList.size();
                        if(newList.size() <= minStackSize) {

                            if (newStr.equals(endWord)) {
                                res.add(newList);
                                minStackSize = newList.size();
                            } else
                                q.add(new Node(newStr, newList));
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean check(Node node, String str){
        for(String s : node.stack)
            if(s.equals(str)) return false;
        return true;
    }

    public List<List<String>> findLadders2(String beginWord, String endWord, Set<String> wordList) {

        if(beginWord ==  null || endWord == null ||
                beginWord.length() != endWord.length() || beginWord.length() == 0 ||
                wordList == null || wordList.size() == 0) return null;

//        if(beginWord.equals(endWord))
//            return new ArrayList<List<String>>(new ArrayList<String>(Arrays.asList(beginWord, endWord)));

        List<List<String>> res = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int minStackSize = Integer.MAX_VALUE;


        q.add(new Node(beginWord, 1));


        while(!q.isEmpty() && q.peek().height + 1 <= minStackSize){
            Node top = q.poll();
            for(int i = 0; i < beginWord.length(); i++){
                for(int j = 97; j < 123; j++){

                    String newStr;
                    StringBuilder stringBuilder = new StringBuilder(top.val);
                    stringBuilder.replace(i, i + 1, String.valueOf((char)j));
                    newStr = stringBuilder.toString();

                    if(wordList.contains(newStr) && check2(top, newStr)){

                            if (newStr.equals(endWord)) {
                                LinkedList<String> newList = new LinkedList<>();
                                newList.add(newStr);
                                Node currentNode = top;

                                while (currentNode != null){
                                    newList.addFirst(currentNode.val);
                                    currentNode = currentNode.parent;
                                }

                                res.add(newList);
                                minStackSize = top.height + 1;
                            }
                            else {
                                Node newNode = new Node(newStr, top, top.height + 1);
                                q.add(newNode);
                            }
                    }
                }
            }
        }
        return res;
    }

    private boolean check2(Node node, String str){
        Node currentNode = node;
        while(currentNode != null) {
            if (currentNode.val.equals(str)) return false;
            currentNode = currentNode.parent;
        }
        return true;
    }




    public static void main(String[] args) {
        String beginWord, endWord;
        Set<String> dic = new HashSet<>();
        WordLadder2 ladder = new WordLadder2();

        for(int i = 97; i < 123; i++)
            dic.add(String.valueOf((char)i));
        dic.add("hot");
        dic.add("dog");
        dic.add("dot");
        List<String> newWords = new ArrayList<>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
        newWords.addAll(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));

        for(String s : newWords)
            dic.add(s);

        beginWord = "a";
        endWord = "c";

        beginWord = "hot";
        endWord = "dog";


        beginWord = "cet";
        endWord = "ism";


        beginWord = "cet";
        endWord = "cut";

//        List<List<String>> res = ladder.findLadders(beginWord, endWord, dic);
//
//        for(List<String> list : res)
//            System.out.println(list);

        List<List<String>> res2 = ladder.findLadders2(beginWord, endWord, dic);

        for(List<String> list : res2)
            System.out.println(list);

    }
}