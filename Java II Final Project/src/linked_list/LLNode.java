package linked_list;

/**
 *
 * @author Kelvin Bonilla
 */
public class LLNode<T>
{
    private T data;
    private LLNode link;
    
    public LLNode(T data)
    {
        this.data = data;
        link = null;
    }
    
    public void setInfo(T data)
    // Sets data of this LLNode
    {
        this.data = data;
    }
    
    public T getInfo()
    // Returns data of this LLNode
    {
        return data;
    }
    
    public void setLink(LLNode link)
    // Sets link of this LLNode
    {
        this.link = link;
    }
    
    public LLNode<T> getLink()
    // Returns link of this LLNode
    {
        return link;
    }
}
