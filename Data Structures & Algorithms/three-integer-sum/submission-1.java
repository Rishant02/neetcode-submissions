class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorting + Two Pointers
        // TC: O(n^2), SC: O(1) Extra Space
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort array
        Arrays.sort(nums);

        int n = nums.length;
        // Step 2: Fix one element
        for(int i = 0; i < n; i++){
            // We need to find distinct elements only, so skipping duplicates
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            // Step 3: Two pointers
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    // need smaller number to meet target
                    right--;
                }
                else if(sum < 0){
                    // need larger number to meet target
                    left++;
                }
                else{
                    // found the triplet
                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));
                    left++;
                    right--;

                    // skip duplicate on both ends
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }
}
