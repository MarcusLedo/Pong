package window;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import constants.Constants;
import services.Time;

@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable{
	
	Graphics2D g2;
	
	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT); //800 pixels X 600 pixels
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);//Usuário não pode modificar as dimensões da janela
		this.setVisible(true);//Permitir o usuário ver janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g2 = (Graphics2D) this.getGraphics();
		
	}
	
	public void update(double deltaTime) { 
		//Mostra o tempo que levou para completar o ultimo Frame
		System.out.println("" + deltaTime + " seconds passed since the last frame");
		System.out.println("FPS: " + 1 / deltaTime);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		g2.setColor(Color.GRAY);
		g2.fillOval(350, 250, 40, 40);
	}
	
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
