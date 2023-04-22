import java.util.*;

public class substring_k_unique_characters{
	// T.C = O(N)
	// S.C = O(N)
   public static int longestkSubstr(int n, int k,String s){
        //write code here
		//initialize the pointers
		int i=-1,j=0;
		// intialize the ans 
		
		int ans = -1;
		HashMap<Character,Integer> hm = new HashMap<>();
		while(j<n)
		{
			// add the jth character in the hashmap	
			char ch = s.charAt(j);
			hm.put(ch,  hm.getOrDefault(ch,0)+1);

			while(hm.size()>k)
			{
				// move i
				i++; 
				// comes to 0 
				char x = s.charAt(i);
				// where x represents the ith character

				if(hm.get(x)==1)
					hm.remove(x); // ill remove when the freq is 1
				else
					hm.put(x,hm.get(x)-1);// decrease the freq
				
			}
			
			if(hm.size()==k)
				ans = Math.max(ans,j-i);
			j++;

		}

		return ans;
   }

   public static void main(String[] args) throws Throwable {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();
      int ans = longestkSubstr(n,k,s);
      System.out.println(ans);
      sc.close();
   }
}