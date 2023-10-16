class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int currMax = nums[0];

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            currMax = Math.max(currMax, sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        return currMax;
    }
}