import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Randomized Queue class.
 * @author David Jones and Mason Parry
 * CSIS 2420 - A02: Randomized Queues and Deques
 */
public class RandomizedQueue<Item> implements Iterable<Item> 
{
	private Node<Item> first;
	private Node<Item> last;
	private int count;
	
	//inner helper class
	@SuppressWarnings("hiding")
	private class Node<Item>
	{
		private Item item;
		private Node<Item> previous;
		private Node<Item> next;
	}
	
	//construct an empty randomized queue
	public RandomizedQueue()
	{
		first = null;
		last = null;
		count = 0;
	}
	
	//is the queue empty?
	public boolean isEmpty()
	{
		return first == null;
	}

	//return the number of items on the queue
	public int size()
	{
		return count;
	}
	
	//add item and place it randomly
	public void enqueue(Item item)
	{
		if(item == null)throw new NullPointerException("Cannot add a null item.");
		
		Node<Item> prevLast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		
		if(isEmpty())
			first = last;
		else
		{
			prevLast.next = last;
			last.previous = prevLast;
		}
		
		count++;
	}
	
	//delete and return a random item
	public Item dequeue()
	{
		if(isEmpty())throw new NoSuchElementException("The Queue was empty.");
			
		int rand = StdRandom.uniform(count);
		
		Node<Item> node = getNode(rand);
		
		if(node == first)
		{
			first = node.next;
			node.next.previous = null;
		}
		else if(node == last)
		{
			last = node.previous;
			node.previous.next = null;
		}
		else
		{		
			Node<Item> prevNode = node.previous;
			node.previous.next = node.next;
			node.next.previous = prevNode;
		}
		
		count--;	
		return node.item;
	}
	
	//get the node by index
	private Node<Item> getNode(int index)
	{
		Node<Item> current = first;
		int i = 0;
		while( i < index)
		{
			i++;
			current = current.next;
		}
		
		return current;
	}
	
	//return (but do not delete) a random item
	public Item sample()
	{
		if(isEmpty())throw new NoSuchElementException("The Queue was empty.");
		
		int rand = StdRandom.uniform(count);		
		Node<Item> node = getNode(rand);
		return node.item;
	}

	//return an independent iterator over items in random order
	@Override
	public Iterator<Item> iterator() 
	{
		@SuppressWarnings("unchecked")
		Item[] items = (Item[])new Object[count];
		Node<Item> current = first;
		int i = 0;
		while(current != null)
		{
			items[i] = current.item;
			current = current.next;
			i++;
		}
		
		return new RandomizedIterator<Item>(items);
	}
	
	//randomized iterator
	@SuppressWarnings("hiding")
	private class RandomizedIterator<Item> implements Iterator<Item>
	{		
		Item[] items;
		int i = 0;
		
		public RandomizedIterator(Item[] items)
		{
			StdRandom.shuffle(items);
			this.items = items;
		}

		@Override
		public boolean hasNext() 
		{
			return i < count;
		}

		@Override
		public Item next() 
		{
			Item item = items[i];
			i++;
			return item;
		}
		
		@Override
		public void remove()      
		{ 
			throw new UnsupportedOperationException();  
		}
		
	}
	
	//unit testing
	public static void main(String[] args) 
	{
		Integer[] integers = { 20, 50, 30, 29, 64, 99};
		RandomizedQueue<Integer> rQ = new RandomizedQueue<Integer>();
		for(Integer i : integers)
		{
			rQ.enqueue(i);
		}
		
		for(Integer i : rQ)
		{
			System.out.print(i);
			System.out.print("[");
			for(Integer j : rQ)
			{
				System.out.print(" " + j);
			}
			System.out.print(" ]\n");
		}
	}
}
