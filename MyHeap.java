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
      int leftchild = index * 2 + 1; //index of left child
      int rightchild = leftchild + 1; //index of right child

      if (rightchild == size) { //if there is exactly one child
        if (data[leftchild] > data[index]) {
          int larger = data[leftchild];
          data[leftchild] = data[index];
          data[index] = larger;
        }
        else {
          done = true;
        }
      }

      else if (rightchild < size) { //there are two children

        if (data[leftchild] > data[rightchild]) {
          if (data[leftchild] > data[index]) {
            int larger = data[leftchild];
            data[leftchild] = data[index];
            data[index] = larger;
          }
          else {
            done = true;
          }
        }
        else {
          if (data[rightchild] > data[index]) {
            int larger = data[rightchild];
            data[rightchild] = data[index];
            data[index] = larger;
          }
          else {
            done = true;
          }
        }
      }
      else {
        done = true;
      }
    }
  }

  private static void pushUp(int[] data, int index) {
    while (index > 0) {

      int parent = 0;
      if (index % 2 == 0) {
        parent = index / 2;
      }
      else {
        parent = parent /2;
      }

    }
  }



}
