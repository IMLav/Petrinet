package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reseau_petri.ArcTP;
import reseau_petri.Petrinet;
import reseau_petri.Place;
import reseau_petri.Transition;
import reseau_petri.ZeroArc;

public class ZeroArcTest {
	private Petrinet petrinet;
	private Place place1;
	private Place place2;
	private Place place3;
	private Transition transition1;
	private Transition transition2;
	private ZeroArc zeroArc1;
	private ZeroArc zeroArc2;
	private ZeroArc zeroArc3;
	private ArcTP arcTP1;
	private ArcTP arcTP2;

	@Before
	public void setUp() throws Exception {
		
		petrinet =  new Petrinet();
		
		place1 = new Place(0);
		place2 = new Place(2);
		place3 = new Place(0);
		zeroArc1 = new ZeroArc(place1);
		zeroArc2 = new ZeroArc(place2);
		zeroArc3 = new ZeroArc(place1);
		arcTP1 = new ArcTP(place3);
		arcTP2 = new ArcTP(place3);

		transition1 = new Transition();
		transition2 = new Transition();

		try {
			transition1.addArcPT(zeroArc1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			transition1.addArcPT(zeroArc2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			transition1.addArcTP(arcTP1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		try {
		transition2.addArcPT(zeroArc3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			transition2.addArcTP(arcTP2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		petrinet.addTransition(transition1);
		petrinet.addTransition(transition2);
		petrinet.addPlace(place1);
		petrinet.addPlace(place2);
		petrinet.addPlace(place3);
			
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPullableReturnsTrue() {
		assertTrue(zeroArc1.isPullable());
		
	}
	@Test
	public void testIsPullableReturnsFalse() {
		assertFalse(zeroArc2.isPullable());
		
	}

}
