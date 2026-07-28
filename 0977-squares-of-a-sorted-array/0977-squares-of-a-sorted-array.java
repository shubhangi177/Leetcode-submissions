class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        while(left <= right){
            int n1 = nums[left]*nums[left];
            int n2 = nums[right]*nums[right];

            if(n2>n1){
                arr[index] = n2;
                right--;
            }else{
                arr[index] = n1;
                left++;
            }
            index--;
        }
        return arr;
    }
}