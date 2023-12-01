public class Dealer {
   
    public String startGame() {
        String setup = ""; 
        int amtPlayers = 4; 
    
        for (int i = 1; i <= amtPlayers; i++) {
            if (cards.length > 0) {
                int dealtCard = cards[0];
                setup += "Player " + i + ": " + dealtCard + "\n";
    
                int[] remainingCards = new int[cards.length - 1];
                for (int j = 1; j < cards.length; j++) {
                    remainingCards[j - 1] = cards[j];
                }
                cards = remainingCards;
            } 
        }
    
        return setup;
    }


}
