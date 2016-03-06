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
                        comp = t2.score - t1.score;
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
                if (maxName.compareTo(t.name) < 0) {
                    maxName = t.name;
                    nameChanged = true;
                    maxID = t.id;
                    maxTime = t.time;
                }
            }
        }
        if(nameChanged)
            res[maxID] = 1;

        Collections.sort(totalScores, new Comparators(Order.NAME));
        res[totalScores.get(0).id] = 1;

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


        str = new String[]{"LRBB 904/387 254/650 869/363", "QCO 520/689 993/918", "IICFSK 51/530 40/47 84/798 317/991 286/34 717/498", "JJDDNTG 630/55 18/99 710/82 998/517 595/232 266/797 185/339", "UTP 930/560 377/11 365/225 349/540 141/379", "CVOG 208/342 233/353 564/512 330/518 437/84 420/113 16/507 469/668 287/490 399/155", "KPHC 36/288 421/644 401/743", "FBFJKNC 831/166 210/303 589/80 896/548 449/485", "NFNB 848/169 629/814", "UFNNX 515/498 838/539 290/140 625/471 73/393 843/543 607/534 696/744 488/551 380/486 419/721", "FDUPL 754/961 810/800 790/230 363/629 792/800 184/590 615/877 962/767 951/985 381/760 249/777", "OQJ 407/876 569/925", "FAM 281/338 373/316 474/618 278/999 101/781 965/7 706/36", "KIJK 606/669 468/147", "QALWDT 976/565 64/53 442/369 165/433 526/431 12/467 808/305", "GHR 484/900 73/764 530/20 783/513 611/255", "HBCTCB 742/426 144/636 933/406 694/606", "WLUD 553/163 67/455 819/520 58/770 472/185 583/250 342/502 280/448 997/784 294/513 493/608 946/697", "VVU 476/442 234/398 975/414 18/487 394/102 237/903 185/746 208/324 814/457 360/126 268/9 710/123", "UKFJJ 978/348 463/395", "NCY 810/683 731/89 703/367 685/358", "HFOOO 280/223 667/753 654/90 775/872 25/19", "PWX 342/308 253/395 663/844 146/754 788/980 265/468 557/941 852/75", "RCA 517/866", "JCLJ 876/265 95/631 557/710 299/638 252/23 532/102 51/227", "DVAZJ 78/539 945/399 112/216 503/513 631/682 740/323 715/27 936/418 883/822 697/701", "QFLPQL 549/523 849/330 225/606 159/55 898/605 289/463", "ZEYVKR 578/546 989/752 117/481 284/822", "KBT 116/680 750/894 610/286 957/395 594/258", "QCBT 896/76", "JMUKYEX 403/990 425/587 516/924 360/227", "SGMC 147/704 332/687 519/913 921/799 940/177 128/181 272/772 868/476", "YVI 515/987 411/670 948/600 604/79 242/966 327/846 942/889 199/123 381/881 982/93 243/488 56/611", "AYH 562/378 254/607", "PGWK 849/889 211/508 199/306 297/445 252/473 335/501 599/377 991/996 975/128", "SIUFKV 814/884 708/915 668/734 932/850 221/344 972/486 493/28", "QYNJLCH 518/622 279/798 624/406 421/969 17/490 213/732 732/698 116/928", "VDY 381/898 106/124 359/625 934/88 820/477 80/677 717/924 26/785", "YHBI 764/817 450/932 356/26 222/792 300/51", "NCKID 557/553 575/768 100/904 517/732", "MSUD 818/813", "ZATTFI 860/302 575/868 431/123 445/934 953/909 154/777 301/705 729/973 724/611 915/255", "AIVYR 404/653", "RHUVA 437/555 218/535 159/162 551/336 300/227 986/450 903/209 391/140 922/775 91/997 676/829 804/395", "NMO 574/387 484/976", "OIB 512/922 398/309 621/614", "EBV 236/809 521/115", "WSUCE 592/646 167/105", "YLQHSEU 645/256 672/294 267/210 14/608 330/578 138/418 627/617 98/7", "NCBIEDU 881/230 284/576 748/725 624/262 346/508", "LXD 922/881 485/251 555/790 566/179", "WYNWQ 964/664 669/339 360/230 475/164 577/116 492/856 699/961 594/663 809/42 24/683", "GOTE 287/519 688/898 223/162 374/787 734/431 288/962 735/228 68/873 520/333 765/979 814/651", "BACXK 472/944 700/726 653/432", "ZHNZV 353/336 317/196 502/691 86/385 572/380 439/738 806/853 943/77 673/221 240/874 708/865", "RCRER 475/666 530/100 440/237 341/660 427/570", "HAJKOJ 655/92 964/589 940/572 768/863 963/902 515/131 896/696 603/268 571/451 504/800", "CHPPIUY 460/107 524/450 836/968 596/680 525/305 562/855 709/214 445/213 986/114 678/677 947/604", "AVIYL 481/970 969/211 593/986 852/256", "IXULBJM 102/888 705/331 70/678 758/96 965/824 741/607 832/924 611/605 274/666 37/792", "VECJ 849/851 892/948 451/718 716/132 951/107", "ZFYYF 902/774 512/653 524/913 855/957 750/192 147/590 187/18 722/688 467/198", "GNFHPNE 115/340 38/60 631/579 697/628 185/960 924/932 906/667 409/157", "ASNWBX 199/812 585/844 826/305 685/127 844/116", "RXM 552/37 942/520 584/690 198/761 701/473 975/902 699/134", "ZOIF 309/338 730/275 545/541 223/810 46/872 771/863 766/320 630/575 509/664 604/809 967/457", "TOGJMCA 242/60 760/40 745/503 740/984 196/948 600/875 93/368 589/223 799/100", "OKDQLX 514/30 638/517 179/156 516/610 105/371 106/689", "LCKFP 350/565 282/13 957/386 305/30 395/291 782/427 429/264 547/565", "VIONST 576/949 226/392 215/392 177/583 87/626 650/861", "VWNOUIL 184/339 322/648 453/280 132/752", "PDWPV 775/949 377/383 232/375 544/852 862/111", "AQVZB 625/680 177/218 296/688 153/157 595/585 12/172 317/181 7/612 438/622 275/640 497/488 993/208", "FXDGO 160/596", "QSFA 988/466 248/526 658/68 636/859", "MQMFCJ 346/700 484/932 615/623 490/447 795/351 187/885", "GYBI 908/134 627/456 487/216 590/730 177/605 127/481", "TPUPXKZ 280/330 816/22 57/986 336/427 365/60 48/284 965/316 914/941", "YBJCXF 936/350 46/758", "EZENWKI 458/870 528/805 893/352 341/445 912/64 500/496 606/63", "HTP 917/451 770/101 904/754 519/221 954/891 434/777 170/503 861/905", "KXECQUO 22/808 712/94 884/222 782/430 515/733 580/112 586/477 856/584 489/355 9/563 101/237", "YFHZC 863/660 627/984 975/660 890/244 55/717 136/922", "APEZ 160/290 943/407 812/283 797/698"};

//        Expected:
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}
//
//        Received:
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}

//        [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]

        System.out.println(Arrays.toString(score.findWinner(str)));
    }

}