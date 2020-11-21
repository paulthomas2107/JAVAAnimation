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


public class GraphicsDemo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 344893772413228397L;

	Timer timer = new Timer(10, this);

	Random random = new Random();


	List<Circle> circleList = new ArrayList<>();

	@Data
	@AllArgsConstructor
	class Circle {
		Dimension location;
		Dimension size;
		Color color;

	}

	public GraphicsDemo() {

		timer.start();

		for (int a = 0; a < 2000; a++) {

			circleList.add(new Circle(new Dimension(390, 390), new Dimension(10, 10), new Color((int) (Math.random() * 0x1000000))));
		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.setBackground(new Color(50, 255, 255));

		Graphics2D g2D = (Graphics2D) g;

		for (Circle circle : circleList) {

			g2D.setColor(circle.getColor());
			g2D.fillOval(circle.getLocation().width, circle.getLocation().height, circle.getSize().height,
					circle.getSize().width);
			
			//g2D.draw3DRect(circle.getLocation().width, circle.getLocation().height, circle.getSize().width, circle.getSize().height, true);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		for (Circle circle : circleList) {

			int rnd = random.nextInt(16);

			int height = circle.getLocation().height;
			int width = circle.getLocation().width;
			int sizeX = circle.getSize().height;
			

			switch (rnd) {
			case 1:
				height--;
				break;
			case 2:
				height--;
				width++;
				break;
			case 3:
				width++;
				break;
			case 4:
				height++;
				width++;
				break;
			case 5:
				height++;
				break;
			case 6:
				height--;
				width--;
				break;
			case 7:
				width--;
				break;
			case 8:
				width--;
				height++;
				break;
			case 9:
				sizeX--;
				if (sizeX < 0) sizeX = 10;
				break;
			case 10:
				sizeX++;
				if (sizeX > 30) sizeX = 10;
				break;
			



			}

			circle.setLocation(new Dimension(width, height));
			circle.setSize(new Dimension(sizeX, sizeX));

		}

	}

}
