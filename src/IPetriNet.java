
public interface IPetriNet {
	
	private void addTokens(Place p, int n) {
		p.setTokens(p.getTokens()+n);
	}
	
}
