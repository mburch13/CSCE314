import java.math.BigInteger;

import javax.swing.plaf.basic.BasicIconFactory;

/*
 * A NaiveTest.java file is included with a simple, functional isPrime function. 
 * replace isPrime function with a more efficient test for primality. 
 * This test must be absolute. This means you can not use any of the probabilistic tests as your 
 * sole determiner of primality. (This includes but is not limited to Fermat’s, Miller-Rabin, and 
 * Solovay-Strasson, Adleman-Huang, Baille-PSW, and Frobenius.) You must use a deterministic primality 
 * test. You can use a fast probabilistic tests as an initial qualifier, as the NaiveTest uses 
 * BigInteger’s isProbablePrime function, but you must then use an absolute test. You are not only 
 * allowed, but encouraged to search Stack Overflow and other online resources for ideas and code 
 * to implement this one feature. However, you must cite your sources and give appropriate credit 
 * for any code that you do not come up with solely on your own.
 */

public class NaiveTest
{
	public static boolean isPrime(BigInteger candidate)
	{
		if (!candidate.isProbablePrime((100))) return false; // Weed out the likely not primes.
		//used prime finder from part 1 of my project
		for(int amount = 0; amount > 0; candidate = candidate.add(BigInteger.ONE)) {
			if(candidate.compareTo(BigInteger.TWO) == 0 || candidate.compareTo(new BigInteger("3")) == 0) {
				return true;
			}
			for(BigInteger i = BigInteger.TWO; i.compareTo(candidate.divide(new BigInteger("2"))) <= 0; i = i.add(BigInteger.ONE)) {	
				if(candidate.mod(i).equals(BigInteger.ZERO)) {
					//number NOT a prime
					return false; 
				}
			}
		}
		return true;
	}
}
