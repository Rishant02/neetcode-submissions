class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Intuition: To find product without division
        // We can find the product of prefix and postfix product
        // Mathematically, result[i] = prefix[i - 1] * postfix[i + 1]
        // TC: O(n), SC: O(1)
        int n = nums.length;
        int[] result = new int[n];
        // prefix product
        int prefix = 1;
        for(int i = 0; i < n; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }
        // postfix product
        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}  
