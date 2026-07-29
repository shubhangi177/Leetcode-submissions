class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // For n/3 majority, there can be at most 2 valid answers.
        // So we maintain two possible candidates.
        int cand1 = 0;
        int cand2 = 1;

        // cnt1 and cnt2 represent the remaining "votes/support"
        // for cand1 and cand2.
        int cnt1 = 0;
        int cnt2 = 0;


        // Boyer-Moore Voting Algorithm (extended for n/3)
        for(int num : nums){
            // Current number supports candidate 1.
            if(num == cand1){
                cnt1++;
            }

            // Current number supports candidate 2.
            else if(num == cand2){
                cnt2++;
            }

            // If candidate 1 has no support left,
            // replace it with the current number.
            //
            // The current number will get its first vote
            // through cnt1++ in the next matching step.
            else if(cnt1 == 0){
                cand1 = num;
                cnt1 = 1;
            }

            // If candidate 2 has no support left,
            // replace it with the current number.
            else if(cnt2 == 0){
                cand2 = num;
                cnt2 = 1;
            }


            // Current number is different from both candidates.
            // It cancels one vote of both candidates.
            //
            // Idea:
            // Remove a group of 3 different elements:
            // cand1 + cand2 + current element
            else{
                cnt1--;
                cnt2--;
            }
        }


        // IMPORTANT:
        // Voting phase only finds possible candidates.
        // It does NOT guarantee that they appear more than n/3 times.
        //
        // Example:
        // [1,2,3,4]
        // voting may leave candidates, but answer is [].
        //
        // So we verify the actual frequencies.

        cnt1 = 0;
        cnt2 = 0;

        for(int num : nums){

            if(num == cand1)
                cnt1++;

            else if(num == cand2)
                cnt2++;
        }


        List<Integer> list = new ArrayList<>();

        // Only add candidates that actually appear more than n/3 times.
        if(cnt1 > nums.length / 3)
            list.add(cand1);

        if(cnt2 > nums.length / 3)
            list.add(cand2);


        return list;
    }
}