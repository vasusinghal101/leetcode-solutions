class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add(new ArrayList<Integer>());
        
        ans.get(0).add(1);
        
        for(int i =1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = ans.get(i-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            ans.add(row);
        }
        
        return ans;
    }
}