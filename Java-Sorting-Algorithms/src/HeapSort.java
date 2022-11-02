import java.util.ArrayList;

public class HeapSort {
    public void sort(ArrayList<Vulnerability> list)
    {
        int N = list.size();
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(list, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Vulnerability temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i,temp);
            // call max heapify on the reduced heap
            heapify(list, i, 0);
        }
        printArray(list);
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(ArrayList<Vulnerability> list, int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && list.get(l).compareTo(list.get(largest)) ==1)
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N &&list.get(r).compareTo(list.get(largest)) ==1)
            largest = r;
 
        // If largest is not root
        if (largest != i) {
             Vulnerability temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest,temp);
        
 
            // Recursively heapify the affected sub-tree
            heapify(list, N, largest);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(ArrayList<Vulnerability> list)
    {
        int N = list.size();
 
    }
 
 
}