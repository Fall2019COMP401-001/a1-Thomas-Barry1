package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

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
			for(int j = 0; j < numItems; j++)
			{
				int individualItems = scan.nextInt();
				String notImportant = scan.next();
				sumItems += scan.nextDouble() * individualItems;
				custSums[i/2] = sumItems;
			}
			
		}
		for(int i = 0; i < numCust*2; i+=2)
		{
			System.out.println(custNames[i].charAt(0)+". "+custNames[i+1]+": "+String.format("%.2f", custSums[i/2]));
		}
		
	}
	static void addCust(String name, String[] names, int location)
	{
		names[location] = name;
	}
}
