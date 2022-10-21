func containsNearbyDuplicate(nums []int, k int) bool {
    hm :=  make(map[int]int)
    
    for i,n := range(nums){
        idx, exst := hm[n]
        if exst{
            if i-idx <= k{
                return true
            }
        }
        hm[n] = i
    }
    return false
}