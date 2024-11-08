import java.util.LinkedList;

public class PetriNet implements IPetriNet{
	
	private LinkedList<Place> places;
	private LinkedList<Transition> transitions;
	private LinkedList<EdgeIn> edgesIn;
	private LinkedList<EdgeOut> edgesOut;
	
	public void addPlace() {
		Place p = new Place();
		this.places.add(p);
	}
	
	public void addTransition() {
		Transition t = new Transition();
		this.transitions.add(t);
	}
	
	public void addEdge(Transition t, Place p, int weight, String typeOfEdge) {
		if (typeOfEdge == "in") {
			boolean test = false;
			for (EdgeIn ei : edgesIn) {
				if (ei.getP() == p && ei.getT() == t) {
					test = true;
				}
			}
			if (test == false) {
				EdgeIn e = new EdgeIn(weight,t,p);
				this.edgesIn.add(e);
				t.getEdgesIn().add(e);
			}
			else {
				System.out.println("Cet arc existe déjà!");
			}
		}
		
		if (typeOfEdge == "out") {
			boolean test = false;
			for (EdgeOut eo : edgesOut) {
				if (eo.getP() == p && eo.getT() == t) {
					test = true;
				}
			}
			if (test == false) {
				EdgeOut e = new EdgeOut(weight,t,p);
				this.edgesOut.add(e);
				t.getEdgesOut().add(e);
			}
			else {
				System.out.println("Cet arc existe déjà!");
			}
		}
		else {
			System.out.println("Ce typeOfEdge n'existe pas");
		}
	}
	
	public void setWeight(Edge e, int weight) {
		e.setWeight(weight);
	}
	
	public void recoverTokens(Place p, int n) {
		int value = p.getTokens();
		if (value >= n) {
			p.setTokens(value-n);
		}
		else {
			System.out.println("Il y a moins de "+ n +" tokens dans cette place.");
		}
	}
	
	public void step(Transition t) {
		if (t.isFireable()) {
			t.fire();
		}
		else {
			System.out.println("Cette transition n'est pas tirable");
		}
	}
	
	
}
