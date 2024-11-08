
public class Place {
	
	private int tokens;
	
	public int getTokens() {
		return this.tokens;
	}
	
	public void setTokens(int n) {
		this.tokens = n;
	}

	public void refresh(int t) {
		tokens += t;
	}
}
