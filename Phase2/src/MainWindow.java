import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

/*
 * This is the main file for creating your application window. 
 * It should create the window described in the GUI and add ActionListeners to all the GUI elements 
 * that need user interactivity. Complete code is provided for the “Generating Prime Numbers” dialog box.
 * You may optimize this code or use it as-it.
 * 
 * You will also need to add two Iterators to the Primes class, one for Primes, one for Crosses. 
 * You will use these in your save functions to iterate through the relevant ArrayList. 
 * You will implement these iterators as private classes that implement the Iterable interface.
 */

/*
 * GUI
 * create a primary window for the program that is 1000x400 pixels in size. 
 * The background color should be the Texas A&M specific shade of maroon used by the school. 
 * The application may be given any name decided upon by the developer. 
 * This window should contain a textbox for entering the Primes the Hexagon Cross file name.
 * Buttons for loading and saving each of these files should be specified, and the default file names 
 * should be initially set for each of these items.
 *  
 * The main window should contain a status bar to keep the user informed of the success or failure of
 * any given operation. It should also contain metadata about the work being done, such as the number
 * of primes generated or loaded (9000), the number of Hexagon Crosses generated or loaded (14), the
 * length of the largest prime (6 digits) and the length of the two numbers in the largest Hexagon Cross
 * (5 and 5 digits).
 *  
 * Buttons for generating primes and generating crosses should be implemented. The Generate Primes
 * button should create a dialog box for the user to enter the number of primes to generate and a
 * starting number. The program should be able to accept and process numbers of arbitrary length. The
 * program may be single-threaded.
 */

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -3880026026104218593L;
	private Primes m_Primes;
	private JTextField tfPrimeFileName;
	private JTextField tfCrossFileName;
	private JLabel lblPrimeCount;
	private JLabel lblCrossCount;
	private JLabel lblLargestPrime;
	private JLabel lblLargestCross;
	private JLabel lblStatus;
	
	MainWindow(String name, Primes p)
	{
		JFrame window = new JFrame(name);
		GridBagLayout gridLayout = new GridBagLayout();
		
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(new Color(80,0,0));
		window.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints windCons = new GridBagConstraints();
		windCons.fill = GridBagConstraints.HORIZONTAL;
		windCons.anchor = GridBagConstraints.WEST;
		windCons.ipady = 10;
		windCons.weightx = .5;
		windCons.insets = new Insets(1,2,0,0);
		windCons.gridx = 0;
		windCons.gridy = 0;
		
		GridBagConstraints westCons = new GridBagConstraints();
//		westCons.fill = GridBagConstraints.HORIZONTAL;
		westCons.anchor = GridBagConstraints.WEST;
		westCons.ipady = 10;
		westCons.weightx = .5;
		westCons.insets = new Insets(1,2,0,0);
		westCons.gridx = 0;
		westCons.gridy = 0;
		
		GridBagConstraints eastCons = new GridBagConstraints();
		eastCons.anchor = GridBagConstraints.EAST;
		eastCons.ipady = 10;
		eastCons.weightx = .5;
		eastCons.insets = new Insets(1,2,0,0);
		eastCons.gridx = 0;
		eastCons.gridy = 0;
		
		JPanel primePanel = new JPanel();
		primePanel.setLayout(new GridBagLayout());
		
		tfPrimeFileName = new JTextField(Config.primeFile);
		tfPrimeFileName.setColumns(75);
		primePanel.add(tfPrimeFileName, westCons);
		
		lblPrimeCount = new JLabel("0");
		lblPrimeCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrimeCount.setAlignmentX(CENTER_ALIGNMENT);
		eastCons.gridx = 1;
		primePanel.add(lblPrimeCount, eastCons);
		
		JLabel lblPrimes = new JLabel("Primes File");
		lblPrimes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		westCons.gridx = 0;
		westCons.gridy = 1;
		primePanel.add(lblPrimes, westCons);
		
		JButton loadPrimes = new JButton("Load");
		loadPrimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileAccess f = new FileAccess();
				try {
					f.loadPrimes(m_Primes, Config.primeFile);
					lblStatus.setText("Status: Primes list successfully loaded");
					updateStats();
					m_Primes.printPrimes();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText("Status: Primes list failed to load");
					updateStats();
					e1.printStackTrace();
				}
			}
		});
		eastCons.gridy = 1;
		eastCons.gridx = 0;
		primePanel.add(loadPrimes, eastCons);
		
		JButton savePrimes = new JButton("Save");
		savePrimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("nothing to save yet");				
			}
		});
		eastCons.gridx = 1;
		primePanel.add(savePrimes, eastCons);
		
		window.add(primePanel, windCons);
		
		JPanel crossPanel = new JPanel();
		crossPanel.setLayout(new GridBagLayout());
		
		tfCrossFileName = new JTextField(Config.crossFile);
		tfCrossFileName.setColumns(75);
		westCons.gridy = 0;
		westCons.gridx = 0;
		crossPanel.add(tfCrossFileName, westCons);
		
		lblCrossCount = new JLabel("0");
		lblCrossCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrossCount.setAlignmentX(CENTER_ALIGNMENT);
		eastCons.gridx = 1;
		eastCons.gridy = 0;
		crossPanel.add(lblCrossCount, eastCons);
		
		JLabel lblCross = new JLabel("Crosses File");
		lblCross.setFont(new Font("Tahoma", Font.PLAIN, 20));
		westCons.gridy = 1;
		westCons.gridx = 0;
		crossPanel.add(lblCross, westCons);
		
		JButton loadCross = new JButton("Load");
		loadCross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileAccess f = new FileAccess();
				try {
					f.loadCrosses(p,  Config.crossFile);
					m_Primes.printHexes();
					lblStatus.setText("Status: Cross list successfully loaded");
					updateStats();
				} catch (FileNotFoundException e1) {
					lblStatus.setText("Status: Cross list failed to load");
					updateStats();
					e1.printStackTrace();
				}
			}
		});
		
		eastCons.gridx = 0;
		eastCons.gridy = 1;
		crossPanel.add(loadCross, eastCons);
		
		JButton saveCross = new JButton("Save");
		saveCross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("nothing to save yet");
			}
		});
		eastCons.gridx = 1;
		crossPanel.add(saveCross, eastCons);
		
		windCons.gridy = 1;
		window.add(crossPanel, windCons);
		
		JPanel generators = new JPanel();
		generators.setLayout(new GridBagLayout());
		
		JButton genPrimes = new JButton("Generate Primes");
		genPrimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupGeneratePrimes();
			}
		});
		generators.add(genPrimes, westCons);
		
		lblLargestPrime = new JLabel("The largest prime has x digits");
		lblLargestPrime.setFont(new Font("Tahoma", Font.BOLD, 12));

		westCons.gridx = 1;
		westCons.gridy = 0;
		westCons.anchor = GridBagConstraints.CENTER;
		generators.add(lblLargestPrime, westCons);
		
		lblLargestCross = new JLabel("The largest cross has x and y digits");
		lblLargestCross.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLargestCross.setAlignmentX(CENTER_ALIGNMENT);
		westCons.gridy = 1;
		generators.add(lblLargestCross, westCons);
		
		JButton genCross = new JButton("Generate Crosses");
		genCross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("nothing to generate yet");
				
			}
		});
		westCons.gridx = 2;
		westCons.anchor = GridBagConstraints.EAST;
		generators.add(genCross, westCons);
		
		windCons.gridy = 2;
		window.add(generators, windCons);
		
		JPanel statPanel = new JPanel();
		
		lblStatus = new JLabel();
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		westCons.gridx = 0;
		statPanel.add(lblStatus, westCons);
		
		windCons.gridy = 3;
		window.add(statPanel, windCons);
		
		window.setSize(1000, 400);
