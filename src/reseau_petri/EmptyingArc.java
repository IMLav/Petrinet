package reseau_petri;

public class EmptyingArc extends ArcPT {

	public EmptyingArc(Place place) {
		super(place);
	}

	public EmptyingArc(Place place, int weight) {
		super(place, weight);
	}
	
	protected void pull() {
		this.place.setToken(0);
	}
	
	public boolean isPullable() {
		boolean isPullable = false;
		if (this.place.getNbToken() >= 1) {
			isPullable = true;
		}
		return isPullable;
	}

}
