class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
          int end = arr.length - 1;

          while (start < end) {
               int middle = start + (end - start) / 2;

               if (arr[middle] > arr[middle + 1]) {
                    //you are in the decreasing part of array
                    //this may be the ans, but look at left
                    //this is why end != mid - 1
                    end = middle;
               } else  {
                    start = middle + 1; // because we know that mid element > mid element
               } 
          }
          return start;
    }
}