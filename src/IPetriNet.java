
public interface IPetriNet {
	
	private void addTokens(Place p, int n) {
		int value = p.getTokens();
		p.setTokens(value+n);
	}
	
}
