class Deck{

    private int[] cards;
    private int[] discardPile;
    private int topCard;

    public Deck(){
        intializeDeck();
        shuffleDeck();
        discardPile = new int[0];
        topCard = 0;
    }

    private void intializeDeck(){
        cards = new int[55];
        int count = 0;
        for(int i = 1; i<=10; i++){
            for(int k = 0; k<i; k++){
                cards[count] = i;
                count++;
            }   
        }  
    }

    public void shuffleDeck(){
        for (int i = 0; i< cards.length; i++){
            int randNum = (int) (Math.random()*(i+1));

            int temp = cards[randNum];
            cards[randNum] = cards[i];
            cards[i] = temp;
        }
    }

    public int drawCard(){
        return cards[topCard++];
    }

    public void addToDiscardPile(int card){
        int[] newDiscardPile = new int[discardPile.length + 1];
        for(int i = 0; i<discardPile.length; i++){
            newDiscardPile[i] = discardPile[i];
        }
        newDiscardPile[discardPile.length] = card;
        discardPile = newDiscardPile;
    }

    public int[] getDiscardPile(){
        return discardPile;
    }

}










