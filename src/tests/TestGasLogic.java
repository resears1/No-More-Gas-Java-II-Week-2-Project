package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.model.GasLogic;
import main.java.model.Vehicle;

public class TestGasLogic {
	Vehicle vehicle = new Vehicle("Truck");
	GasLogic gasLogic = new GasLogic();
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testCalculateGasUsage() {
		vehicle.setGasCurrentAmt(10);
		vehicle.setGasConsumptionPerDay(3);
		int usage = gasLogic.calculateGasUsage(vehicle);
		assertEquals(7, usage);
	}
	
	@Test
	public void testCheckEmptyFailStateTrue() {
		vehicle.setGasCurrentAmt(2);
		vehicle.setGasConsumptionPerDay(3);
		assertTrue(gasLogic.checkEmptyFailState(vehicle));
	}
	
	@Test
	public void testCheckEmptyFailStateFalse() {
		vehicle.setGasCurrentAmt(3);
		vehicle.setGasConsumptionPerDay(3);
		assertFalse(gasLogic.checkEmptyFailState(vehicle));
	}
}
