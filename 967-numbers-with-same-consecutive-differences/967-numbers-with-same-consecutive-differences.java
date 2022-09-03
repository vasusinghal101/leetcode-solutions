class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> results = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            this.DFS(N - 1, num, K, results);

        // convert the ArrayList to int[]
        return results.stream().mapToInt(i->i).toArray();
    }
    
    protected void DFS(int N, int num, int K, List<Integer> results) {
        if(N==0){
            results.add(num);
            return;
        }
        Integer tailDigit = num % 10;
        if(tailDigit-K>=0 && K!=0){
            int tnum = (num*10)+(tailDigit-K);
            DFS(N-1,tnum,K,results);
        }
        
        if(tailDigit+K<10){
            int tnum = (num*10)+(tailDigit+K);
            DFS(N-1,tnum,K,results);
        }
    }
}