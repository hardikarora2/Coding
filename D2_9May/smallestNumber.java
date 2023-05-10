import java.util.*;
class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int k=sc.nextInt();
				Solution ob =new Solution();
				String ans = ob.smallestNumber(n,k);
				System.out.println(ans);
				t--;
			}
		}
	}

}
class Solution{ 
   public String smallestNumber(int sum, int d){
        // when the number is not possible 

		if(sum>(9*d))
			return "-1";
		// start making the string 
		StringBuilder sb = new StringBuilder();
		int i = d-1;
		//starting from the last digit
		// i iterates on digits
		while(i>=0)
		{
			if(sum>9)
			{
				// add the last digit as 9 
				sum -= 9;
				sb.append('9');
			}
			else
			{
				// first digit 
				if(i==0)
					sb.append(sum);
				else
				{
					// placing max possible value over here
					sb.append(sum-1);
					sum = 1;
				}
			}
			i--;
		}
		// string needs to reversed
		sb.reverse();
		return sb.toString();
		
    }
}