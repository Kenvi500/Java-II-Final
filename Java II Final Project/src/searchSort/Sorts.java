package searchSort;

import java.text.NumberFormat;

public class Sorts<T extends Comparable<T>>
{
  private int valuesSize;            // valuesSize of array to be sorted
  private T[] values;   // values to be sorted
  private int comparisonNumber;
  
  public Sorts(int valuesSize, T[] values)
  {
      this.valuesSize = valuesSize;
      this.values = values;
      this.comparisonNumber = 0;
  }

  public void changeValues(int valuesSize, T[] values)
  {
      this.valuesSize = valuesSize;
      this.values = values;
  }
  
  public T[] getValues()
  {
      return values;
  }
  
  public int getSize()
  {
      return valuesSize;
  }
  
  public int getComparisonNumber()
  {
      return comparisonNumber;
  }
  
  public String getFormattedComparisonNumber()
  {
      return NumberFormat.getNumberInstance(java.util.Locale.US).format(getComparisonNumber());
  }
  
  public Sorts resetComparisonNumber()
  {
      comparisonNumber = 0;
      return this;
  }
  
  public boolean isSorted()
  // Returns true if the array values are sorted and false otherwise.
  {
    boolean sorted = true;
    for (int index = 0; index < (valuesSize - 1); index++)
      if (values[index].compareTo(values[index + 1]) > 0)
        sorted = false;
    return sorted;
  }

  public void swap(int index1, int index2)
  // Precondition: index1 and index2 are >= 0 and < valuesSize.
  //
  // Swaps the integers at locations index1 and index2 of the values array. 
  {
    T temp = values[index1];
    values[index1] = values[index2];
    values[index2] = temp;
  }

  /////////////////////////////////////////////////////////////////
  //
  //  Selection Sort

  private int minIndex(int startIndex, int endIndex)
  // Returns the index of the smallest value in
  // values[startIndex]..values[endIndex].
  {
    int indexOfMin = startIndex;
    for (int index = startIndex + 1; index <= endIndex; index++)
    {
        comparisonNumber++;
        if (values[index].compareTo(values[indexOfMin]) < 0)
        {
          comparisonNumber++;
          indexOfMin = index;
        }
    }
    return indexOfMin;
  }

