package tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.model.RandomLogic;
import main.java.model.Vehicle;

public class TestRandomLogic {
	Vehicle vehicle = new Vehicle("Truck");
	RandomLogic randLogic = new RandomLogic();
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testAddFuel() {
		vehicle.setGasTankSize(11);
		vehicle.setGasCurrentAmt(3);
		int current = vehicle.getGasCurrentAmt();
		randLogic.addFuel(vehicle);
		assertNotEquals(current,vehicle.getGasCurrentAmt());
	}
	
	@Test
	public void testRemoveFuel() {
		vehicle.setGasTankSize(11);
		vehicle.setGasCurrentAmt(7);
		int current = vehicle.getGasCurrentAmt();
		randLogic.removeFuel(vehicle);
		assertNotEquals(current, vehicle.getGasCurrentAmt());
	}
}
