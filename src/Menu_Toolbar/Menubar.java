package Menu_Toolbar;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import Item.item.MENUBARSTATUS;


public class Menubar implements Component {
	
	private Rectangle rectangle;
	private Vector<MenuButton> menuList;
	private MENUBARSTATUS menubarStatus;

	public Menubar() {
		rectangle = new Rectangle();
		menuList = new Vector<MenuButton>();
		menubarStatus = MENUBARSTATUS.HORIZON;
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
	
	public MENUBARSTATUS getMenubarStatus() {
		return menubarStatus;
	}
	
	public void setMenubarStatus(MENUBARSTATUS menubarStatus) {
		this.menubarStatus = menubarStatus;
	}
	public void resetBounds() {
		int width = 0;
		int height = 0;
		int x = rectangle.x;
		int y = rectangle.y;
		
		for(MenuButton button : menuList) {
			Rectangle tmp = button.getRectangle();
					
			button.setBounds(x, y, 80, 30);
			if (menubarStatus == MENUBARSTATUS.HORIZON) {
				x += 80;
				width += button.getWidth();
			} else if(menubarStatus == MENUBARSTATUS.VERTICAL) {
				y += 30;
				height += button.getHeight();
			}
		}
		
		this.setBounds(rectangle.x, rectangle.y, width, height);
	}
	
	public void add(MenuButton button) {
		menuList.add(button);
		resetBounds();
	}
	
	public Vector<MenuButton> getMenuList() {
		return menuList;
	}

	public void setMenuList(Vector<MenuButton> menuList) {
		this.menuList = menuList;
	}

	public void setBounds(int x, int y, int width, int height) {
		rectangle.setBounds(x, y, width, height);
	}

	public boolean contain(Point p) {
		return rectangle.contains(p);
	}
	
	public void draw(Graphics2D g) {
		g.draw(rectangle);
		for(MenuButton button : menuList) {
			button.draw(g);
		}
	}
}
