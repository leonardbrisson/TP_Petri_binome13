
public interface IPetriNet {
	
	public Place addPlace();
	public Transition addTransition();
	public void addTokens(Place p, int n);
	public Edge addEdge(Transition t, Place p, int weight, String typeOfEdge);
	public void setWeight(Edge e, int weight);
	public void recoverTokens(Place p, int n);
	public void step(Transition t);
	
}
