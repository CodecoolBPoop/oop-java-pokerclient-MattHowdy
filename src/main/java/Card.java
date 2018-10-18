import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Card {
    String cardCode;
    List<String> validSuits = Arrays.asList("S","C","D","H");
    HashMap<String, Integer> figuredCardValues = new HashMap<>();
    int intCardValue;
    String cardSuit;
    String cardValue;


    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;
        cardSuit = this.cardCode.substring(0, 1).toUpperCase();
        cardValue = cardCode.substring(1);

        figuredCardValues.put("J", 11);
        figuredCardValues.put("Q", 12);
        figuredCardValues.put("K", 13);
        figuredCardValues.put("A", 14);


        if(validSuits.contains(cardSuit)){
            if (figuredCardValues.get(cardValue) == null) {
                intCardValue = Integer.parseInt(cardValue);
                if (intCardValue > 10 || intCardValue < 2) {
                    throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
                }
            }
        } else throw new IllegalArgumentException("card color isn't valid: " + cardSuit);

    }


    public int getValue() {
        if (figuredCardValues.get(cardValue) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = figuredCardValues.get(cardValue);
        }
        return intCardValue;
    }
}
