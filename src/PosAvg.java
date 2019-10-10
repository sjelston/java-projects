import java.io.File;
import java.util.Scanner;

public class PosAvg {

	/**
	 * The initial array to hold stationIDs
	 */
	private String stationID[] = new String[15];
	
	/**
	 * The variable for the station ID of the PosAvg object
	 */
	private String stID;
	
	/**
	 * The station ID at the index 1 below stID
	 */
	private String avgMinus1;
	
	/**
	 * The station ID at the index 1 above stID
	 */
	private String avgPlus1;
	
	/**
	 * The station ID at the index 2 below stID
	 */
	private String avgMinus2;
	
	/**
	 * The station ID at the index 2 above stID
	 */
	private String avgPlus2;
	
	/**
	 * Constructor for PosAvg.  Sets the private field stID
	 * 
	 * @param stID This is the station ID inputed.
	 * @throws Exception 
	 */
	public PosAvg(String stID) throws Exception	{
		this.stID = stID;
		read("Mesonet.txt");
		avgStations();
	}
	
	/**
	 * Finds the index of the station ID within the text file
	 * 
	 * @return An integer representing the index.
	 * @throws Exception
	 */
	public int indexOfStation()	{
		//read("Mesonet.txt");
		
		int index = 0;
		for(int i = 0; i < stationID.length; i++)
		{
			String temp = stationID[i];
			if (temp.equals(stID))	{
					index = i + 1;
				}
		}
		return index;
	}
	
	/**
	 * Calculates the first 2 sets of stations whose indices will average to the index of stID
	 */
	public void avgStations()	{
		int index = (indexOfStation()) - 1;
		int minus1 = index - 1;
		int plus1 = index + 1;
		int minus2 = index - 2;
		int plus2 = index + 2;
		
		avgMinus1 = stationID[minus1];
		avgPlus1 = stationID[plus1];
		avgMinus2 = stationID[minus2];
		avgPlus2 = stationID[plus2];
	}
	
	/**
	 * This method reads from a file and sorts through to find the 
	 * station IDs in the document.  It then stores each station 
	 * ID in the stationID array, enlarging it when necessary.
	 * 
	 * @param fileName The file to be read into stationID
	 * @throws Exception
	 */
	public void read(String fileName) throws Exception
	{
		Scanner sc = new Scanner(new File (fileName));
		String strg = sc.nextLine();
		for(int j = 0; j < 2; j++)
		{
			strg = sc.nextLine();
		}

		int i = 0;
		while (sc.hasNextLine())
		{
			strg = sc.next();
				
			if (i < stationID.length)
			{
				stationID[i] = strg;
			}
			else
			{
				stationID = increaseArray(stationID);
				stationID[i] = strg;
			}
			i++;
			strg = sc.nextLine();
		}
		
		sc.close();
	}
	
	/**
	 * This methods makes an array one element larger while maintaining
	 * the original array's contents
	 * 
	 * @param array The array that will be incremented.
	 * @return A string array that contains the same contents as the input
	 * array, but is larger by one empty element.
	 */
	public String[] increaseArray(String[] array)
	{
		String[] newArray = new String[array.length + 1];
		System.arraycopy(array, 0, newArray, 0, (array.length));
		return newArray;
	}
	
	/**
     * toString override. Gives information of index averages for the given station ID.
     * 
     * @return Information about the index average in the format:
     * This index is average of <avgMinus1> and <avgPlus1>, <avgMinus2> and <avgPlus2>, and so on.
     */
	@Override
	public String toString()	{
		return String.format
				("This index is average of %s and %s, %s and %s, and so on.",
				avgMinus1, avgPlus1, avgMinus2, avgPlus2);
	}
	
}
