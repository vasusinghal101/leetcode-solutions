class Solution {
    class Pair{
        int key;
        int val;
        
        Pair(int key, int val){
            this.key=key;
            this.val = val;
        }
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : arr){
            hm.put(n, hm.getOrDefault(n,0)+1);
        }
        
        int half = (arr.length+1)/2;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        
        for(int n : hm.keySet()){
            pq.add(new Pair(n, hm.get(n)));
        }
        
        int r = 0;
        int ans= 0 ;
        while(r<half){
            Pair p = pq.remove();
            r+=p.val;
            ans++;
        }
        
        return ans;
    }
}