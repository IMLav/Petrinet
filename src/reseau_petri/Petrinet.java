package reseau_petri;
import java.util.ArrayList;
import java.util.List;
 
public class Petrinet {
	public static final String Newline=System.getProperty("line.separator");
	private List<Place> places;
	private List<Arc> arcs;
	private List<Transition> transitions;
	
	public Petrinet() {
		this.places = new ArrayList<Place>();
		this.arcs = new ArrayList<Arc>();
		this.transitions = new ArrayList<Transition>();		
	}

	
	public void addTransition(Transition transition) {
		this.transitions.add(transition);
	}
	public void deleteTransition(Transition transition) {
		this.transitions.remove(transition);
	}
	public void addPlace(Place place) {
		this.places.add(place);
	}
	public void deletePlace(Place place) {
		this.places.remove(place);
	}
		
	public void addArc(Arc arc) {
		this.arcs.add(arc);
	}
	public void deleteArc(Arc arc) {
		this.arcs.remove(arc);
	}
	public void addToken(Place place, int token) {
		place.setToken(token);
	};
	public void modifyArcValue(Arc arc, int newWeight) {
		arc.setWeight(newWeight);
	}
	
	public void run() {
		if(areTransitionsLeft()) {
			for(int i =0; i<this.transitions.size(); i++) {
				this.transitions.get(i).step();
			}
		}
	}
	
	public boolean areTransitionsLeft() {
		boolean areTransitionsLeft = false;
		for(int i =0; i<this.transitions.size(); i++) {
			areTransitionsLeft =  true;
		}
		return areTransitionsLeft;
		}
	
	public static void main(String[] args) {
		Petrinet petrinet = new Petrinet();
		int token =2;
		Place place1 = new Place(token);
		token =1;
		Place place2 = new Place(token);
		token =1;
		Place place3 = new Place(token);
		Place place4 = new Place(token);
		Place place5 = new Place(token);

		ArcPT arcPT1 = new ArcPT(place1);
		ArcPT arcPT2 = new ArcPT(place2);
		ArcTP arcTP1 = new ArcTP(place3);
		ArcTP arcTP2 = new ArcTP(place4);
		ArcTP arcTP3 = new ArcTP(place5);
		
		Transition transition1 = new Transition();
		Transition transition2 = new Transition();
		
		transition1.addArcPT(arcPT1);
		transition2.addArcPT(arcPT2);
		transition2.addArcTP(arcTP1);
		transition1.addArcTP(arcTP1);
		transition2.addArcTP(arcTP2);
		transition2.addArcTP(arcTP3);

		petrinet.addPlace(place1);
		petrinet.addPlace(place2);
		petrinet.addPlace(place3);
		
		petrinet.addTransition(transition1);
		petrinet.addTransition(transition2);
		
		
		System.out.print(place1.toString());
		System.out.print(place2.toString());
		System.out.print(place3.toString());

		petrinet.run();
		
		System.out.print(place1.toString());
		System.out.print(place2.toString());
		System.out.print(place3.toString());
		System.out.print(place4.toString());
		System.out.print(place5.toString());

		petrinet.run();

		System.out.print(place1.toString());
		System.out.print(place2.toString());
		System.out.print(place3.toString());
		System.out.print(place4.toString());
		System.out.print(place5.toString());
		
		
	}

}

