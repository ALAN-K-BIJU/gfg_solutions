class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    r.add(i);
                    c.add(j);
                }
            }
        }
        for(int val : r){
            Arrays.fill(mat[val], 0);
        }
        for(int val : c){
            for(int i = 0; i < mat.length; i++){
                mat[i][val] = 0;
            }
        }
    }
}