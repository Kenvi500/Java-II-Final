package text;

/**
 *
 * @author Kelvin Bonilla
 */
public interface TextFileInterface<T extends Comparable<T>>
{
    enum Order {
        RANDOM,IN_ORDER,REVERSE_ORDER
    }    
    public T[] getArray();
    public void addVal(int index, T value); // used to initialize the text files
    public void writeToOutput(searchSort.SearchSortInterface info);
}
