import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame {
	private JButton startGame;
	public static JTextArea gameArea;
	private JScrollPane sp;
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	
	public GUI() {
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		startGame = new JButton("New game");
		startGame.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//startNewGame();
		    }
		});
		
		gameArea = new JTextArea(10, 15);
		gameArea.setEditable(false);
		gameArea.setLineWrap(true);
		sp = new JScrollPane(gameArea);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel Panel = new JPanel();
		Panel.setLayout(new FlowLayout());
		Panel.add(startGame);
		Panel.add(sp);
		add(Panel);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		
	}
	
	public void startNewGame() {		
		gameArea.setText(null);
	}
	
	public static void main(String[] args) {
		JFrame mainFrame = new GUI();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);
	}
}