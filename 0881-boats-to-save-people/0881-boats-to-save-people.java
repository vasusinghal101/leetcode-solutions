class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int ans=0;
        int l=0,r=people.length-1;
        
        while(l<=r){
            
            int sum = people[l]+people[r];
            if(sum<=limit){
                ans+=1;
                l++;
                r--;
            }else{
                ans+=1;
                r--;
            }
        }
        
        return ans;
    }
}