  public void selectionSort()
  // Sorts the values array using the selection sort algorithm.
  {
    int endIndex = valuesSize - 1;
    for (int current = 0; current < endIndex; current++)
    {
        comparisonNumber++;
        swap(current, minIndex(current, endIndex));
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Bubble Sort

  private void bubbleUp(int startIndex, int endIndex)
  // Switches adjacent pairs that are out of order 
  // between values[startIndex]..values[endIndex] 
  // beginning at values[endIndex].
  {
    for (int index = endIndex; index > startIndex; index--)
    {
        comparisonNumber++;
        if (values[index].compareTo(values[index - 1]) < 0)
        {
          comparisonNumber++;
          swap(index, index - 1);
        }
    }
  }
 
  public void bubbleSort()
  // Sorts the values array using the bubble sort algorithm.
  {
    int current = 0;
 
    while (current < (valuesSize - 1))
    {
        comparisonNumber++;
        bubbleUp(current, valuesSize - 1);
        current++;
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Short Bubble Sort

  private boolean bubbleUp2(int startIndex, int endIndex)
  // Switches adjacent pairs that are out of order 
  // between values[startIndex]..values[endIndex] 
  // beginning at values[endIndex].
  //
  // Returns false if a swap was made; otherwise, returns true.
  {
    boolean sorted = true;
    for (int index = endIndex; index > startIndex; index--)
    {
        comparisonNumber++;
        if (values[index].compareTo(values[index - 1]) < 0)
        {
            comparisonNumber++;
            swap(index, index - 1);
            sorted = false;
        }
    }
    return sorted;
  }
 
  public void shortBubble()
  // Sorts the values array using the bubble sort algorithm.
  // The process stops as soon as values is sorted.
  {
    int current = 0;
    boolean sorted = false;
    while ((current < (valuesSize - 1)) && !sorted)
    {
        comparisonNumber++;
        sorted = bubbleUp2(current, valuesSize - 1);
        current++;
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Insertion Sort

  private void insertItem(int startIndex, int endIndex)
  // Upon completion, values[0]..values[endIndex] are sorted.
  {
    boolean finished = false;
    int current = endIndex;
    boolean moreToSearch = true;
    while (moreToSearch && !finished)
    {
      if (values[current].compareTo(values[current - 1]) < 0)
      {
          comparisonNumber++;
          swap(current, current - 1);
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
   for (int count = 1; count < valuesSize; count++)
   {
       comparisonNumber++;
       insertItem(0, count);
   }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Merge Sort

  private void merge (int leftFirst, int leftLast, int rightFirst, int rightLast)
  // Preconditions: values[leftFirst]..values[leftLast] are sorted.
  //                values[rightFirst]..values[rightLast] are sorted.
  // 
  // Sorts values[leftFirst]..values[rightLast] by merging the two subarrays.
  {
    T[] tempArray = (T[]) new Comparable [valuesSize];
    int index = leftFirst;
    int saveFirst = leftFirst;  // to remember where to copy back
 
    while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
    {
        comparisonNumber++;
        if (values[leftFirst].compareTo(values[rightFirst]) < 0)
        {
            comparisonNumber++;
            tempArray[index] = values[leftFirst];
            leftFirst++;
        }
        else
        {
            tempArray[index] = values[rightFirst];
            rightFirst++;
        }
        index++;
    }
 
    while (leftFirst <= leftLast)
    // Copy remaining items from left half.
    {
        comparisonNumber++;
        tempArray[index] = values[leftFirst];
        leftFirst++;
        index++;
    }
 
    while (rightFirst <= rightLast)
    // Copy remaining items from right half.
    {
        comparisonNumber++;
        tempArray[index] = values[rightFirst];
        rightFirst++;
        index++;
    }
 
    for (index = saveFirst; index <= rightLast; index++)
    {
        comparisonNumber++;
        values[index] = tempArray[index];
    }
  }

  public void mergeSort(int first, int last)
  // Sorts the values array using the merge sort algorithm.
  {
    if (first < last)
    {
        comparisonNumber++;
        int middle = (first + last) / 2;
        mergeSort(first, middle);
        mergeSort(middle + 1, last);
        merge(first, middle, middle + 1, last);
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Quick Sort

  private int split(int first, int last)
  {
    T splitVal = values[first];
    int saveF = first;
    boolean onCorrectSide;
 
    first++;
    do
    {
        comparisonNumber++;        
        onCorrectSide = true;
        while (onCorrectSide) // move first toward last
        {
            if (values[first].compareTo(splitVal) > 0) {
                comparisonNumber++;
                onCorrectSide = false;
            } else {
                first++;
                onCorrectSide = (first <= last);
                comparisonNumber++;
            }
        }

        onCorrectSide = (first <= last);
        comparisonNumber++;
        while (onCorrectSide) // move last toward first
        {
            if (values[last].compareTo(splitVal) <= 0) {
                comparisonNumber++;
                onCorrectSide = false;
            } else {
                last--;
                onCorrectSide = (first <= last);
                comparisonNumber++;
            }
        }

        if (first < last) {
            comparisonNumber++;
            swap(first, last);
            first++;
            last--;
        }
    } while (first <= last);
 
    swap(saveF, last);
    return last;
  }

  public void quickSort(int first, int last)
  {
      if (first < last) {
          comparisonNumber++;
          int splitPoint;

          splitPoint = split(first, last);
          // values[first]..values[splitPoint - 1] <= splitVal
          // values[splitPoint] = splitVal
          // values[splitPoint+1]..values[last] > splitVal

          quickSort(first, splitPoint - 1);
          quickSort(splitPoint + 1, last);
      }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Heap Sort

  private int newHole(int hole, int lastIndex, T item)
  // If either child of hole is larger than item this returns the index
  // of the larger child; otherwise it returns the index of hole.
  {
    int left = (hole * 2) + 1;
    int right = (hole * 2) + 2;
    if (left > lastIndex)
      // hole has no children
    {
        comparisonNumber++;
        return hole;         
    }
    else
    if (left == lastIndex)
      // hole has left child only
    {
        comparisonNumber++;
        if (item.compareTo(values[left]) < 0) 
          // item < left child
        {
            comparisonNumber++;
            return left;
        }
        else
          // item >= left child
          return hole;
    }
    else
    // hole has two children 
    if (values[left].compareTo(values[right]) < 0)
      // left child < right child
    {
        comparisonNumber++;
        if (values[right].compareTo(item) <= 0)
          // right child <= item
        {
            comparisonNumber++;
            return hole;
        }
        else
          // item < right child
          return right;
    }
    else
    // left child >= right child
    if (values[left].compareTo(item) <= 0)
      // left child <= item
    {
        comparisonNumber++;
        return hole;
    }
    else
      // item < left child
      return left;
  }

  private void reheapDown(T item, int root, int lastIndex)
  // Precondition: Current root position is "empty".
  //
  // Inserts item into the tree and ensures shape and order properties.
  {
    int hole = root;   // current index of hole
    int newhole;       // index where hole should move to

    newhole = newHole(hole, lastIndex, item);   // find next hole
    while (newhole != hole)
    {
        comparisonNumber++;
        values[hole] = values[newhole];      // move value up
        hole = newhole;                      // move hole down
        newhole = newHole(hole, lastIndex, item);     // find next hole
    }
    values[hole] = item;           // fill in the final hole
  }

  public void heapSort()
  // Sorts the values array using the heap sort algorithm.
  {
    int index;
    // Convert the array of values into a heap.
    for (index = valuesSize/2 - 1; index >= 0; index--)
    {
        comparisonNumber++;
        reheapDown(values[index], index, valuesSize - 1);
    }
 
    // Sort the array.
    for (index = valuesSize - 1; index >=1; index--)
    {
        comparisonNumber++;
        swap(0, index);
        reheapDown(values[0], 0, index - 1);
    }
  }

}
