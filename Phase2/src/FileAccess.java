// This file gives access to the underlying datafile and stores the data in the Workout class.
/*
 * create static functions to load/save primes and crosses
 * return true if the operation succeeds and false if it fails
 * success or failure should be used to update the main window’s status bar 
 * save functions must use the “ for-each ” Java language construct and iterators to work through 
 * the prime and cross lists. 
 * All saves and loads should be to the “data” subdirectory, but should allow 
 * user-specified filenames from the GUI. This custom filename ability can allow the user to specify 
 * additional path information as part of the custom filename.
 */
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
	  //loading a text file of primes
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
	  File cross = new File(Config.DATAPATH + filename);
	  Scanner sc = new Scanner(cross);
	  
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String leftC = line.substring(0, line.indexOf(","));
			String rightC = line.substring(line.indexOf(",") + 1);

			Pair<BigInteger> myPair = new Pair<BigInteger>(new BigInteger(leftC), new BigInteger(rightC));
			primes.addCross(myPair);
		} 
	return true;
	}
  
  public static boolean savePrimes(Primes primes, String filename) throws IOException
  {  
	  File f = new File(Config.DATAPATH + filename);
	  
	  if(!f.exists()) {
		  f.createNewFile();
	  }
	  
	  BufferedWriter writer = new BufferedWriter(new FileWriter(f));
	  Primes.IterablePrimes itP = primes.iteratePrimes();
	  
	  for(BigInteger p : itP) {
		  writer.write(p.toString() + "\n");
	  }

	  writer.close();

	  return true;
  }
  
  public static boolean saveCrosses(Primes primes, String filename) throws IOException
  {
	  File f = new File(Config.DATAPATH + filename);
	  
	  if(!f.exists()) {
		  f.createNewFile();
	  }
	  
	  BufferedWriter writer = new BufferedWriter(new FileWriter(f));
	  Primes.IterableCrosses itC = primes.iterateCrosses();
	  for(Pair<BigInteger> c : itC) {
		  writer.write(c.left().toString() + "," + c.right() + "\n");
	  }
	  writer.close();
	  
	  return true;
  }
}