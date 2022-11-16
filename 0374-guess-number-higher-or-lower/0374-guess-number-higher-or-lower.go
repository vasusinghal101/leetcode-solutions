/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * func guess(num int) int;
 */

func guessNumber(n int) int {
    l, h := 1,n
    
    for l<=h {
        mid := l + (int)((h-l)/2)
        g := guess(mid) 
        if g == 0 {
            return mid
        } else if g == -1{
            h = mid-1
        }else{
            l = mid+1
        }
    }
    return -1
}