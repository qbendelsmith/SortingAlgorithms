
import java.util.Comparator;
import java.util.Random;

public class SortQuick <T> {
    
    /** Records number of comparisons and iterations. */
  private static int ops = 0;

  public static <T> int sort(T[] inArray, Comparator<T> order) {
    // Find random int for swap
    int randomInt = randomize(inArray, order);
    // Swap int with last int in array
    swap(inArray, randomInt, inArray.length-1);
    //call sort
    sort(inArray, 0, inArray.length-1, order);
    return ops;

  }
  
  private static <T> void sort(T[] inArray, int p, int r, Comparator<T> order){
      if (p < r){
                    //Call partition
                    int q = partition (inArray, p, r, order);
                    //Sort left
                    sort(inArray,p, q-1, order);
                    //Sort right
                    sort(inArray,q+1,r, order);
                }
  }
  
  private static <T> int partition(T[] inArray, int p, int r, Comparator<T> order){
      // Set x as pivot 
                T x = inArray[r];
                int i = p - 1;
                for (int j = p; j <= r - 1; j++){
                    ops++;
                    if (order.compare(inArray[j], x) <= 0){
                        // Increment i and swap with j
                        i++;
                        swap(inArray,i,j);
                    }
                }
                // swap i and pivot
                swap(inArray,i+1,r);
                return (i+1);
  }
  
  private static <T> int randomize(T[] inArray, Comparator<T> order){
      // Take thre random indices from the inArray and add to a new array swapArray
      @SuppressWarnings("unchecked")
      T[] swapArray = (T[]) new Object[3];
      for (int i = 0; i < 3; i++){
          int randomInt = new Random().nextInt(inArray.length);
          swapArray[i] = inArray[randomInt];
      }
      //Sort swapArray
      SortInsertion.sort(swapArray,order);
      // Sorted index of 3, the middle value will always be at index 1
      T indexFinder = swapArray[1];
      int j = 0;
      //Find index of the number in the original array and return
      while (j < inArray.length - 1 && order.compare(indexFinder, inArray[j]) != 0){
          j++;
      }
      return j;
  }
  
  private static <T> void swap(T[] inArray, int p, int r){
      // Basic swap algorithm, with temp value to swap with
      T temp = inArray[r];
      inArray[r] = inArray[p];
      inArray[p] = temp;
  }

}
