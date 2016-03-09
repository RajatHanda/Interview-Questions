import java.util.*;

/**
 * Created by habib on 3/9/16.
 */
public class PalindromPairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length < 2) return null;
        List<List<Integer>> res = new ArrayList<>();

        for(int i =  0; i < words.length - 1; i ++)
            for(int j =  i + 1; j < words.length; j ++){
                if(checkPalindrom(i, j, words)){
                    List<Integer> tempList = new ArrayList<>(Arrays.asList(i, j));
                    res.add(tempList);
                }
//                else
                {
                    if(checkPalindrom(j, i, words)){
                        List<Integer> tempList = new ArrayList<>(Arrays.asList(j, i));
                        res.add(tempList);
                    }
                }
            }
        return res;

    }

    private boolean checkPalindrom(int i, int j, String[] words){
        String concat = words[i] + words[j];

        int index = 0;

        while(index <= (concat.length() - 1) / 2){
            if(concat.charAt(index) != concat.charAt(concat.length() - 1 - index))
                return false;
            index++;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words;
        words = new String[]{"jcbbha","afjg","hhdc","acffiaiidggfjahd","hddgdgdg","ceaidddhcjcbhihhacgc","ghfdb","hai","j","hicfeebdjfhccjhadeih","jfgfaehbhidjfggdfb","bejcfhbcdfdejdhf","dh","ijcf","gj","dhedijfhfhgbecgg","hhehadhbfbfbigg","daehhjcaiiaebgcgd","gjcj","ajh","gajea","hjcbgedbffgga","hbjibge","gabbdejaecjbceih","jdhjdja","abdaibbcgbb","efbbfichj","aaaachheagihe","adgi","cjhcagbhjdcchaaaaifh","ebg","afdffeag","jdebghbfejgf","daghaghhcfjaec","jceef","bjhf","djjibceajgcadfibcga","bieifhcagid","edfeaeidbjibgihi","agcdabhdcfacjibeb","dafaifeddgadacaic","gaghddaebiicefeahij","gdj","bic","bafffajdcffcjb","bagcgggejjffgdifba","hb","fjgdihjjacbaagec","b","fgihfaffhb","bffjafig","jbhibcbejjd","gjdcee","cdeecbbhbfabhiebdd","cijbdjaediccg","aejahhdhbcbiaicaccif","eeedjjabhibdah","fgdij","bcdhdghddhbfjbaccg","dbigdhagifjic","hghcabbaajei","ea","hgah","eacg","jeafhafggjhegjiabjhj","hffhihcdhecabefeaa","egdjihdc","gddjjcdeifcfhcch","achaifgbb","bgejgiaafgfajjehdjdb","ccieedfdegefdjcaifg","hebjhghjafbhcjg","hcibafcchig","ahhdhabee","iaicfii","bgafgejh","gjfaejjaibgiifg","fgihijba","aadgiajfiifg","cegjgibjafiifaijdb","afdihddihh","ecaheeic","eahedei","ifgjbajaccdifhg","eajaij","ffcfgfbhiaebaeaaacb","fdcgdbhfbihgicdhbf","acj","bggdibjgaciijccdaii","fagfdfhfccbjeighf","cffffdcffchg","iadbdbfaijji","cdech","ajgjfjbab","ihefbbcc","cgadda","fajabajafjedjdacb","ch","f","eigafjadfgbfjcadbhcd","ajbcfbaiihacec","abjbbjifca","gdfgefeeiedbhdbfhci","egigcihfjbaiiffdibg","eejfgeigaabbcaaiedi","acgbfh","dbfcihd","hi","cg","edcbgbddjfccfghjacbc","jedjacijfjiacefhi","fibiicheeicdeehicg","fbahafhjchbi","haacgejdijhbid","ajbhj","fehjfbehddcdadbdb","cihficdjjehiahgfaa","bgbijfgeae","hfdhdceccbiaccb","jcibchfg","ddjabaigh","bb","fhhciadihc","digfbhg","hbg","dfeciajfjfgighi","debaij","fc","gbjiabfjbgfgjaa","abgjfheb","jjehi","iidace","ijecaagffiae","cgahbii","igb","ahedhifceachccibj","h","jbjgaajiedff","bc","eiifj","ejeidigiiibec","dbchbddggb","fbabhj","igh","hegddcj","gddgah","egjdiidjgc","abhfhagcifhcaiidf","jfi","i","fdbiaieab","hgcccdchadje","ahihhafi","ddgeegjijbebeeibbdg","fcabgbejfdjaj","jfibdiafgfgecjee","idejgface","ecieajdagcbbc","eiehghedcg","jdeedjaieebaedih","gifbdecjcda","ggibecafcebedifd","adcbghdhh","hjdhd","hbeejddd","jdceejbiccbgefidc","ebe","dg","fiicdbibjced","fdbfceibccdgcicgcjgh","cfbheeadeiciaa","agiddbbijjieb","cabcbddf","effci","fcgbcfj","cddacbcfcfd","fabbeigjijciche","ed","ehdcfeejeae","gbagecegcjaiefdc","ggghjecjiijcc","ehheec","cjajgicccbffffhaai","eecgfdahha","bf","eidcghceihhfhdeih","dfdiaegficdiihigaifb","fiiadifh","djgfiagggj","hgcghe","gibafbccbbcdedjaeed","egji","efbcbdcgbgg","aidbaaaeeajhjechcc","cgcb","hbcbgcdbejdicijaee","cih","ibjecgjjbd","ijjdhgjagf","a","ediggeieghhijbe","ifgfjaidieifhcgd","dibfabcdeebjgjba","gahcabhbcfhd","bicegiehj","aaahbjifgcea","bdbhaehgbejdf","iiahiia","egibgiadi","eficbcacbh","hahhhadjabeacea","cejhhe","dhabbjgcjehbgff","ffdjghd","eadjdfjdhcgjifedeb","hgihajefhfbbhcai","jdaeieecgijhifjejfd","hbgidf","ifhjgigiaai","fgiadieigcdbcj","hgdjfhgh","hfifhbehhfa","hafjaegjdj","dgeiiibfjciadd","eh","hjijjihbafh","cjjccfjfeahifecffa","ciabgchjdgcccgf","jcdabhcdjfcagdga","d","g","aahidacabheejdhjg","gbaegcffhegihbi","ae","ggbhjcgbdgffegagfag","ejabehcfbfddjhc","addida","ebhcgejjjjgj","aebaibfijibhecjc","ciehjcgjigbae","ibjebbdbeg","cdcjbbicehjee","gjffaccgadjh","fifhjg","efi","befgii","bcghgchhhdfgi","efgghcbhgjh","aabghdbgj","cche","ij","aghadedcji","ehgdajhfeicahig","hd","agbiehefjdfbijg","djeiighaceidgdbjhj","fabbjhj","ghjfbdehggbfeceggaf","hcfjhajdfbgceceddhcf","jee","ifcjaacfbijjgacdih","gedhefbea","bha","fbjjfieedbdfbdeaaba","fdhecficdajcjddd","iahcie","cdhdabchegjhhgcdede","jifjhcbfgahhffggh","jajdefcifaejij","ibiegjiiffcj","fjab","addfagdjiehcf","acefjda","bh","iegea","eefegfbddf","geedeejcgcghiee","cjjgbdjibhhgbgjecjb","jgbdfjjeg","diijgfe","bbejehacgfjccidcbh","dagcihcfbbibffjje","jidgfaajbgcahde","ef","hjh","biabbcjacfcihce","dbhaigjajefabhhfiid","bfbfdiajb","dijdcbb","fbhjbic","bggehggefjdcagbjj","ehfd","jciddhj","fejgjagjdiai","fiaef","hffhdg","feeffgj","ebgcaaagcefdbhbbci","jicjbbbecdjh","cbjfefbg","jacfcfi","cieb","dgghiddj","ibebbegigidbddadadfg","ddfjiccj","ichj","chddgfiadcdgajfjafa","cicdbfidi","ghjbibddjef","hcdaiicbd","hda","cejjeejieebegaid","cadiff","cebd","af","jfggiab","eeaacbbcjhfgge","ijecagdb","iecjbbiebehbibg","fiacjagf","icghdiadggdagi","cibgdhfbahcihbhjei","ejbceehedid","hbiihhiffdf","icadi","geffhg","cdifdhafjceafcha","dcjhbdgdjhfaceahfhcg","fa","iefdcc","ehaddejhbcabiacbi","geahhbbfdjegjccd","jbfdggjhfcdjdbigei","ihjeeegiebjbihhf","dcj","jebcc","igaaciee","cefaibfd","gddeabfedjgdcdfchhc","bjfhdgidhg","cbai","bafdhbdbfhajihfhjdb","dffcaedjecjgeecfdcec","fefd","hffcdhgfedhgbidejce","bfhj","c","cidcghdcecfcgfdfgbif","jdjggeicb","bff","achejibgiggahfhede","hehgeeifgfcbadjdab","jdei","ifcbhjhdhidgdjii","digibfcagbcgijafabji","fchjhbejaibefhegf","idjac","bchjebeejjic","dheahe","chcijggbfjbdc","cjabcibcajjeifedieeh","bhecabgaffdidgeccdaj","agaefjhjhcc","icihfhaaifbdgehhbg","jfajhi","eccic","iecbbeggadjcdjfgbdeg","e","ijijaahacahj","hdheidggdjg","caegbf","jbhchhbchci","aiihcddbghgjijbhf","cfagaebcigdchfjahhfg","eb","ijghecgaifcgd","hdcejafhgda","fefaifd","iiiigfdbbcgcij","ibcgafaheadeacjbh","fijjbaidjeiaj","gdiedchbid","idcjgfdbgjf","edjaibgcie","aifhadhfdh","aajeb","hc","aiiafhece","dfbig","hif","gjbjeffbcjbcbejejdcf","fjedhbibah","bijhd","ice","dcia","fehfjedj","igidafjiejdheiehg","hihcdje","ghcbighfgbijbigci","hcbhjacacbbjbcbhgdcd","djfabdbabjbabgidacdi","ddjibhfjiied","acfbagiai","ibjijedccbeebbcggdgb","egjabieicjgjabdcaced","dbbiiegh","haegai","dfgfijibfhjbieebdh","jfifccifjaej","gibceajgiihj","fhbfaijjbhig","eebagjggjfdcfbebdhb","dcdajbcfdfccaadfj","ehhdbibiefdbadcecjj","chgbbhifbha","bbagddefdegcjc","ecbidjdgaedgh","idg","haafe","eeeheabiahgcc","ffcdja","eed","ceggbeace","fhgfb","ccdedfdfchjb","jfjfefddfehef","dejhbed","cfdhjij","jdahafaec","jcccjadfcig","edfbbbaeiccfff","fbfdbhhchfjfeiad","hcifddgddefaj","gjafighje","id","dcffefbaehj","gcaac","cjaggigcabaaeegjdef","hbcjejfdeiiheeghi","abababffeajifaea","bbihbhfaf","gjihbe","afabadfjcee","ihbjhfajf","fjchejfg","dc","gaajagfaadeacdjcgd","fb","fjhgfiehib","cibcgbcjdgiibdjbf","gbjdfhihfjj","gjgcabiicijihggbeafi","fdeh","ijiibbecjcjeicd","bgecihj","gbdiificgccgh","deebegbfgcdbjjcdjh","ihfgbhiaahhfggcjcdh","cabj","cahaf","jhicdadegjgjed","cecjceghgigjgejacj","didhi","if","fgadbhgech","bgchbchfeibdcid","cjefhigjdgggegghbeic","cgg","fiagcgjdbcf","ejbabaedgbiba","gccadcjjaadej","fd","jbghjdicbeaaa","fg","jefi","dabcaad","aaicbhhdicf","defjf","bieije","bghdghhhhdbba","ieajfh","cff","adehegigacdg","affi","jdaejihbifbbddd","df","cb","dbee","cj","cjd","fde","dhejdfighhejhgc","fdd","ie","ecbjbjajagi","fgbiieeeccfcgb","bbifdhehcaj","fjchi","ab","ggcbdggciaigbhgegdhh","cee","cecjjhcbge","iejf","beeahabi","ce","gedbacfcfhgdhcagd","ggd","decdfcgjaagjifjb","gjhbjajgcfgcfjgb","jhfaejjcga","gcag","hhaafheeecfg","gihajbebhgbcji","afjh","hccbbige","ifaih","fcdjhj","aajeibbefghajje","ghj","jfaacdggacbhdif","eefcaefhaijebchddej","gggiiagfijjffeiccbd","aeheifif","cfcdjjedjefjcig","hhceccjfbjebdbbgad","egjhjjaajdciiehicd","jgjedigaj","abdjhjhd","jahgcghhiccbf","jdaigcdha","ifjdci","ghjhghbgdhghhdadehjd","ccejgigceidb","gejcgdaebfjdj","gjjhiehdig","idcebjagc","aedchhdgdagjhbg","ejghchgbegcdjjh","jijbeacegdgaiegec","bcdehbjaf","ge","beabcgicibagjddeg","ddgcggbgf","aeciafhchhdgcifhda","cgcgaigdifjgj","cehjhhbaehfab","ehacaf","ggiheda","jafhabhdijejj","igbghjaiefg","iejicejecfgacieb","ghadfggbhaecfibggd","ehbieibfcfdgchgfhhij","dhedicbgdjai","dcddcejahagabhdgfefj","djjidbagfdgadbdcadbg","ajfihcaajbibgja","ecjgegbifha","chahafbfhebjadjhifai","hfaeaejdihfjjdfgafhc","jai","aeabaiai","iehe","ieeejb","dbehfcgfgbceef","beefg","ifhfdabfhjeb","edbjabda","bbbhbdciiaeaefia","hdehfjhfgggbccf","ibhhfgdbadd","ahcfigciefjjadc","hgcgaebjdafhi","idbgg","jfee","hegchgecdajabfh","gjjh","jdfacjhfiajd","jddefjh","eefgacgdcbj","agjhjecdgghccf","ecjceih","ieai","dbgah","eeb","dbedhffjjhhdg","higfdjgdcefihjjhcjic","cjfbcbbc","fbjfdjiagdhead","geejhgdacig","bjgjcdhbdfdejf","hgedeb","abi","ji","jc","cajgjacgfbbd","agjgfii","bheaeaafceidhcb","giijcgjdbb","hfbeeceadijjjadb","gacghgiadgh","fcdedaabbge","egfdbjiiaafe","jej","bdcacifcfjjafhajeh","fajjja","gagigecgedchg","bdefaihfjbdjjgchidg","idjdiiaed","bhjfajfggbaf","hdaeidgc","jh","cha","ijeicagebcci","hbfaafig","dhhc","bcfcaeefbafbbe","cghdhchechebjcic","fedaiggh","jcgjbidcefg","ggagcbbfafbcbd","facee","jijfdfecfbidcciai","hedfgahgcdbech","cc","ghjffahcajaga","ajgaea","bbjgbaacd","adcea","befahhbhb"};
        PalindromPairs palindromPairs = new PalindromPairs();

        long t1 = System.currentTimeMillis();

        List<List<Integer>> res = palindromPairs.palindromePairs(words);

        System.out.println(System.currentTimeMillis() - t1);

        for(List<Integer> index : res)
            System.out.println(index);

    }

}
