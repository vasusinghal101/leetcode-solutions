func isToeplitzMatrix(matrix [][]int) bool {
    
    for i:=0;i<len(matrix);i++ {
        j:=0
        val := matrix[i+j][j]
        for j<len(matrix[0]) && i+j < len(matrix){
            if val!= matrix[i+j][j]{
                return false;
            }
            j++
        }
    }
    
     for j:=0;j<len(matrix[0]);j++ {
        i:=0
        val := matrix[i][j]
        for i+j < len(matrix[0]) && i<len(matrix){
            if val!= matrix[i][i+j] {
                return false;
            }
            i++
        }
    }
    
    return true
}