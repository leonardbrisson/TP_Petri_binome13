import java.util.LinkedList;
import java.util.Random;

public class PetriNet implements IPetriNet{
	
	private LinkedList<Place> places;
	private LinkedList<Transition> transitions;
	private LinkedList<EdgeIn> edgesIn;
	private LinkedList<EdgeOut> edgesOut;
	
	
	public PetriNet() {
	}
	
	/**
     * Ajoute une nouvelle place au réseau.
     * @return La place créée et ajoutée.
     */
	public Place addPlace() {
		Place p = new Place();
		this.places.add(p);
		return p;
	}
	
	/**
     * Ajoute une nouvelle transition au réseau.
     * @return La transition créée et ajoutée.
     */
	public Transition addTransition() {
		Transition t = new Transition();
		this.transitions.add(t);
		return t;
	}
	
	/**
     * Ajoute des jetons à une place existante.
     * @param p La place à laquelle ajouter les jetons.
     * @param n Le nombre de jetons à ajouter (doit être positif).
	 * @throws PetriExceptions 
     */
	public void addTokens(Place p, int n) throws PetriExceptions {
		if (n>=0) {
			p.setTokens(p.getTokens()+n);
		}
		else {
			throw new PetriExceptions("le nombre de jetons à ajouter doit être positif");
		}
	}
	
	/**
     * Ajoute un arc entre une transition et une place.
     * @param t La transition associée à l'arc.
     * @param p La place associée à l'arc.
     * @param weight Le poids de l'arc (doit être positif).
     * @param typeOfEdge Le type d'arc ("in" pour entrant, "out" pour sortant).
     * @return L'arc créé ou une exception si l'ajout échoue.
	 * @throws PetriExceptions 
     */
	public Edge addEdge(Transition t, Place p, int weight, String typeOfEdge) throws PetriExceptions {
		if (weight < 0) {
			throw new PetriExceptions("le poid doit être positif");
		}
		if (typeOfEdge == "in") {// Arc entrant
			boolean test = false;
			for (EdgeIn ei : edgesIn) {// Vérifie si un tel arc existe déjà
				if (ei.getP() == p && ei.getT() == t) {
					test = true;
				}
			}
			if (test == false) {// Si l'arc n'existe pas, on le crée
				EdgeIn e = new EdgeIn(weight,t,p);
				this.edgesIn.add(e);
				t.getEdgesIn().add(e);
				return e;
			}
			else {
				throw new PetriExceptions("Cet arc existe déjà!");
			}
		}
	
		
		if (typeOfEdge == "out") {// Arc sortant
			boolean test = false;
			for (EdgeOut eo : edgesOut) {// Vérifie si un tel arc existe déjà
				if (eo.getP() == p && eo.getT() == t) {
					test = true;
				}
			}
			if (test == false) {// Si l'arc n'existe pas, on le crée
				EdgeOut e = new EdgeOut(weight,t,p);
				this.edgesOut.add(e);
				t.getEdgesOut().add(e);
				return e;
			}
			else {
				System.out.println("Cet arc existe déjà!");
				return null;
			}
		}
		else {// Si le type d'arc n'est pas valide
			throw new PetriExceptions("Ce typeOfEdge n'existe pas");
		}
		
	}
	
	/**
     * Modifie le poids d'un arc existant.
     * @param e L'arc à modifier.
     * @param weight Le nouveau poids (doit être positif).
	 * @throws PetriExceptions 
     */
	public void setWeight(Edge e, int weight) throws PetriExceptions {
		if (weight>=0) {
			e.setWeight(weight);
		}
		else {
			throw new PetriExceptions("le nouveau poids doit être positif");
		}
	}
	
	/**
     * Récupère un certain nombre de jetons d'une place.
     * @param p La place cible.
     * @param n Le nombre de jetons à retirer.
     *          Doit être inférieur ou égal au nombre de jetons présents.
	 * @throws PetriExceptions 
     */
	public void recoverTokens(Place p, int n) throws PetriExceptions {
		int value = p.getTokens();
		if (value >= n) {
			p.setTokens(value-n);
		}
		else {
			throw new PetriExceptions("Il y a moins de "+ n +" tokens dans cette place.");
		}
	}
	
	/**
     * Exécute une transition si elle est tirable.
     * Met à jour l'état du réseau en consommant et produisant des jetons.
     * @param t La transition à exécuter.
	 * @throws PetriExceptions 
     */
	public void step(Transition t) throws PetriExceptions {
		if (t.isFireable()) {
			t.fire();
		}
		else {
			throw new PetriExceptions("Cette transition n'est pas tirable");
		}
	}
	
	public void step() throws PetriExceptions {
		Random random = new Random();
		Transition transition = transitions.get(random.nextInt(transitions.size()));
		step(transition);
	}
}
