class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer, Pair[]> hm = new HashMap<>();
        int[] ans = new int[queries.length];
        int idx = 0;
        
        for(int[] query : queries){
           if(!hm.containsKey(query[1])){
                Pair[] arr = new Pair[nums.length];
                for(int i=0; i<nums.length; i++){
                    String x = nums[i].substring(nums[i].length()-query[1], nums[i].length()); // trim as required
                    int start = 0;
                    while(start!=x.length() && x.charAt(start)==0) start++;
                    x = x.substring(start, x.length());
                    arr[i] = new Pair(i,x);
                }
               Arrays.sort(arr, (a,b) -> a.str.compareTo(b.str));
               hm.put(query[1],arr);
           }
            ans[idx++] = hm.get(query[1])[query[0]-1].idx;
        }
        return ans;
    }
    
    public class Pair{
        int idx;
        String str;
        public Pair(int idx, String str){
            this.idx = idx;
            this.str = str;
        }
    }
}