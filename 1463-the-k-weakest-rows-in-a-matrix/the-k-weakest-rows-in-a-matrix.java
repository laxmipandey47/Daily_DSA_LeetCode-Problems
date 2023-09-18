class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int y = mat.length, x = mat[0].length, kix = 0;
        int[] vis = new int[y], ans = new int[k];
        for (int j = 0; j <= x; j++)
            for (int i = 0; i < y; i++) {
                if (vis[i] == 0 && (j == x || mat[i][j] == 0)) {
                    ans[kix++] = i;
                    vis[i]++;
                }
                if (kix == k) return ans;
            }
        return ans;
    }
}