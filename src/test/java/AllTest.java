import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AllTest {
    //POKERCLIENT TESTS
    PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "c9");


    @Test
    void highestCardIsMinePoker() {
        assertFalse(pokerClient.highestCardIsMine("s2", "h3","h4","h5","hj"));
    }


    @Test
    void highestCardIsNotMinePoker() {
        assertTrue(pokerClient.highestCardIsMine("h3","h5","h4","h7","h6"));
    }


    @Test
    void emptyStringInsertedAsCardPoker() {
        assertThrows(StringIndexOutOfBoundsException.class, ()-> pokerClient.highestCardIsMine("","h5","h4","h7","h6"));
    }


    @Test
    void invalidCharacterInsertedAsCardPoker() {
        assertThrows(IllegalArgumentException.class, ()-> pokerClient.highestCardIsMine("((","h5","h4","h7","h6"));
    }


    //CARD TESTS
    @Test
    void numberInsertedGetValueCard() {
        Card card = new Card("S2");
        String cardValue = card.cardCode;
        int expected = 2;

        assertEquals(expected, Integer.parseInt(cardValue.substring(1)));
    }

    @Test
    void figureInsertedGetValueCard() {
        Card card = new Card("SK");
        String cardValue = card.cardCode.substring(1);
        int expected = 13;
        int actualNumber = 0;

        if(cardValue.equals("K")){
            actualNumber = 13;
        }

        assertEquals(expected, actualNumber);
    }

    @Test
    void largerNumberEnteredIngetValueCard() {
        assertThrows(IllegalArgumentException.class,()-> new Card("s15"));
    }

    @Test
    void floatEnteredInGetValueCard() {
        assertThrows(NumberFormatException.class,()-> new Card("ss2.0"));
    }


    @Test
    void raisedExceptionCard(){
        assertThrows(IllegalArgumentException.class, ()-> new Card("K300"));
    }


    @Test
    void emptyStringInsertedAsCard() {
        assertThrows(StringIndexOutOfBoundsException.class, ()-> new Card(""));
    }

}
