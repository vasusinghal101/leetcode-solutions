func checkIfPangram(sentence string) bool {
    var fmap [26]bool
    
    for _, c:= range sentence {
        fmap[int(c)-97] = true
    }
    
    for i:=0;i<26;i++{
        if fmap[i]==false{
            return false
        }
    }
    
    return true
}