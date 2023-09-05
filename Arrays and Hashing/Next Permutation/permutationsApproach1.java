class Solution {
    private void recPer(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
        // Base Case
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=0; i < nums.length; i++) {
            if (!freq[i]) {
                ds.add(nums[i]);
                freq[i] = true;
                recPer(nums, ans, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            } 
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recPer(nums, ans, ds, freq);
        return ans;
    }
}