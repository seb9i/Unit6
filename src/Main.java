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
        String[] ranking = {"fiveOfAKind", "fourOfAKind", "fulLHouse", "threeOfAKind", "twoPair", "onePair", "highCard"};
        String[] xr = new String[re.textToArray("src/re.txt").length];
        for (int i = 0; i < re.textToArray("src/re.txt").length; i ++){
            xr[i] = re.textToArray("src/re.txt")[i] + " " + eval(re.textToArray("src/re.txt")[i]);
        }
        Arrays.sort(xr, (a, b) -> Integer.compare(Arrays.asList(ranking).indexOf(b.substring(b.indexOf(" ") + 1)), Arrays.asList(ranking).indexOf(a.substring(a.indexOf(" ") + 1))));
        for (String a: xr){
            System.out.println(a);
        }


    }
    public static void main(String[] args) {

        eval2();
    }
}