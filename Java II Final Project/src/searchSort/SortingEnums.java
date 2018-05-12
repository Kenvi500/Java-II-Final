package searchSort;

/**
 * Holds enumerations for the types of sorts available and for the sort states available.
 * @author Kelvin Bonilla
 */
public interface SortingEnums
{
    /**
     * Enumeration for the sort states available.
     */
    public enum SortState{
        SORTED,UNSORTED;
    }
    
    /**
     * Enumerations for the type of sorts available.
     */
    public enum SortType{
        SELECTION,BUBBLE,INSERTION,MERGE,QUICK,HEAP;
    }
}
