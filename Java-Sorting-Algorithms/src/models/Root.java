import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("Result") 
    public ArrayList<Result> result;
    @JsonProperty("Id") 
    public int id;
    @JsonProperty("Exception") 
    public Object exception;
    @JsonProperty("Status") 
    public int status;
    @JsonProperty("IsCanceled") 
    public boolean isCanceled;
    @JsonProperty("IsCompleted") 
    public boolean isCompleted;
    @JsonProperty("IsCompletedSuccessfully") 
    public boolean isCompletedSuccessfully;
    @JsonProperty("CreationOptions") 
    public int creationOptions;
    @JsonProperty("AsyncState") 
    public Object asyncState;
    @JsonProperty("IsFaulted") 
    public boolean isFaulted;
}
