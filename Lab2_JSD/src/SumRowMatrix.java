public class SumRowMatrix {
    private final byte [][] matrix;
    private int sumUnpaired;
    private int sumPaired;

    public SumRowMatrix(byte[][] matrix) {
        this.matrix = matrix;
    }

    public int getSumUnpaired() {
        return sumUnpaired;
    }

    public int getSumPaired() {
        return sumPaired;
    }
    public void calculate(){

        int maxValue;
        int minValue;
        for (byte[] bytes : matrix) {
            maxValue = 0;
            minValue = Integer.MAX_VALUE;
            for (int j = 0; j < bytes.length; j++) {
                if (j % 2 == 0 && bytes[j] > maxValue) {
                    maxValue = bytes[j];
                } else if (bytes[j] < minValue) {
                    minValue = bytes[j];
                }

            }
            sumPaired += maxValue;
            sumUnpaired += minValue;
        }
    }
}
