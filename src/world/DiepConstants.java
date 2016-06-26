package world;
import java.awt.Color;
import java.awt.BasicStroke;

public class DiepConstants {
	public static final Color BACKGROUND = new Color(245, 245, 245);
	public static final Color TANKCOLOR = new Color(0, 161, 219);
	public static final Color GUNCOLOR = new Color(135, 135, 135);
	public static final Color BULLETCOLOR = new Color(237, 51, 64);
	public static final Color OUTLINECOLOR = Color.BLACK;
	/*public static final double TANKSIZE = 70.0;
	public static final double TANKHEALTH = 100.0;
	public static final double TANKDAMAGE = 5.0;
	public static final double TANKSPEED = 3.0;
	public static final double GUNLENGTH = 70.0;
	public static final double GUNWIDTH = 30.0;*/
	public static final BasicStroke THIN = new BasicStroke(1.0f);
	public static final BasicStroke MEDIUM = new BasicStroke(2.0f);
	public static final BasicStroke THICK = new BasicStroke(4.0f);
	public static final int FRAMEWIDTH = 800;
	public static final int FRAMEHEIGHT = 600;
	public static final int MAPWIDTH = 8000;
	public static final int MAPHEIGHT = 6000;
	public static final double DECELERATION = 0.9;
	public static final double ACCELERATION = 1;
	public static final int BACKGROUNDLINESPACING = 50;
	public static final Color BACKGROUNDLINECOLOR = new Color(230, 230, 230);
}