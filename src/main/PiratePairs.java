public class PiratePairs {
    public static void main(String[] args){
        Deck newDeck = new Deck();
        Dealer newDealer = new Dealer();
        System.out.println(newDeck.printDeck());
        System.out.println(newDeck.shuffleDeck());
        //System.out.println(newDeck.giveCards());
        System.out.println(newDealer.startGame());
    }
}
