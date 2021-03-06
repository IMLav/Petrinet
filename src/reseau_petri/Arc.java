package reseau_petri;

/**
 * @author IML An arc connects a place to a transition, regardless of the order.
 */

public abstract class Arc {

	protected int DEFAULTWEIGHT = 1;

	protected Place place;
	protected int weight = DEFAULTWEIGHT;
	protected int id;

	/**
	 * @return the weight of the arc.
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Sets the weight of the arc.
	 * 
	 * @param weight
	 */
	protected void setWeight(int weight) {
		this.weight = weight;
	}

	public Place getPlace() {
		return this.place;
	}

	protected abstract void pull();
}
