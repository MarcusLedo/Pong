package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import constants.Constants;
import entities.Rectangle;
import services.KeyIn;
import services.PlayerController;
import services.Time;

@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable{
	
	private Graphics2D g2;
	private KeyIn keyListener = new KeyIn();
	Rectangle player1, player2;
	Rectangle ball;
	private PlayerController playerController;
	
	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT); //800 pixels X 600 pixels
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);//Usuário não pode modificar as dimensões da janela
		this.setVisible(true);//Permitir o usuário ver janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(keyListener);
		g2 = (Graphics2D) this.getGraphics();
		
		player1 = new Rectangle(Constants.HZ_SPACING, 40, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PLAYER_COLOR);
		playerController = new PlayerController(player1, keyListener);
		
		player2 = new Rectangle(Constants.SCREEN_WIDTH - 20.0 - Constants.HZ_SPACING, 40.0, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PLAYER_COLOR);
		ball = new Rectangle(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Color.WHITE);
		
		Constants.HEIGHT_LIMIT = this.getInsets().top;
		
	}
	
	public void update(double deltaTime) { 
		Image dbImage = createImage(getWidth(), getHeight());
		Graphics dbg = dbImage.getGraphics();
		this.draw(dbg);
		g2.drawImage(dbImage, 0, 0, this);
		//Mostra o tempo que levou para completar o ultimo Frame
		System.out.println("" + deltaTime + " seconds passed since the last frame");
		System.out.println("FPS: " + String.format("%.2f", getFPS(deltaTime)));
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		
		//int key = keyListener.getKey(); Salvando a tecla
		//if(keyListener.isKeyPressed(KeyEvent.VK_UP))
			//System.out.println("Pressing: up arrow key");
		
		playerController.update(deltaTime);
		
		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		player1.draw(g2);
		player2.draw(g2);
		ball.draw(g2);
	}
	
	public double getFPS(double deltaTime) {
		return 1 / deltaTime;
	}
	
	
	@Override
	public void run() {
		double lastFrameTime = 0.0;
		while(true) {
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime;
			lastFrameTime = time;
			update(deltaTime);
			/*
			try {
				//Esse método pode gerar uma exeção, por isso precisamos do tryCatch
				Thread.sleep(15); //Travando em 60fps
			} catch(Exception e) {
				
			}
			*/
		}
	}
	
	
	
}
