package blackjackRL;
import java.util.Random;

public class Environment {
	static int[] deck = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5,
						6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10,
						10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
	String[] actions = {"hit" , "stick"};       // actions[0] = "hit", actions[1] = "stick"
	int[] playerHand = new int[3];              // value total, dealer's card, soft ace
	int[] dealerHand = new int[2];
	
	int maxScore = 21;       // 1 - 21
	int maxCard = 11;        // 1 - 11

	public Environment() {};

	public String[] getActions() {
		return actions;
	}

	public double getReward(int cardValue, int dTopCard, int soft, int action) {
		if (actions[action] == "Stick") {
			// might want ace to be 11 here
			return dealerTurn();
		}
		else if (cardValue > 21) {                                                              
			return -1.0;
		}
		else if (playerHand[1] == 21 || playerHand[1] == 11 && playerHand[3] == 1) {             
			return 1.5;
		}
		else {                                                                                   
			return 0;                                                                            
		}
	}

	// return int[][] instead
	public int dealCard(int player) {
		int card = -1;
		int index = 0;

		// get random card from deck
		while (card != -1) {
			index = new Random().nextInt(deck.length);
			card = deck[index];
		}

		// check if card dealt was an ace
		if (deck[index] == 1) {                     
			if ( player == 1 ) {		
				playerHand[2] = 1;                  
			}
			else {
				dealerHand[3] = 1;
			}
		}

		playerHand[1] += deck[index];
		deck[index] = -1;
		return card;
	}

	public double dealerTurn() {

		while ( dealerHand[1] <= 21 ) {
			// dealer sticks
			if (dealerHand[1] > playerHand[1]) {
				return -1.0;
			}
			else if (dealerHand[2] == 1 && dealerHand[1]+10 > playerHand[1]) {
				return -1.0;
			}
			dealerHand[1] += dealCard(1);
		}
		return 1.0;
	}

	public Environment shuffleDeck() {
		Environment env = new Environment();
		return env;
	}

}