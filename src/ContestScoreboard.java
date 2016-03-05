import java.util.*;

/**
 * Created by habib on 3/4/16.
 */
public class ContestScoreboard
{
    class TeamScore{
        String name;
        int score;
        int time;
        int id;

        public TeamScore(String n, int s, int t, int i){
            name = n;
            score = s;
            time = t;
            id = i;
        }
        public int getScore(){return score;}
    }



    private enum Order {NAME, SCORE, TIME, FINAL};

    class Comparators implements Comparator<TeamScore> {

        Order sortingBy;
        Comparators(Order o){
            sortingBy = o;
        }

        public int compare(TeamScore t1, TeamScore t2){
            int res = -1;
            switch (sortingBy){
                case NAME: res = t1.name.compareTo(t2.name); break;
                case SCORE: res = t1.score - t2.score; break;
                case TIME: res = t1.time - t2.time; break;
                case FINAL: int comp = t1.time - t2.time;
                    if(comp == 0) {
                        comp = t1.score - t2.score;
                        if(comp == 0)
                            comp = t1.name.compareTo(t2.name);
                    }
                    res = comp;
            }
            return res;
        }
    }

    public int[] findWinner(String[] scores)
    {


        List<TeamScore> transactions = new ArrayList<>();




        if(scores.length == 1) return new int[]{0};
        int[] res = new int[scores.length];
        List<TeamScore> totalScores = new ArrayList<>();
        int count = -1;

        for(String score : scores){
            count++;
            List<TeamScore> teamScore = new ArrayList<>();
            String name = "";
            int indexStart = 0, indexFinish = 0;
            while(indexFinish <= score.length()){
                if(indexFinish == score.length() || score.charAt(indexFinish) == ' '){
                    if(indexStart == 0){
                        name = score.substring(0, indexFinish);
                        indexStart = indexFinish + 1;
                        indexFinish += 2;
                    }
                    else {
                        String scoreWithTime = score.substring(indexStart, indexFinish);
                        int i = indexStart + 1;

                        while(!(score.charAt(i) == '/'))	i++;

                        teamScore.add(new TeamScore(name, Integer.parseInt(score.substring(indexStart, i)),Integer.parseInt(score.substring(i + 1, indexFinish)), count) );
                        indexStart = indexFinish + 1;
                        indexFinish += 2;
                    }
                }
                else
                indexFinish++;
            }

            Collections.sort(teamScore, new Comparators(Order.TIME));

            totalScores.add(teamScore.get(0));
            for(int i = 1; i < teamScore.size(); i++){
                teamScore.get(i).score += teamScore.get(i - 1).score;
                totalScores.add(teamScore.get(i));
            }
        }


        Collections.sort(totalScores, new Comparators(Order.FINAL));

        int maxScore = 0, maxID = 0, index = -1, maxTime = 0;
        String maxName = "";
        boolean nameChanged = false;
        for(TeamScore t : totalScores) {
            index++;
//            if(t.id == 5)
            {
//                System.out.println(index + "\t\t" +
//                        maxName + "\t\t " +
//                        maxScore + "\t\t " +
//                maxTime);

            }


            if (maxScore < t.score) {
                if (nameChanged)
                {
                    res[maxID] = 1;
                    nameChanged = false;

                }

                res[t.id] = 1;
                maxScore = t.score;
                maxName = t.name;
                maxID = t.id;
                maxTime = t.time;
            } else if (maxScore == t.score) {
                System.out.println(index + "\t\t" +
                        maxName + "\t\t " +
                        maxScore + "\t\t " +
                        maxTime);
                if (maxName.compareTo(t.name) > 0) {
                    maxName = t.name;
                    nameChanged = true;
                    maxID = t.id;
                    maxTime = t.time;
                }
            }
        }
        if(nameChanged)
            res[maxID] = 1;



        return res;
    }