//		window.pack();
		window.setVisible(true);
	}

	protected void popupGeneratePrimes()
	{
		JDialog dPrimes = new JDialog(this, "Prime Number Generation");
		GridBagLayout gridLayout = new GridBagLayout();
		dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		JPanel pnlGenerate = new JPanel();
		pnlGenerate.setLayout(new GridBagLayout());
		
		JLabel lblCount = new JLabel("Number of Primes to Generate");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlGenerate.add(lblCount, gbcPanel);
		
		JTextField tfCount = new JTextField();
		lblCount.setLabelFor(tfCount);
		tfCount.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfCount, gbcPanel);
		
		JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlGenerate.add(lblStart, gbcPanel);
		
		JTextField tfStart = new JTextField();
		lblStart.setLabelFor(tfStart);
		tfStart.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfStart, gbcPanel);
		
		dPrimes.add(pnlGenerate, gbcDialog);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					BigInteger start = new BigInteger(tfStart.getText());
					int count = Integer.parseInt(tfCount.getText());
					m_Primes.generatePrimes(start, count);
					lblStatus.setText("Status: Excited. Primes have been generated.");
					updateStats();
					dPrimes.dispose();
				}
				catch(NumberFormatException ex)
				{
					lblStatus.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
					dPrimes.dispose();
				}

			}
		});
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		JButton btnCancel = new JButton("Cancel Generation");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dPrimes.dispose();
			}
		});
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		pnlButtons.add(btnCancel, gbcPanel);		
		
		gbcDialog.gridy = 1;
		dPrimes.add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 2;
		dPrimes.add(pnlStatus, gbcDialog);
		
		dPrimes.setSize(200,200);
		dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		dPrimes.setVisible(true);		
	}

	// This function updates all the GUI statistics. (# of primes, # of crosses, etc)
	private void updateStats()
	{
 	}

}
