package convexHull;

import convexHull.Point;

/*
 * 
 * Klasa punkt (x,y)
 * 
 */
public class Point implements Comparable<Point>{
	public int x, y;
	
	public Point() {
		super();
		this.x = 0;
		this.y = 0;
	}	
	
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int compareTo(Point p) {
		//przypadek jezeli w poziomie x obydwa sa na tej samej linii
		//wtedy interesuja nas y
		if (this.x == p.x) {
			return this.y - p.y;
		//normalny przypadek
		} else {
			return this.x - p.x;
		}
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
}
