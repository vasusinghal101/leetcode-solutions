class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, nums, new boolean[nums.length], new LinkedList<Integer>());
        return ans;
    }
    
    private void backTrack(List<List<Integer>> ans, int[] nums, boolean[] visited,LinkedList<Integer> cl){
        if(nums.length == cl.size()){
            ans.add(new ArrayList<Integer>(cl));
            return;
        }
        
        for(int i=0; i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                cl.add(nums[i]);
                backTrack(ans,nums, visited, cl);
                cl.removeLast();
                visited[i]=false;
            }
        }
        return;
    }
}