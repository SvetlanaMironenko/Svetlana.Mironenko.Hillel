package hillel.lesson06;

public class MyGame {

    public static void main(String[] args) {
        PokerCards pCards = new PokerCards();

        Player playerOne = new Player("Nikolas");
        Player playerTwo = new Player("Pedro");
        Player playerThree = new Player("Daniil");
        Player playerFour = new Player("Andrian");

        PokerGame game = new PokerGame();
        game.registerCards(pCards);

        game.registerPlayer(playerOne);
        game.registerPlayer(playerTwo);
        game.registerPlayer(playerThree);
        game.registerPlayer(playerFour);

        System.out.println("1. Prepare for game");
        game.prepareForGame();

        System.out.println("2. Game started");
        for (int i = 1; i <= 5; i++) {
            System.out.println("========== Round " + i + " ==========");
            game.executeRound();
            System.out.println("");
        }

        System.out.println("3. Displaying players cards");
        game.showPlayersCards();
    }
}
