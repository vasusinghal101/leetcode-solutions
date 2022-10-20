var (
	r0 = []string{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
	r1 = []string{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}
	r2 = []string{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}
	r3 = []string{"", "M", "MM", "MMM"}
)

func intToRoman(num int) string {
	// This is efficient in Go. The 4 operands are evaluated,
	// then a single allocation is made of the exact size needed for the result.
	return r3[num%1e4/1e3] + r2[num%1e3/1e2] + r1[num%100/10] + r0[num%10]
}