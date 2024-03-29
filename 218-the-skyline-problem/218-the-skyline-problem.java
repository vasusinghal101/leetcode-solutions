class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();     // height list to store all buildings' heights
        for (int[] b : buildings) {
            height.add(new int[]{b[0], - b[2]});    // start of a building, height stored as negtive
            height.add(new int[]{b[1], b[2]});      // end of a building, height stored as positive
        }
        Collections.sort(height, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));     // sort the height list
        
        // a pq that stores all the encountered buildings' heights in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int preMax = 0;
        
        for (int[] h : height) {
            if (h[1] < 0) {     // h[1] < 0, that means it meets a new building, so add it to pq
                pq.offer(-h[1]);
            } else {            // h[1] >=0, that means it has reached the end of the building, so remove it from pq
                pq.remove(h[1]);
            }
            
            // the current max height in all encountered buildings
            int curMax = pq.peek();
            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if (curMax != preMax) {
                res.add(new ArrayList<>(Arrays.asList(h[0], curMax)));
                preMax = curMax;
            }
        }
        return res;
    }
}