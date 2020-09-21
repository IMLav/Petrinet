package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reseau_petri.EmptyingArc;
import reseau_petri.Petrinet;
import reseau_petri.Place;
import reseau_petri.Transition;


public class EmptyingArcTest {
	
	private Petrinet petrinet;
	private EmptyingArc emptyingArc;
	private Place place1;
	private Transition transition1;

	@Before
	public void setUp() throws Exception {
		petrinet =  new Petrinet();
		
		place1 = new Place(1);
		emptyingArc = new EmptyingArc(place1);
		transition1 = new Transition();
	

		try {
			transition1.addArcPT(emptyingArc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	

		petrinet.addTransition(transition1);
		petrinet.addPlace(place1);
	

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPullable() {
		assertTrue(emptyingArc.isPullable());
	}
	
	@Test
	public void testPull() {
		emptyingArc.pull();
		assertEquals(place1.getNbToken(),0);
	}
	
	

}
