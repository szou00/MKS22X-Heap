import java.util.Arrays;

public class driver {

  public static void main(String[] args) {
    int[] array = {100,19,36,17,3,25,1,2,7};

    MyHeap.heapify(array);
    System.out.println(Arrays.toString(array));
  }
}
