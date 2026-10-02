package inheritance.code;

public class PQuadrilateral extends PPolygon {

	public PQuadrilateral(PPoint pA, PPoint pB//
			, PPoint pC, PPoint pD) {
		corner = new PPoint[4];
		this.corner[0] = pA;
		this.corner[1] = pB;
		this.corner[2] = pC;
		this.corner[3] = pD;
	}

}
