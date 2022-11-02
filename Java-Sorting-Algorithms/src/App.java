
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

import models.Result;
import models.Root;

import java.io.InputStream;
import java.util.ArrayList;
import models.Vulnerability;

public class App {
    public static void main(String[] args) throws Exception {
        InsertionSort insertionSortObject = new InsertionSort();//insertion sort object
        HeapSort heapSortObject=new HeapSort();


        Quick quickSortObject = new Quick();//quicksort Object

        ObjectMapper om = new ObjectMapper();//object mapper object
        ArrayList<Vulnerability> vulnerabilities=new ArrayList<>();
        InputStream is = Root.class.getResourceAsStream("/data3.json");//json string

        Root[] root = om.readValue(is, Root[].class);//root array

        for (Root elementRoot : root) {
            for (Result elemetResult : elementRoot.result) {
                vulnerabilities.addAll(elemetResult.vulnerabilities);
               
            }
        }
         for (Root elementRoot : root) {
            for (Result elemetResult : elementRoot.result) {
                insertionSortObject.insertionSortArrayList(elemetResult.vulnerabilities);//insertionSort

                quickSortObject.quicksort(elemetResult.vulnerabilities);//quickSort
            }
        }
        insertionSortObject.insertionSortArrayList(vulnerabilities);//insertionSort
        heapSortObject.sort(vulnerabilities);//insertionSort
    }
}
