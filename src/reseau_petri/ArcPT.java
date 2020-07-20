package reseau_petri;

public class ArcPT extends Arc {
	private static int DEFAULTIDVALUE =1;

	
	public ArcPT(Place place){
		this.place = place;
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE +=1;
	}
	
	public ArcPT(Place place, int weight){
		assert weight>0;
		this.place = place;
		this.weight = weight;
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE +=1;
	}
	
	

	public boolean isPullable() {
		boolean isPullable = false;
		if (this.place.getToken()>= this.weight) {
			isPullable = true;
		}
		return isPullable;
	}

	@Override
	protected void pull() {
		assert weight>0;
		this.place.setToken(this.place.getToken() - this.weight);
		System.out.print("La place "+this.id+" a maintenant " + this.place.getToken() +" jetons."+Petrinet.Newline);
	}

	

}
