import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card implements Comparable<Card>{
    String line;
    boolean jack;
    public Card(String line, boolean jack){
        this.line = line;
        this.jack = jack;
    }

    public void displayDeck(){
        System.out.println(line);
    }

    public String determineLine(){
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
            return "fiveOfAKind";
        }
        else if (a.size() == 2){

            if (a.containsValue(4)){
                return "fourOfAKind";
            }

            else {
                return "fullHouse";
            }
        }
        else if (a.size() == 3){

            if (a.containsValue(3)){
                return "threeOfAKind";
            }
            else {
                return "twoPair";
            }
        }

        else if (a.size() == 4){
            return "onePair";
        }

        else {
            return "highCard";
        }
    }
    public String determineLineJack(){
        HashMap<String, Integer> a = new HashMap<>();

        for (String i: line.substring(0, line.indexOf("|")).split(",")){
            if (a.containsKey(i)){
                a.put(i, (a.get(i) + 1));
            }
            else {
                a.put(i, 1);
            }
        }

        if (a.containsKey("Jack")){
            if (Objects.equals(mostCommonValue(a), "Jack")){
                a.put(mostCommonValue(a), a.get(mostCommonValue(a)) + 1);
            }
            else {
                int val = a.get("Jack");
                a.remove("Jack");
                a.put(mostCommonValue(a), a.get(mostCommonValue(a)) + val);
            }
        }


        if (a.size() == 1){
            return "fiveOfAKind";
        }
        else if (a.size() == 2){

            if (a.containsValue(4)){
                return "fourOfAKind";
            }

            else {
                return "fullHouse";
            }
        }
        else if (a.size() == 3){

            if (a.containsValue(3)){
                return "threeOfAKind";
            }
            else {
                return "twoPair";
            }
        }

        else if (a.size() == 4){
            return "onePair";
        }

        else {
            return "highCard";
        }
    }
    public String mostCommonValue(HashMap<String, Integer> b){

        int mostFrequent = -1;
        String mostFrequentValue = "";
        for (Map.Entry<String, Integer> e: b.entrySet()){
            int count = e.getValue();
            String value = e.getKey();
            if (!Objects.equals(value, "Jack")){
                if (count > mostFrequent){
                    mostFrequent = count;
                    mostFrequentValue = value;
                }
            }

        }

        return mostFrequentValue;
    }
    @Override
    public int compareTo (Card card){
        String[] ar = this.line.substring(0, this.line.indexOf("|")).split(",");
        String[] br = card.line.substring(0, card.line.indexOf("|")).split(",");
        String determineLine = jack ? card.determineLineJack(): card.determineLine();
        String determineLine2 = jack ? this.determineLineJack(): this.determineLine();

        String[] ranking = {"fiveOfAKind", "fourOfAKind", "fullHouse", "threeOfAKind", "twoPair", "onePair", "highCard"};

        String[] ranking2 = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        if (jack){
            ranking2 = new String[]{"Ace", "King", "Queen", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "Jack"};

        }

        if (Arrays.asList(ranking).indexOf(determineLine) == Arrays.asList(ranking).indexOf(determineLine2)){
            for (int i = 0; i < ar.length; i++){
                if (Arrays.asList(ranking2).indexOf(br[i]) != Arrays.asList(ranking2).indexOf(ar[i])) {
                    return Integer.compare(Arrays.asList(ranking2).indexOf(br[i]), Arrays.asList(ranking2).indexOf(ar[i]));
                }
            }
        }
        else {
            if (jack){
                return Integer.compare(Arrays.asList(ranking).indexOf(determineLine), Arrays.asList(ranking).indexOf(determineLine2));
            }
            return Integer.compare(Arrays.asList(ranking).indexOf(determineLine), Arrays.asList(ranking).indexOf(determineLine2));
        }
        return 0;
    }
    public int returnBid(){
        return Integer.valueOf(this.line.substring(this.line.indexOf("|") + 1));
    }
}

