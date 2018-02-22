import java.util.*;

class PainterG {
   
     public static int painter(int ar[],int n,int nearest)
     {   int total=0;
         int count=1;
         for(int i=0;i<n;i++)
         {
             total+=ar[i];
             if(total>nearest){
                 total=ar[i];
                 count++;
             }
         }
         return count;
     }
    public static int findSolution(int ar[],int n,int k,int max,int sum)
    {
        int least=max;
        int high=sum;
        while(least<high){
            int mid=least+(high-least)/2;
            int worker= painter(ar,n,mid);
            if(worker<=k)
            high=mid;
            else
            least=mid+1;            
        }
        return least;
    }
	public static void main (String[] args) {
		try (Scanner in =new Scanner (System.in)) {
			int t=in.nextInt();
			while(t>0)
			{
			    int k=in.nextInt();
			    int n=in.nextInt();
			    int ar[]=new int[n];
			    int sum=0;
			    for(int i=0;i<n;i++)
			    {
			        ar[i]=in.nextInt();
			        sum+=ar[i];
			    }
			   int  max=-1;
	        for(int i=0;i<n;i++)
	        if(max<ar[i])
	        max=ar[i];
			int sol= findSolution(ar,n,k,max,sum);
			System.out.println(sol);
			--t;			    
			}	
		}
	}
}