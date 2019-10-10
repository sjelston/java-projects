# proj2F19

This project was designed to compute some averages for a given 4-character station ID as well as give some additional relevant information based on station IDs from the Mesonet.txt file.

**MesoAbstract.java**	*An abstract class to create methods for MesoInherit.java to implement.*

Methods:
	
	abstract int[] calAverage()		An abstract method meant to be implemented by a subclass to calculate averages.
	abstract char letterAverage()		An abstract method meant to be implemented by a subclass to determine a letter average.
	
**MesoInherit.java**	*A subclass of MesoAbstract.java*

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
												
**PosAvg.java**	*A class built to determine detatils about a station ID's average position*

*generates the first 2 lines of output*

Variables:

	private String stationID[]
		= new String[15]
		
	private String stID
	
	private String avgMinus1
	private String avgPlus1
	private String avgMinus2
	private String avgPlus2
	
Methods:

	public PosAvg(String stID) throws IOException
	
	public int indexOfStation()
	
	public void avgStations()		Calculates the first 2 sets of stations whose indices will average to the index of stID 
											and assigns them to the private fields avgMinus1, avgPlus1, avgMinus2, avgPlus2.
	
	public void read(String fileName) throws IOException		reads through a file and obtains the station IDs which are then 
																	placed into the private field String array stationID, enlarged 
																	when necessary.
	
	public String[] increaseArray(String[] array)		This methods makes an array one element larger while maintaining 
															the original array's contents
	
	public String toString()		toString() override. Gives information on index averages for the given station ID.