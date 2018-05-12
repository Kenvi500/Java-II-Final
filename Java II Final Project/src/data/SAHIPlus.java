package data;

/**
 * Declares a SortableArrayHolder with some additional properties.
 * @author Kelvin Bonilla
 * @param <T> the data type of this SortableArrayHolder. T must extend Comparable.
 */
public interface SAHIPlus<T extends Comparable<T>> extends SortableArrayHolderInterface<T>, searchSort.SearchEnum
{
       
    /**
     * Gets index of an element with the search type given.
     * @param element the element whose index is to be searched for
     * @param searchType the type of search to do
     * @return the index of the element, or an indication that it wasn't found
     */
    public int indexOf(T element, SearchType searchType);
    
    /**
     * Deletes the element at index position, and allows the user to shift the values so the values of the structure are sequential with empty spaces at the end of the cluster.
     * @param index the index position of the element to delete
     * @param shift a boolean value indicating whether or not user wishes to shift array to eliminate all null values
     */
    public void delete(int index, boolean shift);
    // Precondition: index is within the bounds of this SAHIPlus (0, SAHIPlus.size() - 1)
    
    /**
     * Gets the number of comparisons done by the most recent sorting function called.
     * @return the number of comparisons done by the most recent sorting function as an integer type
     */
    public int getSortComparisons();
    
    /**
     * Resets the number of comparisons done by the most recent sorting function called back to zero.
     * @return a reference to this ArrayHolder to enable multiple method calls
     */
    public SAHIPlus resetSortComparisons();

    
    /**
     * Gets the number of comparisons done by the most recent searching function called.
     * @return the number of comparisons done by the most recent searching function as an integer type
     */
    public int getSearchComparisons();
    
    /**
     * Resets the number of comparisons done by the most recent searching function back to zero.
     * @return a reference to this ArrayHolder to enable multiple method calls
     */
    public SAHIPlus resetSearchComparisons();

    /**
     * The binary search algorithm, which searches for an element in a sorted array using random-access.
     * @param element whose subscript is to be found in this ArraHolder
     * @return the current subscript to the first "element" found in the structure, or -1 indicating no such value was found
     */
    public int binarySearch(T element);
    // Preconditions: Structure is not empty
    //                Structure has been sorted in ascending order
    
    /**
     * The linear search algorithm, which sequentially searches for an element.
     * @param element whose subscript is to be found in this ArrayHolder
     * @return the current subscript to the  first "element" found in the this ArrayHolder, or -1 indicating no such value was found
     */
    public int linearSearch(T element);
    // Precondition: Strucutre is not empty
    


}
