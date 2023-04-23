import java.io.*;
import java.util.*;

class Node{
   int card;
   Node nextCard;
   Node(int card){
      this.card = card;
      nextCard = null;
   }
}
class Deck{
   Node head;
   void add(int card ){
      Node new_node = new Node(card);
      if(head == null){
         head = new_node;
         return;
      }
      Node current = head;
      while(current.nextCard !=null){
         current = current.nextCard;
      }
      current.nextCard = new_node;
   }
}

class Solution {
static Node combine(Node h1, Node h2){

      //create a dummy node for better traversal 
      Node dummy = new Node(-1);
      // curr is used to iterate the lls
      Node curr = dummy;

      while(h1!= null && h2!= null)
      {
      // first set of operations
         //link the curr with the head1
         curr.nextCard = h1;
         // h1 moves forward
         h1 = h1.nextCard;
         // curr moves forward
         curr = curr.nextCard;

         // second set of operations
         //link the curr with head 2
         curr.nextCard = h2;
         // h2 moves forward
         h2 = h2.nextCard;
         // curr moves forward
         curr = curr.nextCard;
      }

      // remember that the list starts from dummy so return the dummy;s next
   return dummy.nextCard;
   }
}
public class Main {
   
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Deck class1= new Deck();
      for(int i=0;i<n;i++){
            class1.add(sc.nextInt());
      }
      int m = n;
      Deck class2 = new Deck();
      for(int i=0;i<m;i++){
            class2.add(sc.nextInt());
      }

      Solution Ob = new Solution();
      Node head = Ob.combine(class1.head, class2.head);
      while(head != null){
            System.out.print(head.card + " ");
            head = head.nextCard;
      }
   }
}