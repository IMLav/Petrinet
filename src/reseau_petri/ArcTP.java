package reseau_petri;

public class ArcTP extends Arc {

	private static int DEFAULTIDVALUE =1;
	


	public ArcTP(Place place){
		this.place = place;
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE +=1;	
	}
	
	public ArcTP(Place place, int weight){
		assert weight>0;
		this.place = place;
		this.weight = weight;
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE +=1;	
	}
	
	protected void pull() {
		assert weight>0;
		this.place.setToken(this.place.getToken() + this.weight);
	}


}
