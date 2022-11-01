import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

import java.io.InputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1



public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Vulnerability> vulnerabilities = new ArrayList<Vulnerability>();
        ObjectMapper om = new ObjectMapper();
        InputStream is = Root.class.getResourceAsStream("/data3.json");
        Root[] root = om.readValue(is, Root[].class);

        for (Root elementRoot : root) {
            for (Result elemetResult : elementRoot.result) {
                for (Vulnerability rootelement2 : elemetResult.vulnerabilities) {
                    System.out.println(rootelement2.cve.id);
                }
            }
        }
    }
}
