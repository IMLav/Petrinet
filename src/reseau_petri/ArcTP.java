package reseau_petri;

/**
 * @author IML An ArcTP inherits from Arc. It links a place to a transition
 *         (hence TP).
 */
public class ArcTP extends Arc {

	private static int DEFAULTIDVALUE = 1;

	/**
	 * @param place This constructor builds an ArcTP linked to the place given in
	 *              parameters. Its default weight is 1.
	 */
	public ArcTP(Place place) {
		this.place = place;
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE += 1;
	}

	/**
	 * @param place
	 * @param weight This constructor builds an ArcTP linked to the place given in
	 *               parameters. Its weight is also passed as a parameter.
	 */
	public ArcTP(Place place, int weight) {
		assert weight >= 0;
		this.place = place;
		this.weight = weight;
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE += 1;
	}

	/**
	 * This method pulls the ArcTP. That is, updates the number of tokens contained
	 * in the linked Place.
	 */
	public void pull() {
		assert weight >= 0;
		this.place.setToken(this.place.getNbToken() + this.weight);

	}

}
