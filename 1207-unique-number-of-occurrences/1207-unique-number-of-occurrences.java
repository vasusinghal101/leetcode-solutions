class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int n : arr){
            hm.put(n, hm.getOrDefault(n,0)+1);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int n: hm.keySet()){
            int f = hm.get(n);
            if(hs.contains(f)) return false;
            hs.add(f);
        }
        
        return true;
    }
}