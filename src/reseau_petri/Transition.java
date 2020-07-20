package reseau_petri;

import java.util.ArrayList;
import java.util.List;

class Transition {
	
	
	private static int DEFAULTIDVALUE =1;
	private List<ArcPT> arcsPT;
	private List<ArcTP> arcsTP;
	private int id;

	
	public Transition() {
		
		this.arcsPT = new ArrayList<ArcPT>();
		this.arcsTP = new ArrayList<ArcTP>();
		this.id = DEFAULTIDVALUE;
		DEFAULTIDVALUE +=1;
	}
	
	// pas sûre encapsulation
	
	public void addArcPT(ArcPT arcPT) {
		this.arcsPT.add(arcPT);
	}
	public void addArcTP(ArcTP arcTP) {
		this.arcsTP.add(arcTP);
	}
	

	
	public void step() {
		boolean isTransitionPullable = true;
			for (int i=0; i< this.arcsPT.size(); i++) {
				isTransitionPullable = this.arcsPT.get(i).isPullable();
			}
			System.out.print("La transition " +this.id+ " est tirable : "+isTransitionPullable+ Petrinet.Newline);

			if (isTransitionPullable == true) {
				for(int i=0; i<this.arcsPT.size(); i++) {
					this.arcsPT.get(i).pull();
				}
				for(int i=0; i<this.arcsTP.size(); i++) {
					this.arcsTP.get(i).pull();
				}
			}
	}
}
	
	


