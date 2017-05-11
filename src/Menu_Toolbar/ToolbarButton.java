package Menu_Toolbar;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class ToolbarButton implements Component {
	private Rectangle rectangle;
	private String title;
	private Toolbar myToolbar;
	private boolean viewState;
	
	public ToolbarButton() {
		init();
	}
	
	public ToolbarButton(String title) {
		this.title = title;
		init();
	}
	
	public void init() {
		rectangle = new Rectangle();
	}
	
	public Toolbar getMyToolbar() {
		return myToolbar;
	}

	public void setMyToolbar(Toolbar myToolbar) {
		this.myToolbar = myToolbar;
		this.myToolbar.setBounds(rectangle.x, rectangle.y + rectangle.height, myToolbar.getRectangle().width,  myToolbar.getRectangle().height);
		this.myToolbar.resetBounds();
	}

	public void setViewToolbar(boolean bool) {
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
			if(myToolbar != null)
				myToolbar.draw(g);
		}
				
		Color tempColor = g.getColor();
		g.setColor(Color.green);
		g.fill(rectangle);
		g.setColor(tempColor);
		g.draw(rectangle);
		g.drawString(title, rectangle.x + 5, rectangle.y + 20);
	}

	public int getHeight() {
		return rectangle.height;
	}

}