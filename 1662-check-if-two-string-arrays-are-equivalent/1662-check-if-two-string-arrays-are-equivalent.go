func arrayStringsAreEqual(word1 []string, word2 []string) bool {
    str1 := ""
    str2 := ""
    
    for _,s:= range word1 {
        str1 += s
    }
    
    for _,s:= range word2 {
        str2+= s
    }
    
    return str1==str2
}