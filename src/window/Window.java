package window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import constants.Constants;
import services.Time;
import services.KeyIn;

@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable{
	
	private Graphics2D g2;
	private KeyIn keyListener = new KeyIn();
	
	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT); //800 pixels X 600 pixels
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);//Usuário não pode modificar as dimensões da janela
		this.setVisible(true);//Permitir o usuário ver janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(keyListener);
		g2 = (Graphics2D) this.getGraphics();
		
	}
	
	public void update(double deltaTime) { 
		//Mostra o tempo que levou para completar o ultimo Frame
		System.out.println("" + deltaTime + " seconds passed since the last frame");
		System.out.println("FPS: " + 1 / deltaTime);
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		
		int key = keyListener.getKey();
		
		switch(key) {
		case KeyEvent.VK_UP:
			System.out.println("Pressing: up arrow key");
		break;
		case KeyEvent.VK_DOWN:
			System.out.println("Pressing: down arrow key");
		break;
		}
		
		//if(keyListener.isKeyPressed(KeyEvent.VK_UP))
			//System.out.println("Pressing: up arrow key");
	}
	
	
	@Override
	public void run() {
		double lastFrameTime = 0.0;
		while(true) {
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime;
			lastFrameTime = time;
			
			update(deltaTime);
			
			try {
				//Esse método pode gerar uma exeção, por isso precisamos do tryCatch
				Thread.sleep(15); //Travando em 60fps
			} catch(Exception e) {
				
			}
		}
	}
	
	
	
}
