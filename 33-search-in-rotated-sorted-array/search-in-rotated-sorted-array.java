class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        //if you did not find the pivot, it means the array is not rotated
        if(pivot == -1) {
          //just do binary seach
          return findBinarySearch(nums, target, 0, nums.length - 1);
        }

        //if pivot is found
        if(nums[pivot] == target) {
          return pivot;
        }
     
        if(target >= nums[0]) {
          return findBinarySearch(nums, target, 0, pivot - 1);
        }

        return findBinarySearch(nums, target, pivot + 1, nums.length - 1);
     }

     int findBinarySearch(int[] arr, int target, int start, int end) {
     
          while (start <= end) {
               int middle = start + (end - start) / 2;

               if (target < arr[middle]) {
                    end = middle - 1;
               } else if (target > arr[middle]) {
                    start = middle + 1;
               } else {
                    // ans found
                    return middle;
               }
          }
          return -1;
     }

     int findPivot(int[] arr) {
          int start = 0;
          int end = arr.length - 1;
          while (start <= end) {
               int mid = start + (end - start) / 2;
               // 4 cases over here
               //case 1
               if (mid < end && arr[mid] > arr[mid + 1]) {
                    return mid;
               }
               //case 2
               if (mid > start && arr[mid] < arr[mid - 1]) {
                    return mid - 1;
               }
               //case 3
               if(arr[mid] <= arr[start]){
                   end = mid - 1; 
               } 
               else {
                    start = mid + 1;
               }
          }
          return -1;
    }
}