package Menu_Toolbar;

import java.awt.Graphics2D;
import java.awt.Point;

public interface Component {
	public void setBounds(int x, int y, int width, int height);
	public boolean contain(Point p);
	public void draw(Graphics2D g);
}
