package array;

public class SetZeroMatrix {

    public int[][] setZero_Approach1(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    for(int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = matrix[k][j] == 0 ? 0 : -1;
                    }
                    for(int k = 0; k < matrix[i].length; k++) {
                        matrix[i][k] = matrix[i][k] == 0 ? 0 : -1;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == -1)  matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    public int[][] setZero_Approach2(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i = 0; i < rows.length; i++) {
            if(rows[i] == 1) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < cols.length; i++) {
            if(cols[i] == 1) {
                for(int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }

    public int[][] setZero_Approach3(int[][] matrix) {

        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i  = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark ith row

                    if (j != 0) {
                        matrix[0][j] = 0; // mark jth column
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // step 2: mark with 0 from (1,1) to (n-1,m-1)
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    // check for col and row
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // step 3: finally mark the 1st col and then 1st row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0 ; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }
}
