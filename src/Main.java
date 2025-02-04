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

//    public static void eval2(){
//        String[] ranking = {"fiveOfAKind", "fourOfAKind", "fullHouse", "threeOfAKind", "twoPair", "onePair", "highCard"};
//        String[] ranking2 = {"Ace", "King", "Queen", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "Jack"};
//
//        String[] xr = new String[re.textToArray("src/re.txt").length];
//        for (int i = 0; i < re.textToArray("src/re.txt").length; i ++){
//            xr[i] = re.textToArray("src/re.txt")[i];
//        }
//        Arrays.sort(xr, (a, b) -> {
//            String[] ar = a.substring(0, a.indexOf("|")).split(",");
//            String[] br = b.substring(0, b.indexOf("|")).split(",");
//            if (eval(b).compareTo(eval(a)) == 0){
//                for (int i = 0; i < ar.length; i++){
//                    if (Arrays.asList(ranking2).indexOf(ar[i]) != Arrays.asList(ranking2).indexOf(br[i])){
//                        return Integer.compare(Arrays.asList(ranking2).indexOf(br[i]), Arrays.asList(ranking2).indexOf(ar[i]));
//                    }
//                }
//            }
//            else {
//                return Integer.compare(Arrays.asList(ranking).indexOf(eval(b)), Arrays.asList(ranking).indexOf(eval(a)));
//            }
//            return 0;
//        });
//        for (int i = 0; i < xr.length; i++){
//            System.out.println(xr[i] + eval(xr[i]));
//            sum += Integer.valueOf(xr[i].substring(xr[i].indexOf("|") + 1)) * (i + 1);
//        }
//    }

    public static void main(String[] args) {
        Card[] c = createDeck("src/re.txt", false);
        for (Card i: c){
            if (Objects.equals(i.determineLine(), "fiveOfAKind")){
                fiveOfAKind += 1;
            }
            if (Objects.equals(i.determineLine(), "fourOfAKind")){
                fourOfAKind += 1;
            }
            if (Objects.equals(i.determineLine(), "threeOfAKind")){
                threeOfAKind += 1;
            }
            if (Objects.equals(i.determineLine(), "fullHouse")){
                fullHouse += 1;
            }
            if (Objects.equals(i.determineLine(), "twoPair")){
                twoPair += 1;
            }
            if (Objects.equals(i.determineLine(), "onePair")){
                onePair += 1;
            }
            if (Objects.equals(i.determineLine(), "highCard")){
                highCard += 1;
            }
        }
        for (int i = 0; i < c.length; i++){
            sum += (i + 1) * c[i].returnBid();
        }
        System.out.printf("Number of five of a kind hands: %d\n", fiveOfAKind);
        System.out.printf("Number of full house hands: %d\n", fullHouse);
        System.out.printf("Number of four of a kind hands: %d\n", fourOfAKind);
        System.out.printf("Number of three of a kind hands: %d\n", threeOfAKind);
        System.out.printf("Number of two pair hands: %d\n", twoPair);
        System.out.printf("Number of one pair hands %d\n", onePair);
        System.out.printf("Number of high card hands %d\n", highCard);
        System.out.printf("Total Bid Value: %d\n", sum);
        sum = 0;
        Card[] d = createDeck("src/re.txt", true);
        for (int i = 0; i < d.length; i++){
            sum += (i + 1) * d[i].returnBid();
        }
        System.out.printf("Total Bid Value Jack: %d\n", sum);


    }
    public static Card[] createDeck(String fileLocation, boolean jack){
        String[] arr = re.textToArray(fileLocation);
        int length = arr.length;
        Card[] c = new Card[length];
        for (int i = 0; i < arr.length; i++){
            c[i] = new Card(arr[i], jack);
        }
        Arrays.sort(c);
        return c;
    }
}