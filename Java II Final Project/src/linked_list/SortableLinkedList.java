package linked_list;

import searchSort.SortingEnums.SortState;
import searchSort.SortingEnums.SortType;

/**
 *
 * @author Kelvin Bonilla
 */
public class SortableLinkedList<T extends Comparable<T>>
{
    private LLNode<T> list;
    private long sortComparisons;
    private int numElements;
    private SortState curSortState;
            
    public SortableLinkedList()
    {
        list = null;
        curSortState = SortState.UNSORTED;
    }
    
    public SortState getCurSortState()
    {
        return curSortState;
    }
    
    public long getSortComparisons()
    {
        return sortComparisons;
    }
    
    public void resetSortComparisons()
    {
        sortComparisons = 0;
    }
    
    public LLNode<T> getListRef()
    {
        return list;
    }
    
    public int getSize()
    {
        return numElements;
    }
    
    private LLNode<T> getNodeRef(T val) // returns null if not found on the list
    {
        LLNode<T> traversalNode = list;
        while(traversalNode != null)
        {
            sortComparisons++;
            if(traversalNode.getInfo().compareTo(val) == 0)
            {
                sortComparisons++;
                return traversalNode;
            }
            else
                traversalNode = traversalNode.getLink();
        }
        return null;
    }
    
    private LLNode<T> getNodeRef(int index)
    {
        LLNode<T> traversalNode = list;
        if(index == 0)
        {
            sortComparisons++;
            return traversalNode;
        }
        else
        {
            for(int i = 1; i < index + 1; i++)
            {
                sortComparisons++;
                traversalNode = traversalNode.getLink();
            }
            return traversalNode;
        }
    }
    
    public void add(T toAdd)
    {
        LLNode<T> newNode = new LLNode<>(toAdd);
        LLNode<T> traverselNode = list;
        if(list == null)
        {
            list = newNode;
        }
        else
        {
            while(traverselNode.getLink() != null)
            {
                traverselNode = traverselNode.getLink();
            }
            traverselNode.setLink(newNode);
        }
        numElements++;
    }
        
    public void sort(SortType st)
    {
        if(st == SortType.SELECTION)
            selectionSort();
        else if(st == SortType.BUBBLE)
            bubbleSort();
        else if(st == SortType.INSERTION)
            insertionSort();
        else if(st == SortType.MERGE)
            mergeSort();
        else if(st == SortType.QUICK)
            quickSort();
        curSortState = SortState.SORTED;        
    }
    
    public void swap(LLNode<T> first, LLNode<T> second)
    {
        T temp = first.getInfo();
        first.setInfo(second.getInfo());
        second.setInfo(temp);
    }
    
    /////////////////////////////////////////////////////////////////
    //
    //  Selection Sort  
    private T minNode(int startIndex, int endIndex)
    {
        int indexOfMin = startIndex;
        for (int index = startIndex + 1; index <= endIndex; index++)
        {
            sortComparisons++;
            if (getNodeRef(index).getInfo().compareTo(getNodeRef(indexOfMin).getInfo()) < 0)
            {
              sortComparisons++;
              indexOfMin = index;
            }
        }
        return getNodeRef(indexOfMin).getInfo();
    }
            
    public void selectionSort()
    {
        int endIndex = numElements - 1;
        for(int current = 0; current < endIndex; current++)
        {
            sortComparisons++;
            swap(getNodeRef(current), getNodeRef(minNode(current, endIndex)));
        }
    }
    
    /////////////////////////////////////////////////////////////////
    //
    //  Bubble Sort
    private void bubbleUp(int startIndex, int endIndex)
    {
        for(int index = endIndex; index > startIndex; index--)
        {
            sortComparisons++;
            if(getNodeRef(index).getInfo().compareTo(getNodeRef(index - 1).getInfo()) < 0)
            {
                sortComparisons++;
                swap(getNodeRef(index), getNodeRef(index - 1));
            }
        }
    }
    
    public void bubbleSort()
    {
        int current = 0;
        
        while(current < (numElements - 1))
        {
            sortComparisons++;
            bubbleUp(current, numElements - 1);
            current++;
        }
    }

    /////////////////////////////////////////////////////////////////
    //
    //  Insertion Sort
    private void insertItem(int startIndex, int endIndex)
    {
        boolean finished = false;
        int current = endIndex;
        boolean moreToSearch = true;
        while (moreToSearch && !finished)
        {
            if (getNodeRef(current).getInfo().compareTo(getNodeRef(current - 1).getInfo()) < 0)
            {
                sortComparisons++;
                swap(getNodeRef(current), getNodeRef(current - 1));
                current--;
                moreToSearch = (current != startIndex);
            } 
            else
                finished = true;
        }
    }
 
