package game_components;

import Geom.*;

public class M {
	private Point3D p;
	private int id;
	private double radius;
	private double speed;

	
	
	public Point3D getP() {
		return p;
	}
	
	
	public void setP(Point3D p) {
		this.p = p;
	}
	public M (Point3D p1, int id1) {
		p= new Point3D(p1);
		this.id = id1;
	}
	
	public M (Point3D p1, int id1, double spee, double rad) {
		p= new Point3D(p1);
		id = id1;
		radius = rad;
		speed = spee;
	}
	public M (double x, double y) {
		p= new Point3D(x,y,0);
	}
	public M (Point3D p1) {
		p= new Point3D(p1);
	}
//	public M (double x, double y, int id1) {
//		; 
//		id = id1;
//	}
	
	public M () {
		p = new Point3D(0, 0);
		
	}

	

}
