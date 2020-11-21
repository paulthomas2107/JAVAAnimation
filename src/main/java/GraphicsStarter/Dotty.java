package GraphicsStarter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Dotty extends JPanel implements ActionListener {

	private static final long serialVersionUID = 344893772413228397L;

	private Timer timer = new Timer(0, this);

	private Random random = new Random();

	private List<Dot> dotListHolder = new ArrayList<>();

	private DotList dotHolder;
	
	private static final int MAX_ROWS = 840;
	private static final int MAX_COLUMNS = 840;
	private static final int DIAMETER = 20;
	
	private int line = 0;
	private int row = 1;

	@Data
	@AllArgsConstructor
	class Dot {
		private int size;
		private boolean status;
		private Color color;
		
	}
		
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	class DotList {
		private List<List<Dot>> dotList = new ArrayList<>();
	}

	public Dotty() {

		timer.start();
		dotHolder =  new DotList();
		createRow();

	}

	private void createRow() {
		dotListHolder = new ArrayList<>();

		for (int a = 0; a < MAX_COLUMNS; a++) {

			

				dotListHolder.add(new Dot(random.nextInt(DIAMETER), random.nextInt(2) == 0 ? true : false, new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255))));
			
	
		};
		
		
		
		dotHolder.getDotList().add(dotListHolder);
		
	
		row++;
		
	

	}

	public void paintComponent(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;

		super.paintComponent(g);
		this.setBackground(Color.BLACK);


		for (int a = 0; a < dotHolder.getDotList().size(); a++) {
			List<Dot> dotList = dotHolder.getDotList().get(a);
			for (int b = 0; b < MAX_ROWS ; b=b + DIAMETER) {
				Dot myDot = dotList.get(b);
				g2D.setColor(myDot.status ? Color.BLACK : myDot.getColor());
				g2D.fillOval(b, line+a*DIAMETER, myDot.getSize(), myDot.getSize());
				g2D.fillOval(line+a*DIAMETER, b,  myDot.getSize(), myDot.getSize());
				g2D.fillOval(MAX_ROWS - line+a*DIAMETER, b,  myDot.getSize(), myDot.getSize());
				g2D.fillOval(b, MAX_ROWS - line+a*DIAMETER, myDot.getSize(), myDot.getSize());
				
				
			

			}
				
		
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		line++;

		if (line == 840) {
			row = row +1;
			createRow();
			line = -1;
		}

		repaint();

	}

}
