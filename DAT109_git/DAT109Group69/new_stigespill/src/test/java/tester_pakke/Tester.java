package tester_pakke;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brett.Brett;
import spiller.Brikke;
import spiller.Spiller;
import spiller.Terning;
/**
 * tester klasse for stigespillet
 * @author Maksim
 *
 */
public class Tester {
	
	private Brikke brikke;
	private Spiller spiller;
	private Brett brett;
	private Terning terning;
	
	@BeforeEach
	void setUp() throws Exception {
		brikke = new Brikke(Color.red, 20, 20, 0);
		spiller = new Spiller("Spiller1", new Terning(1), 1, brikke, false);
		brett = new Brett(4);
		terning = new Terning(1);
	}
	
	/**
	 * tester terning
	 * @throws InterruptedException
	 */
	@Test
	void testTerning() throws InterruptedException {
		List<Integer> verdier = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		assertTrue(verdier.contains(terning.trillTerning()));
	}
	
	/**
	 * tester posisjonmetoden for brikken til spilleren
	 * @throws InterruptedException
	 */
	@Test
	void testSetPos () throws InterruptedException {
		
		assertEquals(spiller.getPosisjon(), 1);
		
		spiller.setPosisjon(20);
		
		assertEquals(spiller.getPosisjon(), 20);
		
		brett.setPos(30, spiller);
		
		assertEquals(spiller.getBrikke().getX(), 982);
		assertEquals(spiller.getBrikke().getY(), 556);
	}

}
