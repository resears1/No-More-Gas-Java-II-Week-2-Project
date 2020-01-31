package main.java.model;

// Logic for managing gas usage and fail state

public class GasLogic {
	
	// This called once every loop/ "day" to auto subtract gas
	public int calculateGasUsage(Vehicle vehicle) {
		int gasCurrent = vehicle.getGasCurrentAmt();
		int gasUsage = vehicle.getGasConsumptionPerDay();
		
		int newGasAmt = gasCurrent - gasUsage;
		
		if (newGasAmt < 0) {
			// Make sure gas never goes below 0
			newGasAmt = 0;
		}
		
		vehicle.setGasCurrentAmt(newGasAmt);
		
		return vehicle.getGasCurrentAmt();
	}
	
	// Checks if gas is 0 or too little (true) or not (false)
	public boolean checkEmptyFailState(Vehicle vehicle) {
		
		if (vehicle.getGasCurrentAmt() < vehicle.getGasConsumptionPerDay()) {
			return true;
		} else {
			return false;
		}
		
	}
}
