package reseau_petri;

public class EmptyingArc extends ArcPT {

	public EmptyingArc(Place place) {
		super(place);
	}
	
	/**
	 * Pulls the transition and sets the number of tokens of the Place to 0.
	 */
	protected void pull() {
		this.place.setToken(0);
	}
	
	/**
	 * An EmptyingArc is pullable when the place contains one or more than one token.
	 */
	public boolean isPullable() {
		boolean isPullable = false;
		if (this.place.getNbToken() >= 1) {
			isPullable = true;
		}
		return isPullable;
	}

}
