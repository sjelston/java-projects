# proj2F19

## Overview

**General Behavior**

This project was designed to compute some averages for a given 4-character station ID as well as give some additional relevant information based on station IDs from the Mesonet.txt file.

**Output format**

A sample output for the input station ID "NRMN" would look like this:

	The Index of the city is: 77
	This index is average of NOWA and OILT, NEWP and OKCE, and so on.

	Ascii Ceiling is 79
	Ascii Floor is 78
	Ascii Average is 79

	Letter Avg: O

	Total number of stations starting with letter 'O' is 4.

	They are:
	OILT
	OKCE
	OKEM
	OKMU

## Classes

**MesoAbstract.java**	*An abstract class to create methods for MesoInherit.java to implement.*

Methods:
	
	abstract int[] calAverage()		An abstract method meant to be implemented by a subclass to calculate averages.
	abstract char letterAverage()		An abstract method meant to be implemented by a subclass to determine a letter average.
	
**MesoInherit.java**	*A subclass of MesoAbstract.java*

*generates lines 3-6 of output*

Variables:

	private int[] averages		An int array to hold the averages once they have been computed.
	private String stID		A String variable to hold the station ID the object is created with.

Methods:

	public MesoInherit(MesoStation station)		Constructor for MesoInherit, takes in a MesoStation object and obtains its 
													station ID then assigns it to private field stID.  
												
	int[] calAverage()		Implementation of MesoAbstract method.  This method determines the ASCII int 
									representing each character in a station ID and calculates its floor, ceiling, 
									and rounded averages, placing them each in an int array[].
												
	char letterAverage()		Implementation of MesoAbstract method.  This method determines and returns 
									the ASCII character corresponding to the average of the letters in the station ID.
												
**PosAvg.java**	*A class built to determine details about a station ID's average position*

*generates the first 2 lines of output*

Variables:

	private String stationID[]		String array to hold station IDs.
		= new String[15]
		
	private String stID		String containing the station ID for the object.
	
	private String avgMinus1		The station ID at the index 1 below stID.
	private String avgPlus1		The station ID at the index 1 above stID.
	private String avgMinus2		The station ID at the index 2 below stID.
	private String avgPlus2		The station ID at the index 2 above stID.
	
Methods:

	public PosAvg(String stID) throws IOException		Constructor for PosAvg.  Sets the private field stID from input and reads 
															in Mesonet.txt file to the stationID array and calls avgStations().
	public int indexOfStation()		Finds the index of the station ID within the Mesonet text file.
	
	public void avgStations()		Calculates the first 2 sets of stations whose indices will average to the index of stID 
											and assigns them to the private fields avgMinus1, avgPlus1, avgMinus2, avgPlus2.
	
	public void read(String fileName) throws IOException		Reads through a file and obtains the station IDs which are then 
																	placed into the private field String array stationID, enlarged 
																	when necessary.
	public String[] increaseArray(String[] array)		This methods makes an array one element larger while maintaining 
															the original array's contents
	
	public String toString()		toString() override. Gives information on index averages for the given station ID.
	
**LetterAvg.java**	*A class built to determine details about a station ID's letter average*

*generates the output from line 7 until the end*

Variables:

	private String stationID[]		String array to hold station IDs.
		= new String[15]
		
	private char letter		Used to hold the character representing the average, determined in another method.
	
Methods:

	public LetterAvg(char avg) throws IOException		
	
	public int numberOfStationWithLetterAvg()		
	
	public void read(String fileName) throws IOException		
	
	public String[] increaseArray(String[] array)		
	
	public String toString()		
	