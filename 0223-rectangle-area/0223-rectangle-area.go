func computeArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
    nx1 := Max(ax1, bx1)
    nx2 := Min(ax2, bx2)
    ny1 := Max(ay1, by1)
    ny2 := Min(ay2, by2)
    
    if ny2<=ny1 || nx2<=nx1 {
        return (by2-by1)*(bx2-bx1)+(ay2-ay1)*(ax2-ax1)
    }
    
    return (by2-by1)*(bx2-bx1)+(ay2-ay1)*(ax2-ax1)-(ny2-ny1)*(nx2-nx1)
}

// Max returns the larger of x or y.
func Max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

// Min returns the smaller of x or y.
func Min(x, y int) int {
	if x > y {
		return y
	}
	return x
}