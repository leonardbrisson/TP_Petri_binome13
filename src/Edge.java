import java.util.LinkedList;

public class Edge {
	
	protected int weight;
	protected Place p;
	protected Transition t;
	
	
	/**
     * Constructeur de la classe Edge.
     * Initialise un arc avec un poids donné.
     * @param weight Le poids de l'arc (doit être positif).
     */
	public Edge(int weight) {
		if (weight>=0) {
			this.weight = weight;
		}
		else {
			System.out.println("le poid doit être positif");
		}
	}
	
	/**
     * Définit un nouveau poids pour l'arc.
     * @param weight Le nouveau poids de l'arc (doit être positif).
     */
	public void setWeight(int weight) {
		if (weight>=0) {
			this.weight = weight;
		}
		else {
			System.out.println("le poid doit être positif");
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
