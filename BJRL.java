package blackjackRL;

import java.util.Random;

public class BJRL {

	private double[][][][] P;                 // = [card value][dealers top card][softace?][action]
	private double[][][][] Q;
	
	private int[] state;                     // = [card total, dealer's top card, soft ace?]        
	private int[] dealerState;               // = [card total, soft ace?]
	private Environment env;
	private final double EPSILON;
	
	public BJRL() {
		state = new int[3];
		dealerState = new int[3];
		env = new Environment();
		Q = new double[21][11][2][2];   // card value
		P = new double[21][11][2][2];
		EPSILON = 0.1;
		
		// deal player 2 cards and deal dealer 1 card (start new hand)
		// int[] card = Environment.dealCard();
		// state[0] = card[0];
		// state[2] = card[1];
		// card = Environment.dealCard();
		// dealerState = card;
		// state[1] = dealerState[0];
		
		
		// P&Q = [32 x 10]
		// no split action added yet
		// initialize all P to 1/2
		// initialize all Q to 0
		for (int s = 0; s < 21; s++) {
			for (int d = 0; d < 11; d++) {
				for (int a = 0; a < 2; a++) {
					for (int i = 0; i < env.actions.length; i++) {
						Q[s][d][a][i] = 0;
						P[s][d][a][i] = 1.0/env.actions.length;
					}
				}
			}
		}
		
		
	}
	
	
	public void QLearningIteration() {
		
		
		int action = selectActionFromPolicy(state);
		GUI.gameArea.append(action+"");
		//double reward = Environment.getReward(state[0], state[1], state[2], action);
		
 
		// 2. take action, get reward and get next state
		   // don't update state here!! need both states for update!
		// 3. update policy and value
		// 4. state = next state
		// 5. "shuffle deck" if state is terminal
		// test each numbered step and environment functions as you go
		
	}
	
	public int selectActionFromPolicy(int[] state) {
		String[] actions = env.getActions();
		
		if (new Random().nextDouble() < EPSILON ) {
			return new Random().nextInt(actions.length);
		}
		else {
			double randNum = new Random().nextDouble();
			double offSet = 0;
			for (int i = 0; i < actions.length; i++) {
				if (randNum < P[state[0]][state[1]][state[2]][i] + offSet) {
					return i;
				}
				offSet +=  P[state[0]][state[1]][state[2]][i];
			}
			
		}
		return -1;                        // an error has occured 
	}
	
	public void OutputPolicyAndValues() {
		for (int s = 0; s < 21; s++) {
			for (int d = 0; d < 11; d++) {
				for (int a = 0; a < 2; a++) {
					for (int i = 0; i < env.actions.length; i++) {
						GUI.gameArea.append(Double.toString(Q[s][d][a][i]) + " ");
					}
				}
				GUI.gameArea.append("\n");
			}
		}
		
		for (int s = 0; s < 21; s++) {
			for (int d = 0; d < 11; d++) {
				for (int a = 0; a < 2; a++) {
					for (int i = 0; i < env.actions.length; i++) {
						GUI.gameArea.append(Double.toString(P[s][d][a][i]) + " ");
					}
					GUI.gameArea.append("\n");
				}
			}
		}
	}
	 
}
/*
Initialize Q(s, a) arbitrarily
Repeat (for each episode):
Choose a from s using policy derived from Q
Take action a, observe r, and s'
Q(s, a) ⇐ Q(s, a) +  [r +  maxa' Q(s', a') ­ Q(s, a)]
s ⇐ s'
until s is terminal
Figure 1: The Q­learning algorithm

1. 6 decks (5 in play, and 1 as a buffer)
2. Dealer stands on soft 17
3. Double down allowed after splitting
4. No limit on the number of re-splits
5. Insurance is not offered
6. No surrender
7. Natural blackjack pays 3:2


*/
