import java.util.Arrays;

class Deck{

    private final int amtCards = 55;
    public int[] cards = new int[amtCards];
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




}


