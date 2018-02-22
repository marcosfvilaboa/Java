/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt() , s = scan.nextInt();
		    int firstPos = 1, lastPos = 2;
		    System.out.println("t="+t+"| n="+n+"| s="+s);
		    while(n>0)
		    {
		        int currentSum = 0;
		        int next = scan.nextInt();
		        currentSum = currentSum + next;
		        System.out.println("current="+currentSum+"| next="+next);
		        while((lastPos>n)&&(lastPos>firstPos+1))
		        {
		            if (s==currentSum)
    		        {
    		            System.out.println(firstPos+" "+lastPos);
    		            break;
    		        } 
    		        if (s>currentSum)
    		        {
    		            lastPos++;
    		        }
    		        if (s<currentSum)
    		        {
    		            firstPos++;
    		        }
		        }
    		        
		    }
		}
	}
}