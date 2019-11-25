// This class is for all our configuration data. By putting it all in one place, we can easily make changes to the program without having to hunt down where in the code a constant is defined.

public class Config {
  public final static String DATAPATH = "data/"; // If you don't know what the static keyword does, you better go look it up now.
  public final static String APPLICATIONNAME = "Hexagon Cross Generator";
  // Prime file: One prime per line.
  public String primeFile = "primes.txt"; 
  // Cross file: Two primes per line, separated by a comma.
  public String crossFile = "crosses.text";
}