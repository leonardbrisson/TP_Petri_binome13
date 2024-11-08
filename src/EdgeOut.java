
public class EdgeOut extends Edge {

	private Place p;
	private Transition t;
	
	public EdgeOut(int weight, Transition t,Place p) {
		super(weight);
		this.setP(p);
		this.setT(t);
	}

	public Place getP() {
		return p;
	}

	public void setP(Place p) {
		this.p = p;
	}

	public Transition getT() {
		return t;
	}

	public void setT(Transition t) {
		this.t = t;
	}

	public void fire() {
		p.refresh(weight);
		
	}
}
