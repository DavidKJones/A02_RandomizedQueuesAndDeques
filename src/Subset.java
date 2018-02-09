/**
 * Subset class.
 * @author David Jones and Mason Parry
 * CSIS 2420 - A02: Randomized Queues and Deques
 */
public class Subset 
{

	public static void main(String[] args) 
	{
		RandomizedQueue<String> rQ = new RandomizedQueue<String>();
		
		StdOut.println("Please enter the number of strings you want to create:");
		int N = StdIn.readInt();
		String[] str = new String[N];
		for(int i = 0; i < N; i++)
		{
			str[i] = StdIn.readString();
			rQ.enqueue(str[i]);
		}
		
		
		//print randomized queue
		StdOut.print("% echo ");
		for(String s : rQ)
		{
			StdOut.print(String.format("%s ", s));
		}
		StdOut.print(String.format("| java Subset %d\n", N));
	}

}
