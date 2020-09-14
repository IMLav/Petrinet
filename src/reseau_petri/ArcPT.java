package reseau_petri;

/**
 * @author IML
 * An ArcPT inherits from Arc. It links a place to a transition (hence PT).
 *
 */
public class ArcPT extends Arc {
	private static int IDVALUE =1;

	
	/**
	 * @param place
	 * This constructor builds an ArcPT linked to the place given in parameters. Its default weight is 1.
	 */
	public ArcPT(Place place){
		this.place = place;
		this.id = IDVALUE;
		IDVALUE +=1;
	}
	
	/**
	 * @param place
	 * @param weight
	 * This constructor builds an ArcPT linked to the place given in parameters. Its weight is also passed as a parameter.
	 */
	public ArcPT(Place place, int weight){
		assert weight>0;
		this.place = place;
		this.weight = weight;
		this.id = IDVALUE;
		IDVALUE +=1;
	}
	
	

	/**
	 * @return
	 * This method returns a boolean defining whether or not the arc can be pulled. That is, if the weight of the ArcPT is smaller than (or equal to) the number of tokens contained in the linked place.
	 */
	public boolean isPullable() {
		boolean isPullable = false;
		if (this.place.getToken()>= this.weight) {
			isPullable = true;
		}
		return isPullable;
	}

	
	/**
	 *This method pulls the ArcPT. That is, updates the number of tokens contained in the linked Place.
	 */
	@Override
	protected void pull() {
		assert weight>0;
		this.place.setToken(this.place.getToken() - this.weight);
	}

	

}
