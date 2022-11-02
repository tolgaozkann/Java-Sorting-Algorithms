package models;

import java.util.ArrayList;
import java.util.Date;

public class Result {
    public int resultsPerPage;
    public int startIndex;
    public int totalResults;
    public String format;
    public String version;
    public Date timestamp;
    public ArrayList<Vulnerability> vulnerabilities;
}
