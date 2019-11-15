//McKenzie Burch
//CSCE 314-501
//GitHub: https://github.com/mburch13/CSCE314-PHASE1.git
import java.math.BigInteger;
import java.util.ArrayList;

public class Project1 {
	public static void main(String[] args) 
	{
		try {
		// Instantiate Primes Class
		PrimeOperations testOne = new PrimeOperations();

		// Generate Primes and test.
		testOne.generatePrimes(21);
		testOne.printPrimes();
		
		// Generate and test Twin Primes
		PrimeOperations testTwo = new PrimeOperations();
		testTwo.generatePrimes(100);
		testTwo.generateTwinPrimes();
		testTwo.printTwins();
//		
//		// Generate and test Hexagonal crosses
		PrimeOperations testThree = new PrimeOperations();
		testThree.generatePrimes(2000);
		testThree.generateTwinPrimes();
		testThree.generateHexPrimes();
		testThree.printHexes();
		
//		System.out.println("\n MY TEST CASES");
//		PrimeOperations myTest = new PrimeOperations();
//		myTest.generatePrimes(40);
//		myTest.printPrimes();
//		myTest.generateTwinPrimes();
//		myTest.printTwins();
//		myTest.generateHexPrimes();
//		myTest.printHexes();
	
		} catch(RuntimeException ex) {
			System.out.println("Runtime Error");
		}
	}
}
