package Menu_Toolbar;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import Item.item.TOOLBARSTATUS;

public class Toolbar implements Component {
	
	private Rectangle rectangle;
	private Vector<ToolbarButton> toolbarList;
	private TOOLBARSTATUS toolbarStatus;

	public Toolbar() {
		rectangle = new Rectangle();
		toolbarList = new Vector<ToolbarButton>();
		toolbarStatus = TOOLBARSTATUS.HORIZON;
		init();
	}
	
	private void init() {
		rectangle.x = 0;
		rectangle.y = 0;
		
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public TOOLBARSTATUS getToolbarStatus() {
		return toolbarStatus;
	}
	
	public void resetBounds() {
		int width = 0;
		int height = 0;
		int x = rectangle.x;
		int y = rectangle.y+30;
		
		for(ToolbarButton button : toolbarList) {
			Rectangle tmp = button.getRectangle();
					
			button.setBounds(x, y, 80, 30);
			if (toolbarStatus == TOOLBARSTATUS.HORIZON) {
				x += 80;
				width += button.getWidth();
			} else if(toolbarStatus == TOOLBARSTATUS.VERTICAL) {
				y += 30;
				height += button.getHeight();
			}
		}
		
		this.setBounds(rectangle.x, rectangle.y, width, height);
	}
	
	public void add(ToolbarButton button) {
		toolbarList.add(button);
		resetBounds();
	}
	
	public Vector<ToolbarButton> getToolbarList() {
		return toolbarList;
	}

	public void setToolbarList(Vector<ToolbarButton> toolbarList) {
		this.toolbarList = toolbarList;
	}

	public void setBounds(int x, int y, int width, int height) {
		rectangle.setBounds(x, y, width, height);
	}

	public boolean contain(Point p) {
		return rectangle.contains(p);
	}
	
	public void draw(Graphics2D g) {
		g.draw(rectangle);
		for(ToolbarButton button : toolbarList) {
			button.draw(g);
		}
	}

	public void setToolbarStatus(TOOLBARSTATUS vertical) {
		// TODO Auto-generated method stub
		
	}
}
