package hillel.lesson06;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String playerName;
    private final List<String> listOfCards = new ArrayList<>();

    public Player(String name) {
        playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void addOfGotCard(String currentCard) {
        listOfCards.add(currentCard);
    }

    public void displayAllCards() {
        System.out.println("Player " + playerName + " contains cards: " + listOfCards);
    }

}
