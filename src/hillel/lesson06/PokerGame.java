package hillel.lesson06;

import java.util.ArrayList;
import java.util.List;

public class PokerGame {

    private PokerCards cardDeck = null;
    private final List<Player> listOfPlayers = new ArrayList<>();
    private boolean gameIsPrepared = false;

    public void registerCards(PokerCards currentCardDeck) {
        cardDeck = currentCardDeck;
    }

    public PokerGame registerPlayer(Player currentPlayer) {
        listOfPlayers.add(currentPlayer);
        return this;
    }

    public void prepareForGame() {
        if (cardDeck == null) {
            throw new RuntimeException("No cards for game!");
        }
        if (listOfPlayers.isEmpty()) {
            throw new RuntimeException("No players for game!");
        }
        cardDeck.unSortCards();
        gameIsPrepared = true;
    }

    public void executeRound() {
        String currentCard;
        checkGameIsPrepared();
        for (Player currentPlayer : listOfPlayers) {
            currentCard = cardDeck.giveNextCard();
            currentPlayer.addOfGotCard(currentCard);
            System.out.println(currentPlayer.getPlayerName() + " got card " + currentCard);
        }
    }

    public void showPlayersCards() {
        checkGameIsPrepared();
        for (Player currentPlayer : listOfPlayers) {
            currentPlayer.displayAllCards();
        }
    }

    private void checkGameIsPrepared() {
        if (gameIsPrepared == false) {
            throw new RuntimeException("Game not prepared! Use prepareForGame() for prepare.");
        }
    }


}
