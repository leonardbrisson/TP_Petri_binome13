import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class TestPetriNet {
	private PetriNet PN = new PetriNet();
	
	public static void main(String[] args) {
		
	}
	
	@Test 
	public void TestCreationPlace() {
	try {
		Place p = PN.addPlace();
		PN.addTokens(p, 10);
		assertEquals(true,10 == p.getTokens());
	}
	catch (Exception e){
		System.out.println("une place avec 10 tokens aurait du être crée");
	}
	}
	
	public void TestAddEdge() {
		try {
			Transition t = PN.addTransition();
			Place p = PN.addPlace();		
			Edge e = PN.addEdge(t,p,3,"in");
			assertEquals(true,3 == e.getWeight());
		}
		catch (Exception e){
			System.out.println("Un edge de poids 3 aurait du être crée");
		}
		}
}


//try {
//	Place p = new Place(0);
	// First test assertion
//	assertEquals(true, new Place(0).equals(p));
//} catch (InvalidPlaceException e) {
	// If here, there is a problem with the constructor code
//	assertFalse("A place with no tokens should have been created.", false);