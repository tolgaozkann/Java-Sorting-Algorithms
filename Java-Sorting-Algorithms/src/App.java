
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();

        InsertionSort insertionSortObject = new InsertionSort();// insertion sort object

        HeapSort heapSortObject = new HeapSort();//heap sort object

        AVL avlObject = new AVL();

        Quick quickSortObject = new Quick();// quicksort Object

        ObjectMapper om = new ObjectMapper();// object mapper object
        InputStream is = Root.class.getResourceAsStream("/data3.json");// json string

        Root[] root = om.readValue(is, Root[].class);// root array

        for (Root elementRoot : root) {
            for (Result elementResult : elementRoot.result) {
                vulnerabilities.addAll(elementResult.vulnerabilities);

            }
        }
        
        MergeSort mergeSortObject = new MergeSort(vulnerabilities);
        long start = System.currentTimeMillis();
        insertionSortObject.insertionSortArrayList(vulnerabilities);// insertionSort
        long end = System.currentTimeMillis();
        System.out.println("Insertion time: "+(end-start)+" milliseconds.");
        start = System.currentTimeMillis();
        heapSortObject.sort(vulnerabilities);// insertionSort
        end = System.currentTimeMillis();
        System.out.println("HeapSortTime time: "+(end-start)+" milliseconds.");
        start = System.currentTimeMillis();
        quickSortObject.quicksort(vulnerabilities);// quickSort
        end = System.currentTimeMillis();
        System.out.println("QuickSort time: "+(end-start)+" milliseconds.");
        start = System.currentTimeMillis();
        mergeSortObject.sortGivenArray();//mergeSort
        end = System.currentTimeMillis();
        System.out.println("MergeSort time: "+(end-start)+" milliseconds.");
        start = System.currentTimeMillis();
        avlObject.avlSort(vulnerabilities);//it creats AVL Tree from given arraylist
        end = System.currentTimeMillis();
        System.out.println("AvlSort time: "+(end-start)+" milliseconds.");


    }
}
