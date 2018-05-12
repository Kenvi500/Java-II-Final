package searchSort;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Holds the information of a particular searching algorithm.
 * @author Kelvin Bonilla
 */
public class SearchInfoHolder implements SearchSortInterface
{
    private String searchName;
    private String valueSearchedFor;    
    private String result;
    private String implementation; // array or linked-list
    private int comparisons;
    private long timeTaken;
    private String timeMeasurement; // whether milli-seconds, nano-seconds, etc.
    private int numberOfElements;
    private String dataType;
    
    /**
     * Constructor that instantiates a SearchInfoHolder object.
     * @param searchName the name of the search that was done
     * @param valueSearchedFor the value searched for in the structure
     * @param result the results of the search
     * @param implementation the type of structure this searching algorithm was implemented in
     * @param comparisons the number of comparisons the search did
     * @param timeTaken the amount of time it took for the search to finish
     * @param timeMeasurement whether the time is in seconds, milli-seconds, or some other type of time measurement
     * @param numberOfElements the number of elements of the structure this search was applied on
     * @param dataType the data type of the objects that the structure held within it
     */
    public SearchInfoHolder(String searchName, String valueSearchedFor, String result, String implementation, String dataType,  int numberOfElements, long timeTaken, String timeMeasurement, int comparisons)
    {
        this.searchName = searchName;
        this.valueSearchedFor = valueSearchedFor;
        this.result = result;
        this.implementation = implementation;
        this.dataType = dataType;
        this.numberOfElements = numberOfElements;
        this.timeTaken = timeTaken;
        this.timeMeasurement = timeMeasurement;        
        this.comparisons = comparisons;
    }
    
    @Override
    public String toString()
    {
        String out = "";
        out += "Search Name: " + getSearchName() + "\n";
        out += "Value Searched For: " + getValueSearchedFor() + "\n";
        out += "Result of Search: " + getResult() + "\n";
        out += "Implementation: " + getImplementation() + "\n";
        out += "Data Type of Structure: " + getDataType() + "\n";
        out += "Number of Elements: " + NumberFormat.getNumberInstance(Locale.US).format(getNumberOfElements()) + "\n";
        out += "Time Taken: " + NumberFormat.getNumberInstance(Locale.US).format(getTimeTaken()) + " " + getTimeMeasurement() + "\n";
        out += "Comparisons Done: " + NumberFormat.getNumberInstance(Locale.US).format(getComparisons()) + "\n";
        return out;
    }

    /**
     * @return the searchName
     */
    public String getSearchName() {
        return searchName;
    }

    /**
     * @param searchName the searchName to set
     */
    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    /**
     * @return the valueSearchedFor
     */
    public String getValueSearchedFor() {
        return valueSearchedFor;
    }

    /**
     * @param valueSearchedFor the valueSearchedFor to set
     */
    public void setValueSearchedFor(String valueSearchedFor) {
        this.valueSearchedFor = valueSearchedFor;
    }

    /**
     * @return the comparisons
     */
    public int getComparisons() {
        return comparisons;
    }

    /**
     * @param comparisons the comparisons to set
     */
    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    /**
     * @return the timeTaken
     */
    public long getTimeTaken() {
        return timeTaken;
    }

    /**
     * @param timeTaken the timeTaken to set
     */
    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    /**
     * @return the timeMeasurement
     */
    public String getTimeMeasurement() {
        return timeMeasurement;
    }

    /**
     * @param timeMeasurement the timeMeasurement to set
     */
    public void setTimeMeasurement(String timeMeasurement) {
        this.timeMeasurement = timeMeasurement;
    }

    /**
     * @return the numberOfElements
     */
    public int getNumberOfElements() {
        return numberOfElements;
    }

    /**
     * @param numberOfElements the numberOfElements to set
     */
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the implementation
     */
    public String getImplementation() {
        return implementation;
    }

    /**
     * @param implementation the implementation to set
     */
    public void setImplementation(String implementation) {
        this.implementation = implementation;
    }
}
