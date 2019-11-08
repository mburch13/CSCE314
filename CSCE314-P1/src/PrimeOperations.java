import java.util.ArrayList; 
import java.math.BigInteger;

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class PrimeOperations {
	
	// Pair class implementation.
	private class Pair<T> {
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		//if list is null add to list
				//else check to see if number is in list
					//if present return
					//else add to list
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		//call and println generatePrimes
//		System.out.println(generatePrimes(count));
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		//call and println generateTwinPrimes

	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
		//call and println generateHexPrimes

	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		/**
		 * for loop for all possible primes{
		 * 	if count not 0{
		 * 		for loop to start checking if number is prime{
		 * 			if mod2 == 0 
		 * 		}addPrime()
		 * 	}--count
		 * }*/
		
		int flag = -1; //change if number is prime
		
		for(BigInteger x = new BigInteger("2"); x.compareTo(BigInteger.ZERO) > 0; x = x.add(BigInteger.ONE)) {
			if(count != 0) {
//				System.out.println("X Before Check: " + x);
				for(BigInteger i = new BigInteger("2"); i.compareTo(x.divide(new BigInteger("2"))) <= 0; i = i.add(BigInteger.ONE)) {
					if(x.mod(i).equals(BigInteger.ZERO) 
							&& x.compareTo(new BigInteger("2")) != 0 
							|| x.compareTo(new BigInteger("3")) != 0) {
						flag = -1;
						break; //number NOT a prime
					}
//					System.out.println("X After Check: " + x);
					flag = 1;
					
					//addPrime to the list
				}
				if(flag == 1) {
					--count;
					System.out.print(x);
					System.out.println("\tTest: " + count);
				}
			}
		}
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		//call generatePrimes
				//while 
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		//loop through list
		//if twin prime
	}
}
