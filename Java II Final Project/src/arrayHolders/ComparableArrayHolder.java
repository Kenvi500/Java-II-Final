package arrayHolders;

import searchSort.Sorts;

/**
 * Defines a ComparableArrrayHolder that implements the sourceCode.access.SAHIAccess. SAHIAccess extends all interfaces found in sourceCode.data. 
 * @author Kelvin Bonilla
 * @param <T> the data type of this ComparableArrayHolder. T must extend Comparable.
 */
public class ComparableArrayHolder<T extends Comparable<T>> implements access.SAHIAccess<T> {
    private T[] array;     // underlying array
    private int lastIndex; // recent index position with data
    private SortState curSortState;
    private Sorts sortObj;
    private int searchComparisons = 0;
    private static int DEF_CAP = 100; // default capacity of a ComparableArrayHolder
    
    /**
     * Constructor for this ComparableArrayHolder which manually takes in the size.
     * @param size the size of this ComparableArrayHolder
     */
    public ComparableArrayHolder(int size){
        array = (T[]) new Comparable[size];
        lastIndex = -1;
        sortObj = new Sorts(size, array);
    }
    
    /**
     * Default constructor with a default capacity of 50.
     */
    public ComparableArrayHolder(){
        this(DEF_CAP);
    }
    /**
     * Constructor for this ComparableArrayHolder which sets the underlying array to one that has already been created.
     * @param array the array to make this ComparableArrayHolder hold
     */
    public ComparableArrayHolder(T[] array){
        this.array = array;
        lastIndex = -1;
        sortObj = new Sorts(array.length, array);
    }

    @Override
    public int size(){
        return array.length;
    }
    
    @Override
    public T get(int index){
        return array[index];
    }

    @Override
    public void delete(int index){
        this.delete(index, false);
    }

    @Override
    public void delete(int index, boolean shift){
        if(shift){
            array[index] = null;
            T[] copy = (T[]) new Comparable[this.size()];
            int counter = 0;
            for(int i = 0; i < this.size(); i++){
                if(array[i] != null){
                    copy[counter] = array[i];
                    counter++;
                }
            }
            array = copy;
        }
        else
            array[index] = null;
    }

    @Override
    public void add(T element){
        array[++lastIndex] = element;
    }

    @Override
    public void add(int index, T element)
    {
        array[index] = element;
    }
    
    @Override
    public int indexOf(T element)
    {
        return indexOf(element, SearchType.LINEAR);
    }
    
    @Override
    public int indexOf(T element, SearchType searchType)
    // Precondition: Data has already been sorted (if using SearchType that requires it)
    {
        if(searchType == SearchType.BINARY)
            return binarySearch(element);
        else
            return linearSearch(element);
    }
    
    @Override
    public void sort(SortType st)
    {
        if(st == SortType.SELECTION)
            sortObj.selectionSort();
        else if(st == SortType.BUBBLE)
            sortObj.bubbleSort();
        else if(st == SortType.INSERTION)
            sortObj.insertionSort();
        else if(st == SortType.MERGE)
            sortObj.mergeSort(0, lastIndex);
        else if(st == SortType.QUICK)
            sortObj.quickSort(0, lastIndex);
        else if(st == SortType.HEAP)
            sortObj.heapSort();        
        curSortState = SortState.SORTED;
    }
    
    @Override
    public String toString(){
        String toReturn = "";
        for(int i = 0; i <= lastIndex; i++)
        {
            if(i != lastIndex)
            {
                if(i % 10 == 0)
                    toReturn += array[i] + System.getProperty("line.seperator");
                else
                    toReturn += array[i] + ",";
            }
            else
                toReturn += array[i];
        }
        return toReturn;
    }
    
    @Override
    public SortState getCurSortState() {
        boolean sorted = sortObj.isSorted();
        if(sorted)
            curSortState = SortState.SORTED;
        else
            curSortState = SortState.UNSORTED;
        return curSortState;
    }
  
    @Override
    public int getSortComparisons()
    {
        return sortObj.getComparisonNumber();
    }
    
    @Override
    public ComparableArrayHolder resetSortComparisons()
    {
        sortObj.resetComparisonNumber();
        return this;
    }
    
    @Override
    public int getSearchComparisons()
    {
        return searchComparisons;
    }

    @Override
    public ComparableArrayHolder resetSearchComparisons()
    {
        searchComparisons = 0;
        return this;
    }

    @Override
    public int linearSearch(T element)
    {
        int i = 0;
        int location = 0;
        while(i <= array.length - 1 && element.compareTo( (T) array[i]) != 0)
        {
            searchComparisons++;
            i++;
            if(i <= array.length - 1)
            {
                searchComparisons++;
                location = i;
            }
            else
                location = -1;
        }
        return location;
    }
    
    @Override
    public int binarySearch(T element)
    {
        int i = 0; // lower-end
        int j = array.length - 1; // higher-end
        int m; // mid
        int location = -1; // location to be returned
        while(i <= j)
        {
            searchComparisons++;
            m = (i + j)/2;
            if(element.compareTo((T) array[m]) > 0)
            {
                searchComparisons++;
                i = m + 1;          
            }
            else if(element.compareTo((T) array[m]) == 0)
            {
                searchComparisons++;
                location = m;
                return location;
            }
            else
                j = m;            
        }        
        return location;
    }
    
    @Override
    public int hashSearch(T element)
    {
        int length = String.valueOf(element).length();
        int modVal = 10^length;
        int index;
        if(element instanceof Integer)
        {
            index = (Integer) element;
            index = index % modVal;
            if(index < array.length & index != -1)
                if(array[index] != null)
                    return index;
            return -1;
        }
        else
            return -1;
    }
}
