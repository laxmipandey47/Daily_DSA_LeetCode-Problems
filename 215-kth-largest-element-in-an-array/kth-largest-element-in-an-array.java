class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans;
        sort(nums, 0, nums.length - 1);
        ans = nums[nums.length - k];
        return ans;
    }

    public void sort(int[] nums, int low, int high){
         if(low >= high) {
          return;
         } 

         int s = low;
         int e = high;
         int m = s + (e - s)/2;
         int pivot = nums[m];
         while(s <= e) {
          //also a reason why if its already sorted it will not swap
          while(nums[s] < pivot) {
               s++;
          }

          while(nums[e] > pivot) {
               e--;
          }

          //swap
          if(s <= e) {
               int temp = nums[s];
               nums[s] = nums[e];
               nums[e] = temp;
               s++;
               e--;
          }
         }

         //recursion call
         //now my pivot is at correct index, 
         //sort the remaining two halves
         sort(nums, low, e);
         sort(nums, s, high);
     }
}