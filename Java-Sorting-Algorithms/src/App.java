import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws Exception {
        InsertionSort insertionSortObject = new InsertionSort();//insertion sort object

        Quick quickSortObject = new Quick();//quicksort Object

        ObjectMapper om = new ObjectMapper();//object mapper object

        InputStream is = Root.class.getResourceAsStream("/data3.json");//json string

        Root[] root = om.readValue(is, Root[].class);//root array

        for (Root elementRoot : root) {
            for (Result elemetResult : elementRoot.result) {
                insertionSortObject.insertionSortArrayList(elemetResult.vulnerabilities);//insertionSort

                quickSortObject.quicksort(elemetResult.vulnerabilities);//quickSort
            }
        }
    }
}
