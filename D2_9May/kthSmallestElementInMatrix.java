class Solution {
   public int kthSmallest(int[][] matrix, int k) {
       // t.c O(nlog(max-min))
       // s.c O(1)
      int n = matrix.length;
      int st = matrix[0][0];
      int end = matrix[n-1][n-1];

      // using the binary search on st and end
      int ans = Integer.MIN_VALUE;
      while(st<=end)
      {
         int mid = (st+end)/2;
         // search how many are values are there that are greater than this value 
         // intialize 2 pointers
         int i=0; int j= n-1,cnt = 0;
         //reason for the condns
         // i will be incremented always and j will be decremented always
         while(i<n && j>=0)
         {
            // search in ith row 
            if(matrix[i][j]<= mid)
            {
                  // fine 
                  // add to counter
                  cnt += (j+1);
                  i++;
            }
            else
            {
                  //move your j pointer
                  j--;
            }
         }

         // I have the cnt and I need to compare it with k 

         if(cnt<k)
         {
            // cannot be my ans 
            st = mid+1;
         }
         else if(cnt>=k)
         {
            // can this be my ans ??
            end = mid-1;
            ans = mid;
         }
      }

      return ans;
   }
}