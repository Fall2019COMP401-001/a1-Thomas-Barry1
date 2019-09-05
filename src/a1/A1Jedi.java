package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numItemsStore = scan.nextInt();
		String[] itemsStore = new String[numItemsStore];
		double[] priceItems = new double[numItemsStore];
		int[] numCustBoughtItems = new int[numItemsStore];
		int[] numItemsBought = new int[numItemsStore];
		for(int i = 0; i < numItemsStore; i++)
		{
			itemsStore[i] = scan.next();
			priceItems[i] = scan.nextDouble();
		}
		
		int numCust = scan.nextInt();
		String [] custNames = new String[numCust*2];
		double [] custSums = new double[numCust];
		for(int i = 0; i < numCust*2; i+=2)
		{
			int location = i;
			addCust(scan.next(), custNames, location);
			location = i + 1;
			addCust(scan.next(), custNames, location);
			
			double sumItems = 0;	//total sum of values for items, reused for each customer
			
			int numItems = scan.nextInt();
			
			int[] removeRepeats = new int[numItemsBought.length];
			for(int j = 0; j < numItems; j++)
			{
				int individualItems = scan.nextInt();
				String notImportant = scan.next();
				numItemsBought[locationOfItem(notImportant, itemsStore, priceItems)] += individualItems;
				if (removeRepeats[locationOfItem(notImportant, itemsStore, priceItems)] == 0)
				{
					numCustBoughtItems[locationOfItem(notImportant, itemsStore, priceItems)] += 1;
				}
				removeRepeats[locationOfItem(notImportant, itemsStore, priceItems)] = 1;
				
			}
			//
		}
		for(int i = 0; i < numItemsBought.length; i++)
		{
			if(numCustBoughtItems[i] == 0)
			{
				System.out.println("No customers bought " + itemsStore[i]);
			}
			else
			{
				System.out.println(numCustBoughtItems[i] + " customers bought " + numItemsBought[i] + " " + itemsStore[i]);
			}
		}
			//System.out.println("Biggest: " + custNames[bigSpender(custSums)*2] + " " + custNames[bigSpender(custSums)*2+1] + " (" + String.format("%.2f", custSums[bigSpender(custSums)]) + ")");
			//System.out.println("Smallest: " + custNames[smallSpender(custSums)*2] + " " + custNames[smallSpender(custSums)*2+1] + " (" + String.format("%.2f", custSums[smallSpender(custSums)]) + ")");
			//System.out.println("Average: " + String.format("%.2f", average(custSums)));
		//}
		
	}
	static int bigSpender(double[] custSums)
	{
		int location = 0;
		int trueLocation = 0;
		double max = custSums[0];
		while(location < custSums.length)
		{
			if (max < custSums[location])
			{
				max = custSums[location];
				trueLocation = location;
			}
			location++;
		}
		return trueLocation;
	}
	static int smallSpender(double[] custSums)
	{
		int location = 0;
		int trueLocation = 0;
		double min = custSums[0];
		while(location < custSums.length)
		{
			if (min > custSums[location])
			{
				min = custSums[location];
				trueLocation = location;
			}
			location++;
		}
		return trueLocation;
	}
	static double average(double[] custSums)
	{
		double sum = 0;
		for(int i = 0; i < custSums.length; i++)
		{
			sum += custSums[i];
		}
		return (sum/custSums.length);
	}
	static int locationOfItem(String item, String[] items, double[] prices)
	{
		double value = prices[0];
		int location = 0;
		int keepGoing = 0;
		while(keepGoing == 0)
		{
			if(item.equals(items[location]))
			{
				break;
			}
			location++;
		}
		return location;
	}
	static void addCust(String name, String[] names, int location)
	{
		names[location] = name;
	}
}
