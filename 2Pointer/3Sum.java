//Leetcode 15

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        if (nums.length ==0) {
            return new ArrayList<>(result); //!!!!!
        }
        Arrays.sort(nums); //array into sorted list
        for(int i=0; i< nums.length-2; i++){ //O(n)
            int j= i+1; //!!!!!declare don't mess up from python
            int k= nums.length-1; //last one two pointer as 2sum
            while(j<k){ //the loop still checking O(n) runtime
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){ //hit the target
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        //Total runtime O(n^2) memory space O(n)
        return new ArrayList<>(result);
    }
}

