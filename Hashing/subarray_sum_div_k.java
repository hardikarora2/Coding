import java.util.*;

public class subarray_sum_div_k {

   public static int subarrayDivisbleByK(int arr[], int n, int k){
      int ans =0;
			// create a hashmap
		HashMap<Integer,Integer> hm = new HashMap<>();
			 // prefix_sum  count
		int prefix_sum=0;
		for(int i=0; i<n; i++)
			{
				prefix_sum+= arr[i];
				prefix_sum%=k;

				prefix_sum = (prefix_sum+k)%k;
				

				// System.out.println(prefix_sum+" ");
				
				// changed step  ***** 
				
				// case 1
				if(hm.containsKey(prefix_sum)) // ** changed part
				ans += (hm.get(prefix_sum));

				// case 2
				if(prefix_sum==0)
					ans++;
				
				hm.put(prefix_sum,hm.getOrDefault(prefix_sum,0) +1 );
			}

      return ans;
   }
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int k=sc.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;++i){
         arr[i]=sc.nextInt();
      }
      int result = subarrayDivisbleByK(arr, n, k);
      System.out.print(result);        
      System.out.println('\n');
      sc.close();
   }
}