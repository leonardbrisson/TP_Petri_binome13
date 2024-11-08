
public class EdgeOut extends Edge {

	public Place p;
	public Transition t;
	
	public EdgeOut(int weight, Transition t,Place p) {
		super(weight);
		this.p = p;
		this.t = t;
	}
}
