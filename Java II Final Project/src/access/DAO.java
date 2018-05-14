package access;

import arrayHolders.ComparableArrayHolder;
import arrayHolders.SAHIPlus;
import java.io.IOException;
import linked_list.SortableLinkedList;
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
public class DAO<T extends Comparable<T>> implements SAHIAccess<T>, TextFileInterface, SearchSortInterface{
    
    TextFile theTxtFile;
    
    public DAO(){}

    /**
     * Static function that instantiates a ComparableArrayHolder of type T.
     * @return a ComparableArrayHolder of type T with the default size of 50 and casted to a SAHIAccess
     */
    public SAHIAccess<T> getCompareableArrayHolder()
    {
        return (SAHIAccess) new ComparableArrayHolder<>();
    }
    
    /**
     * Static function that instantiates a ComparableArrayHolder of type T.
     * @param size the maximum number of elements this ComparableArrayHolder can have
     * @return a ComparableArrayHolder of type T with the size of "size" elements and casted to a SAHIAccess
     */
    public SAHIAccess<T> getCompareableArrayHolder(int size)
    // Precondition: size is a integer >1
    {
        return (SAHIAccess) new ComparableArrayHolder<>(size);
    }
    
    public SAHIAccess<T> getComparableArrayHolder(T[] array)
    {
        return (SAHIAccess) new ComparableArrayHolder<>(array);
    }
    
    public SearchSortInterface getSearchInfoHolder(SearchType searchName, String valueSearchedFor, String result, String implementation, String dataType, int numberOfElements, long timeTaken, String timeMeasurement, int comparisons)
    {
        return (SearchSortInterface) new SearchInfoHolder(searchName.toString(), valueSearchedFor, result, implementation, dataType, numberOfElements, timeTaken, timeMeasurement, comparisons);
    }
    
    public SearchSortInterface getSortInfoHolder(SortType sortName, String implementation, String dataType, int numberOfElements, long timeTaken, String timeMeasurement, long comparisons)
    {
        return (SearchSortInterface) new SortInfoHolder(sortName.toString(), implementation, dataType, numberOfElements, timeTaken, timeMeasurement, comparisons);
    }
        
    public void createTextFile(int numElements, Order order)
    {
        try 
        {
            theTxtFile = new TextFile(numElements, order);
        } 
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public Integer[] getArrayFromFile()
    {
        return theTxtFile.getArray();
    }
    
    public SortableLinkedList<Integer> getLinkedListFromFile()
    {
        return theTxtFile.getLinkedList();
    }
    
    public void writeToOutput(SearchSortInterface info)
    {
        theTxtFile.writeToOutput(info);
    }    
    
    @Override
    public int indexOf(T element, SearchType searchType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int index, boolean shift) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSortComparisons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SAHIPlus resetSortComparisons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSearchComparisons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SAHIPlus resetSearchComparisons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int binarySearch(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int linearSearch(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sort(SortType st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SortState getCurSortState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer[] getArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVal(int index, Integer value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashSearch(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SortableLinkedList<Integer> getLinkedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
