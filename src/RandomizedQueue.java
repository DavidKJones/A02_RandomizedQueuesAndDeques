import java.util.Iterator;

/**
 * Randomized Queue class.
 * @author David Jones and Mason Parry
 * CSIS 2420 - A02: Randomized Queues and Deques
 */
public class RandomizedQueue<Item> implements Iterable<Item> 
{
	//construct an empty randomized queue
	public RandomizedQueue()
	{
		
	}
	
	//is the queue empty?
	public boolean isEmpty()
	{
		return false;
	}

	//return the number of items on the queue
	public int size()
	{
		return 0;
	}
	
	//add the item
	public void enqueue(Item item)
	{
		
	}
	
	//delete and return a random item
	public Item dequeue()
	{
		return null;
	}
	
	//return (but do not delete) a random item
	public Item sample()
	{
		return null;
	}

	//return an independent iterator over items in random order
	@Override
	public Iterator<Item> iterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	//unit testing
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
}
