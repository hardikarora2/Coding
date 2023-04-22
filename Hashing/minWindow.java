import java.util.*;

class Solution {
	public boolean isValid(int [] freqs, int []freqt)
	{
		// now check for validity
		// 65 stands for uppercase a 
		//122 stands for lowercase z
		for(int i=65; i<123; i++)
		{
			if(freqs[i] <freqt[i])
				return false; // not valid
		}
		return true;
	}
   public String minWindow(String s, String t) {
		// write code here
		//create a freq array for string t
		int freqt[] = new int[128];
		int n = s.length();
		int m = t.length();


		//iterate on string t
		for(int i=0; i<m; i++)
		freqt[t.charAt(i)]++;

		//after this we are not modifying the freqt 
		

		int anslen = Integer.MAX_VALUE;
		int i=-1,j=0;
		int ansst=-1,ansend=-1;

		//freq array for the string s
		int freqs[] = new int[128];

		//iteerate on the string s
		while(j<n)
			{
				//add the j th char
				freqs[s.charAt(j)]++;

				// check is it valid
				while(isValid(freqs,freqt))
				{
					// you enter the function means the string is valid
					// coud be my possible ans 
					//check for the length
					if(anslen>(j-i))
					{
						anslen = j-i;
						ansst = i+1;
						ansend = j;
						// we want the string 
						//1 thing 
						// we can store the start end end of the ans string 
						// 2nd thind 
						// we can store the string 
						// if it changes multiple times then the tc could
						// be compromised
					}

					//remove the ith char
					i++;
					freqs[s.charAt(i)]--;
				}

				j++;
				// move the jth pointer
			}
		//edge case
		if(anslen == Integer.MAX_VALUE)
			return "";

		
		// we have the anslen and ansst and ansend
		// we want the string 
		// .. use sb

		StringBuilder sb = new StringBuilder();

		for(int r=ansst; r<=ansend; r++)
			sb.append(s.charAt(r));

		return sb.toString();
   }
}

public class minWindow {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s,t;
      s = sc.next();
   t = sc.next();
      Solution Obj = new Solution();
      System.out.print(Obj.minWindow(s,t));
      sc.close();
   }
}