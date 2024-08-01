
import java.util.Comparator;

public class SortInsertion <T> {

  public static <T> int sort(T[] array, Comparator<T> order) {

    int ops = 0;

    for (int i=1; i<array.length; i++) {
      T key = array[i];
      int j = i-1;
      ++ops; // add one for the comparison in the while loop
      while (j >= 0 && order.compare(array[j],key)>0) {
        ++ops;
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = key;
    }
    return ops;
  }
  
  public static <T> int sortHybrid(T[] array, int p, int r, Comparator<T> order) {
    int ops = 0;
    T key;

    // copy of the sort above with slight modifications
    // i is set to p+1 (p being the min value in subarray) increment up to the max value in subarray r
    for (int i=(p+1); i<=r; i++) {
      key = array[i];
      //Same as p
      int j = i-1;
      ++ops; // add one for the comparison in the while loop
      while (j >= p && order.compare(array[j],key)>0) {
        ++ops;
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = key;
    }
    return ops;
  }
}
