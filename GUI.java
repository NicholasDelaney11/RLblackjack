// buttons:
//  single q iteration
//  constant q iteration
//  output current P & Q
//  output optimal P & Q
//  reset q learning ( reset P & Q )  (start new game)
// + text fields for variables



package blackjackRL;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame {
	private JButton startGame;
	private JButton singleIteration;
	private JButton toggleIteration;
	private JButton outputPolicyAndValue;
	private JScrollPane sp;
	public static JTextArea gameArea;

	public static final int FRAME_WIDTH = 400;
	public static final int FRAME_HEIGHT = 400;
	
	public static BJRL qLearn;
	public static boolean learningInProgress;
	
	
	public GUI() {
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		startGame = new JButton("Reset Learning");
		startGame.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	startNewGame();
		    }
		});
		outputPolicyAndValue = new JButton("Output Current Policy");
		outputPolicyAndValue.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {	
		    	qLearn.OutputPolicyAndValues();
		    }
		});
		toggleIteration = new JButton("Toggle Iteration");
		toggleIteration.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				// this may not be a good way to do this
		    	learningInProgress = !learningInProgress;
		    }
		});
		singleIteration = new JButton("Single Iteration");
		singleIteration.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	qLearn.QLearningIteration();
		    }
		});
		
		gameArea = new JTextArea(20, 30);
		gameArea.setEditable(false);
		gameArea.setLineWrap(true);
		sp = new JScrollPane(gameArea);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel Panel = new JPanel();
		Panel.setLayout(new FlowLayout());
		Panel.add(toggleIteration);
		Panel.add(outputPolicyAndValue);
		Panel.add(singleIteration);
		Panel.add(startGame);
		Panel.add(sp);
		add(Panel);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		qLearn = new BJRL();
		learningInProgress = false;
		
		
	}
	
	public void startNewGame() {		
		gameArea.setText(null);
		qLearn = new BJRL();
	}
	
	public static void main(String[] args) {
		JFrame mainFrame = new GUI();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);
		
		
		// THIS DOESNT WORK 
		//while(mainFrame.components != null) {
			//if (learningInProgress) {
			//	qLearn.QLearningIteration();
			//}
		
		
	}
}