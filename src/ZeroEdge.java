
public class ZeroEdge extends EdgeIn{

	public ZeroEdge(int weight, Transition t, Place p) {
		super(weight,t,p);
	}
	
	public boolean isActive() {
		return (p.getTokens() == 0);
	}
}
