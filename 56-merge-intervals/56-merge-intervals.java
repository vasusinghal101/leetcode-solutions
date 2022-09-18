class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        ArrayList<int[]> ans= new ArrayList<>();
        
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for(int[] interval: intervals){
            if(newInterval[1]>=interval[0]){
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }else{
                newInterval = interval;
                ans.add(newInterval);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}