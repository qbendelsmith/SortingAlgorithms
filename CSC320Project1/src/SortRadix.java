
import java.util.function.Function;

public class SortRadix <T> {
    private static int ops = 0;

  /** Creates a lambda function to use the "d" digit for sorting.
	*/
  private static Function<Simple,Integer> getAlphaHashFunction(int digit) {
    // determine ASCII value of char at position "digit" and normalize
		// to be in range of 0 and 25
		return (simple) -> Character.getNumericValue(simple.alpha().charAt(digit)) - Character.getNumericValue('a');
	}

	/** Get the digit at the 10's position place.
	For example, if position==0, then getting the 10^0 (ones) digit.
	For example, if position==2, then getting the 10^2 (hundreds) digit.
	@param number to extract digit from
	@param position position of the digit
	*/
	private static int getDigit(Integer number, int position) {
    if (0 != position) {
	   // Another mistake on my part: number = number / (position*10);
	    // corrected with the next line!
            Double power = Math.pow(10,position);
            Double newPow = new Double(power);
            //Necessary for converting int from double, from https://www.geeksforgeeks.org/convert-double-to-integer-in-java/
            int value = newPow.intValue();
	    number = number / value;

		}
		return number % 10;
	}

	/** Create a lambda function that uses the getDigit function to map a position to a digit.
	@param pos position of digit to extract from Simple.numeric
	@return lambda function maps Simple.numeric to the digit at pos
	*/
	public static Function<Simple,Integer> getNumericHashFunction(int pos) {
		return (simple) -> getDigit(simple.numeric(),pos);
	}
        
        /** Create a lambda function that uses the getDigit function to map a position to a digit.
	@param pos position of digit to extract from Simple.intValue
	@return lambda function maps Simple.intValue to the digit at pos
	*/
        public static Function<Integer,Integer> getNumericHashFunctionCopy(int pos) {
		return (simple) -> getDigit(simple.intValue(),pos);
	}

  public static <T> int sort(T[] array, boolean byNumber) {

      int a = 0;
    // IMPORTANT: You will need to get the number of operations for each loop
		// This means you have to get it from Counting sort in each loop and
		// add to total.
		if (byNumber) {
			// @TODO ***^^^^^^^^^^^^^^^^ FILL ME IN
                        //Find Max in array
                        int x = getMax(array);
                        // Y is a predetermined maximum possible power for the int that I chose
                        int y = 10;
                        // Finding the max possible power from the max in array
                        while (getDigit(x,y) != 0){
                            y--;
                        }
                        for (int i = 0; i <= y; i++){
                            ops++;
                            // Get variable of type Function<Integer, Integer>
                            Function<Integer, Integer> z = getNumericHashFunctionCopy((Integer) i);
                            //Cast an array of Integer on array of type T
                            Integer[] newArray = (Integer[]) array;
                            // Plug into counting sort at each power of 10
                            a = SortCounting.sort(newArray, 9, z);
                        }
                        
                        
		} else {
			// @TODO ***^^^^^^^^^^^^^^^^ FILL ME IN but not right now :p
		}
                
                return a+ops;
	} // end sort
  
  public static <T> int getMax(T[] array){
      //Initialize max value as first item in array
      int max = (int) array[0];
      
      //Iterate through the array and find max value
      for (int i = 1; i < array.length; i++){
          if (max < (int) array[i]){
              //Cast int over the value because otherwise it would have to take a comparator as an argument
              max = (int) array[i];
          }
      }
      //Output the max value
      return max;
  }
} // end class