    public static void main(String [] args){
        ContestScoreboard score = new ContestScoreboard();
        String[] str;
        str = new String[]{"TVG 1/1 1/2 1/3", "AJI 1/4 1/5 1/6"};
        str = new String[]{"GLP 1/114 1/195 1/171 1/19 1/146 1/29","BKPF 1/57 1/187 1/277 1/21 1/223 1/35"};
        str = new String[]{"AAA 248/2 495/5 993/7","BBB 244/6 493/7 990/10", "CCC 248/2 495/5 993/10"};
        str = new String[]{"UBA 10/2 30/4 25/3 999/1000", "UNC 1/3 3/20 40/50", "UNLP 2/2 3/3 4/4 100/100", "UNR 999/1000000 999/999999", "UNS 999/100000000"};

        str = new String[]{"WMNM 39/632846215 151/155723076 74/73111109 632/284617556", "SZM 978/450285461 740/609990187", "ICSTXA 335/392114668 978/370026106 794/798965506 966/756315922", "DUEAZS 421/232498236 887/18200164 33/540288897 229/80582427", "XIWJYH 881/37785809", "ABSPBMI 330/667384278 746/739815267 509/33151498 834/431407835 616/777220936 228/246136821", "MADIRM 596/125057379 413/923135530 108/439979910 943/865982470", "QPC 8/343703417 118/227257132 459/192869338 385/217055547 391/817620345", "PLAUT 763/482916730", "DJVO 958/372351668 794/648355885 8/828358713", "HYA 943/908530980 475/126083867 557/88375545", "VEXNLM 213/115608863 213/703330539 805/778243304", "OMC 590/529339678 242/169487324", "PQS 236/216979197 995/93483927 700/584677116 426/783696588 276/146988547 617/625722094", "ULLHQJZ 789/606547218", "WDS 971/963196356 646/169732486", "ZRMCEZ 99/600752247", "CPXFHGB 28/210957829 85/812716817", "DCEHDU 431/186316521 401/884360610 872/22687749 726/536275233", "AUMN 382/181971226 900/639260496 252/660483807", "WPG 344/489238016", "SLIMQ 580/626385155 787/620800293", "HDYPK 619/818288610", "EMSRV 950/515855484 908/78735232", "CEGS 120/411343004 743/820096636 613/471142884 751/306066281", "DGLX 947/400268927 798/577028066 156/406766323", "YIEM 972/379130399 584/599967319 594/493746671 235/391770243 137/913422226", "FQI 325/916199589 502/811517522 379/490668287", "YDAP 486/568748270 529/464182044 24/256664093 820/426939845", "IZCIR 488/445407882 254/524581870 190/559333950 932/922732344 399/188760221 132/45522073", "OCQSW 540/667801904 165/416173263 799/487911076 234/517666065 855/967578507", "DYBZ 138/562625026 680/882598535 610/923589927 509/648197318 202/908034810", "BYDAXZC 634/517534116 566/565484038", "PNL 243/992706864 935/149590792 472/889687918 938/469695341", "EWI 504/535794835 643/491858737", "IUKTXLK 882/297500638 29/531351023", "IZHBTR 38/216820846 746/335763835 528/473605455 572/224705804", "YMQPQTP 683/344908270 686/663106009 480/573186260 337/869095507", "NTFJI 408/727822861 290/210928903", "FGH 316/937543763 546/923548787 757/382268967", "EMIY 342/13755217", "YCL 61/669654687 582/992572000 919/905736884 277/353561232 141/428450926", "DVMBXO 895/322509604 355/762146892 613/262880146", "YTWWZUI 27/939103162 802/934714697 358/888134865 602/233830467 232/905902704", "TVKNRV 34/266883727 338/543737830 743/123949679", "HWBCPZ 885/994354672", "JVL 102/871735905 320/177872041 881/689654817", "FLXWPZO 902/488027983 674/347934006 876/393716005 941/263093669 563/244232261 834/879833969", "KAJCDL 45/591670093 920/427229805 664/475447199 253/723645099", "ZSBQIR 535/921471666 869/317766387 232/316419651", "GSKIJ 62/608829238 662/949721733 828/416411674 927/473627533"};

//        Expected:
//        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
//
//        Received:
//        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}



        System.out.println(Arrays.toString(score.findWinner(str)));
    }

}