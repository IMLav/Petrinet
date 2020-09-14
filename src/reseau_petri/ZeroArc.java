package reseau_petri;

public class ZeroArc extends ArcPT {
	
	protected int DEFAULTWEIGHT = 0;

	public ZeroArc(Place place) {
		super(place);
	}

	public boolean isPullable() {
		boolean isPullable = false;
		if (this.place.getNbToken() == 0) {
			isPullable = true;
		}
		return isPullable;
	}
	
	public void pull() {
		assert weight == 0;
		this.place.setToken(this.place.getNbToken() - this.weight);
	}
}
