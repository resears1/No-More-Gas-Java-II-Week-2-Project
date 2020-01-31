package main.java.model;

public class Vehicle {
	private String vehicleType;
	private int gasTankSize;
	private int gasConsumptionPerDay;
	private int gasCurrentAmt;
	
	public Vehicle() {

	}

	public Vehicle(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getGasTankSize() {
		return gasTankSize;
	}

	public void setGasTankSize(int gasTankSize) {
		this.gasTankSize = gasTankSize;
	}

	public int getGasConsumptionPerDay() {
		return gasConsumptionPerDay;
	}

	public void setGasConsumptionPerDay(int gasConsumptionPerDay) {
		this.gasConsumptionPerDay = gasConsumptionPerDay;
	}

	public int getGasCurrentAmt() {
		return gasCurrentAmt;
	}

	public void setGasCurrentAmt(int gasCurrentAmt) {
		this.gasCurrentAmt = gasCurrentAmt;
	}
	
	
}
