package access;

import arrayHolders.ComparableArrayHolder;
import java.io.IOException;
import searchSort.SearchInfoHolder;
import searchSort.SearchSortInterface;
import searchSort.SortInfoHolder;
import text.TextFile;
import text.TextFileInterface;
import text.TextFileInterface.Order;

/**
 * Used to indirectly instantiate a ComparableArrayHolder of type T, where T extends Comparable.
 * Used to access the back-end.
 * @author Kelvin Bonilla
 * @param <T> the data type that will be used by any functions that need it
 */
public abstract class DAO<T extends Comparable<T>> implements SAHIAccess<T>, TextFileInterface, SearchSortInterface
{    
    /**
     * Static function that instantiates a ComparableArrayHolder of type T.
     * @return a ComparableArrayHolder of type T with the default size of 50 and casted to a SAHIAccess
     */
    public static <T extends Comparable<T>> SAHIAccess<T> getCompareableArrayHolder()
    {
        return (SAHIAccess) new ComparableArrayHolder<>();
    }
    
    /**
     * Static function that instantiates a ComparableArrayHolder of type T.
     * @param size the maximum number of elements this ComparableArrayHolder can have
     * @return a ComparableArrayHolder of type T with the size of "size" elements and casted to a SAHIAccess
     */
    public static <T extends Comparable<T>> SAHIAccess<T> getCompareableArrayHolder(int size)
    // Precondition: size is a integer >1
    {
        return (SAHIAccess) new ComparableArrayHolder<>(size);
    }
    
    public static <T extends Comparable<T>> SAHIAccess<T> getComparableArrayHolder(T[] array)
    {
        return (SAHIAccess) new ComparableArrayHolder<>(array);
    }
    
    public static SearchSortInterface getSearchInfoHolder(SearchType searchName, String valueSearchedFor, String result, String implementation, String dataType, int numberOfElements, long timeTaken, String timeMeasurement, int comparisons)
    {
        return (SearchSortInterface) new SearchInfoHolder(searchName.toString(), valueSearchedFor, result, implementation, dataType, numberOfElements, timeTaken, timeMeasurement, comparisons);
    }
    
    public static SearchSortInterface getSortInfoHolder(SortType sortName, String implementation, String dataType, int numberOfElements, long timeTaken, String timeMeasurement, long comparisons)
    {
        return (SearchSortInterface) new SortInfoHolder(sortName.toString(), implementation, dataType, numberOfElements, timeTaken, timeMeasurement, comparisons);
    }
        
    public static TextFileInterface createTextFile(int numElements, Order order)
    {
        try 
        {
            return (new TextFile(numElements, order));
        } 
        catch (IOException ex) {
            System.out.println(ex);
            return null;
        }
    }    
}
