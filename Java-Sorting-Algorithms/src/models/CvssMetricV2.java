package models;

public class CvssMetricV2{
    public String source;
    public String type;
    public CvssData cvssData;
    public double exploitabilityScore;
    public double impactScore;
    public boolean acInsufInfo;
    public boolean obtainAllPrivilege;
    public boolean obtainUserPrivilege;
    public boolean obtainOtherPrivilege;
    public boolean userInteractionRequired;
}