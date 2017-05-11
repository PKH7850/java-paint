package Menu_Toolbar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Item.item.MENUBARSTATUS;
import Item.item.TOOLBARSTATUS;

public class Panel extends JPanel {

	private Menubar myMenuBar;
	private MouseHandler handler;
	private Menubar file;
	private Menubar edit;
	private Menubar item;
	private Menubar window;
	private Menubar help;
	private Toolbar myToolbar;
	private Toolbar rect;
	private Toolbar oval;

	
	public Panel() {
		handler = new MouseHandler();
		myMenuBar = new Menubar();
		file = new Menubar();
		edit = new Menubar();
		item = new Menubar();
		window = new Menubar();
		help = new Menubar();
		myToolbar = new Toolbar();
		rect = new Toolbar();
		oval = new Toolbar();
		
		init();
	}
	
	public void init() {
				
		file.setMenubarStatus(MENUBARSTATUS.VERTICAL);
		edit.setMenubarStatus(MENUBARSTATUS.VERTICAL);
		item.setMenubarStatus(MENUBARSTATUS.VERTICAL);
		window.setMenubarStatus(MENUBARSTATUS.VERTICAL);
		help.setMenubarStatus(MENUBARSTATUS.VERTICAL);
		rect.setToolbarStatus(TOOLBARSTATUS.VERTICAL);
		oval.setToolbarStatus(TOOLBARSTATUS.VERTICAL);
		
		
		MenuButton fileButton = new MenuButton("File");
		MenuButton editButton = new MenuButton("Edit");
		MenuButton itemButton = new MenuButton("Item");
		MenuButton windowButton = new MenuButton("Window");
		MenuButton helpButton = new MenuButton("Help");
		ToolbarButton rectButton = new ToolbarButton("Rect");
		ToolbarButton ovalButton = new ToolbarButton("Oval");
				
		
		myMenuBar.add(fileButton);
		myMenuBar.add(editButton);
		myMenuBar.add(itemButton);
		myMenuBar.add(windowButton);
		myMenuBar.add(helpButton);
		myToolbar.add(rectButton);
		myToolbar.add(ovalButton);
		
	
		file.add(new MenuButton("New"));
		file.add(new MenuButton("Save"));
		file.add(new MenuButton("Load"));
		file.add(new MenuButton("Exit"));
		edit.add(new MenuButton("Copy"));
		edit.add(new MenuButton("Paste"));
		item.add(new MenuButton("LineColor"));
		item.add(new MenuButton("LineSize"));
		window.add(new MenuButton("Sample"));
		help.add(new MenuButton("About"));
		
		
		fileButton.setMyMenuBar(file);
		editButton.setMyMenuBar(edit);
		itemButton.setMyMenuBar(item);
		windowButton.setMyMenuBar(window);
		helpButton.setMyMenuBar(help);
		rectButton.setMyToolbar(rect);
		ovalButton.setMyToolbar(oval);
		
		
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
	}

	class MouseHandler implements MouseListener, MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseClicked(MouseEvent e) {
			for(MenuButton button : myMenuBar.getMenuList()) {
				if(button.contain(e.getPoint())) {
					button.setViewMenuBar(true);
				} else  {
					button.setViewMenuBar(false);
				}
			}
			repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D)g;
		myMenuBar.draw(g2D);
		myToolbar.draw(g2D);
	}
	
}
