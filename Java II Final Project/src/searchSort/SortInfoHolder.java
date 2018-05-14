package searchSort;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Holds the information of a particular sorting algorithm.
 * @author Kelvin Bonilla
 */
public class SortInfoHolder implements SearchSortInterface
{
    private String sortName;
    private String implementation; // array or linked-list
    private long comparisons;
    private long timeTaken;
    private String timeMeasurement; // whether milli-seconds, nano-seconds, etc.
    private int numberOfElements;
    private String dataType;
    
    /**
     * Constructor that instantiates a SortInfoHolder object.
     * @param sortName the name of the sort that was done
     * @param implementation the type of structure this sorting algorithm was implemented in
     * @param comparisons the number of comparisons the sort did
     * @param timeTaken the amount of time it took for the sort to finish
     * @param timeMeasurement whether the time is in seconds, milli-seconds, or some other type of time measurement
     * @param numberOfElements the number of elements of the structure this sort was applied on
     * @param dataType the data type of the objects that the structure held within it
     */
    public SortInfoHolder(String sortName, String implementation, String dataType, int numberOfElements, long timeTaken, String timeMeasurement, long comparisons)
    {
        this.sortName = sortName;
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
        out += "Sort Name: " + getSortName() + System.getProperty("line.separator");
        out += "Implementation: " + getImplementation() + System.getProperty("line.separator");
        out += "Data Type of Structure: " + getDataType() + System.getProperty("line.separator");
        out += "Number of Elements: " + NumberFormat.getNumberInstance(Locale.US).format(getNumberOfElements()) + System.getProperty("line.separator");
        out += "Time Taken: " + NumberFormat.getNumberInstance(Locale.US).format(getTimeTaken()) + " " + getTimeMeasurement() + System.getProperty("line.separator");
        out += "Comparisons Done: " + NumberFormat.getNumberInstance(Locale.US).format(getComparisons()) + System.getProperty("line.separator");
        return out;
    }
    
    /**
     * @return the sortName
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * @param sortName the sortName to set
     */
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /**
     * @return the comparisons
     */
    public long getComparisons() {
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
