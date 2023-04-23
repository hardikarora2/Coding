import java.util.*;

class Sol {
   static Node filterList(Node head){
         //create the dummy node 
		Node dummy = new Node(-1);
		// dummy is a temporary node because we dont know the ans head of the ll
		//creating the link between dummy and the head node 
		dummy.next = head;

		//create your iterators 
		//preb starts from the dummy 
		Node prev = dummy;
		//curr starts from the head 
		Node curr = head;

		// Ill run the loop until curr == null
		while(curr!= null)
		{
			//when the node is divisible by 10
			if(curr.data%10==0)
			{
				//break the link between the prev and curr
				// creating the link between prev and curr's next
				// in other words deleting the link between prev and curr
				prev.next = curr.next;
				
			}
			else
			{
				// just move both the pointers 
				//i.e prev and curr
				prev = prev.next;
			}
			// move the traversing pointer that is curr 
			curr = curr.next;
		}

		//create a link between prev and curr
		//reason what if the last few nodes are invalid 
		// then else would not be called hence carrying some wrong nodes also

		// Just return the dummy's next 
		return dummy.next;
		
   
   }
};

class Node  {
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
}

public class Bob_hates_10 {
   public static void main(String[] args) throws Throwable {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Node head = new Node(sc.nextInt());
      Node a = head;
      for(int i=1;i<n;i++) {
            Node temp = new Node(sc.nextInt());
            a.next = temp;
            a = temp;
      }
      Node ans = Sol.filterList(head);
      while(ans!=null){
            System.out.print(ans.data +" ");
            ans= ans.next;
      }
      sc.close();
   }
}

