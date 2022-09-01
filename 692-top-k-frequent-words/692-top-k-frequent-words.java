class Solution {
    class Pair implements Comparable<Pair>{
        String str;
        int freq;
        
        Pair(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
            if(this.freq == o.freq){
                return o.str.compareTo(this.str);
            }else{
                return this.freq - o.freq;
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> fmap = new HashMap<>();
        
        for(String s : words){
            fmap.put(s, fmap.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(String s : fmap.keySet()){
            pq.add(new Pair(s, fmap.get(s)));
            if(pq.size()>k) pq.poll();
        }
        
        List<String> ans = new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.poll().str);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}