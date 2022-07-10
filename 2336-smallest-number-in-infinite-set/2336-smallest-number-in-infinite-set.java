class SmallestInfiniteSet {
    int s;
    HashSet<Integer> popped;
    public SmallestInfiniteSet() {
        popped = new HashSet<>();
        s=1;
    }
    
    public int popSmallest() {
        int t = s;
        popped.add(t);
        while(popped.contains(s)){
            s++;
        }
        return t;
    }
    
    public void addBack(int num) {
        if(num<s){
            s=num;
        }
        popped.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */