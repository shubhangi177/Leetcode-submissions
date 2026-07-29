class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum+=nums[i];
        }
        double avg = (double) sum/k; //Cast to double to avoid integer division.
        for(int i = k; i < nums.length; i++){
            sum = sum+ nums[i] - nums[i-k]; //sum = oldSum - outgoing + incoming
            avg = Math.max(avg, (double)sum/k);
        }
        return avg;
    }
}