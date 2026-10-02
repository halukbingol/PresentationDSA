package inheritance.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)

class All_PShape_jUnit {
	static final double EPSILON = 1e-1;

	// location of points
	// .. 00.30.60.90
	// 00 A..B..C..D
	// 40 E..F..G..H
	// 80 I..J..K..L

	final PPoint pA = new PPoint(0, 0);
	final PPoint pB = new PPoint(30, 0);
	final PPoint pC = new PPoint(60, 0);
	final PPoint pD = new PPoint(90, 0);
	//
	final PPoint pE = new PPoint(0, 40);
	final PPoint pF = new PPoint(30, 40);
	final PPoint pG = new PPoint(60, 40);
	final PPoint pH = new PPoint(90, 40);
	//
	final PPoint pI = new PPoint(0, 80);
	final PPoint pJ = new PPoint(30, 80);
	final PPoint pK = new PPoint(60, 80);
	final PPoint pL = new PPoint(90, 80);
	//
	final double ac = pA.distance(pC);
	final double ae = pA.distance(pE);
	final double cg = pC.distance(pG);
	final double bd = pB.distance(pD);
	final double be = pB.distance(pE);
	final double dk = pD.distance(pK);
	final double eg = pE.distance(pG);
	final double ej = pE.distance(pJ);
	final double ek = pE.distance(pK);
	final double jk = pJ.distance(pK);

	/*
	 * Polygon
	 */

	@Test
	void polygon_circumference_JKDBE() {
		System.out.println("\npolygon_circumference_JKDBE");
		PPolygon shape = new PPolygon(new PPoint[] { pJ, pK, pD, pB, pE });
		double expected = jk + dk + bd + be + ej;
		double actual = shape.circumference();
		/**/System.out.println("expected:" + expected);
		/**/System.out.println("actual:" + actual);
		assertEquals(expected, actual, EPSILON);
	}

	/*
	 * Quadrilateral
	 */

	@Test
	void quadrilateral_circumference_ACGE() {
		System.out.println("\nquadrilateral_circumference_ACGE");
		PQuadrilateral shape = new PQuadrilateral(pA, pC, pG, pE);
		double expected = ac + cg + eg + ae;
		double actual = shape.circumference();
		/**/System.out.println("expected:" + expected);
		/**/System.out.println("actual:" + actual);
		assertEquals(expected, actual, EPSILON);
	}

	@Test
	void quadrilateral_circumference_KDBE() {
		System.out.println("\nquadrilateral_circumference_KDBE");
		PQuadrilateral shape = new PQuadrilateral(pK, pD, pB, pE);
		double expected = dk + bd + be + ek;
		double actual = shape.circumference();
		/**/System.out.println("expected:" + expected);
		/**/System.out.println("actual:" + actual);
		assertEquals(expected, actual, EPSILON);
	}

	/*
	 * Rectangle
	 */

	@Test
	void rectangle_circumference_ACGE() {
		System.out.println("\nrectangle_circumference_ACGE");
		PRectangle shape = new PRectangle(pA, pC, pG, pE);
		double expected = ac + cg + eg + ae;
		double actual = shape.circumference();
		/**/System.out.println("expected:" + expected);
		/**/System.out.println("actual:" + actual);
		assertEquals(expected, actual, EPSILON);
	}

}
