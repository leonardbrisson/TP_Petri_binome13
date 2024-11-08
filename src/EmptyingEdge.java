
public class EmptyingEdge extends EdgeIn{
	
	public EmptyingEdge(Transition t, Place p) {
		super(p.getTokens(),t,p);
	}
	
	public void autoWeight() {
		weight = p.getTokens();
	}
	
	public boolean isActive() {
		return (p.getTokens() != 0);
	}
}
