class Solution {
    private int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    public double knightProbability(int n, int k, int r, int c) {
        HashMap<String, Double> hm = new HashMap<>();
        return find(n, k, r, c, hm);
    }

    public double find(int n, int k, int r, int c, HashMap<String, Double> hm) {
        if(isValid(r, c, n) == false) {
            return 0;
        }

        if(k == 0) {
            return 1;
        }

        String key = r + "row" + c + "col" + k;

        if(hm.containsKey(key)) {
            return hm.get(key);
        }

        double prob = 0;

        for(int i = 0; i < dir.length; i++) {
            prob += find(n, k - 1, r + dir[i][0], c + dir[i][1], hm)/8.0;
        }

        hm.put(key, prob);
        return prob;
    }

    public boolean isValid(int r, int c, int n) {
        if(r < 0 || r >= n || c < 0 || c >= n) {
            return false;
        }

        return true;
    }
}