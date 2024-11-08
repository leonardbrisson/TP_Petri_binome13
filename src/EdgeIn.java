
public class EdgeIn extends Edge{
	
	protected Place p;
	private Transition t;

	public EdgeIn(int weight, Transition t, Place p) {
		super(weight);
		this.setP(p);
		this.setT(t);		
	}

	public Transition getT() {
		return t;
	}

	public void setT(Transition t) {
		this.t = t;
	}

	public Place getP() {
		return p;
	}

	public void setP(Place p) {
		this.p = p;
	}

	public boolean isFireable() {
		boolean test = true;
		if (this instanceof ZeroEdge) {
			test = ((ZeroEdge)this).isActive();
		}
		if (this instanceof EmptyingEdge) {
		test = ((EmptyingEdge)this).isActive();
		}
		if (weight > p.getTokens()) {
			test = false;
		}
		return test;
	}

	public void fire() {
		if (this instanceof EmptyingEdge) {
			((EmptyingEdge)this).autoWeight();
		}
		p.refresh(-weight);
		if (this instanceof EmptyingEdge) {
			((EmptyingEdge)this).autoWeight();
		}
	}
}
