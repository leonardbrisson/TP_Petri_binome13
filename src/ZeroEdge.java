
public class ZeroEdge extends EdgeIn{

	/**
     * Constructeur de la classe ZeroEdge.
     * Initialise un arc entrant de type ZeroEdge avec un poids, une transition et une place.
     *
     * @param weight Le poids de l'arc.
     * @param t La transition associée à l'arc entrant.
     * @param p La place associée à l'arc entrant.
	 * @throws PetriExceptions 
     */
	public ZeroEdge(int weight, Transition t, Place p) throws PetriExceptions {
		super(weight,t,p);// Appelle le constructeur de la classe parente (EdgeIn)
	}
	
	/**
     * Vérifie si l'arc est actif.
     * L'arc est considéré comme actif uniquement si la place associée contient zéro jeton.
     *
     * @return true si la place contient zéro jeton, false sinon.
     */
	public boolean isActive() {
		return (p.getTokens() == 0); // Vérifie si la place a zéro jeton
	}
}
