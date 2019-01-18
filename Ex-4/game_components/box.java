package game_components;

import Geom.Point3D;

public class box {
	
	private Point3D p1;
	private Point3D p2;
	private int id;
	
	
	public box(Point3D pp1, Point3D pp2, int id) {
		p1 = pp1;
		p2= pp2;
		this.id = id;
	}


	public Point3D getP1() {
		return p1;
	}


	public void setP1(Point3D p1) {
		this.p1 = p1;
	}


	public Point3D getP2() {
		return p2;
	}


	public void setP2(Point3D p2) {
		this.p2 = p2;
	}
	

}
