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

        boolean firstZeroRow = false;
        boolean firstZeroCol = false;

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                firstZeroRow = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                firstZeroCol = true;
                break;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[i].length - 1; j > 0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstZeroRow) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(firstZeroCol) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        return matrix;
    }
}
