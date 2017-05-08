package object;

import java.util.ArrayList;
import java.util.List;

public class objAttributeCommon {
	public static List<objFood> foodList = new ArrayList<objFood>();
	public static List<objNode> mapList = new ArrayList<objNode>();
	public static List<objGhost> ghostList = new ArrayList<objGhost>();
	public int runFlg = 1;

	public final char WALL_CONTENT = '█';
	public final char FOOD_CONTENT = '.';
	public final char ROAD_CONTENT = ' ';
	public final char GHOST_CONTENT = 'G';
	public final char PACMAN_CONTENT = 'P';
	public final double SAFE_DISTANCE = 2;
	public final double SAFE_DISTANCE2 = 4;
	public final int SPEED_MOVE = 100;
	public final int WIDTH_MAP = 107;
	public final int HEIGHT_MAP = 16;
}
