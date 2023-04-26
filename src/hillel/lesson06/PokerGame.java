package hillel.lesson06;

import java.util.ArrayList;
import java.util.List;

public class PokerGame {

    private PokerCards cardDeck = null;
    private final List<Player> listOfPlayers = new ArrayList<>();

    public void registerCards(PokerCards currentCardDeck) {
        cardDeck = currentCardDeck;
    }

    public void registerPlayer(Player currentPlayer) {
        listOfPlayers.add(currentPlayer);
    }

    public void prepareForGame() {
        if (cardDeck == null) {
            System.out.println("No cards for game!");
            return;
        }
        if (listOfPlayers.isEmpty()) {
            System.out.println("No players for game!");
            return;
        }
        cardDeck.unSortCards();
    }

    public void executeRound() {
        String currentCard;
        for (Player currentPlayer : listOfPlayers) {
            currentCard = cardDeck.giveNextCard();
            currentPlayer.addOfGotCard(currentCard);
            System.out.println(currentPlayer.getPlayerName() + " got card " + currentCard);
        }
    }

    public void showPlayersCards() {
        for (Player currentPlayer : listOfPlayers) {
            currentPlayer.displayAllCards();
        }
    }


}
