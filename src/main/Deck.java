import java.util.Arrays;

class Deck{

    private final int amtCards = 55;
    private int[] cards = new int[amtCards];
    private int highestOrderCard = 10;
    private int count = 0;

public Deck(){
    for(int i = 0; i<=highestOrderCard; i++){
        for(int k = 0; k<i; k++){
            cards[count] = i;
            count++;
        }
    }
}

public String printDeck(){
    return(Arrays.toString(cards));
}

public String shuffleDeck(){
    for (int i = 0; i< cards.length; i++){
        int randNum = (int) (Math.random()*(i+1));

        int temp = cards[randNum];
        cards[randNum] = cards[i];
        cards[i] = temp;
    }
    return(Arrays.toString(cards));
}

private int amtPlayers = 4;
private String setup = "";
int[] remainingCards = new int[cards.length];

public String startGame(){
    for(int i = 1; i<=amtPlayers; i++){
        int dealtCard = remainingCards[0];
        setup += "Player " + i + ": " + dealtCard + "\n";

        remainingCards = new int[cards.length - 1];
        for (int j = 1; j < cards.length; j++) {
            remainingCards[j - 1] = cards[j];

        }
    }
    return setup;
}

}


