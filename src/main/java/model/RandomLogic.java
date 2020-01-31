package main.java.model;

// Logic for managing random events and fuels events
public class RandomLogic {
	
	// Method for use by the randomEvents() method
	// Gets a random number if called, and then adds gas.
	public int addFuel(Vehicle vehicle) {
		final int MIN = 1;
		final int MAX = 10;
		final int RANGE = (MAX - MIN) + 1;
		
		int randFuel = (int)(Math.random() * RANGE) + MIN;
		
		// Slightly different text for single gallon cases
		if (randFuel > 1) {
			System.out.println("You found a tank with " + randFuel + " gallons of gas!");
		} else {
			System.out.println("You found a tank with " + randFuel + " gallon of gas. Better than nothing I guess.");
		}
		
		// Prevent fuel from going over the gas tank size
		if (vehicle.getGasCurrentAmt() > vehicle.getGasTankSize()) {
			vehicle.setGasCurrentAmt(vehicle.getGasTankSize()); 
		} else {
			vehicle.setGasCurrentAmt(vehicle.getGasCurrentAmt() + randFuel);
		}
		
		return vehicle.getGasCurrentAmt();
	}
	
	// Method for use by the randomEvents() method
	// Gets a random number if called, and then subtracts gas.
	public int removeFuel(Vehicle vehicle) {
		final int MIN = 1;
		final int MAX = 3;
		final int RANGE = (MAX - MIN) + 1;
		
		int randFuel = (int)(Math.random() * RANGE) + MIN;
		
		// Slightly different text for single gallon cases
		if (randFuel > 1) {
			System.out.println("In the night someone snuck up to your vehicle and siphoned " + randFuel + " gallons of gas.");
		} else {
			System.out.println("In the night someone snuck up to your vehicle and siphoned " + randFuel + " gallon of gas. Not too big of a deal unless you're almost out.");
		}
	
		vehicle.setGasCurrentAmt(vehicle.getGasCurrentAmt() - randFuel);
		
		return vehicle.getGasCurrentAmt();
	}
	
	// The controller method/ manager for addFuel() and removeFuel()
	public void randomEvents(Vehicle vehicle) {
		final int MIN = 1;
		final int MAX = 10;
		final int RANGE = (MAX - MIN) + 1;
		
		int rand = (int)(Math.random() * RANGE) + MIN;
		
		// Randomize events with random numbers.
		if (rand >= 1 && rand < 7) {
			System.out.println("Nothing happened and you found no gas.");
		} else if (rand >= 7 && rand < 10) {
			addFuel(vehicle);
		} else {
			removeFuel(vehicle);
		}
	}
}
