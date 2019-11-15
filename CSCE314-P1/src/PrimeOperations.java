//McKenzie Burch
//CSCE 314-501
//GitHub: https://github.com/mburch13/CSCE314-PHASE1.git
import java.util.ArrayList; 
import java.math.BigInteger;

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class PrimeOperations {
	
	// Pair class implementation.
	private class Pair<T> {
		T x;
		T y;
		
		//constructor
		public Pair(T x1, T y1) {
			this.x = x1;
			this.y = y1;
		}

		public T getX() {
			return x;
		}

		public T getY() {
			return y;
		}

		public void setX(T x) {
			this.x = x;
		}

		public void setY(T y) {
			this.y = y;
		}
		
		public String toString() {
			return x + ", " + y;
		}
		
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
	ArrayList<Pair<BigInteger>> primeTwins = new ArrayList<Pair<BigInteger>>();
	ArrayList<Pair> primeHex = new ArrayList<Pair>();
	ArrayList<Pair> primeHexSplit = new ArrayList<Pair>();

	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		/* if list is null{
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
		}
		else {
			if (primes.contains(x) != true) {
				primes.add(x);
			}
		}
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		for(int i = 0; i < primes.size(); i++) {
			System.out.println(primes.get(i));
		}
		System.out.println("Total Primes: " +primes.size());

	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		for(int i = 1; i < primeTwins.size(); i++) {
			System.out.println(primeTwins.get(i));
		}
		System.out.println("Total Twins: " + primeTwins.size());

	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
		for(int i = 0; i < primeHex.size(); i++) {
			System.out.println("Prime Pairs: " + primeHex.get(i).getX() + " and " + primeHex.get(i).getY() + " separated by " + primeHexSplit.get(i));
		}
		System.out.println("Total Hex Crosses: " + primeHex.size());

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
		BigInteger num = BigInteger.ONE;
		
		for(int amount = count; amount > 0; num = num.add(BigInteger.ONE)) {
			if(num.compareTo(new BigInteger("2")) == 0 || num.compareTo(new BigInteger("3")) == 0) {
				flag = 1;
			}
			for(BigInteger i = new BigInteger("2"); i.compareTo(num.divide(new BigInteger("2"))) <= 0; i = i.add(BigInteger.ONE)) {	
				if(num.mod(i).equals(BigInteger.ZERO)) {
					//number NOT a prime
					flag = -1;
					break; 
				}
				flag = 1;
			}
			if(flag == 1) {
				//addPrime to the list
				addPrime(num);
				amount--;
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
			BigInteger diff = primes.get(i).subtract(primes.get(i-1));
			if(diff.compareTo(new BigInteger("2")) == 0){
				PrimeOperations.Pair<BigInteger> twins = new Pair<BigInteger>(primes.get(i-1), primes.get(i));
				primeTwins.add(twins);
			}
		}
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		/*
		 * A “hexagon cross” is a pair of numbers that are the middle integer between the primes in a twin prime, 
		 * such that the second number in the pair is twice the first number. For example, 6 and 12 make up a hexagon cross, 
		 * because 6 is the integer between the twin prime 5 and 7, and 12 is the middle number 
		 * between the twin prime 11 and 13, and 6 * 2 = 12. (6,270 and 12540 are another hexagon cross.)
		 * 
		 * loop through primeTwins i as iterator{
		 * 	loop through primeTwins k as iterator{
		 * 		if (i+1)*2 == k{
		 * 			create pairs to store prime pairs and hex crosses			
		 * 			add to list
		 * 		}
		 * 	}
		 * }			
		 */
		
		for(int i = 0; i < primeTwins.size(); i ++) {
			for(int k = 0; k < primeTwins.size(); k++) {
				BigInteger t1 = primeTwins.get(i).getX().add(BigInteger.ONE);
				BigInteger t2 = primeTwins.get(k).getX().add(BigInteger.ONE);
				if(t1.multiply(new BigInteger ("2")).compareTo(t2) == 0) {
					Pair<BigInteger> p1 = new Pair<BigInteger>(primeTwins.get(i).getX(), primeTwins.get(i).getY());
					Pair<BigInteger> p2 = new Pair<BigInteger>(primeTwins.get(k).getX(), primeTwins.get(k).getY());
					
					Pair<Pair> pairs = new Pair<Pair>(p1, p2);
					primeHex.add(pairs);
					
					Pair<BigInteger> splits = new Pair<BigInteger>(t1, t2);
					primeHexSplit.add(splits);
				}
			}
		}
	}
}
