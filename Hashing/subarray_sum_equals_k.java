import java.io.*;
import java.util.*;

class Solution
{
         static int solve(int n, int[] arr, int k){
       // Write your code here
        // create an answer variable 
		int ans =0;
			// create a hashmap
		HashMap<Integer,Integer> hm = new HashMap<>();
			 // prefix_sum  count
		int prefix_sum=0;
		for(int i=0; i<n; i++)
			{
				prefix_sum+= arr[i];
				// case 1
				if(hm.containsKey(prefix_sum - k))
				{
					ans += (hm.get(prefix_sum-k));
						// add the count 
				}

				// case 2
				if(prefix_sum==k)
					ans++;

				if(hm.containsKey(prefix_sum))
				{
					hm.put(prefix_sum,hm.get(prefix_sum) +1 );
				}
				else
				hm.put(prefix_sum,1);
			}

      return ans;
   
   }
}
public class subarray_sum_equals_k{
      public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
         {
            Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         int K = Integer.parseInt(br.readLine().trim());

         int out_ =  Solution.solve(N, Arr, K);
         System.out.println(out_);

         wr.close();
         br.close();
   }
}