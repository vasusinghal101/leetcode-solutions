func checkIfPangram(sentence string) bool {
    var fmap [26]bool
    
    for i, c:= range sentence {
        i=i
        fmap[int(c)-97] = true
    }
    
    for i:=0;i<26;i++{
        if fmap[i]==false{
            return false
        }
    }
    
    return true
}