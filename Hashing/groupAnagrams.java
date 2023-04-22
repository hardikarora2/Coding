
// A Java program to print all anagrams together
import java.util.*;

public class groupAnagrams {

	// TC: O(N * M) -> N, length of longest word, M -> no. of words
	// SC: O(M)
	
    // Given a list of words in wordArr[],
    static void printAnagramsTogether(String strs[], int size) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(String s: strs)
        {
            char ch[] = s.toCharArray();
            // converted to char array 
            Arrays.sort(ch);
            // sorted the char array
            String sorted_s = new String(ch);
            // converted the sorted array to the string 


            // check for the sorted string as the key in the hm 
            if(hm.containsKey(sorted_s))
            {
                ArrayList<String> al = hm.get(sorted_s);
                // got the list of anagrams
                al.add(s);
                // add my string s to the list of anagrams
                hm.put(sorted_s,al);
                // inserted the new al in the hm
            }
            else
            {
                ArrayList<String> al = new ArrayList<>();
                // made a new al
                al.add(s);
                // add my string s to the list 
                hm.put(sorted_s,al);
            }
            // System.out.println(sorted_s);
        }

        //after this I have a hm in which infront of key I have the list of anagrams

        for(String s : hm.keySet())
        {
            // s si my sorted string
            ans.add(hm.get(s));
        }

        // return ans;
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}
