package window;
import javax.swing.JFrame;

import constants.Constants;

public class Window extends JFrame implements Runnable{
	
	
	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT); //800 pixels X 600 pixels
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);//Usuário não pode modificar as dimensões da janela
		this.setVisible(true);//Permitir o usuário ver janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void run() {
		while(true) {
			//Do this
		}
	}
}
