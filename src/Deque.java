import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Randomized Queue class.
 * @author David Jones and Mason Parry
 * CSIS 2420 - A02: Randomized Queues and Deques
 */
public class Deque<Item> implements Iterable<Item>{
	//fields
    private int size;
    private Node<Item> first;
    private Node<Item> last;

	public Deque() { // Construct an empty deque
		size = 0;
		first = null;
		last = null;
	}
	
	@SuppressWarnings("hiding")
	private class Node<Item> // Inner helper class
	{
		private Item item;
		private Node<Item> previous;
		private Node<Item> next;
	}
    
	public boolean isEmpty() { // is the deque empty?
		return first == null;
	}
	
	public int size() { // return the number of items on the deque
		return size;
	}
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addFirst(Item item) { // insert the item at the front
		if(item == null)
			throw new NullPointerException("Cannot add null item");
		if (size == 0) { // if deque is empty
            first = new Node();
            first.item = item;
            first.next = null;
            first.previous = null;
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            first.previous = null;
            oldFirst.previous = first;
        }
        size++;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addLast(Item item) { // insert the item at the end
		if (item == null)
            throw new NullPointerException("Cannot add null item");
        if (size == 0) { // if deque is empty
            last = new Node();
            last.item = item;
            last.next = null;
            last.previous = null;
            first = last;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            last.previous = oldLast;
            oldLast.next = last;
        }
        size++;
	}
	
	public Item removeFirst() { // delete and return the item at the front
		if(isEmpty())
			throw new NoSuchElementException("The Queue is empty");
        Item item = first.item; // item to be removed
        if (size == 1) {
            first = null;
            last = first;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return item;
	}
	
	public Item removeLast() { // delete and return the item at the end
		if(isEmpty())
			throw new NoSuchElementException("The Queue is empty");
        Item item = last.item;
        if (size == 1) {
            last = null;
            first = last;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return item;
	}
	
	@Override
	public Iterator<Item> iterator() { // return and iterator over items in order from front to end
		@SuppressWarnings("unchecked")
		Item[] items = (Item[])new Object[size];
		Node<Item> current = first;
		int i = 0;
		while(current != null)
		{
			items[i] = current.item;
			current = current.next;
			i++;
		}
		
		return new DequeIterator<Item>(items);
	}
	
	@SuppressWarnings("hiding")
	private class DequeIterator<Item> implements Iterator<Item>
	{		
		Item[] items;
		int i = 0;
		
		public DequeIterator(Item[] items)
		{
			this.items = items;
		}

		@Override
		public boolean hasNext() 
		{
			return i < size;
		}

		@Override
		public Item next() 
		{
			if (items[i] == null)
				throw new NoSuchElementException();
			
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
    
	public static void main(String[] args) { // unit testing
		String[] cards = { "Queen of Hearts","2 of Diamonds","6 of Clubs",
						   "Ace of Spades","9 of Hearts","King of Clubs"};
		Deque<String> dq = new Deque<String>();
		dq.addFirst(cards[0]);
		dq.addLast(cards[1]);
		dq.addFirst(cards[2]);
		dq.addLast(cards[3]);
		dq.addFirst(cards[4]);
		dq.addLast(cards[5]);
		System.out.println("Cards added first front then back repeatedly:");
		for(String s : dq)
		{
			System.out.println(s);
		}
		System.out.println("\nThere are "+dq.size+" cards in the deck");
		dq.removeFirst();
		dq.removeLast();
		System.out.println("\nRemoved the top and bottom card");
		for(String s : dq)
		{
			System.out.println(s);
		}
		System.out.println("\nThere are "+dq.size+" cards in the deck");
		dq.removeFirst();
		dq.removeLast();
		dq.removeFirst();
		dq.removeLast();
		System.out.println("\nremoved all cards from deck");
		System.out.println("\nThere are "+dq.size+" cards in the deck");
	}
}
