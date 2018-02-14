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
		
		//get integer k from the command line
		int k = Integer.parseInt(args[0]);
		String list = "";
		
		//get the value of N
		StdOut.println("Type in the number of strings you want to queue.");
		int N = StdIn.readInt();
		//we want to insure that N is greater than or equal to k
		while(N < k)
		{
			StdOut.println("Number of strings needs to be greater or equal to k.");
			N = StdIn.readInt();
		}
		
		//enqueue the items
		for(int i = 0; i < N; i++)
		{
			String str = StdIn.readString();
			rQ.enqueue(str);
			list += " " + str;
		}
		
		//print the list and print k items randomly
		StdOut.println("% echo" + list + " | java Subset " + k);			
		int count = 0;
		for( String s : rQ )
		{
			System.out.println(s);
			count++;
			if(count == k)
				break;
		}
	}

}