    public void insertionSort()
    // Sorts the values array using the insertion sort algorithm.
    {
        for (int count = 1; count < numElements; count++)
        {
            sortComparisons++;
            insertItem(0, count);
        }
    }
    
    /////////////////////////////////////////////////////////////////
    //
    //  Merge Sort
    private LLNode<T> merge(LLNode<T> leftSide, LLNode<T> rightSide)
    {
        LLNode<T> result;
        if(leftSide == null)
        {
            sortComparisons++;
            return rightSide;
        }
        else if(rightSide == null)
        {
            sortComparisons++;
            return leftSide;
        }
        
        if(leftSide.getInfo().compareTo(rightSide.getInfo()) <= 0)
        {
            sortComparisons++;
            result = leftSide;
            result.setLink(merge(leftSide.getLink(), rightSide));
        }
        else
        {
            result = rightSide;
            result.setLink(merge(leftSide, rightSide.getLink()));
        }
        return result;
    }
    
    private LLNode<T> getMid(LLNode<T> node)
    {
        if(node == null)
        {
            sortComparisons++;
            return node;
        }
        LLNode<T> fastNode = node.getLink();
        LLNode<T> slowNode = node;
        
        while(fastNode != null)
        {
            sortComparisons++;
            fastNode = fastNode.getLink();
            if(fastNode != null)
            {
                sortComparisons++;
                slowNode = slowNode.getLink();
                fastNode = fastNode.getLink();
            }
        }
        return slowNode;
    }

    private LLNode<T> mergeSort(LLNode<T> first)
    {
        if (first == null || first.getLink() == null)
        {
            sortComparisons++;
            return first;
        }
                    
        LLNode<T> mid = getMid(first);
        LLNode<T> midPlusOne = mid.getLink();
        
        mid.setLink(null);
        
        LLNode<T> leftSide = mergeSort(first);
        LLNode<T> rightSide = mergeSort(midPlusOne);
        
        LLNode<T> sortedList = merge(leftSide, rightSide);
        return sortedList;
    }
    
    public void mergeSort()
    {
        list = this.mergeSort(list);
    }
    
    /////////////////////////////////////////////////////////////////
    //
    //  Quick Sort
    private int split(int first, int last)
    {
        LLNode<T> splitNode = getNodeRef(first);
        boolean onCorrectSide;
 
        first++;
        do
        {
            sortComparisons++;        
            onCorrectSide = true;
            while (onCorrectSide) // move first toward last
            {
                if (getNodeRef(first).getInfo().compareTo(splitNode.getInfo()) > 0) 
                {
                    sortComparisons++;
                    onCorrectSide = false;
                } 
                else 
                {
                    first++;
                    onCorrectSide = (first <= last);
                    sortComparisons++;
                }
            }

            onCorrectSide = (first <= last);
            sortComparisons++;
            while (onCorrectSide) // move last toward first
            {
                if (getNodeRef(last).getInfo().compareTo(splitNode.getInfo()) <= 0) 
                {
                    sortComparisons++;
                    onCorrectSide = false;
                } 
                else 
                {
                    last--;
                    onCorrectSide = (first <= last);
                    sortComparisons++;
                }
            }

            if (first < last) {
                sortComparisons++;
                swap(getNodeRef(first), getNodeRef(last));
                first++;
                last--;
            }
        } while (first <= last);
 
        swap(splitNode, getNodeRef(last));
        return last;
    }

    private void quickSort(int first, int last)
    {
        if (first < last) 
        {
            sortComparisons++;
            int splitPoint;

            splitPoint = split(first, last);
            quickSort(first, splitPoint - 1);
            quickSort(splitPoint + 1, last);
      }
    }
    
    public void quickSort()
    {
        quickSort(0, numElements - 1);
    }
  
    @Override
    public String toString()
    {
        String toReturn = "";
        for(int i = 0; i < numElements; i++)
        {
            if(i % 10 == 0)
                toReturn += getNodeRef(i).getInfo().toString() + System.getProperty("line.separator");
            else if(i == numElements - 1)
                toReturn += getNodeRef(i).getInfo().toString();
            else
                toReturn += getNodeRef(i).getInfo().toString() + ",";
        }
        return toReturn;
    }
}
