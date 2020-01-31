import java.util.Scanner;

import main.java.model.GasLogic;
import main.java.model.RandomLogic;
import main.java.model.Vehicle;

/*
 * Name: No More Gas 
 * Project: Week 2 "Assessment"
 * Class: Java II
 * Purpose: Create a project with 2 classes that utilizes Maven and JUnit.
 * Date: 1/30/2020
 */
public class NoMoreGasDriver {

	public static void main(String[] args) {
		
		// DECLARATIONS
		
		// Randomize for gas tank size
		// not constant due to reuse of values later
		int min = 8;
		int max = 15;
		int range = (max - min) + 1;
		
		int rand = (int)(Math.random() * range) + min;
		
		GasLogic gasLogic = new GasLogic();
		RandomLogic randLogic = new RandomLogic();
		
		Scanner in = new Scanner(System.in);
		String vehicleName;
		String exitInput;
		

		// START
		System.out.println("Welcome to the Wasteland!");
		System.out.println(" ");
		System.out.println("The world has long since ended, and all you have left is your trusty...");
		System.out.println("Please enter a vehicle...");
		
		// Create Vehicle
		vehicleName = in.nextLine();
		Vehicle userVehicle = new Vehicle(vehicleName);
		System.out.println("...and all you have left is your trusty " + userVehicle.getVehicleType() + "!");
		userVehicle.setGasTankSize(rand);
		
		// Randomize for current gas 
		// Make it at least 6 so they get a day or so.
		min = 6;
		max = userVehicle.getGasTankSize() - 1;
		range = (max - min) + 1;
		rand = (int)(Math.random() * range) + min;
		userVehicle.setGasCurrentAmt(rand);
		System.out.println(" ");
		System.out.println("It has a gas tank size of " + userVehicle.getGasTankSize() + ", and only " + userVehicle.getGasCurrentAmt() + " gallons currently in it.");
		System.out.println("With no where else to go, you figure you'll travel the wastes in hope there is something out there. Or maybe just to see how far you get before you kick the bucket...");
		System.out.println("You decide to conserve gas by driving only a certain distance a day and waiting till the next day in hopes of someone finding you first.");
		
		// Randomize for gas usage
		min = 2;
		max = 3;
		range = (max - min) + 1;
		rand = (int)(Math.random() * range) + min;
		userVehicle.setGasConsumptionPerDay(rand);
		System.out.println(" ");
		System.out.println("After some not very intense calculation, you figure your " + userVehicle.getVehicleType() + " will use up " + userVehicle.getGasConsumptionPerDay() + " gallons per day.");
		System.out.println("You also have an entire pallette of canned peaches that you've stuffed into the back, so you shouldn't need to worry about food or hydration.");
		System.out.println("With this knowledge, you head out into the dust in search of life... and gas.");
		
		
		
		// Game loop begin
		System.out.println("----Press any key to continue, or 'q' to exit at any time.----");
		int dayCount = 1;
		exitInput = in.next();
		
		while (exitInput.toLowerCase() != "q") {
			System.out.println("Day: " + dayCount);
			gasLogic.calculateGasUsage(userVehicle);
			randLogic.randomEvents(userVehicle);
			
			System.out.println("You currently have " + userVehicle.getGasCurrentAmt() + " gallons in the tank.");
			
			if (gasLogic.checkEmptyFailState(userVehicle) == true) {
				exitInput = "q";
			} else {
				System.out.println("----Press any key to continue, or 'q' to exit at any time.----");
				exitInput = in.next();
			}
			
			dayCount++;
		}
		
		System.out.println(" ");
		System.out.println("--GAME OVER--");
		System.out.println("With not enough gas to keep going, you have sadly perished.");
		System.out.println("You lasted " + dayCount + " days.");
	}

}
