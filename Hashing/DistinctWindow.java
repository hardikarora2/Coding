import java.util.*;

public class DistinctWindow{

   public static String Distinct_Window(String s){

		int n = s.length();
      int i=-1,j=0;
		// intialize the ans 
		
		HashMap<Character,Integer> dm = new HashMap<>();
		// dummy hashmap for getting the length of distinct 
		//characters
		for(int r=0; r<n; r++)
			{
				dm.put(s.charAt(r),dm.getOrDefault(s.charAt(r),0) +1);
			}
		int k = dm.size();
		// getting the number of distinct characters


		
		int ans = n;
		String res = s;

		
		HashMap<Character,Integer> hm = new HashMap<>();
		while(j<n)
		{
			// add the jth character in the hashmap	
			char ch = s.charAt(j);
			hm.put(ch,  hm.getOrDefault(ch,0)+1);

			

			while(hm.size()==k)
			{
				// move i

				if(ans>(j-i))
				{
					ans = j-i;
					res = s.substring(i+1,j+1);
				}

				
				i++; 
				// comes to 0 
				char x = s.charAt(i);
				// where x represents the ith character

				if(hm.get(x)==1)
					hm.remove(x); // ill remove when the freq is 1
				else
					hm.put(x,hm.get(x)-1);// decrease the freq
				
			}
			j++;

		}

		return res;
   }

   public static void main(String[] args) throws Throwable {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      String ans = Distinct_Window(s);
      System.out.println(ans);
      sc.close();
   }
}