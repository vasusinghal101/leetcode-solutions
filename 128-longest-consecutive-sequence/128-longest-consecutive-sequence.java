class Solution {
    public int longestConsecutive(int[] nums) {
         Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         int max=0;
//         //will maintain length for start and end
//         for(int val:nums){
//             if(hm.containsKey(val)){
//                 continue;
//             }
//             if(hm.containsKey(val-1)&&hm.containsKey(val+1)){
//                 int l = hm.get(val-1);
//                 int r = hm.get(val+1);
//                 hm.put(val+r,l+r+1);
//                 hm.put(val,l+r+1);//reqd to check for repetition
//                 hm.put(val-l,l+r+1);
//                 max=Math.max(max,l+r+1);
//             }else if(hm.containsKey(val-1)){
//                 int len = hm.get(val-1);
//                 hm.put(val,len+1);
//                 hm.put(val-len,len+1);
//                 max=Math.max(max,len+1);
//             }else if(hm.containsKey(val+1)){
//                 int len = hm.get(val+1);
//                 hm.put(val,len+1);
//                 hm.put(val+len,len+1);
//                 max = Math.max(max,len+1);
//             }else{
//                 hm.put(val,1);
//                  max = Math.max(max,1);
//             }
//         }
        
//         return max;
    }
}