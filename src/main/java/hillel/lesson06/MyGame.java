package hillel.lesson06;

public class MyGame {

    public static void main(String[] args) {
        PokerCards pCards = new PokerCards();

        PokerGame game = new PokerGame();
        game.registerCards(pCards);

        game.registerPlayer(new Player("Nikolas"))
                .registerPlayer(new Player("Pedro"))
                .registerPlayer(new Player("Daniil"))
                .registerPlayer(new Player("Andrian"));

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
