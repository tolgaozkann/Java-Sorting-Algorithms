
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

import models.Result;
import models.Root;

import java.io.InputStream;
import java.util.ArrayList;
<<<<<<< HEAD
import models.Vulnerability;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();

        InsertionSort insertionSortObject = new InsertionSort();//insertion sort object
        HeapSort heapSortObject=new HeapSort();


        Quick quickSortObject = new Quick();//quicksort Object

        ObjectMapper om = new ObjectMapper();//object mapper object
        InputStream is = Root.class.getResourceAsStream("/data3.json");//json string

        Root[] root = om.readValue(is, Root[].class);//root array

         for (Root elementRoot : root) {
            for (Result elementResult : elementRoot.result) {
                vulnerabilities.addAll(elementResult.vulnerabilities);
                
            }
    }
           insertionSortObject.insertionSortArrayList(vulnerabilities);//insertionSort
            heapSortObject.sort(vulnerabilities);//insertionSort
}
}
