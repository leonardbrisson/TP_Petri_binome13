import java.util.LinkedList;

public class Edge {
	
	protected int weight;
	protected Place p;
	protected Transition t;
	
	
	/**
     * Constructeur de la classe Edge.
     * Initialise un arc avec un poids donné.
     * @param weight Le poids de l'arc (doit être positif).
	 * @throws PetriExceptions 
     */
	public Edge(int weight) throws PetriExceptions {
		if (weight>=0) {
			this.weight = weight;
		}
		else {
			throw new PetriExceptions("le poid doit être positif");
		}
	}
	
	/**
     * Définit un nouveau poids pour l'arc.
     * @param weight Le nouveau poids de l'arc (doit être positif).
	 * @throws PetriExceptions 
     */
	public void setWeight(int weight) throws PetriExceptions {
		if (weight>=0) {
			this.weight = weight;
		}
		else {
			throw new PetriExceptions("le poid doit être positif");
		}
	}
	
	/**
     * Retourne le poids actuel de l'arc.
     * @return Le poids de l'arc.
     */
	public int getWeight() {
		return this.weight;
	}

}
