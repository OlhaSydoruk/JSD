public class MultiplyMatrix {
    private byte[][] A;
    private byte[][] B;

    public MultiplyMatrix(byte[][] a, byte[][] b) {
        A = a;
        B = b;
    }
    public byte[][] multiplyMatrix(){
        int numRowsA = A.length;
        int numColsA = A[0].length;
        int numColsB = B[0].length;

        byte[][] result = new byte[numRowsA][numColsB];

        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                for (int k = 0; k < numColsA; k++) {
                    result[i][j] += (byte) (A[i][k] * B[k][j]);
                }
            }
        }
      return result;
    }
}
