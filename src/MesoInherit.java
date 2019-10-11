public class MesoInherit extends MesoAbstract	{

	/**
	 * integer array to hold averages of a station ID
	 */
	private int[] averages;
	
	/**
	 * Station ID of the given input
	 */
	private String stID;
	
	/**
	 * Constructor for MesoInherit objects.  Sets private field stID from MesoStation input object.
	 * 
	 * @param station The MesoStation object to be used within MesoInherit
	 */
	public MesoInherit(MesoStation station)	{
		stID = station.getStID();
	}
	
	/**
	 * This method determines the ASCII integer representing each character in a station ID and calculates its average.
	 * 
	 * @return an integer array containing the floor, ceiling, and rounded average of the station ID.
	 */
	@Override
	int[] calAverage() {
		averages = new int[3];
		
		double first = (int)stID.charAt(0);
		double second = (int)stID.charAt(1);
		double third = (int)stID.charAt(2);
		double fourth = (int)stID.charAt(3);
		
		double avg = (first + second + third + fourth)/4;
		
		averages[0] = (int) Math.ceil(avg);  
		averages[1] = (int) Math.floor(avg);
		averages[2] = (int) Math.round(avg);
		
		return averages;
	}

	/**
	 * Determines the letter that corresponds to the average of the letters in a station ID.
	 * 
	 * @return the ASCII character represented by the average determined in calAverage().
	 */
	@Override
	char letterAverage() {
		double first = (int)stID.charAt(0);
		double second = (int)stID.charAt(1);
		double third = (int)stID.charAt(2);
		double fourth = (int)stID.charAt(3);
		
		double avg = (first + second + third + fourth)/4;
		int average = (int) Math.round(avg);
		
		char letterAvg = (char)average;
		return letterAvg;
	}
}
