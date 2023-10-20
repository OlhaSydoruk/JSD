public class PrintMatrix {
    private byte[][] matrix;

    public PrintMatrix(byte[][] matrix) {
        this.matrix = matrix;
    }
    public void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
