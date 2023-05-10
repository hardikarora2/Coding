class Solution {
   public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
   
//traversing the matrix 
int n = matrix.length;

//because we want the kht smallest 
   k = (n*n) - k +1 ;
   for(int i=0; i<n; i++)
   {
      for(int j=0; j<n; j++)
      {
         
         pq.add(matrix[i][j]);	
         //removal part 
         if(pq.size()>k)
            pq.poll();
      }
   }
     //added all the elements in the array 

      // that we need to restrict our pq to k size
      return pq.poll();
   }
}