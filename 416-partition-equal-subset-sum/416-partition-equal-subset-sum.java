public class Solution {
    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[volumn];
    }
}


// class Solution {
//     public boolean canPartition(int[] nums) {
//         return canPartition(nums, 0, 0, 0);
//     }
    
//     public boolean canPartition(int[] nums, int i, int sum1, int sum2) {
//         if(i==nums.length){
//             if(sum1 == sum2) return true;
//             else return false;
//         }
        
//         return canPartition(nums, i+1, sum1 + nums[i], sum2) || canPartition(nums, i+1, sum1, sum2+nums[i]);
//     }
// }