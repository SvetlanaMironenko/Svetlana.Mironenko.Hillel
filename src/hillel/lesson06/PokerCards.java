package hillel.lesson06;

import java.util.Random;

public class PokerCards {
    private final String[] cardNames = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "dama", "king", "ace"};
    private final String[] suits = {"♦", "♥", "♠", "♧"};
    private final String[] totalCards = new String[cardNames.length * suits.length];
    private int cardIndex = 0;

    public PokerCards() {
        for (int i = 0; i < cardNames.length; i++) {
            String cardName = cardNames[i];
            for (int j = 0; j < suits.length; j++) {
                String suitsName = suits[j];
                totalCards[(i * suits.length) + j] = cardName + suitsName;
            }
        }
    }

    public void unSortCards() {
        Random random = new Random();
        for (int i = 0; i < totalCards.length; i++) {
            String currentCard = totalCards[i];
            int randomIndex = random.nextInt(totalCards.length);
            totalCards[i] = totalCards[randomIndex];
            totalCards[randomIndex] = currentCard;
        }
    }

    public String giveNextCard() {
        String currentCard = totalCards[cardIndex];
        cardIndex++;
        return currentCard;
    }

}
