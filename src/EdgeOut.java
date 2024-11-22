
public class EdgeOut extends Edge {
	
	 /**
     * Constructeur de la classe EdgeOut.
     * Initialise un arc sortant avec un poids, une transition source, et une place cible.
     *
     * @param weight Le poids de l'arc (doit être positif).
     * @param t La transition associée à cet arc.
     * @param p La place associée à cet arc.
     */
	public EdgeOut(int weight, Transition t,Place p) {
		super(weight);
		this.setP(p);
		this.setT(t);
	}
	/**
     * Retourne la place associée à cet arc sortant.
     *
     * @return La place cible.
     */
	public Place getP() {
		return p;
	}

	/**
     * Définit la place associée à cet arc sortant.
     *
     * @param p La place cible.
     */
	public void setP(Place p) {
		this.p = p;
	}

	/**
     * Retourne la transition associée à cet arc sortant.
     *
     * @return La transition source.
     */
	public Transition getT() {
		return t;
	}

	/**
     * Définit la transition associée à cet arc sortant.
     *
     * @param t La transition source.
     */
	public void setT(Transition t) {
		this.t = t;
	}
	
	/**
     * Effectue l'opération de tir de l'arc.
     * Produit des jetons dans la place cible en fonction du poids de l'arc.
     */
	public void fire() {
		p.refresh(weight);// Ajoute des jetons dans la place cible
		
	}
}
