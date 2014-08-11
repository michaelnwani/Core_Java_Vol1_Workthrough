package treeSet;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 * @author michaelnwani
 *
 */
public class TreeSetTest 
{
	public static void main(String... args)
	{
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		parts.add(new Item("Tachikoma", 1776));
		System.out.println(parts);
		
		
		//a function object will typically be implemented in an anonymous inner class
		SortedSet<Item> sortByDescription = new TreeSet<>(new 
				Comparator<Item>()
				{
					public int compare(Item a, Item b)
					{
						String descrA = a.getDescription();
						String descrB = b.getDescription();
						return descrA.compareTo(descrB);
					}
				});
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}


