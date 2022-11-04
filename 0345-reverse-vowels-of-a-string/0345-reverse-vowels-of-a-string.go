func reverseVowels(s string) string {
    
    i:= 0
    j:=len(s)-1
    runes := []rune(s)
    for i<j {
        for i<=j && !isVowel(runes[i]){
            i++
        }
        for !isVowel(runes[j]) && j>=i {
            j--
        }
        if i<j {
            runes[i], runes[j] = runes[j], runes[i]
            i++
            j--
        }
    }
    return string(runes)
}

func isVowel(c rune) bool {
    if c < 'a' { c += 32 }
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}