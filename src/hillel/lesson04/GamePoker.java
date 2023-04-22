package hillel.lesson04;

import java.util.Random;

public class GamePoker {
    private static String[] cardNames = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "dama", "king", "ace"};
    private static String[] suits = {"♦", "♥", "♠", "♧"};
    private static String[] totalCards = new String[cardNames.length * suits.length];
    private static String[] players = {"Nikolas", "Pedro", "Daniil", "Andrian"};
    private static int cardIndex = 0;

    public static void main(String[] args) {
        creationCard();
        unSortCards();
        dealCardsToThePlayers();
    }

    private static void creationCard() {
        for (int i = 0; i < cardNames.length; i++) {
            String cardName = cardNames[i];
            for (int j = 0; j < suits.length; j++) {
                String suitsName = suits[j];
                totalCards[(i * suits.length) + j] = cardName + suitsName;
            }
        }
    }

    private static void unSortCards() {
        Random random = new Random();
        for (int i = 0; i < totalCards.length; i++) {
            String currentCard = totalCards[i];
            int randomIndex = random.nextInt(totalCards.length);
            totalCards[i] = totalCards[randomIndex];
            totalCards[randomIndex] = currentCard;
        }
    }

    private static void dealCardsToThePlayers() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < players.length; j++) {
                String currentPlayer = players[j];
                String currentCard = giveNextCard();
                System.out.println(currentPlayer + " got card " + currentCard);
            }
        }
    }

    private static String giveNextCard() {
        String currentCard = totalCards[cardIndex];
        cardIndex++;
        return currentCard;
    }

}
