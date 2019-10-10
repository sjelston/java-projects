import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg {

	/**
	 * The initial array to hold stationIDs
	 */
	private String stationID[] = new String[15];
	
	/**
	 * The letter average to be used for the LetterAvg object
	 */
	private char letter;
	
	/**
	 * Constructor for LetterAvg.  Sets letter and reads in Mesonet.txt to set the stationID array.
	 * 
	 * @param avg The character representing the average of characters in a stationID.
	 * @throws Exception 
	 */
	public LetterAvg(char avg) throws IOException	{
		letter = avg;
		read("Mesonet.txt");
	}
	
	/**
	 * Determines the number of station IDs within Mesonet.txt that begin with the letter corresponding
	 * to the letter average of a station ID.
	 * 
	 * @return The number of station IDs starting with the letter average.
	 */
	public int numberOfStationWithLetterAvg()	{
		int stations = 0;
		for(int i = 0; i < stationID.length; i++)
		{
			String temp = stationID[i];
			if ((temp.charAt(0)) == letter)	{
				stations += 1;
			}
		}
		return stations;
	}
	
	/**
	 * This method reads from a file and sorts through to find the 
	 * station IDs in the document.  It then stores each station 
	 * ID in the stationID array, enlarging it when necessary.
	 * 
	 * @param fileName The file to be read into stationID
	 * @throws IOException 
	 * @throws Exception
	 */
	public void read(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String ID = "";
		String strg = br.readLine();

		for(int i = 0; i < 2; i++)
		{
			br.readLine();
		}
		
		int count = 0;
		while (!((strg = br.readLine()) == null))	{
			for (int j = 1; j < 5; j++)	{
				ID += strg.charAt(j);
			}
			if (count < stationID.length)	{
				stationID[count] = ID;
			}
			else	{
				stationID = increaseArray(stationID);
				stationID[count] = ID;
			}
			count++;
			ID = "";
		}
		br.close();
	}
		/*	Scanner sc = new Scanner(new File (fileName));
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
	*/
	
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
     * toString override. Gives the station IDs starting with the letter average.
     * 
     * @return Station IDs beginning with the letter average in the format:
     * They are: \n <ID1> \n <ID2> \n <ID3> \n .... <IDn>
     */
	@Override
	public String toString()	{
		String output = "\nThey are:" + "\n";
		String[] sameLetter = new String[20];
		
		int j = 0;
		for(int i = 0; i < stationID.length; i++)	{
			String temp = stationID[i];
			if ((temp.charAt(0)) == letter)	{
				sameLetter[j] = temp;
				j++;
			}
		}
		for(int k = 0; k < j; k++)	{
			output += sameLetter[k] + "\n";
		}
		output += sameLetter[j];
		return output;
	}
}
