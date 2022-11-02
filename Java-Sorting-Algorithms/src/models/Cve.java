package models;

import java.util.ArrayList;
import java.util.Date;

public class Cve{
    public String id;
    public String sourceIdentifier;
    public Date published;
    public Date lastModified;
    public String vulnStatus;
    public ArrayList<Description> descriptions;
    public Metrics metrics;
    public ArrayList<Weakness> weaknesses;
    public ArrayList<Configuration> configurations;
    public ArrayList<Reference> references;
}