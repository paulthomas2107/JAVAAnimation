package GraphicsStarter;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	//GraphicsDemo graphicsDemo = new GraphicsDemo();
	Dotty graphicsDemo  = new Dotty();
	
	public MyFrame() {
		
		this.setSize(840, 840);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(graphicsDemo);
		this.setVisible(true);
		
	}
	
	

}
