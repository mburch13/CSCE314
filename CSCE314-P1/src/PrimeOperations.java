import java.util.ArrayList; 
import java.math.BigInteger;

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class PrimeOperations {
	
	// Pair class implementation.
	private class Pair<T> {
		BigInteger x, y;
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
	ArrayList<BigInteger> primeTwins = new ArrayList<BigInteger>();

	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		/* make an array list
		 * if list is null{
		 * 	add to list
		 * 	}else{
		 * 		check to see if number is in list
		 * 		if not present{
		 * 			add to list
		 * 		}
		 * 	}
		 * }
		 */

		if(primes.isEmpty()) {
			primes.add(x);
//			System.out.println(x + " was added to list");
		}
		else {
			if (primes.contains(x) != true) {
				primes.add(x);
//				System.out.println(x + " was added to list");
			}
		}
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
//		System.out.print("hello");
//		System.out.println(primes.size());
		for(int i = 0; i <= primes.size()-1; i++) {
			System.out.println(primes.get(i));
		}
		System.out.println("Total Primes: " +primes.size());

	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		//call and println generateTwinPrimes
		for(int i = 1; i < primeTwins.size(); i++) {
			System.out.println(primeTwins.get(i) + ", " + primeTwins.get(i-1));
		}
		System.out.println("Total Twins: " + primeTwins.size()/2);

	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
		//call and println generateHexPrimes
		for(int i = 0; i <= primes.size()-1; i++) {
			System.out.println(i);
		}
		System.out.println("Total Hex Crosses: " +primes.size());

	}
		
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		/**
		 * for loop for all possible primes{
		 * 	if count not 0{
		 * 		check if number is 2 or 3{
		 * 			flag prime number
		 * 		}for loop to start checking if number is prime{
		 * 			if mod2 == 0{
		 * 				flag not prime
		 * 			}flag prime number
		 * 		}if flag is prime number{
		 * 			addPrime()
		 * 			--count
		 * 			}
		 * 		}
		 * 	}
		 * }*/
		
		int flag = -1; //change if number is prime
		BigInteger start = new BigInteger("2");
//		BigInteger amount = BigInteger.valueOf(count);
		
		for(int amount = count; amount > 0; start = start.add(BigInteger.ONE)) {
//			System.out.println("X Before Check: " + x);
			if(start.compareTo(new BigInteger("2")) == 0 || start.compareTo(new BigInteger("3")) == 0) {
				flag = 1;
			}
			for(BigInteger i = new BigInteger("2"); i.compareTo(start.divide(new BigInteger("2"))) <= 0; i = i.add(BigInteger.ONE)) {	
				if(start.mod(i).equals(BigInteger.ZERO)) {
				flag = -1;
					break; //number NOT a prime
				}
//				System.out.println("X After Check: " + x);
				flag = 1;
			}
			if(flag == 1) {
				//addPrime to the list
				addPrime(start);
				amount--;
//				System.out.print(start);
//				System.out.println("\tTest: " + amount);
			}
		}
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		/* A “twin prime” is a pair of primes that only have one integer between them, 
		 * such as 5 and 7; 11 and 13; 6269 and 6271; or 12539 and 12541.
		 * 
		 * access the primes list
		 * loop through the list{
		 * 		if i - i-1 == 2{
		 * 			pair (i-1, i)
		 * 		}
		 * }
		 */
		
		for(int i = 1; i < primes.size(); i++) {
			BigInteger diff = primes.get(i).subtract(primes.get(i - 1));
			System.out.print(primes.get(i) + ", " + primes.get(i-1));
			System.out.println("\t" + diff);
			if(diff.compareTo(new BigInteger("2")) == 0){
				System.out.println("adding to the list");
				primeTwins.add(primes.get(i));
				primeTwins.add(primes.get(i-1));
			}
		}
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		//loop through list
		//if twin prime
	}
}
