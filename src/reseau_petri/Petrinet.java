package reseau_petri;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IML A petrinet contains places and transitions. An arcs links a place
 *         and a transition together. When Petrinet runs, it pulls every
 *         pullable transition. When none of them are left, the running stops.
 * 
 */
public class Petrinet {

	private List<Transition> transitions; // transitions know the arcs and by extension places, hence
	private List<Place> places; // useful to garanty that deleting an arc won't make the related place disappear
								// from the petrinet

	public List<Place> getPlaces(){
		return this.places;
	}
	
	public List<Transition> getTransitions(){
		return this.transitions;
	}
	/**
	 * Default constructor : initializes a Petrinet without any places, transitions
	 * nor arcs.
	 */
	public Petrinet() {

		this.transitions = new ArrayList<Transition>();
		this.places = new ArrayList<Place>();
	}

	/**
	 * @param transition Adds a transition to the petrinet.
	 */
	public void addTransition(Transition transition) {
		this.transitions.add(transition);
	}

	/**
	 * @param place Adds a place to the petrinet.
	 */
	public void addPlace(Place place) {
		if (!this.places.contains(place)) {
			this.places.add(place);
		}
	}

	/**
	 * @param transition Removes a transition and its connected arcs from the
	 *                   petrinet.
	 */
	public void deleteTransition(Transition transition) {
		// arcs cannot exist without the associated transition, while places can.
		// no need to remove the arcs directly : since they are contained in the
		// transition, once the transition is gone, they won't be accessible to the
		// user. The places will still be.
		this.transitions.remove(transition);
	}

	/**
	 * @param arc
	 * @throws Exception Deletes an Arc from the petrinet.
	 */
	public void deleteArc(Arc arc) throws Exception {
		// arcs are stocked in the transition, hence it is necessary to delete them in
		// the transition, depending on their arc type.
		// removing an arc does not affect the existence of the transition or the place.

		for (Transition transition : this.transitions) {
			if (arc instanceof ArcPT) {
				if (transition.getArcsPT().contains(arc)) {
					transition.deleteArcPT((ArcPT) arc);
				}

			} else {
				if (transition.getArcsTP().contains(arc)) {
					transition.deleteArcTP((ArcTP) arc);
				}
			}
		}
	}

	/**
	 * @param place
	 * @throws Exception Deletes a place and the linked arcs from the petrinet.
	 */
	public void deletePlace(Place place) throws Exception {
		// arcs cannot exist without the associated place.
		// arcs need to be deleted from the associated transition.
		if (this.places.contains(place)) {

			for (Transition currentTransition : this.transitions) {
				for (int j = 0; j < currentTransition.getArcsPT().size(); j++) {
					ArcPT currentArcPT = currentTransition.getArcsPT().get(j);
					if (currentArcPT.getPlace() == place) {
						currentTransition.deleteArcPT(currentArcPT);
					}
				}
				for (int j = 0; j < currentTransition.getArcsPT().size(); j++) {
					ArcTP currentArcTP = currentTransition.getArcsTP().get(j);
					if (currentArcTP.getPlace() == place) {
						currentTransition.deleteArcTP(currentArcTP);
					}
				}

			}

			this.places.remove(place);
		}

	}

	/**
	 * @param place
	 * @param token
	 * 
	 *              Adds a specified number of tokens to a selected place.
	 */
	public void addToken(Place place, int token) {
		place.setToken(token);
	};

	/**
	 * @param arc
	 * @param newWeight Updates the weight of the selected arc.
	 */
	public void modifyArcValue(Arc arc, int newWeight) {
		arc.setWeight(newWeight);
	}

	/**
	 * Runs the petrinet : while there are transitions left, the petrinet pulls new
	 * transitions.
	 */
	public void run() {
		if (areTransitionsLeft()) {
			for (int i = 0; i < this.transitions.size(); i++) {
				this.transitions.get(i).step();
			}
		}
	}

	/**
	 * @return Returns a boolean that shows whether or not there are remaining
	 *         transitions to be pulled.
	 */
	private boolean areTransitionsLeft() {
		boolean areTransitionsLeft = false;
		for (int i = 0; i < this.transitions.size(); i++) {
			areTransitionsLeft = true;
		}
		return areTransitionsLeft;
	}

	public static void main(String[] args) {

		Petrinet petrinet = new Petrinet();

		int token = 2;
		Place place1 = new Place(token);
		token = 1;
		Place place2 = new Place(token);
		token = 1;
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

		try {
			transition1.addArcPT(arcPT1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			transition2.addArcPT(arcPT2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		transition2.addArcTP(arcTP1);
		transition1.addArcTP(arcTP1);
		transition2.addArcTP(arcTP2);
		transition2.addArcTP(arcTP3);

		petrinet.addTransition(transition1);
		petrinet.addTransition(transition2);
		petrinet.addPlace(place1);
		petrinet.addPlace(place2);
		petrinet.addPlace(place3);
		petrinet.addPlace(place4);
		petrinet.addPlace(place5);

		System.out.println(place1);
		System.out.println(place2);
		System.out.println(place3);
		System.out.println(place4);
		System.out.println(place5);

		petrinet.run();

		System.out.println(place1);
		System.out.println(place2);
		System.out.println(place3);
		System.out.println(place4);
		System.out.println(place5);

		petrinet.run();

		System.out.println(place1);
		System.out.println(place2);
		System.out.println(place3);
		System.out.println(place4);
		System.out.println(place5);

		try {
			petrinet.deletePlace(place3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Delete place 3");
		System.out.println("transition1 size: " + transition1.getArcsTP().size());
		System.out.println("transition2 size: " + transition2.getArcsTP().size());

		System.out.println("transition1 size: " + transition1.getArcsPT().size());
		System.out.println("transition2 size: " + transition2.getArcsPT().size());

		System.out.println("Delete place 1");
		try {
			petrinet.deletePlace(place1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("transition1 size: " + transition1.getArcsPT().size());
		System.out.println("transition2 size: " + transition2.getArcsPT().size());

		try {
			petrinet.deleteArc(arcPT2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("transition2 size: " + transition2.getArcsPT().size());

		petrinet.deleteTransition(transition2);

	}

}
