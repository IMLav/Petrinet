package reseau_petri;

abstract class Arc {
	
	protected int DEFAULTWEIGHT = 1;

	protected Place place;
	protected int weight = DEFAULTWEIGHT;
	protected int id;
	
	public int getWeight() {
		return this.weight;
	}
	
	protected void setWeight(int weight) {
		this.weight = weight;
	}
	
	protected abstract void pull();
}
