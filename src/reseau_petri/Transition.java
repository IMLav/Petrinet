package reseau_petri;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IML A transition is represented by a square. A transition can be
 *         linked to no or several places though ArcPT and ArcTP. Each
 *         transition has is own unique IDVALUE.
 */
public class Transition {

	private static int IDVALUE = 1;
	private List<ArcPT> arcsPT;
	private List<ArcTP> arcsTP;
	private int id;

	/**
	 * Default constructor of a Transition. The transition is not linked to any
	 * places.
	 */
	public Transition() {

		this.arcsPT = new ArrayList<ArcPT>();
		this.arcsTP = new ArrayList<ArcTP>();
		this.id = IDVALUE;
		IDVALUE += 1;
	}

	public List<ArcPT> getArcsPT() {
		return this.arcsPT;
	}

	public List<ArcTP> getArcsTP() {
		return this.arcsTP;
	}

	/**
	 * @param arcPT This method allows to add an ArcPT given as parameter to the
	 *              transition. The transition is then linked to an entering Place.
	 * @throws Exception
	 */
	public void addArcPT(ArcPT arcPT) throws Exception {
		if (!arcsPT.contains(arcPT)) {
			this.arcsPT.add(arcPT);
		} else {
			throw new Exception("Please stop deleting a non-existing ArcPT");
		}
	}

	/**
	 * @param arcTP This method allows to add an ArcTP given as parameter to the
	 *              transition. The transition is then linked to an exiting Place.
	 */
	public void addArcTP(ArcTP arcTP) {
		if (!arcsTP.contains(arcTP)) {
			this.arcsTP.add(arcTP);
		}
	}

	public void deleteArcPT(ArcPT arcPT) throws Exception {
		if (arcsPT.contains(arcPT)) {
			this.arcsPT.remove(arcPT);
		} else {
			throw new Exception("Please stop deleting a non-existing ArcPT");
		}
	}

	public void deleteArcTP(ArcTP arcTP) throws Exception {
		if (arcsTP.contains(arcTP)) {
			this.arcsTP.remove(arcTP);
		} else {
			throw new Exception("Please stop deleting a non-existing ArcTP");
		}

	}

	/**
	 * This method implements a step in the running of the Petrinet. A step
	 * corresponds to the following operations: - checking if the transition is
	 * pullable (all the connected arcs can be pulled). - if so, pulling all the
	 * connected arcs.
	 */
	
	public void printPullable(Boolean isTransitionPullable) {
		StringBuilder str = new StringBuilder();
		str.append("La transition ");
		str.append(this.id);
		str.append(" est tirable : ");
		str.append(isTransitionPullable);
		System.out.println(str.toString());
			
	}
	
	public void step() {
		boolean isTransitionPullable = true;
		if (isTransitionPullable) {
			for (ArcPT arcPT: this.arcsPT) {
				isTransitionPullable = arcPT.isPullable();
			}
		}

		printPullable(isTransitionPullable);

		if (isTransitionPullable) {
			for (ArcPT arcPT: this.arcsPT) {
				arcPT.pull();
			}
			for (ArcTP arcTP: this.arcsTP) {
				arcTP.pull();
			}
		}
	}

}
