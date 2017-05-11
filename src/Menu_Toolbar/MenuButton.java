package Menu_Toolbar;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class MenuButton implements Component {
	private Rectangle rectangle;
	private String title;
	private Menubar myMenuBar;
	private boolean viewState;
	
	public MenuButton() {
		init();
	}
	
	public MenuButton(String title) {
		this.title = title;
		init();
	}
	
	public void init() {
		rectangle = new Rectangle();
	}
	
	public Menubar getMyMenuBar() {
		return myMenuBar;
	}

	public void setMyMenuBar(Menubar myMenuBar) {
		this.myMenuBar = myMenuBar;
		this.myMenuBar.setBounds(rectangle.x, rectangle.y + rectangle.height, myMenuBar.getRectangle().width,  myMenuBar.getRectangle().height);
		this.myMenuBar.resetBounds();
	}

	public void setViewMenuBar(boolean bool) {
		this.viewState = bool;
	}
	
	public int getWidth() {
		return rectangle.width;
	}
	
	public void setBounds(int x, int y, int width, int height) {
		rectangle.setBounds(x, y, width, height);
	}

	public boolean contain(Point p) {
		return rectangle.contains(p);
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void draw(Graphics2D g) {
		
		if(this.viewState) {
			if(myMenuBar != null)
				myMenuBar.draw(g);
		}
				
		Color tempColor = g.getColor();
		g.setColor(Color.yellow);
		g.fill(rectangle);
		g.setColor(tempColor);
		g.draw(rectangle);
		g.drawString(title, rectangle.x + 5, rectangle.y + 20);
	}

	public int getHeight() {
		return rectangle.height;
	}

}
