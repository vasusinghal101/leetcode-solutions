class MyCircularQueue {
    int f;
    int r;
    int s;
    int count;
    int[] q;
    public MyCircularQueue(int k) {
        q = new int[k];
        f=0;
        r=-1;
        s=k;
        count=0;
    }
    
    public boolean enQueue(int value) {        
        if(count == s) return false;
        else{
            r=(r+1)%s;
            q[r]=value;
            count++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(count == 0) return false;
        else{
            f=(f+1)%s;
            count--;
            return true;
        }
    }
    
    public int Front() {
        if(count == 0) return -1;
        else return q[f];
    }
    
    public int Rear() {
        if(count == 0) return -1;
        else return q[r];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == s;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */