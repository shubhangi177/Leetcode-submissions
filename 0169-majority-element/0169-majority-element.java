class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0;
        int cnt = 0;
        for (int num : nums) {

            // If the current candidate has no remaining support,
            // choose the current number as the new candidate.
            if (cnt == 0)
                cand = num;

            // We use a separate 'if' (NOT 'else if') because if we just selected
            // a new candidate above, the current number should immediately count
            // as its first vote.
            //
            // Example:
            // cnt = 0, num = 5
            // -> cand = 5
            // -> num == cand, so cnt becomes 1
            //
            // If we used 'else if', this block would be skipped and the new
            // candidate would incorrectly have 0 votes.
            if (num == cand)
                cnt++;

            // Current number is different from the candidate,
            // so it cancels out one vote of the candidate.
            else
                cnt--;
        }
        return cand;
    }
}
