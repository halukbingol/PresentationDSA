package inheritance.code;

import hblib.utility.LibNumber;

/**
 * Point in 2D
 * 
 * @author bingol
 *
 */
public class PPoint {

	double x;
	double y;

	public PPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public PPoint add(PPoint pX) {
		return add(pX.x, pX.y);
	}

	public PPoint add(double deltaX, double deltaY) {
		return new PPoint(x + deltaX, y + deltaY);
	}

	public double distance(PPoint pX) {
		double x2 = (this.x - pX.x) * (this.x - pX.x);
		double y2 = (this.y - pX.y) * (this.y - pX.y);
		return Math.sqrt(x2 + y2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		PPoint p = (PPoint) o;
		return LibNumber.doubleEquals(x, p.x)//
				&& LibNumber.doubleEquals(y, p.y);
	}

	@Override
	public String toString() {
		return "[Point: x=" + x + ", y=" + y + "]";
	}

}
