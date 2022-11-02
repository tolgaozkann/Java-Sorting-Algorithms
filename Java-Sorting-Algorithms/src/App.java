import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();

        InsertionSort insertionSortObject = new InsertionSort();//insertion sort object

        Quick quickSortObject = new Quick();//quicksort Object

        ObjectMapper om = new ObjectMapper();//object mapper object

        InputStream is = Root.class.getResourceAsStream("/data3.json");//json string

        Root[] root = om.readValue(is, Root[].class);//root array

        for (Root elementRoot : root) {
            for (Result elementResult : elementRoot.result) {

                vulnerabilities.addAll(elementResult.vulnerabilities);
                
            }
        }
    }
}
