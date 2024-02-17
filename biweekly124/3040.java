class Solution {
    private int recur(Integer[][] dp, int[] nums, int i, int j, int val, int comp) {
        if (val != comp) {
            return -1;
        }
        if (j <= i) {
            return 0;
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        int ret = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        
        if (i+1 <= j) {
            a = 1 + recur(dp, nums, i+2, j, val, nums[i] + nums[i+1]);
            b = 1 + recur(dp, nums, i+1, j-1, val, nums[i] + nums[j]);
            c = 1 + recur(dp, nums, i, j-2, val, nums[j] + nums[j-1]);
        }
        
        ret = Math.max(a, Math.max(b, c));
                           
        return dp[i][j] = ret;
    }
    
    public int maxOperations(int[] nums) {
        Integer[][][] dp = new Integer[3][nums.length][nums.length];
        
        if (nums.length == 2) {
            return 1;
        }
        
        int ans = 0;
        
        
        ans = Math.max(ans, recur(dp[0], nums, 2, nums.length-1, nums[0] + nums[1], nums[0] + nums[1]));
        ans = Math.max(ans, recur(dp[1], nums, 1, nums.length-2, nums[0] + nums[nums.length-1], nums[0] + nums[nums.length-1]));
        ans = Math.max(ans, recur(dp[2], nums, 0, nums.length-3, nums[nums.length-1] + nums[nums.length-2], nums[nums.length-1] + nums[nums.length-2]));
        
        return 1 + ans;
    }
}