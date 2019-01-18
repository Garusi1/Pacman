package game_components;

import Geom.Point3D;

public class ghost {

	private Point3D ghostPoint;

	/** The speed. */
	private double speed; 

	/** The Radius. */
	private double Radius;

	/** The id. */
	private int id;

	public ghost(Point3D p, int id, double spe, double rad) {
		ghostPoint=p;
		this.id=id;
		speed = spe;
		Radius = rad;

	}

	//getters and setters

	/**
	 * 
	 * @return
	 */
	public Point3D getPoint() {
		return ghostPoint;
	}

	public void setPoint(Point3D p) {
		ghostPoint=p;

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRadius() {
		return Radius;
	}

	public void setRadius(double radius) {
		Radius = radius;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
