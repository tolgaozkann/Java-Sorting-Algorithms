import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1



public class App {
    public static void main(String[] args) throws Exception {

        ObjectMapper om = new ObjectMapper();
        System.out.println("Hello, World!");
    }
}
