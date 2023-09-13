class Solution {
    public int candy(int[] ratings) {
        int count = 0;
        int[] l2r = new int[ratings.length];
        //int[] r2l = new int[ratings.length];

        for(int i = 0; i < ratings.length; i++) {
            l2r[i] = 1;
        }

        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                l2r[i] = l2r[i - 1] + 1;
            }
        }
        int right = 1;

        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right++;
                l2r[i] = Math.max(l2r[i], right);
            }
            else {
                right = 1;
            }
        }

        for(int i = 0; i < l2r.length; i++) {
            count += l2r[i];
        }

        return count;
    }
}