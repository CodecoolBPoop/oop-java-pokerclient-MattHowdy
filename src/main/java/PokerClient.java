import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerClient {
    List<Card> allCards = new ArrayList<>();


    public PokerClient(String p1, String p2, String p3, String p4, String p5) {
        List<String> inputCards = Arrays.asList(p1,p2,p3,p4,p5);
        inputCards.forEach(c -> allCards.add(new Card(c.toUpperCase())));
    }


    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        Card highestCard = new Card("s2");
        List<Card> myCards = new ArrayList<>();
        List<String> inputCards = Arrays.asList(p1,p2,p3,p4,p5);
        inputCards.forEach(c -> myCards.add(new Card(c.toUpperCase())));

        for (Card myCard : myCards)
            for (Card allCard : allCards)
                if (myCard.getValue() <= allCard.getValue()) {
                    if (highestCard.getValue() <= myCard.getValue()) highestCard = allCard;
                } else {
                    if (myCard.getValue() > highestCard.getValue()) highestCard = myCard;
                }

        return allCards.contains(highestCard);
    }

}