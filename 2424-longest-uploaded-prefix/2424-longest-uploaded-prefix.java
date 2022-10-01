class LUPrefix {
    TreeSet<Integer> ts;
    public LUPrefix(int n) {
        ts = new TreeSet<Integer>();
        for(int i=1;i<=n+1;i++) ts.add(i);
    }
    
    public void upload(int video) {
        ts.remove(video);
    }
    
    public int longest() {
        return ts.first()-1;
    }
}
// class LUPrefix {
//     HashMap<Integer,Integer> hm;
//     public LUPrefix(int n) {
//       hm = new HashMap<>();
//     }
    
//     public void upload(int val) {
//         //will maintain length for start and end
//         if(hm.containsKey(val)){
//             return;
//         }
//         if(hm.containsKey(val-1)&&hm.containsKey(val+1)){
//             int l = hm.get(val-1);
//             int r = hm.get(val+1);
//             hm.put(val+r,l+r+1);
//             hm.put(val,l+r+1);//reqd to check for repetition
//             hm.put(val-l,l+r+1);
//         }else if(hm.containsKey(val-1)){
//             int len = hm.get(val-1);
//             hm.put(val,len+1);
//             hm.put(val-len,len+1);
//         }else if(hm.containsKey(val+1)){
//             int len = hm.get(val+1);
//             hm.put(val,len+1);
//             hm.put(val+len,len+1);
//         }else{
//             hm.put(val,1);
//         }
//     }
    
//     public int longest() {           
//        return hm.getOrDefault(1, 0);
//     }
// }
/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */