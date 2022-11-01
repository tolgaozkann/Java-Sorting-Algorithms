import java.util.ArrayList;

// Java program for implementation of Insertion Sort
public class InsertionSort {

    public void insertionSortArrayList(ArrayList<Vulnerability> list) {

        for (int j = 1; j < list.size(); j++) {
            Vulnerability current = list.get(j);
            int i = j - 1;
            while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
                list.set(i + 1, list.get(i));
                i--;
            }
            list.set(i + 1, current);
        }
    }

};

// Example Usage

// public static void main(String args[])
// {
// int arr[] = { 12, 11, 13, 5, 6 };

// InsertionSort ob = new InsertionSort();
// ob.sort(arr);

// printArray(arr);
// }