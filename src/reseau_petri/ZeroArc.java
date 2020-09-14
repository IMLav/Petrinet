package reseau_petri;

public class ZeroArc extends ArcPT {
	
	protected int DEFAULTWEIGHT = 0;

	public ZeroArc(Place place) {
		super(place);
	}

	/**
	 *A ZeroArc is pullable when the number of tokens in the place is 0.
	 */
	public boolean isPullable() {
		boolean isPullable = false;
		if (this.place.getNbToken() == 0) {
			isPullable = true;
		}
		return isPullable;
	}
	
	/**
	 *When a ZeroArc is pulled, the number of Tokens in the place remains 0.
	 */
	public void pull() {
		assert weight == 0;
		this.place.setToken(this.place.getNbToken() - this.weight);
	}
}
