public class BJRL {

	int[] deck = { 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9,
				   10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11 };
	int[] P;
	int[] Q;
	//string[] actions = {"hit" , "stick"}
	
	
	int[] state = new int[3];
	
	public BJRL() {
		// P&Q = [32 x 10]
		// initilize all P to 1/2
		// initialize all Q to 0
		// shuffle deck, deal the player 2 faceup, deal the dealer 1 faceup and 1 facedown
	}
	
	
	public void learningIteration() {
		// same as assign 5
		
	}

}