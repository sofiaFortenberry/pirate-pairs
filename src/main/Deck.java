import java.util.Arrays;

class Deck{

    final private int amtCards = 55;
    private int[] cards = new int[amtCards];
    private int highestOrderCard = 10;
    private int count = 0;

public String deckOfCards(){
    for(int i = 0; i<=highestOrderCard; i++){
        for(int k = 0; k<i; k++){
            cards[count] = i;
            count++;
        }
    }
    return(Arrays.toString(cards));
}
}


