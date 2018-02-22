/**
 * @author Marcos F. Vilaboa
 *
 */

import java.util.*;

// Class to find a subarray of elements given the array, its size
// and the sum we need to find. 
// If the subarray doesn't exists, it prints '-1'
public class SubarrayWithGivenSum {		
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
				int firstPosition = 0, lastPosition = 1;
				int accumulated = array[firstPosition];
				while((firstPosition < (array.length - 2)) && (sum != accumulated)) {
					if ((lastPosition == (array.length-1)) && (firstPosition == 0) && (sum > accumulated)) 
						break;	
					accumulated = accumulated + array[lastPosition];
					if (sum > accumulated) {
							lastPosition++;
					} 				
					if(sum < accumulated) {
						firstPosition++;
						lastPosition = firstPosition + 1;
						accumulated = array[firstPosition];
					}						
				}
				if (sum == accumulated)
					System.out.println((firstPosition+1) + " " + (lastPosition+1));
				else
					System.out.println("-1");
			}	
			long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			double usedMemoryInMB = (double)(afterUsedMem - beforeUsedMem) / (double)(1024 * 1024);
			long endTime   = System.nanoTime();
			double totalTimeInSec = (double) (endTime - startTime) / 1000000000.0;			
			System.out.println("\nTime (sec)-->"+totalTimeInSec+" Memory Usage-->"+usedMemoryInMB);
		}
		
	}
}