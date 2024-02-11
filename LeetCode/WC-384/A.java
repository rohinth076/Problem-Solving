class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int r = matrix.length,c = matrix[0].length;
        int[] max = new int[c];
        for(int j=0;j<c;j++){
            for(int i=0;i<r;i++)
                max[j] = Math.max(max[j],matrix[i][j]);
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = max[j];
                }
            }
        }
        return matrix;
    }
}
