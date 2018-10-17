/**
 * 
 */
package pingPong;

import javax.swing.JFrame;

/**
 * @author Rafale
 *
 */
public class Main {


	
	public static void main(String[] args) {
		GamePlay gameplay = new GamePlay();
		JFrame frame = new JFrame();
		frame.setBounds(10,10,1250,600);
		frame.setVisible(true);
		frame.setTitle("Classic PingPong");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gameplay);
		// TODO Auto-generated method stub

	}

}
