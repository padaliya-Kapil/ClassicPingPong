package pingPong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;




public class GamePlay  extends JPanel implements KeyListener,ActionListener {
	
	private boolean play = false;
	private int scoreA = 0;
	private int scoreB = 0;
	private Timer timer;
	private int delayed =0;
	private int playerAX=0;
	private int playerBX=1225;
	private int playerAY=250;
	private int playerBY=250;
	
	private int ballPosY=300;
	private int ballPosX=593;
	
	private int ballDirX =-1;
	private int ballDirY =-2;
	
	public GamePlay() 
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delayed,this);
		timer.start();
	
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void paint(Graphics g)
	{	/*To set black background*/
		g.setColor(Color.black);
		g.fillRect(1, 1, 1250, 600);
		
		/*Ball*/
		g.setColor(Color.WHITE);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		/*Court Line*/
		for(int i=0;i<=600;i+=100)	
					{
					g.setColor(Color.WHITE);
					g.fillRect(601, i+10, 20, 50);
					}
		/*Pedal for Player A*/
		g.fillRect(playerAX, playerAY, 20, 80);
		
		/*Pedal for Player B*/
		g.fillRect(playerBX, playerBY, 500, 80);
	
		
		/*ScoreCards*/
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Gill Sans", Font.BOLD, 50));
		g.drawString(""+scoreA, 500,50);
		g.drawString(""+scoreB, 700,50);
		if(scoreA>9)
		{
			play=false;
			g.drawString("WINNER", 300,250);
			
		}
		if(scoreB>9)
		{
			play=false;
			g.drawString("WINNER", 700,250);
		}
		
		
		
		g.dispose();/*dispose this always*/
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			/*This is the logic of collision*/
			if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerAX, playerAY, 20, 80)))
			{
				ballDirX=-ballDirX;
			}
			if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerBX, playerBY, 20, 80)))
			{
				ballDirX=-ballDirX;
			}
			
			/*This is basic logic of movement*/
			ballPosX+=ballDirX;
			ballPosY+=ballDirY;
			if(ballPosX<0)	
				{
				ballDirX=-ballDirX;
				scoreB++;
				}
			if(ballPosY<0){ballDirY=-ballDirY;}
			if(ballPosY>555){ballDirY=-ballDirY;}
			if(ballPosX>1225)
				{
				ballDirX=-ballDirX;
				scoreA++;
				}
		
			
			
			
		}
		repaint();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
					restart();
				}			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(playerBY<=0)
			{
				playerBY=0;
			}
			else {
				playerBY-=20;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			if(playerAY<=0)
			{
				playerAY=0;
			}
			else {
				playerAY-=20;
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(playerBY>=491)
			{
				playerBY=491;
			}
			else {
				playerBY+=20;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_S)
		{
			if(playerAY>=491)
			{
				playerAY=491;
			}
			else {
				playerAY+=20;
			}
		}
		
	}

	private void restart() {
		  play = true;
		  scoreA = 0;
		  scoreB = 0;
		  delayed =0;
		  playerAX=0;
		  playerBX=1225;
		  playerAY=250;
		  playerBY=250;
		
		  ballPosY=300;
		  ballPosX=593;
		
		  ballDirX =-1;
		  ballDirY =-2;
		  
		
	}

	
}
