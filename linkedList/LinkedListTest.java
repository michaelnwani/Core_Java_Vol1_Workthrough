package linkedList;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 * @author michaelnwani
 *
 */
public class LinkedListTest 
{
	public static void main(String... args)
	{
		List<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		List<String> b = new LinkedList<>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		//merge the words from b into a
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		//they both start at the beginning
		while (bIter.hasNext())
		{
			if (aIter.hasNext()) aIter.next(); //get to a's end
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		//remove every second word from b
		bIter = b.iterator();
		while (bIter.hasNext()) //starts from the beginning again
		{
			bIter.next(); //skip one element
			if (bIter.hasNext())
			{
				bIter.next(); //skip one element
				bIter.remove(); // remove that skipped element
			}
		}
		
		System.out.println(b);
		
		//bulk operation: remove all words in b from a
		a.removeAll(b);
		
		System.out.println(a);
	}
}
