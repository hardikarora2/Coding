import java.util.*;

class Solution {
   int countEqualSubarray01(int arr[], int n)
   {
      int cnt =0;
		// count for returning the asnwer
		HashMap<Integer,Integer> hm = new HashMap<>();
		// hashmap for storing prefix sum and its freq
		int pre_sum = 0;
		// calculating the prefix sum 
		for(int i=0; i<n; i++)
		{
			if(arr[i] ==1)
				pre_sum++;
			else // else means the number is 0 so in that case we need to decrease the sum 
				pre_sum--; 
			// check this value in hm
			// this was the count for the intermediate subarray 
			if(hm.containsKey(pre_sum))
			cnt+= hm.get(pre_sum);
			
			// count for whole subarray 
			if(pre_sum==0)
				cnt++;

			hm.put(pre_sum,hm.getOrDefault(pre_sum,0)+1);
		}
		return cnt;
   }   

}

public class countEqualSubarray01 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N= sc.nextInt();
   

      int arr[] = new int[N];

      for(int i=0; i<N; i++){
         arr[i]= sc.nextInt();
      }
      
      Solution Obj = new Solution();
      System.out.println(Obj.countEqualSubarray01(arr,N));
		sc.close();

   }
}