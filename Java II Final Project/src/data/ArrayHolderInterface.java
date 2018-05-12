package data;

/**
 * Declares an ArrayHolder of type T
 * @author Kelvin Bonilla
 * @param <T> the data type of the ArrayHolder
 */
public interface ArrayHolderInterface<T> {
    
    /**
     * Gets the size of this ArrayHolder
     * @return the size (number of elements) of the ArrayHolder
     */            
    int size();
    
    /**
     * Gets the element at index position.
     * @param index the index position of the element desired
     * @return the element at the index position
     */
    T get(int index);
    // Precondition: index is within the bounds of the ArrayHolder (0, ArrayHolder.size() - 1)
    
    /**
     * Deletes the element at index position.
     * @param index the index position of the element to delete
     */
    void delete(int index);
    // Precondition: index is within the bounds of the ArrayHolder (0, ArrayHolder.size() - 1)
    
    /**
     * Adds an element to this ArrayHolder.
     * @param element the element to add to this ArrayHolder
     */
    void add(T element);
    // Precondition: ArrayHolder isn't full
    
    /**
     * Adds an element to this ArrayHolder at the index given.
     * @param element the element to add to this ArrayHolder
     * @param index the index position indicating where the element should be added
     */
    void add(int index, T element);
    // Preconditions: ArrayHolder isn't full
    //               Index is within bounds
    
    /**
     * Gets the index position of an element. 
     * @param element the element whose index is to be searched for
     * @return the index of the element, or an indication that it wasn't found
     */
    int indexOf(T element);
    
    /**
     * Converts this ArrayHolder to a String data type.
     * @return this ArrayHolder in a String type
     */
    String toString();
}
