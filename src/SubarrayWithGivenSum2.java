/**
 * @author Marcos F. Vilaboa
 * 
 * based on a method written by Praveen here --> https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0#ExpectOP
 *
 */

import java.util.*;

public class SubarrayWithGivenSum2 {
	public static void main(String[] args) {		
		try (Scanner in = new Scanner(System.in)) {
			int testsNumber = in.nextInt();
			long startTime = System.nanoTime();
			long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			while(testsNumber --> 0) {
				int array[] = new int[in.nextInt()];
				int sum = in.nextInt();
				for(int i = 0; i < array.length; i++) {
					array[i] = in.nextInt();
				}
				int currentSum=0;
				HashMap<Integer,Integer> sumAtIndex= new HashMap<Integer,Integer>();
				int i=0,j=0;
				while(i<array.length) {
					currentSum=currentSum+array[i];
					sumAtIndex.put(currentSum,i+1);
					if(currentSum==sum){
						System.out.println((j+1)+" "+(i+1));
						j++;
						break;
					} else if(currentSum > sum){
						if(sumAtIndex.containsKey(currentSum-sum)){
							System.out.println(1+sumAtIndex.get(currentSum-sum)+" "+(i+1));
							j++;
							break;
						}
					}
					i++;
				}
				if(j==0) System.out.println(-1);
			}
			long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			double usedMemoryInMB = (double)(afterUsedMem - beforeUsedMem) / (double)(1024 * 1024);
			long endTime   = System.nanoTime();
			double totalTimeInSec = (double) (endTime - startTime) / 1000000000.0;			
			System.out.println("\nTime (sec)-->"+totalTimeInSec+" Memory Usage-->"+usedMemoryInMB);
		}		
	}
}