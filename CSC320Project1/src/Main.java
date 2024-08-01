import java.util.Random;
import java.util.function.Function;
import java.util.Comparator;

/** Framework to test sorting algorithms. */
public class Main {

	/************** Comparator for Integer ******/
	public static Comparator<Integer> defaultInts = new Comparator<Integer>() {
		@Override
		public int compare(Integer n1, Integer n2) {
			return n1 - n2;
		}
	};

	/** Lambda function to get the Integer of an Integer, hence the name */
	static Function<Integer,Integer> identity = obj -> obj;

	/**********************************************************************/
	/**********************************************************************/
	/**********************************************************************/

	public static void main(String[] args) {

                Random random = new Random();
                Integer[] randomArray = new Integer[2000];
                for(int i = 0; i < 2000; i++){
                    randomArray[i] = random.nextInt(5000);
                }
                
                // TRY COUNTING SORT
		Integer[] numbers = { 5, 4, 1, 3, 0, 2, 1, 7, 8, 6 };
		System.out.print("pre-sort COUNTING ");
		for (Integer n : numbers) {
			System.out.print(n+" ");
		}
		System.out.println();


		int d = SortCounting.sort(numbers, 10, identity);

		System.out.print("post-sort ");
		for (Integer n : numbers) {
			System.out.print(n+" ");
		}
		System.out.println();
                System.out.println(d);

		// --------------------------------------------
		// TRY MERGE SORT
		Integer[] numbers2 = { 5, 4, 1, 3, 0, 2, 1, 7, 8, 6 };
		System.out.print("pre-sort MERGE ");
		for (Integer n : numbers2) {
			System.out.print(n+" ");
		}
		System.out.println();

		int y = SortMerge.sort(numbers2, defaultInts);

		System.out.print("post-sort ");
		for (Integer n : numbers2) {
			System.out.print(n+" ");
		}
		System.out.println();
                System.out.println(y);

		// --------------------------------------------
		// TRY INSERTION SORT
		Integer[] numbers3 = { 5, 4, 1, 3, 0, 2, 1, 7, 8, 6 };
		System.out.print("pre-sort INSERTION ");
		for (Integer n : numbers3) {
			System.out.print(n+" ");
		}
		System.out.println();

		SortMerge.sort(numbers3,defaultInts);

		System.out.print("post-sort ");
		for (Integer n : numbers3) {
			System.out.print(n+" ");
		}
		System.out.println();
                
                // --------------------------------------------
		// TRY Quick SORT
		Integer[] numbers4 = { 5, 4, 1, 3, 0, 2, 1, 7, 9, 6 };
		System.out.print("pre-sort Quick ");
		for (Integer n : numbers4) {
			System.out.print(n+" ");
		}
		System.out.println();

		int x = SortQuick.sort(numbers4, defaultInts);

		System.out.print("post-sort ");
		for (Integer n : numbers4) {
			System.out.print(n+" ");
		}
		System.out.println();
                System.out.println(x);
                
                // --------------------------------------------
		// TRY Merge Hybrid
                
                System.out.print("pre-sort MERGEHYBRID ");
		for (Integer n : randomArray) {
			System.out.print(n+" ");
		}
		System.out.println();
                
		int a = SortMerge.sortHybrid(randomArray, defaultInts);

		System.out.print("post-sort ");
		for (Integer n : randomArray) {
			System.out.print(n+" ");
		}
		System.out.println();
                System.out.println(a);
                
                // --------------------------------------------
		// TRY Radix
                Integer[] numbers5 = { 585, 4004, 12345, 313, 570, 292, 4001, 5007, 19, 6 };
		System.out.print("pre-sort Radix ");
		for (Integer n : numbers5) {
			System.out.print(n+" ");
		}
		System.out.println();
                
		int c = SortRadix.sort(numbers5, true);

		System.out.print("post-sort ");
		for (Integer n : numbers5) {
			System.out.print(n+" ");
		}
		System.out.println();
                System.out.println(c);
                
	} // end main
        
} // end class main
