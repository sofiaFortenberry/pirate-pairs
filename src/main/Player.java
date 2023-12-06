public class Player {
    private int score;
    private int[] hand;
    private int id;

    public Player(int playerId){
        this.id = playerId;
        this.hand = new int[0];
    }

    public int getId(){
        return id;
    }

    public int getScore(){
        return score;
    }

    public int[] getHand(){
        return hand;
    }
    
    public int drawCard(Deck deck){
        int drawnCard = deck.drawCard();
        addToHand(drawnCard);
        return drawnCard;
    }

    public void addToHand(int card){
        int[] newHand = new int[hand.length + 1];
        for (int i =0; i<hand.length; i++){
            newHand[i] = hand[i];
        }
        newHand[hand.length] =card;
        hand = newHand;
      }
    

    public boolean checkPair(int drawnCard){
        for (int i = 0; i<hand.length; i++){
            if (hand[i] == drawnCard){
                return true;
            }
        }
        return false;
    }

    public void resetHand(){
        hand = new int[0];
    }

    public void resetScore(){
        score = 0;
    }

    public void addToScore(int points){
        score += points;
    }

    public int getLowestCard(){
        if(hand.length == 0){
            return -1;
        }
        int lowestCard = hand[0];
        for(int card : hand){
            if(card<lowestCard){
                lowestCard = card;
            }
        }
        return lowestCard;
    }

    public void addToDiscardPile(Deck deck){
        if(hand.length>0){
            int drawnCard = hand[hand.length -1];
            if(checkPair(drawnCard)){
                deck.addToDiscardPile(drawnCard);
                resetHand();
                addToScore(drawnCard);
            }else{
                
            }
        }
    }
}
