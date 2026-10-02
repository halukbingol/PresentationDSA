package inheritance.code;

import java.util.Arrays;
import hblib.io.svg.Line;

/**
 * Convex polygon.
 * 
 * @author bingol
 */
public class PPolygon extends PShape {

	PPoint[] corner;

	public PPolygon() {
		corner = null;
	}

	public PPolygon(PPoint pA, PPoint pB, PPoint pC) {
		this(new PPoint[] { pA, pB, pC });
	}

	public PPolygon(PPoint pA, PPoint pB, PPoint pC, PPoint pD) {
		this(new PPoint[] { pA, pB, pC, pD });
	}

	public PPolygon(PPoint[] corner) {
		// TODO should deep-clone the array.
		this.corner = corner;
		/**/System.out.println("line:" + Arrays.toString(this.corner));
	}

	@Override
	public double circumference() {
		double d = 0;
		for (int i = 0; i < corner.length - 1; i++) {
			d += corner[i].distance(corner[i + 1]);
		}
		d += corner[corner.length - 1].distance(corner[0]);
		return d;
	}

	@Override
	public double area() {
		/**/System.out.println("\narea");
		double d = 0;
		for (int i = 1; i < corner.length - 1; i++) {
			double a = corner[0].distance(corner[i]);
			double b = corner[0].distance(corner[i + 1]);
			double c = corner[i].distance(corner[i + 1]);
			d += PTriangle.heron(a, b, c);
		}
		return d;
	}

	@Override
	public String toString() {
		return "[Polygon: corner=" + Arrays.toString(corner) + "]";
	}

}
