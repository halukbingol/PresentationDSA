package inheritance.code;

public class PRectangle extends PQuadrilateral {

	public PRectangle(PPoint pA, PPoint pB//
			, PPoint pC, PPoint pD) {
		super(pA, pB//
				, pC, pD);
	}

//	@Override
//	public double circumference() {
//		return super.circumference();
//	}

//	@Override
//	public double area() {
//		return super.area();
//	}
	
	@Override
	public double circumference() {
		double d = 0;
		d += corner[0].distance(corner[1]);
		d += corner[1].distance(corner[2]);
		return 2 * d;
	}

	@Override
	public double area() {
		double d = 0;
		d = corner[0].distance(corner[1])//
				* corner[1].distance(corner[2]);
		return d;
	}

}
