package text;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class TextFile<T extends Comparable<T>> implements TextFileInterface<T>
{

    private T[] values = null;
    private boolean array; // if not array, it will default to linked-list
    private Path path = null;
    private File file = null;
    int lastIndex = -1; // most recent index for values that has stuff

    private final String FIELD_SEP = ",";

    /**
     * @param numElements
     * @param array
     * @param order
     * @throws IOException 
     */
    public TextFile(int numElements, boolean array, Order order) throws IOException
    {
        values = (T[]) new Comparable[numElements];
        for(int i = 0; i < values.length; i++)
            values[i] = null;
        this.array = array;
        switch(order)
        {
            case RANDOM:
                path = Paths.get("RandInt" +  numElements + ".txt");
                break;
            case IN_ORDER:
                path = Paths.get("InOrderInt" + numElements + ".txt");
                break;
            case REVERSE_ORDER:
                path = Paths.get("ReverseOrderInt" + numElements + ".txt");
                break;
            default:
                throw new IOException("Combination of arguments are invalid.");
        }
        file = path.toFile();
        getArrayFromFile();
    }

    private void getArrayFromFile()
    {
        try
        {
            // if the file doesn't exists, create it
            if (!Files.exists(path))
                Files.createFile(path);

            BufferedReader in =
                new BufferedReader(
                    new FileReader(file));

            String line = in.readLine();
            StringTokenizer t;
            int indexVal = -1;
            while(line != null)
            {
                String[] splitLine = line.split(FIELD_SEP);
                for(int i = 0; i < splitLine.length; i++)
                {
                    values[++indexVal] = (T) splitLine[i];
                        
                }                                
                line = in.readLine();
            }
            in.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    private void saveVals()
    {
        try
        {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(file)));       
            for (int i = 0; i < values.length; i++)
            {  
                if(i == values.length - 1)
                    out.println(values[i]);
                else if(i % 10 == 0)
                    out.println(values[i]);
                else
                    out.print(values[i] + FIELD_SEP);
                
            }

            out.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public T[] getArray()
    {
        return values;
    }

    // get linked-list, turns array into a linked-list of values
    
    @Override
    public void addVal(int index, T value)
    {
        values[index] = value;
        saveVals();
        getArrayFromFile();
    }

    @Override
    public void writeToOutput(searchSort.SearchSortInterface info)
    {
        Path thePath = null;
        File theFile = null;
        if(info instanceof searchSort.SortInfoHolder)
        {
            thePath = Paths.get("Sorting Results.txt");
            theFile = thePath.toFile();
        }
        else if(info instanceof searchSort.SearchInfoHolder)
        {
            thePath = Paths.get("Searching Results.txt");
            theFile = thePath.toFile();
        }
        else // should never get here
        {
            thePath = Paths.get("Errors.txt");
            theFile = thePath.toFile();
        }
        
        try
        {
            
            if (!Files.exists(thePath)) {
                Files.createFile(thePath);
            }

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(theFile, true)));
            out.println(info.toString());
            out.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }
}