package inheritance.code;

public class PTriangle extends PPolygon {
	PPoint pA;
	PPoint pB;
	PPoint pC;

	public PTriangle(PPoint pA, PPoint pB, PPoint pC) {
		this.pA = pA;
		this.pB = pB;
		this.pC = pC;
	}

	public static double heron(double a, double b, double c) {
		// https://en.wikipedia.org/wiki/Heron's_formula
		double s = (a + b + c) / 2;
		double x = s * (s - a) * (s - b) * (s - c);
		return Math.sqrt(x);
	}

}
