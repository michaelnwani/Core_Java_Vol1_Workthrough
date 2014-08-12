package bounce;

import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;

/**
 * A ball that moves and bounces off the edges of a rectangle
 * @author michaelnwani
 *
 */
public class Ball 
{
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1; //an incremental step? x = 1. x = 1 + 1. x = 2 + 1. ...
	private double dy = 1;
	
	/**
	 * Moves the ball to the next position, reversing direction if it hits one of the edges
	 */
	public void move(Rectangle2D bounds)
	{
		x += dx;
		y += dy;
		if (x < bounds.getMinX())
		{
			x = bounds.getMinX(); //does x become less than the minimum when it hits the end of the 'screen' (the x-coordinate)? Thereby resetting its position
			dx = -dx; //a precaution? Is the point to ALWAYS keep x = to bounds.getMinX()? If so, it makes sense. 
			//It flips back and forth. Wowwww
		}
		if (x + XSIZE >= bounds.getMaxX()) //we have safeguards against both directions. Again, dx = -dx means it starts going the opposite direction, then can turn around again
		{
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if (y < bounds.getMinY())
		{
			y = bounds.getMinY();
			dy = -dy;
		}
		if (y + YSIZE >= bounds.getMaxY())
		{
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	/**
	 * Gets the shape of the ball at its current position
	 */
	public Ellipse2D getShape() //will always repeatedly be called?
	{
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
	
}
