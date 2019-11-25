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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;

public class FileAccess {
  
  public static boolean loadPrimes(Primes primes, String filename) {
		return true;
  }
  
  public static boolean loadCrosses(Primes primes, String filename) {
    return true;
	}
  
  public static boolean savePrimes(Primes primes, String filename)
  {
  	return true;
  }
  
  public static boolean saveCrosses(Primes primes, String filename)
  {
  	return true;
  }
}