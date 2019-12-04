import java.math.BigInteger;

import javax.swing.plaf.basic.BasicIconFactory;

//used the isPrime algorithm from part 1 of my project
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
			for(BigInteger i = BigInteger.TWO; i.compareTo(candidate.divide(BigInteger.TWO)) <= 0; i = i.add(BigInteger.ONE)) {	
				if(candidate.mod(i).equals(BigInteger.ZERO)) {
					//number NOT a prime
					return false; 
				}
			}
		}
		return true;
	}
}
