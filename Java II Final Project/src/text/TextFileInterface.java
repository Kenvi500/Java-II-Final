package text;

import linked_list.SortableLinkedList;

/**
 *
 * @author Kelvin Bonilla
 */
public interface TextFileInterface
{
    enum Order {
        RANDOM,IN_ORDER,REVERSE_ORDER
    }    
    public Integer[] getArray();
    public SortableLinkedList<Integer> getLinkedList();
    public void addVal(int index, Integer value); // used to initialize the text files
    public void writeToOutput(searchSort.SearchSortInterface info);
}
