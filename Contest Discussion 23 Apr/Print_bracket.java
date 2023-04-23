import java.io.*;
import java.util.*;

class Main {
   public static void main(String args[]) throws IOException {
      BufferedReader read =
         new BufferedReader(new InputStreamReader(System.in));
      
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.barcketNumbers(S);
            for(int value :  result)
            System.out.print(value + " ");
            System.out.println();
      
   }
}
class Solution {
   ArrayList<Integer> barcketNumbers(String s) {

		// Create an arraylist for the ans 
		ArrayList<Integer> ans = new ArrayList<> ();

		//intialize the count variable
		int count = 1;
		
		// make the stack in which the numbers would be pushed
		Stack<Integer> st = new Stack<>();

		// Take the length of the string 
		int n = s.length();

		//running a loop to iterate 
		for(int i=0; i<n; i++)
		{
			// ith character
			char ch = s.charAt(i);
			// for the opening bracket 
			if(ch=='(')
			{
				// push 
				st.push(count);
				// print
				ans.add(count);
				//increment
				count++;
			}
			else if(ch ==')') // remember to use else if because there are other characters also 
			{
				// print 
				ans.add(st.peek());
				//pop
				st.pop();
			}
			// else part would the remaining characters so because we need not do any action on the 
			// characters so we can ignore it 
		}
		// returning the made arraylist 
		return ans;
   }
};