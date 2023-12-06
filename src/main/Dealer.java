public class Dealer {
    private Player[] players;
    private Deck deck;
    private int losingScore = 21;

    public Dealer(int numPlayers){
        deck = new Deck();
        players = new Player[numPlayers];
        for(int i = 0; i<numPlayers; i++){
            players[i]= new Player(i+1);
            players[i].resetHand();
            players[i].resetScore();
            players[i].drawCard(deck);
        }
    }

    public void playGame(){
        boolean gameEnded = false;
        int count = 0;

        for(Player player : players){
            while(player.getHand().length == 0){
                player.drawCard(deck);
            }
        }

        while(!gameEnded){
            Player currentPlayer = players[count];
            
            System.out.println("--------------------------------");
            System.out.println("Player " + currentPlayer.getId() + " 's turn.");
            System.out.println("Current discard pile: " + arrayToString(deck.getDiscardPile()));
            System.out.println("Player " + currentPlayer.getId() + " 's hand: " + arrayToString(currentPlayer.getHand()));
            System.out.println("Player " + currentPlayer.getId() + " 's score: " + currentPlayer.getScore());

            int action;

            if(currentPlayer.getHand().length == 1){
                action = 1;
            }else{
                action = (int)(Math.random()*2)+1;
            }

            if (action == 1){
                int drawnCard = currentPlayer.drawCard(deck);
                currentPlayer.addToDiscardPile(deck);
            }else{
                int lowestCard = getLowestCard(players);
                currentPlayer.resetHand();
                currentPlayer.addToScore(lowestCard);
                if(currentPlayer.getScore()>0){
                    deck.addToDiscardPile((lowestCard));
                    System.out.println("Player " + currentPlayer.getId() + " folded and took the lowest card points");
                }
            }
            if(currentPlayer.getScore() >= losingScore){
                System.out.println("Player " + currentPlayer.getId() + "has reached the losing socre. Game over!");
                gameEnded = true;
            }
            count = (count + 1) % players.length;
        }
    }
    


    private static int getLowestCard(Player[] players){
        int lowestCard = 1;
        boolean found = false;

        for(Player player : players){
            int playersLowestCard = player.getLowestCard();
            if(!found){
                lowestCard = playersLowestCard;
                found = true;
            }else{
                if(playersLowestCard <lowestCard){
                    lowestCard = playersLowestCard;
                }
            }
        }
        return lowestCard;
    }

    private static String arrayToString(int[] array){
        String result =  "[";
        for(int i = 0; i<array.length; i++){
            result += array[i];
            if(i<array.length -1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}

