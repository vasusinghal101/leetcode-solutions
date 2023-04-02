class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        
        for(int i = 0; i < spells.length;i++){
            int req = (int)Math.ceil((double)(success)/(double)(spells[i]));
            pairs[i] = getCount(potions, req);
        }
        
        
        return pairs;
    }
    
    public int getCount(int[] arr, int val){
        if(arr[arr.length-1]<val){
            return 0;
        }
        int l = 0;
        int r = arr.length-1;
        
        while(l<r){
            int mid = l+ (r-l)/2;
            
            if(arr[mid]==val){
                r=mid;
            }else if(arr[mid]>val){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        
        return arr.length-r;
    }
}