import java.util.Arrays;

public class driver {

  public static void main(String[] args) {
    int[] array = {100,19,36,17,3,25,1,2,7,12,34,62,682,134,1252,2,134,23,34,62,3,64,23,63,1,557,2};

    MyHeap.heapify(array);
    System.out.println(Arrays.toString(array));

    MyHeap.heapsort(array);
    System.out.println(Arrays.toString(array));
  }
}
