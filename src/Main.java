import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int fiveOfAKind;
    static int fourOfAKind;
    static int fullHouse;
    static int threeOfAKind;
    static int twoPair;
    static int onePair;
    static int highCard;
    static int sum;
    public static String eval(String line){
        HashMap<String, Integer> a = new HashMap<>();
        for (String i: line.substring(0, line.indexOf("|")).split(",")){
            if (a.containsKey(i)){
                a.put(i, (a.get(i) + 1));
            }
            else {
                a.put(i, 1);
            }
        }
        if (a.size() == 1){
            fiveOfAKind += 1;
            return "fiveOfAKind";
        }
        else if (a.size() == 2){
            if (a.containsKey("Jack")){
                fourOfAKind += 1;
                return "fourOfAKind";
            }
            if (a.containsValue(4)){
                fourOfAKind += 1;
                return "fourOfAKind";
            }
            else {
                fullHouse += 1;
                return "fullHouse";
            }
        }
        else if (a.size() == 3){
            if (a.containsKey("Jack")){
                threeOfAKind += 1;
                return "threeOfAKind";
            }
            if (a.containsValue(3)){
                threeOfAKind += 1;
                return "threeOfAKind";
            }
            else{
                twoPair += 1;
                return "twoPair";
            }
        }
        else if (a.size() == 4){
            onePair += 1;
            return "onePair";
        }
        else {
            highCard += 1;
            return "highCard";
        }
    }
    public static void eval2(){
        String[] ranking = {"fiveOfAKind", "fourOfAKind", "fullHouse", "threeOfAKind", "twoPair", "onePair", "highCard"};
        String[] ranking2 = {"Ace", "King", "Queen", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "Jack"};

        String[] xr = new String[re.textToArray("src/re.txt").length];
        for (int i = 0; i < re.textToArray("src/re.txt").length; i ++){
            xr[i] = re.textToArray("src/re.txt")[i];
        }
        Arrays.sort(xr, (a, b) -> {
            String[] ar = a.substring(0, a.indexOf("|")).split(",");
            String[] br = b.substring(0, b.indexOf("|")).split(",");
            if (eval(b).compareTo(eval(a)) == 0){
                for (int i = 0; i < ar.length; i++){
                    if (Arrays.asList(ranking2).indexOf(ar[i]) != Arrays.asList(ranking2).indexOf(br[i])){
                        return Integer.compare(Arrays.asList(ranking2).indexOf(br[i]), Arrays.asList(ranking2).indexOf(ar[i]));
                    }
                }
            }
            else {
                return Integer.compare(Arrays.asList(ranking).indexOf(eval(b)), Arrays.asList(ranking).indexOf(eval(a)));
            }
            return 0;
        });
        for (int i = 0; i < xr.length; i++){
            sum += Integer.valueOf(xr[i].substring(xr[i].indexOf("|") + 1)) * (i + 1);
        }
    }

    public static void main(String[] args) {
        for (String i: re.textToArray("src/re.txt")){
            eval(i);
        }
        System.out.printf("Number of five of a kind hands:" +  fiveOfAKind);
        System.out.printf("\nNumber of full house hands: " + fullHouse);
        System.out.printf("\nNumber of four of a kind hands: " +  fourOfAKind);
        System.out.printf("\nNumber of three of a kind hands: " + threeOfAKind);
        System.out.printf("\nNumber of two pair hands: " + twoPair);
        System.out.printf("\nNumber of one pair hands: " +  onePair);
        System.out.printf("\nNumber of high card hands: " +  highCard + "\n");
        eval2();
        System.out.printf("Total Bid Value: %d", sum);

    }
}