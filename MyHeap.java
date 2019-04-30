import java.util.Arrays;

public class MyHeap {

  /*
  - size  is the number of elements in the data array.
     - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     - precondition: index is between 0 and size-1 inclusive
     - precondition: size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown(int[]data,int size,int index) {
    boolean done = false;
    while (!done) {
      int leftchild = (index * 2 + 1); //index of left child
      int rightchild = leftchild + 1; //index of right child

      if (rightchild == size) { //if there is exactly one child
        if (data[leftchild] > data[index]) { //if the other child is greater than the current value
          int larger = data[leftchild]; //switch the two
          data[leftchild] = data[index];
          data[index] = larger;
          index = leftchild;
        }
        else {
          done = true; //otherwise no more pushing is needed
        }
      }

      else if (rightchild < size) { //there are two children

        if (data[leftchild] > data[rightchild]) { //if the child on the left is greater than right
          if (data[leftchild] > data[index]) { //if the child is also greater than the current value
            int larger = data[leftchild]; //switch the two
            data[leftchild] = data[index];
            data[index] = larger;
            index = leftchild; //changes current index to the left child since it's been pushed down
          }
          else { //otherwise no more pushing is needed
            done = true;
          }
        }
        else {
          if (data[rightchild] > data[index]) { //if the child on the right is greater than the left
            //and it is greater than the current value
            int larger = data[rightchild]; //switch the two
            data[rightchild] = data[index];
            data[index] = larger;
            index = rightchild;
          }
          else { //otherwise no more pushing is needed
            done = true;
          }
        }
      }
      else { //no more pushing is needed
        done = true;
      }
    }
  }

  private static void pushUp(int[] data, int index) {
    boolean done = false;
    while (!done) {

      if (index == 0) { //if it's at the top
        done = true; //no more switching is needed
      }

      int parent = 0; //initializes parent
      if (index % 2 == 0) { //if the child has an even index
        parent = index / 2; //parent is half of that
      }
      else { //if the child has an odd index
        parent = parent /2; //parent ??
      }

      if (data[index] > data[parent]) { //if the current value is greater than the parent
        int larger = data[index]; //switch the two
        data[index] = data[parent];
        data[parent] = larger;
      }
      else { //otherwise no more pushing up is needed
        done = true;
      }

    }
  }

    public static void heapify(int[] data) {

      for (int i = data.length-1; i>-1;i--) { //starting from the back
        pushDown(data,data.length,i); //push them down
      }
    }

    public static void heapsort(int[] data) {
      heapify(data); //create a heap
      int s = data.length; //keep track of the amt of values that are being sorted
      for (int i = data.length-1; i > -1; i--) { //going through the list
        int temp = data[0]; //store the current largest value
        // System.out.println(Arrays.toString(data));
        data[0] = data[i]; //switch the current end with the largest
        data[i] = temp;
        s--; //decrease the amount of values being looked at
        pushDown(data,s,0); //get the switched value in its correct spot 
      }
    }


}
