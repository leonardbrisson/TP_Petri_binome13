
public class EdgeIn extends Edge{
	
	public Place p;
	public Transition t;

	public EdgeIn(int weight, Transition t, Place p) {
		super(weight);
		this.p = p;
		this.t = t;		
	}
}
