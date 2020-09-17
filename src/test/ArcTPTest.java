package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reseau_petri.ArcPT;
import reseau_petri.ArcTP;
import reseau_petri.Petrinet;
import reseau_petri.Place;
import reseau_petri.Transition;

public class ArcTPTest {

	Petrinet petrinet;
	Place place1;
	Place place2;
	ArcPT arcPT;
	ArcTP arcTP;
	Transition transition1;
	Transition transition2;

	@Before
	public void setUp() throws Exception {
		petrinet = new Petrinet();

		place1 = new Place(1);
		place2 = new Place(0);
		arcPT = new ArcPT(place1);
		arcTP = new ArcTP(place2);

		transition1 = new Transition();

		try {
			transition1.addArcPT(arcPT);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			transition1.addArcTP(arcTP);
		} catch (Exception e) {
			e.printStackTrace();
		}

		petrinet.addTransition(transition1);
		petrinet.addPlace(place1);
		petrinet.addPlace(place2);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPull() {
		arcTP.pull();
		assertEquals(place2.getNbToken(),1);
	}

}
