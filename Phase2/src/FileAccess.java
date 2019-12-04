// This file gives access to the underlying datafile and stores the data in the Workout class.

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;


public class FileAccess {

	public static boolean loadPrimes(Primes primes, String filename) throws FileNotFoundException {
		//load a text file of primes
		File prime = new File(Config.DATAPATH + filename);
		Scanner sc = new Scanner(prime);

		//check to see if the file as a next line 
		while(sc.hasNextLine()) {
			BigInteger a = new BigInteger(sc.nextLine());
			primes.addPrime(a);
		}
		return true;
	}

	public static boolean loadCrosses(Primes primes, String filename) throws FileNotFoundException {
		//load a text file of crosses
		File cross = new File(Config.DATAPATH + filename);
		Scanner sc = new Scanner(cross);

		//check to see if the file as a next line 
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			//find left side pair
			String leftC = line.substring(0, line.indexOf(","));
			//find right side of pair
			String rightC = line.substring(line.indexOf(",") + 1);

			Pair<BigInteger> myPair = new Pair<BigInteger>(new BigInteger(leftC), new BigInteger(rightC));
			primes.addPair(myPair);
		} 
		return true;
	}

	public static boolean savePrimes(Primes primes, String filename) throws IOException
	{  
		//access primes file
		File f = new File(Config.DATAPATH + filename);

		//create new file if needed
		if(!f.exists()) {
			f.createNewFile();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		Primes.IterablePrimes itP = primes.iteratePrimes();

		//iterate through list to write to file
		for(BigInteger p : itP) {
			writer.write(p.toString() + "\n");
		}

		writer.close();

		return true;
	}

	public static boolean saveCrosses(Primes primes, String filename) throws IOException
	{
		//access cross file
		File f = new File(Config.DATAPATH + filename);

		//create new file if needed
		if(!f.exists()) {
			f.createNewFile();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		Primes.IterableCrosses itC = primes.iterateCrosses();
		
		//iterate through list to write to file
		for(Pair<BigInteger> c : itC) {
			writer.write(c.left().toString() + "," + c.right() + "\n");
		}
		writer.close();

		return true;
	}
}